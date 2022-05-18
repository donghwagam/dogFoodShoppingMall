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
		
		List<Map<String ,Object>> list = adminDao.selectProductListByAdmin();
		System.out.println("ProductManagementController list.size() :" + list.size());
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("WEB-INF/view/productManagement.jsp").forward(request, response);
		
	}

}
