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

@WebServlet("/updateAddressController")
public class UpdateAddressController extends HttpServlet {
	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.memberDao = new MemberDao();
		
		// 세션 호출
		HttpSession session = request.getSession();
		     
		// 현재 로그인 된 멤버 아이디 받아오기
		String memberId = (String) session.getAttribute("sessionMemberId");
		
		//디버깅
	    System.out.println("UpdateAddressController (doGet) :"+ memberId);
		
	    // 회원정보를 보여주는 리스트 (현재 주소정보 구하기 위함)
	    Map<String, Object> memberMap = memberDao.selectMemberInfo(memberId);
	    
	    request.setAttribute("memberMap", memberMap);
		
		//뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/updateAddress.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.memberDao = new MemberDao();
		
		// 세션 호출
		HttpSession session = request.getSession();
				     
		// 현재 로그인 된 멤버 아이디 받아오기
		String memberId = (String) session.getAttribute("sessionMemberId");
		
		//요청값 불러오기
		int addressId = Integer.parseInt(request.getParameter("addressId"));
		String detailAddr = request.getParameter("detailAddr");
		
		// 회원정보를 보여주는 리스트 (현재 주소정보 구하기 위함)
	    Map<String, Object> memberMap = memberDao.selectMemberInfo(memberId);
	    
	    request.setAttribute("memberMap", memberMap);
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setAddressId(addressId);
		member.setDetailAddr(detailAddr);
		
		int row = this.memberDao.updateAddress(member);
		if(row == 1) {
			System.out.println("UpdateAddressController (doPost) update 성공! " );
			response.sendRedirect(request.getContextPath()+"/memberOneController");
		}else {
			System.out.println("UpdateAddressController (doPost) update 실패! " );
			response.sendRedirect(request.getContextPath()+"/updateAddressController");
		}
	}

}
