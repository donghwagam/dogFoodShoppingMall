package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;


@WebServlet("/updateMemberController")
public class UpdateMemberController extends HttpServlet {
	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.memberDao = new MemberDao();
		
		HttpSession session = request.getSession();
		
		//세션에서 현재 로그인된 아이디 들고오기
		String memberId = (String) session.getAttribute("sessionMemberId");

		Map<String, Object> MemberMap = memberDao.selectMemberInfo(memberId);
		
		request.setAttribute("MemberMap", MemberMap);
		
		request.getRequestDispatcher("/WEB-INF/view/updateMember.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.memberDao = new MemberDao();
		
		//요청값 받아오기
		String memberName = request.getParameter("memberName");
		String memberId = request.getParameter("memberId");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		//디버깅
		System.out.println("UpdateMemberController (doPost) name : " + memberName);
		System.out.println("UpdateMemberController (doPost) memberId : "+memberId);
		System.out.println("UpdateMemberController (doPost) memberName : "+memberName);
		System.out.println("UpdateMemberController (doPost) gender : "+gender);
		System.out.println("UpdateMemberController (doPost) birth : "+birth);
		System.out.println("UpdateMemberController (doPost) phone : "+phone);
		System.out.println("UpdateMemberController (doPost) email : "+email);
		
		//데이터 바인딩
		Member member = new Member();
		member.setName(memberName);
		member.setMemberId(memberId);
		member.setBirth(birth);
		member.setPhone(phone);
		member.setEmail(email);
		member.setGender(gender);
		
		// 정보 수정할 메서드 호출
		int row = this.memberDao.updateMember(member);
		
		if(row == 1) {
			//수정 완료했으면 다시 마이페이지로 보내주기
			//디버깅
			System.out.println("회원정보 수정");
			response.sendRedirect(request.getContextPath()+"/memberOneController");
		} else {
			response.sendRedirect(request.getContextPath()+"/UpdateMemberController");
		}
		
	}

}
