package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;


@WebServlet("/updatePurchaseTotalListController")
public class UpdatePurchaseTotalListController extends HttpServlet {
	private AdminDao adminDao; // 지역변수 AdminDao 선언
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao(); //AdminDao호출 
		
		request.getRequestDispatcher("/WEB-INF/view/updatePurchaseTotalList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
