package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddressDao;
import dao.MemberDao;
import vo.Member;

@WebServlet("/loginDenied/insertMemberController")
public class InsertMemberController extends HttpServlet {
	
	private MemberDao memberDao; // 전역변수 MemberDao 선언

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // 현재 세션 받아오기
		String sessionMemberId = (String)session.getAttribute("sessionMemberId"); // 현재 접속중인 아이디 받아서 저장
		
		if(sessionMemberId != null) { // 로그인 돼있는 상태면 메인페이지로 이동
			response.sendRedirect(request.getContextPath()+"/mainPageController");
			return;
		}
		
	
		
		request.getRequestDispatcher("/WEB-INF/view/insertMember.jsp").forward(request, response); // 회원가입 입력폼 연결
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// 회원가입 입력폼에서 입력된 정보를 각 변수에 저장
		int addressId = Integer.parseInt(request.getParameter("addressId")); // 주소
		String detailAddr = request.getParameter("detailAddr"); // 상세주소
		String name = request.getParameter("name"); // 이름
		String memberId = request.getParameter("memberId"); // 아이디
		String memberPw = request.getParameter("memberPw"); // 비밀번호
		String birth = request.getParameter("birth"); // 생년월일
		String phone = request.getParameter("phone"); // 핸드폰번호
		String email = request.getParameter("email"); // 이메일 
		String gender = request.getParameter("gender"); // 성별

		
		// 디버깅
		System.out.println("InsertLoginController.doPost() addressId : " + addressId);
		System.out.println("InsertLoginController.doPost() detailAddr : " + detailAddr);
		System.out.println("InsertLoginController.doPost() name : " + name);
		System.out.println("InsertLoginController.doPost() memberId : " + memberId);
		System.out.println("InsertLoginController.doPost() memberPw : " + memberPw);
		System.out.println("InsertLoginController.doPost() birth : " + birth);
		System.out.println("InsertLoginController.doPost() phone : " + phone);
		System.out.println("InsertLoginController.doPost() email : " + email);
		System.out.println("InsertLoginController.doPost() gender : " + gender);

		
		Member member = new Member(); // memberDao.insertMember()메서드의 매개변수로 사용될 Member객체 생성
		// 객체를 이용해 정보저장
		member.setAddressId(addressId); 
		member.setDetailAddr(detailAddr);
		member.setName(name);
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setBirth(birth);
		member.setPhone(phone);
		member.setEmail(email);
		member.setGender(gender);

		
		this.memberDao = new MemberDao(); // 메서드 사용을 위한 MemberDao 객체생성
		this.memberDao.insertMember(member); // 회원가입 메서드 실행
		
		System.out.println("회원가입 성공"); // 디버깅
		response.sendRedirect(request.getContextPath()+"/loginDenied/loginController"); // 회원가입 성공 후 로그인 페이지로 이동
	}

}
