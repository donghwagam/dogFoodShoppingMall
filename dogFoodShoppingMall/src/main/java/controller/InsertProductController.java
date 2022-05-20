package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



import vo.Brand;
import vo.Category;
import vo.Component;
import dao.AdminDao;

@WebServlet("/insertProductController")
public class InsertProductController extends HttpServlet {
	private AdminDao adminDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao();
		List<Component> componentList = adminDao.selectComponentList();
		System.out.println("InsertProductController.doGet() componentList.size() :" + componentList.size());
		
		List<Brand> brandList = adminDao.selectBrandList();
		System.out.println("InsertProductController.doGet() brandList.size() :" + brandList.size());
		
		List<Category> categoryList = adminDao.selectCategoryList();
		System.out.println("InsertProductController.doGet() categoryList.size() :" + categoryList.size());
		request.setAttribute("brandList", brandList);
		request.setAttribute("componentList", componentList);
		request.setAttribute("categoryList", categoryList);
		
		request.getRequestDispatcher("WEB-INF/view/insertProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상품기본정보 받아옴 
		
		String path = request.getSession().getServletContext().getRealPath("/images"); //사진을 담을 경로설정 
		System.out.println("InsertProductController.doPost() 사진 경로 : " + path);
		
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024*1024*100,"utf-8", new DefaultFileRenamePolicy());
		
		
		String productName = multiReq.getParameter("productName");
		int price = Integer.parseInt(multiReq.getParameter("price"));
		double gram = Double.parseDouble(multiReq.getParameter("gram"));
		String rate = multiReq.getParameter("rate");
		String feedSize = multiReq.getParameter("feedSize");
		String origin = multiReq.getParameter("origin");
		String info = multiReq.getParameter("info");
		int stock = Integer.parseInt(multiReq.getParameter("stock"));
		int brandId = Integer.parseInt(multiReq.getParameter("brandId")); 
		String [] component = multiReq.getParameterValues("component");
		String [] category = multiReq.getParameterValues("category");
		String productPhotoOriginalName = multiReq.getOriginalFileName("productPhoto");
		String productPhotoName = multiReq.getFilesystemName("productPhoto");
		String productPhotoType = multiReq.getContentType("productPhoto");
		
		
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
		System.out.println("InsertProductController.doPost() productPhotoOrigianlName :" + productPhotoOriginalName);
		System.out.println("InsertProductController.doPost() productPhotoName :" + productPhotoName);
		System.out.println("InsertProductController.doPost() productPhotoName :" + productPhotoName);
		
		
		System.out.println("insertProductController.doPost() productName :" + productName);
		System.out.println("insertProductController.doPost() price :" +price);
		System.out.println("insertProductController.doPost() gram :" +gram);
		System.out.println("insertProductController.doPost() rate :" +rate);
		System.out.println("insertProductController.doPost() feedSize :" +feedSize);
		System.out.println("insertProductController.doPost() origin :" +origin);
		System.out.println("insertProductController.doPost() info  :" +info);
		System.out.println("insertProductController.doPost() stock :" +stock);
		System.out.println("insertProductController.doPost() brandId :" +brandId);
		for(int i=0; i<component.length; i++) {
			System.out.println("insertProductController.doPost() component :" + componentId[i]);
		}
		for(int i=0; i<category.length; i++) {
			System.out.println("insertProductController.doPost() category :" + categoryId[i]);
		}
		
			 //사진타입이 png나 jpg이면 
			 // map 에 변수값 저장 
		int row = 0;
		if(productPhotoType.equals("image/png") || productPhotoType.equals("image/jpeg")) {
			Map<String, Object> m = new HashMap<>();
			m.put("productName", productName);
			m.put("price",price);
			m.put("gram", gram);
			m.put("rate", rate);
			m.put("feedSize", feedSize);
			m.put("origin", origin);
			m.put("info", info);
			m.put("stock", stock);
			m.put("brandId", brandId);
			m.put("componentId", componentId);
			m.put("categoryId", categoryId);
			m.put("productPhotoOriginalName", productPhotoOriginalName);
			m.put("productPhotoName", productPhotoName);
			m.put("productPhotoType",productPhotoType);
			row = adminDao.insertProduct(m);
			
		} 
		if (row == 1) {
			System.out.println("상품 등록 성공 ");
			response.sendRedirect(request.getContextPath()+"/productManagementController");
		} else {
			System.out.println("상품 등록 실패 ");
			File file = new File(path + "\\"+productPhotoName); // 잘못된 파일 불러오기. 
			file.delete();
			response.sendRedirect(request.getContextPath() + "/insertProductController");
		}

	}

}
