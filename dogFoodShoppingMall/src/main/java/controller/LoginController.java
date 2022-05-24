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

@WebServlet("/loginController")
public class LoginController extends HttpServlet {

	private MemberDao memberDao; // 멤버변수 MemberDao 선언

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = 0;
		if (request.getParameter("productId") != null) {
			productId = Integer.parseInt(request.getParameter("productId"));
		}
		System.out.println("LoginController productId : " + productId);
		Cookie[] cookies = request.getCookies(); // 쿠키 받아오기

		for(Cookie c : cookies) { // 받아온 쿠키들 중에서 이름이 cookieId인 쿠키 정보 저장
			if(c.getName().equals("cookieId")) {
				request.setAttribute("cookieId", c.getValue());
			}
		} 

		request.setAttribute("productId", productId);

		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response); // 로그인 페이지 연결
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // 현재 세션 받아오기
		String memberId = request.getParameter("memberId"); // memberId 받아오기
		String memberPw = request.getParameter("memberPw"); // memberPw 받아오기

		this.memberDao = new MemberDao(); // 메서드 사용을 위한 memberDao 객체 생성

		boolean idSave = false; // id저장 체크

		if(request.getParameter("idSave") != null) { // id저장을 체크했으면 idSave를 true로 변경
			idSave = true;
		}

		int productId = 0;
		if (request.getParameter("productId") != null) {
			productId = Integer.parseInt(request.getParameter("productId"));
		}

		Member member = new Member(); // member 객체 생성 
		member.setMemberId(memberId); // memberId 필드값 셋팅 
		member.setMemberPw(memberPw); // memberPw 필드값 셋팅 

		String returnMemberId = memberDao.selectMemberByIdPw(member); // 메서드 실행 후 반환값(현재 로그인 된 ID,PW) 저장

		session.setAttribute("sessionMemberId", returnMemberId); // returnMemberId값 session에 저장(키값 : sessionMemberId)

		if(idSave) { // idSave가 true면
			Cookie cookieId = new Cookie("cookieId", returnMemberId); // Cookie 객체 생성 후, 현재 접속된 ID 쿠키값으로 저장
			cookieId.setMaxAge(60*60*24); // 쿠키 생명주기는 하루로 setting
			response.addCookie(cookieId); // 쿠키 저장
		}

		if(returnMemberId == null) { // returnMemberId값이 null이어서 로그인에 실패했을때 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/loginDenied/loginController");
			System.out.println("로그인 실패"); // 디버깅
			return;
		}

		//pw_update_date 불러오기
		int diffDay = memberDao.selectDiffDay(memberId);

		// 디버깅(memberId, memberPw, pwUpdateDate)
		System.out.println("LoginController.doPost() memberId : " + memberId);
		System.out.println("LoginController.doPost() memberPw : " + memberPw);
		System.out.println("LoginController.doPost() diffDay : " + diffDay);		

		String active = null;
		active = memberDao.selectMemberActive(memberId);
		System.out.println("LoginController.doGet() active : " + active);

		if(active.equals("1")){
			if(productId == 0) {
				response.sendRedirect(request.getContextPath()+"/mainPageController");
				
			} else {
				response.sendRedirect(request.getContextPath()+"/mainProductOneController?productId=" + productId);
			}
			if(diffDay > 90) { // 비밀번호 안바꾼지 3달이 넘었다면
				String msg = "changePw";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response); // 로그인 페이지 연결
			} else {
				response.sendRedirect(request.getContextPath()+"/mainPageController");
				System.out.println("활성화 된 아이디로 로그인 성공 하였습니다.");
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/loginController"); // 로그인 성공 후 메인페이지로 이동
			System.out.println("비활성화 된 아이디로 로그인 실패 하였습니다.");
		}
	}

}