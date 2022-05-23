package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/faqController")
public class FaqController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String service = request.getParameter("service");
		System.out.print("----------------service:"+service);
		if(service.equals("memberService")) {
			request.getRequestDispatcher("/WEB-INF/view/faq.jsp").forward(request, response);
		} else if(service.equals("order")) {
			request.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/delivery.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
