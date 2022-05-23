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
import vo.Brand;
import vo.Category;
import vo.Component;

@WebServlet("/updateProductController")
public class UpdateProductController extends HttpServlet {
	private AdminDao adminDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao();
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("UpdateProductController.doGet()  productId : " + productId);
		
		List<Map<String, Object>> list = adminDao.selectProductManagementOne(productId);
		
		// 구성품 종류에 대한 리스트 
		List<Component> componentList = adminDao.selectComponentList();
		System.out.println("InsertProductController.doGet() componentList.size() :" + componentList.size());
		// 브랜드 종류에 대한 리스트 
		List<Brand> brandList = adminDao.selectBrandList();
		System.out.println("InsertProductController.doGet() brandList.size() :" + brandList.size());
		// 카태고리 정보 출력 리스트 
		List<Category> categoryList = adminDao.selectCategoryList();
		System.out.println("InsertProductController.doGet() categoryList.size() :" + categoryList.size());
		
		request.setAttribute("list", list);
		request.setAttribute("brandList", brandList);
		request.setAttribute("componentList", componentList);
		request.setAttribute("categoryList", categoryList);
		//디버깅 
		for(Map<String, Object> m : list) {
			System.out.println("UpdateProductController.doGet() productName : " + m.get("productName"));
			System.out.println("UpdateProductController.doGet() price : " + m.get("price"));
			System.out.println("UpdateProductController.doGet() rate : " + m.get("rate"));
			System.out.println("UpdateProductController.doGet() origin : " + m.get("origin"));
			System.out.println("UpdateProductController.doGet() feedSize : " + m.get("feedSize"));
			System.out.println("UpdateProductController.doGet() info : " + m.get("info"));
			System.out.println("UpdateProductController.doGet() photoName : " + m.get("photoName"));
			System.out.println("UpdateProductController.doGet() stock : " + m.get("stock"));
			System.out.println("UpdateProductController.doGet() brandName : " + m.get("brandName"));
			System.out.println("UpdateProductController.doGet() componentName : " + m.get("componentName"));
		}
		
		request.getRequestDispatcher("/WEB-INF/view/updateProduct.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


}
