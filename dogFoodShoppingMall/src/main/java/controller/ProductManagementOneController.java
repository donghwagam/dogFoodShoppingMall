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
import dao.MainProductDao;
import vo.ProductPhoto;



@WebServlet("/productManagementOneController")
public class ProductManagementOneController extends HttpServlet {
	private AdminDao adminDao; // 지역변수 AdminDao 선언 
	private MainProductDao mainProductDao; // 지역변수 MainProductDao선언 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao();
		this.mainProductDao = new MainProductDao();
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("ProductManagementOneController.doGet() productId :" + productId); 
		List<Map<String ,Object>> list = adminDao.selectProductManagementOne(productId);
		System.out.println("ProductManagementOneController.doGet() list.size() :" + list.size());
		
		List<ProductPhoto> photoList = mainProductDao.selectPhotoList(productId);
		
		request.setAttribute("list", list);
		request.setAttribute("photoList", photoList);
		 request.getRequestDispatcher("/WEB-INF/view/productManagementOne.jsp").forward(request,response);
	}

}
