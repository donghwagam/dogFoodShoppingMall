// ChartListController.java
package controller;
 
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import java.util.Map;

import dao.AdminDao;

@WebServlet("/chartListController")
public class ChartListController extends HttpServlet  {
   private AdminDao adminDao;  // 

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      HttpSession session = request.getSession(); // 세션정보 불러오기 
      this.adminDao = new AdminDao(); // Dao 호출
      
      // 상품별 판매량을 보여주는 리스트
      List<Map<String, Object>> chartListByProductList = adminDao.selectChartListByProduct();
      
      System.out.println("ChartListController.doGet() chartListByProductList : " + chartListByProductList.size());    // 디버깅
      request.setAttribute("chartListByProductList", chartListByProductList);
      
      // 날짜별 판매량을 보여주는 리스트
      List<Map<String, Object>> chartListByDateList = adminDao.selectChartListByDate();   
      System.out.println("ChartListController.doGet() chartListByDateList : " + chartListByDateList.size());          // 디버깅
      request.setAttribute("chartListByDateList", chartListByDateList);
      
      
      // 카테고리별 판매량을 보여주는 리스트
      List<Map<String, Object>> chartListByCategoryList = adminDao.selectChartListByCategory();   
      System.out.println("ChartListController.doGet() chartListByCategoryList : " + chartListByCategoryList.size());    // 디버깅
      request.setAttribute("chartListByCategoryList", chartListByCategoryList);
      
      
      
      // 브랜드별 판매량을 보여주는 리스트
      List<Map<String, Object>> chartListByBrandList = adminDao.selectChartListByBrand();   
      System.out.println("ChartListController.doGet() chartListByBrandList : " + chartListByBrandList.size());       // 디버깅
      request.setAttribute("chartListByBrandList", chartListByBrandList);
      
      
      request.getRequestDispatcher("/WEB-INF/view/chartList.jsp").forward(request, response);                   // 뷰 포워딩
   }
}   
