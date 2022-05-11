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
import vo.Category;
import vo.Component;

@WebServlet("/ProductSearchController")
public class ProductSearchController extends HttpServlet {
   private ProductDao productDao;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.productDao = new ProductDao();
      
      //component 정보 받아오기 위한 메서드 호출해서 componentList에 저장
      List<Component> componentList = this.productDao.selectComponent();
      
      request.setAttribute("componentList", componentList);
      
      //디버깅
      for(Component component : componentList) {
         System.out.println("ProductSearchController(doGet) componentId: "+component.getComponentId());
         System.out.println("ProductSearchController(doGet) componentName: "+component.getName());
      }
      
      //age 정보 받아오기 위한 메서드 호출해서 ageList에 저장
      List<Category> ageList = this.productDao.selectAge();
      
      request.setAttribute("ageList", ageList);
      
      //feedType정보 받아오기 위한 메서드 호출해서 feedTypeList에 저장
      List<Category> feedTypeList = this.productDao.selectFeedType();
      
      request.setAttribute("feedTypeList", feedTypeList);
      
      // 상품목록 최신순으로 띄워줄 메서드 호출해서 searchList에 저장
      List<Map<String, Object>> searchList = this.productDao.selectProductListBySearch();
      
      request.setAttribute("searchList", searchList); 
      
      // 디버깅
      for(Map<String, Object> m : searchList) {
         System.out.println("ProductSearchController(doGet) productName: "+m.get("productName"));
         System.out.println("ProductSearchController(doGet) price: "+m.get("price"));
         System.out.println("ProductSearchController(doGet) gram: "+m.get("gram"));
         System.out.println("ProductSearchController(doGet) photoName: "+m.get("photoName"));
         System.out.println("ProductSearchController(doGet) star: "+m.get("star"));
      }
      
      // 뷰 포워딩
      request.getRequestDispatcher("/WEB-INF/view/productSearch.jsp").forward(request, response);
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.productDao = new ProductDao();
      
      // 요청값 불러오기
      int age = -1;
      if(!"".equals(request.getParameter("age"))) {
         age = Integer.parseInt(request.getParameter("age"));
      }
      int component = -1;
      if(!"".equals(request.getParameter("component"))) {
         component = Integer.parseInt(request.getParameter("component"));
      }
      int feedType = -1;
      if(!"".equals(request.getParameter("feedType"))) {
         feedType = Integer.parseInt(request.getParameter("feedType"));
      }
      String size = request.getParameter("size");
      
      // 디버깅
      System.out.println("ProductSearchController(doPost) age: "+age);
      System.out.println("ProductSearchController(doPost) component: "+component);
      System.out.println("ProductSearchController(doPost) feedType: "+feedType);
      System.out.println("ProductSearchController(doPost) size: "+size);
      
      List<Map<String, Object>> searchCategoryList = this.productDao.selectProductListBySearchCategory(age, component, feedType, size);

      request.setAttribute("searchCategoryList", searchCategoryList);
      
      //디버깅
      for(Map<String, Object> m : searchCategoryList) {
         System.out.println("--------searchCategoryList----------");
         System.out.println("ProductSearchController(doPost) productName: "+m.get("productName"));
         System.out.println("ProductSearchController(doPost) price: "+m.get("price"));
         System.out.println("ProductSearchController(doPost) gram: "+m.get("gram"));
         System.out.println("ProductSearchController(doPost) photoName: "+m.get("photoName"));
         System.out.println("ProductSearchController(doPost) star: "+m.get("star"));
      }
      
      // 뷰 포워딩
      request.getRequestDispatcher("/WEB-INF/view/productSearch.jsp").forward(request, response);
      
   }

}
