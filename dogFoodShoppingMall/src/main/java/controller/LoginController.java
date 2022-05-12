package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;

@WebServlet("/loginDenied/loginController")
public class LoginController extends HttpServlet {

	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies) {
			if(c.getName().equals("cookieId")) {
				request.setAttribute("cookieId", c.getValue());
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response); // 로그인 페이지 연결
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberId = request.getParameter("memberId"); // memberId 받아오기
		String memberPw = request.getParameter("memberPw"); // memberPw 받아오기
		boolean idSave = false;
		
		if(request.getParameter("idSave") != null) {
			idSave = true;
		}
		
		Member member = new Member(); // member 객체 생성 
		member.setMemberId(memberId); // memberId 필드값 셋팅 
		member.setMemberPw(memberPw); // memberPw 필드값 셋팅 
		this.memberDao = new MemberDao(); // 메서드 사용을 위한 memberDao 객체 생성
		String returnMemberId = memberDao.selectMemberByIdPw(member); // 메서드 실행 후 반환값(현재 로그인 된 ID,PW) 저장
		
		session.setAttribute("sessionMemberId", returnMemberId); // returnMemberId값 session에 저장(키값 : sessionMemberId)
		
		if(idSave) {
			Cookie cookieId = new Cookie("cookieId", returnMemberId);
			cookieId.setMaxAge(60*60*24);
			response.addCookie(cookieId);
		}
		
		if(returnMemberId == null) { // returnMemberId값이 null이어서 로그인에 실패했을때 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/loginDenied/loginController");
			System.out.println("로그인 실패"); // 디버깅
			return;
		}
		
		// 디버깅(memberId, memberPw)
		System.out.println("LoginController.doPost() memberId : " + memberId);
		System.out.println("LoginController.doPost() memberPw : " + memberPw);
		
		response.sendRedirect(request.getContextPath()+"/mainPageController"); // 로그인 성공 후 메인페이지로 이동
		
	
	}

}
