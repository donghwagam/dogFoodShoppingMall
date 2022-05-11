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

@WebServlet("/insertMemberController")
public class InsertMemberController extends HttpServlet {
	MemberDao memberDao = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // 현재 세션 받아오기
		String sessionMemberId = (String)session.getAttribute("sessionMemberId"); // 현재 접속중인 아이디 저장
		
		if(sessionMemberId != null) { // 로그인 돼있는 상태면 메인페이지로 이동
			response.sendRedirect(request.getContextPath()+"/mainPageController");
			return;
		}
		
		request.getRequestDispatcher("WEB-INF/view/insertLogin.jsp").forward(request, response); // 회원가입 입력폼 연결
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int addressId = Integer.parseInt(request.getParameter("addressId"));
		String detailAddr = request.getParameter("detailAddr");
		String name = request.getParameter("name");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
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
		
		Member member = new Member();
		member.setAddressId(addressId);
		member.setDetailAddr(detailAddr);
		member.setName(name);
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setBirth(birth);
		member.setPhone(phone);
		member.setEmail(email);
		member.setGender(gender);
		
		this.memberDao.insertMember(member);
		
		System.out.println("회원가입 성공");
		response.sendRedirect(request.getContextPath()+"/loginController");
	}

}
