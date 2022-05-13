package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.Member;


@WebServlet("/loginDenied/updateMemberPwController")
public class UpdateMemberPwController extends HttpServlet {
	
	private MemberDao memberDao; // 멤버변수 MemberDao 선언
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비밀번호 찾기(SearchMemberPwController) 에서 넘어온 정보 저장
		String memberId = request.getParameter("memberId"); // 아이디
		String phone = request.getParameter("phone"); // 핸드폰번호
		
		// 디버깅
		System.out.println("updateMemberPwController.doGet() memberId : " + memberId);
		System.out.println("updateMemberPwController.doGet() phone : " + phone);
		
		// request에 정보저장
		request.setAttribute("memberId", memberId); 
		request.setAttribute("phone", phone);
		
		request.getRequestDispatcher("/WEB-INF/view/updateMemberPw.jsp").forward(request, response); // 비밀번호 변경페이지로 연결
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비밀번호 변경(updateMemberPw.jsp) 에서 넘어온 정보 저장
		String memberId = request.getParameter("memberId"); // 아이디
		String phone = request.getParameter("phone"); // 핸드폰번호
		String memberPw = request.getParameter("memberPw"); // 변경할 비밀번호
		
		// 디버깅
		System.out.println("updateMemberPwController.doPost() memberId : " + memberId);
		System.out.println("updateMemberPwController.doPost() phone : " + phone);
		System.out.println("updateMemberPwController.doPost() memberPw : " + memberPw);
		
		this.memberDao = new MemberDao(); // 메서드 사용을 위한 MemberDao 객체 생성
		Member member = new Member(); // memberDao.updateMemberPw() 메서드의 매개변수 사용을 위한 Member 객체 생성
		
		// 객체에 정보 저장
		member.setMemberPw(memberPw); 
		member.setMemberId(memberId);
		member.setPhone(phone);
		
		memberDao.updateMemberPw(member); // 비밀번호 변경 메서드 실행
		
		System.out.println("비밀번호 수정 완료"); // 디버깅 
		
		response.sendRedirect(request.getContextPath()+"/loginDenied/loginController"); // 비밀번호 변경 완료 후 로그인 페이지로 이동
		
		
	}

}
