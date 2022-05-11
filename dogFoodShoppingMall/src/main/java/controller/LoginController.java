package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {

	MemberDao memberDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // 현재 세션 받아옴
		String sessionMemberId = (String)session.getAttribute("sessionMemberId"); // 변수 sessionMemberId 저장
		if(sessionMemberId != null) { // 로그인 상태라면 메인페이지로 이동
			response.sendRedirect(request.getContextPath()+"/mainPageController");
			return;
		}
		
		request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response); // 로그인 페이지 연결
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId"); // memberId 받아오기
		String memberPw = request.getParameter("memberPw"); // memberPw 받아오기
		
		// 디버깅(memberId, memberPw)
		System.out.println("LoginController.doPost() memberId : " + memberId);
		System.out.println("LoginController.doPost() memberPw : " + memberPw);
		
		Member member = new Member(); // member 객체 생성 
		member.setMemberId(memberId); // memberId 필드값 셋팅 
		member.setMemberPw(memberPw); // memberPw 필드값 셋팅 
		
		memberDao = new MemberDao(); // 메서드 사용을 위한 memberDao 객체 생성
		String returnMemberId = memberDao.selectMemberByIdPw(member); // 메서드 실행 후 반환값(현재 로그인 된 ID,PW) 저장
		
		if(returnMemberId == null) { // returnMemberId값이 null이어서 로그인에 실패했을때 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/loginController");
			System.out.println("로그인 실패"); // 디버깅
			return;
		} 
		
		// 현재 세션 받아오기
		HttpSession session = request.getSession(); 
		session.setAttribute("sessionMemberId", returnMemberId); // returnMemberId값 session에 저장(키값 : sessionMemberId)
		response.sendRedirect(request.getContextPath()+"/mainPageController"); // 로그인 성공 후 메인페이지로 이동
		
	
	}

}
