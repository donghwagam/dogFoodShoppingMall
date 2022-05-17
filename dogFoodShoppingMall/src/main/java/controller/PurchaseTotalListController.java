package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;


@WebServlet("/purchaseTotalListController")
public class PurchaseTotalListController extends HttpServlet {
	private AdminDao adminDao; // 지역변수 AdminDao 선언 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		this.adminDao = new AdminDao(); // AdminDao 호출 
		
		final String memberId = request.getParameter("memberId"); // memberId 정보 받아오기 
		System.out.println("PurchaseTotalListController.doGet() memberId : " + memberId); // memberId 디버깅 
		
		
		// -----------------------패이징---------------------------
		int currentPage = 1;  // 현재 페이지 
		if (request.getParameter("currentPage") != null ) { // 현재패이지값이 null 이 아니면 
			currentPage = Integer.parseInt(request.getParameter("currentPage")); // 현재 페이지 값 불러
		}
		
		int rowPerPage = 10; // 한패이지당 회원정보 10개씩 출력 
		int beginRow = (currentPage - 1)*rowPerPage;
		// 멤버 정보 출력 메서드 
		List<Map<String ,Object>> list = adminDao.selectPurchaseMemberTotalListByPage(beginRow, rowPerPage, memberId);
		// 디버깅
		System.out.println("PurchaseTotalListController.doGet() selectPurchaseTotalListByPage list.size() : " + list.size());
		
		// 페이지 끝 구하기 
		int lastPage = 0; // 마지막 페이지 
		
		int totalCount = adminDao.selectMemberTotalRow(); // 전체 리스트 수
		
		lastPage = (int)Math.ceil((double)totalCount / (double)rowPerPage); // 마지막 페이지 구하기
		
		
		request.setAttribute("list", list);
		request.setAttribute("memberId", memberId);
		request.getRequestDispatcher("/WEB-INF/view/purchaseTotalList.jsp").forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -------------값 받아오기 --------------------------------
				this.adminDao = new AdminDao(); // AdminDao 호출 
				String memberId = request.getParameter("memberId");
				System.out.println("PurchaseTotalSearchListController.doGet() memberId : " + memberId);
				String status = "";
				if(!"".equals(request.getParameter("status"))) {
					status = request.getParameter("status");
				}
				System.out.println("PurchaseTotalSearchListController.doGet() status :" + status);
				
				String aDate ="";
				if(!"".equals(request.getParameter("aDate"))) {
					aDate = request.getParameter("aDate");
				}
				System.out.println("PurchaseTotalSearchListController.doGet() aDate :" + aDate);
				String bDate = "";
				if(!"".equals(request.getParameter("bDate"))) {
					bDate = request.getParameter("bDate");
				}
				System.out.println("PurchaseTotalSearchListController.doGet() bDate :" + bDate);
				// ---------------------------- 페이징 -------------------------------
				int currentPage = 1;  // 현재 페이지 
				if (request.getParameter("currentPage") != null ) { // 현재패이지값이 null 이 아니면 
					currentPage = Integer.parseInt(request.getParameter("currentPage")); // 현재 페이지 값 불러
				}
				
				int rowPerPage = 10; // 한패이지당 회원정보 10개씩 출력 
				int beginRow = (currentPage - 1)*rowPerPage;
				// 멤버 정보 출력 메서드 
				List<Map<String, Object>> list = adminDao.selectSearchPurchaseTotalListByPage(beginRow, rowPerPage, memberId, status, aDate, bDate);
				// 디버깅
				System.out.println("PurchaseTotalListController.doGet() selectPurchaseTotalListByPage list.size() : " + list.size());
				
				// 페이지 끝 구하기 
				int lastPage = 0; // 마지막 페이지 
				
				int totalCount = adminDao.selectSearchPurchaseTotalRow(memberId, status, aDate, bDate);// 전체 리스트 수
				
				lastPage = (int)Math.ceil((double)totalCount / (double)rowPerPage); // 마지막 페이지 구하기
					
				
				request.setAttribute("list", list);
				request.setAttribute("memberId", memberId);
				request.getRequestDispatcher("WEB-INF/view/purchaseTotalList.jsp").forward(request, response);
	}
}
