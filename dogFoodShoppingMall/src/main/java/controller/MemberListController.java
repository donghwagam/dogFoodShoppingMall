package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;

@WebServlet("/memberListController")
public class MemberListController extends HttpServlet {
	
	private AdminDao adminDao; // 지역변수 AdminDao 선언 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao(); // AdminDao 호출 
		int currentPage = 1;  // 현재 페이지 
		if (request.getParameter("currentPage") != null ) { // 현재패이지값이 null 이 아니면 
			currentPage = Integer.parseInt(request.getParameter("currentPage")); // 현재 페이지 값 불러
		}
		
		int rowPerPage = 10; // 한패이지당 회원정보 10개씩 출력 
		int beginRow = (currentPage - 1)*rowPerPage;
		// 멤버 정보 출력 메서드 
		List<Map<String ,Object>> list = adminDao.selectMemberListByPage(beginRow, rowPerPage); 
		// 디버깅
		System.out.println("MemberListController selectMemberListByPage list.size() : " + list.size());
		
		// 페이지 끝 구하기 
		int lastPage = 0; // 마지막 페이지 
		int totalCount = list.size(); // 전체 리스트 수
		lastPage = (int)Math.ceil((double)totalCount / (double)rowPerPage); // 마지막 페이지 구하기
		//디버깅 
		System.out.println("MemberListController currentPage :" + currentPage);
		System.out.println("MemberListController beginRow : " + beginRow);
		System.out.println("MemberListController rowPerPage : " + rowPerPage);
		System.out.println("MemberListController totalCount : " + totalCount);
		// 값 넘기기 
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/view/memberList.jsp").forward(request, response);
	}

}
