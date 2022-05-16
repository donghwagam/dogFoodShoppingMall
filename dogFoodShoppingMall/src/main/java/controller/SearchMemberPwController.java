package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.Member;


@WebServlet("/loginDenied/searchMemberPwController")
public class SearchMemberPwController extends HttpServlet {

	private MemberDao memberDao; // 멤버변수 MemberDao 선언
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/searchMemberPw.jsp").forward(request, response); // 비밀번호 찾기 페이지로 연결
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 비밀번호 찾기(searchMemberPw.jsp)에서 받아온 정보 저장
		String memberId = request.getParameter("memberId"); // 아이디 
		String name = request.getParameter("name"); // 이름
		String phone = request.getParameter("phone"); // 핸드폰번호
		
		// 디버깅
		System.out.println("SearchMemberPwController.doPost() memberId : " + memberId);
		System.out.println("SearchMemberPwController.doPost() name : " + name);
		System.out.println("SearchMemberPwController.doPost() phone : " + phone);
		
		Member member = new Member(); // memberDao.searchMemberPw() 메서드의 매개변수로 사용할 Member 객체 생성
		// 객체에 정보 저장
		member.setMemberId(memberId); 
		member.setName(name);
		member.setPhone(phone);
		
		this.memberDao = new MemberDao(); // 메서드 사용을 위한 MemberDao 객체 생성
		String memberPw = memberDao.searchMemberPw(member); // 비밀번호 찾기 메서드 실행 후 찾아온 비밀번호를 memberPw에 저장
		
		
		if(memberPw != null) { // 찾아온 비밀번호가 있으면 
			response.sendRedirect(request.getContextPath()+"/loginDenied/updateMemberPwController?memberId="+memberId+"&phone="+phone); // 비밀번호 변경 페이지로 이동
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/loginDenied/searchMemberPwController"); // 찾아온 비밀번호가 없으면 비밀번호 찾기 페이지로 이동
	}

}
