package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.Component;

@WebServlet("/ProductSearchController")
public class ProductSearchController extends HttpServlet {
	private ProductDao productDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.productDao = new ProductDao();
		
		List<Component> componentList = this.productDao.selectComponent();
		
		request.setAttribute("componentList", componentList);
		
		//디버깅
		for(Component component : componentList) {
			System.out.println("ProductSearchController(doGet) componentId: "+component.getComponentId());
			System.out.println("ProductSearchController(doGet) componentName: "+component.getName());
		}

		List<Map<String, Object>> searchList = this.productDao.selectProductListBySearch();
		
		request.setAttribute("searchList", searchList); 
		
		// 디버깅
		for(Map<String, Object> m : searchList) {
			System.out.println("ProductSearchController(doGet) name: "+m.get("productName"));
			System.out.println("ProductSearchController(doGet) price: "+m.get("price"));
			System.out.println("ProductSearchController(doGet) gram: "+m.get("gram"));
			System.out.println("ProductSearchController(doGet) name: "+m.get("photoName"));
			System.out.println("ProductSearchController(doGet) star: "+m.get("star"));
		}
		
		// 뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/productSearch.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.productDao = new ProductDao();
		
		// 요청값 불러오기
		String age = request.getParameter("age");
		String component = request.getParameter("component");
		String feedType = request.getParameter("feedType");
		String size = request.getParameter("size");
		
		// 디버깅
		System.out.println("ProductSearchController(doPost) age: "+age);
		System.out.println("ProductSearchController(doPost) component: "+component);
		System.out.println("ProductSearchController(doPost) feedType: "+feedType);
		System.out.println("ProductSearchController(doPost) size: "+size);

	}

}

