package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import vo.Member;



@WebServlet("/deleteProductController")
public class DeleteProductController extends HttpServlet {
	private AdminDao adminDao; //지역변수 AdminDao 선언 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao(); // dao호출
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		System.out.println("deleteProductController.doGet() productId :" + productId);
		List<Map<String ,Object>> list = adminDao.selectProductManagementOne(productId);
		for(Map<String ,Object> m : list) {
			System.out.println("deleteProductController.doGet() productId :" +m.get("productId"));
			System.out.println("deleteProductController.doGet() productName : " + m.get("productName"));
			System.out.println("deleteProductController.doGet() price : " + m.get("price"));
			System.out.println("deleteProductController.doGet() rate : " + m.get("rate"));
			System.out.println("deleteProductController.doGet() origin : " + m.get("origin"));
			System.out.println("deleteProductController.doGet() feedSize : " + m.get("feedSize"));
			System.out.println("deleteProductController.doGet() info : " + m.get("info"));
			System.out.println("deleteProductController.doGet() photoName : " + m.get("photoName"));
			System.out.println("deleteProductController.doGet() stock : " + m.get("stock"));
			System.out.println("deleteProductController.doGet() brandName : " + m.get("brandName"));
			System.out.println("deleteProductController.doGet() componentName : " + m.get("componentName"));
			System.out.println("deleteProductController.doGet() updateDate : " + m.get("updateDate"));
		}
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/deleteProduct.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao(); //dao 호출 
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("deleteProductController.doPost() productId : " + productId);
		
		String photoName = request.getParameter("photoName");
		System.out.println("deleteProductController.doPost() photoName : " + photoName);
		
		
		int row = adminDao.deleteProduct(productId);
		if (row == 1) {
			System.out.println("삭제 성공 ");
			String path = request.getSession().getServletContext().getRealPath("/images"); //사진을 담을 경로설정 
			System.out.println("InsertProductController.doPost() 사진 경로 : " + path);
			File file = new File(path + "//"+ photoName); // 잘못된 파일 불러오기. 
			System.out.println("deleteProductController.doPost() 사진 :" + file);
			file.delete();
			response.sendRedirect(request.getContextPath() + "/productManagementController");
		} else {
			System.out.println("삭제실패 ");
			response.sendRedirect(request.getContextPath() + "/deleteProductController?productId=" + productId);
		}
	}

}
