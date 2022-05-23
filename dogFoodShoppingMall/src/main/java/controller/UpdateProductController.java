package controller;

import java.io.IOException;
import java.util.HashMap;
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
import vo.ProductCategory;
import vo.ProductComponent;

@WebServlet("/updateProductController")
public class UpdateProductController extends HttpServlet {
	private AdminDao adminDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao();
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("UpdateProductController.doGet()  productId : " + productId);
		
		List<Map<String, Object>> list = adminDao.selectProductManagementOne(productId);
		//productId 에 대한 구성품 리스트 
		List<ProductComponent> pcList = adminDao.selectProductComponentByProductId(productId);
				    
		List<ProductCategory> pcaList = adminDao.selectProductCategoryByProductId(productId);
		// 구성품 종류에 대한 리스트 
		List<Component> componentList = adminDao.selectComponentList();
		System.out.println("updateProductController.doGet() componentList.size() :" + componentList.size());
		// 브랜드 종류에 대한 리스트 
		List<Brand> brandList = adminDao.selectBrandList();
		System.out.println("updateProductController.doGet() brandList.size() :" + brandList.size());
		// 카태고리 정보 출력 리스트 
		List<Category> categoryList = adminDao.selectCategoryList();
		System.out.println("updateProductController.doGet() categoryList.size() :" + categoryList.size());
		
		request.setAttribute("pcList", pcList);
		request.setAttribute("pcaList", pcaList);
		request.setAttribute("list", list);
		request.setAttribute("brandList", brandList);
		request.setAttribute("componentList", componentList);
		request.setAttribute("categoryList", categoryList);
		//디버깅 
		for(Map<String, Object> m : list) {
			System.out.println("UpdateProductController.doGet() productName : " + m.get("productName"));
			System.out.println("UpdateProductController.doGet() price : " + m.get("price"));
			System.out.println("UpdateProductController.doGet() gram : " + m.get("gram"));
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
		this.adminDao = new AdminDao(); //dao 호출 
		int row = 0;
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("price"));
		String rate = request.getParameter("rate");
		Double gram = Double.parseDouble(request.getParameter("gram"));
		String origin = request.getParameter("origin");
		String feedSize = request.getParameter("feedSize");
		String info = request.getParameter("info");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int brandId = Integer.parseInt(request.getParameter("brandId"));
		String [] component = request.getParameterValues("component");
		String [] category = request.getParameterValues("category");
		
		int[] componentId = null;
		componentId = new int[component.length];
		for(int i=0; i<component.length; i++) {
			componentId[i] = Integer.parseInt(component[i]);
		}
		
		int[] categoryId = null;
		categoryId = new int[category.length];
		for(int i=0; i<category.length; i++) {
			categoryId[i] = Integer.parseInt(category[i]);
		}
			
		for(int i=0; i<component.length; i++) {
				System.out.println("updateProductController.doPost() component :" + componentId[i]);
			}
			for(int i=0; i<category.length; i++) {
				System.out.println("updateProductController.doPost() category :" + categoryId[i]);
			}
		System.out.println("updateProductController.doPost() productId :" + productId);
		System.out.println("updateProductController.doPost() productName :" + productName);
		System.out.println("updateProductController.doPost() price :" +price);
		System.out.println("updateProductController.doPost() gram :" +gram);
		System.out.println("updateProductController.doPost() rate :" +rate);
		System.out.println("updateProductController.doPost() feedSize :" +feedSize);
		System.out.println("updateProductController.doPost() origin :" +origin);
		System.out.println("updateProductController.doPost() info  :" +info);
		System.out.println("updateProductController.doPost() stock :" +stock);
		System.out.println("updateProductController.doPost() brandId :" +brandId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("productName", productName);
		map.put("price",price);
		map.put("gram", gram);
		map.put("rate", rate);
		map.put("feedSize", feedSize);
		map.put("origin", origin);
		map.put("info", info);
		map.put("stock", stock);
		map.put("brandId", brandId);
		map.put("componentId", componentId);
		map.put("categoryId", categoryId);
		row = adminDao.updateProduct(map, productId);
		
		if(row==1) {
			System.out.println("UpdateProductController.doPost() 수정성공");
			response.sendRedirect(request.getContextPath() + "/productManagementOneController?productId=" + productId);
		} else {
			System.out.println("UpdateProductController.doPost() 수정실패 ");
			response.sendRedirect(request.getContextPath() + "/updateProductController?productId=" + productId);
		}
		
			
		}
	}

