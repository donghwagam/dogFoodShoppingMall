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

@WebServlet("/loginDenied/searchMemberIdController")
public class SearchMemberIdController extends HttpServlet {
	private MemberDao memberDao; // 전역변수 MemberDao 선언
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/searchMemberId.jsp").forward(request, response); // 아이디 찾기 페이지로 연결
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디 찾기 페이지에서 넘어온 정보 저장
		String name = request.getParameter("name"); // 이름
		String phone = request.getParameter("phone"); // 핸드폰번호
		
		// 디버깅
		System.out.println("SearchMemberController.doPost() name : " + name);
		System.out.println("SearchMemberController.doPost() phone : " + phone);
		
		
		Member member = new Member(); // memberDao.searchMemberId() 메서드 매개변수로 사용될 Member객체 생성
		// 객체에 정보 저장
		member.setName(name);
		member.setPhone(phone);
		
		this.memberDao = new MemberDao(); // 메서드 사용을 위한 MemberDao 객체 생성
		
		String memberId = memberDao.searchMemberId(member); // 아이디 찾기 메서드 실행 후 찾아온 값을 memberId에 저장
		
		request.setAttribute("memberId", memberId); // request에 memberId 저장
		
		System.out.println("아이디 찾기 성공"); // 디버깅
		
		request.getRequestDispatcher("/WEB-INF/view/searchMemberId.jsp").forward(request, response); // 아이디 찾기와 연결 (Id를 찾으면 페이지에서 보여주기)
		
	}

}
