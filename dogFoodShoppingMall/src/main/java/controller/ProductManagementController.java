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
@WebServlet("/productManagementController")

public class ProductManagementController extends HttpServlet {
	private AdminDao adminDao; // 지역변수 AdminDao 선언 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao(); // AdminDao 호출
		int currentPage = 1;  // 현재 페이지 
		if (request.getParameter("currentPage") != null ) { // 현재패이지값이 null 이 아니면 
			currentPage = Integer.parseInt(request.getParameter("currentPage")); // 현재 페이지 값 불러
		}
		
		int rowPerPage = 10; // 한패이지당 회원정보 10개씩 출력 
		int beginRow = (currentPage - 1)*rowPerPage;
		List<Map<String ,Object>> list = adminDao.selectProductListByAdmin(beginRow, rowPerPage);
		System.out.println("ProductManagementController list.size() :" + list.size());
		int lastPage = 0; // 마지막 페이지 
		int totalCount = adminDao.selectProductTotalRow(); // 전체 리스트 수
		lastPage = (int)Math.ceil((double)totalCount / (double)rowPerPage); // 마지막 페이지 구하기
		//디버깅 
		System.out.println("productManagementController currentPage :" + currentPage);
		System.out.println("productManagementController beginRow : " + beginRow);
		System.out.println("productManagementController rowPerPage : " + rowPerPage);
		System.out.println("productManagementController totalCount : " + totalCount);
		System.out.println("productManagementController lastPage : " + lastPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("WEB-INF/view/productManagement.jsp").forward(request, response);
		
	}

}
