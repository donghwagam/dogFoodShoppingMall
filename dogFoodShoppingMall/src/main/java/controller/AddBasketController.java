package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;

@WebServlet("/addBasketController")
public class AddBasketController extends HttpServlet {
	private BasketDao basketDao;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.basketDao = new BasketDao();
    	
      //요청값 불러오기
      int productId = Integer.parseInt(request.getParameter("productId"));
      //디버깅
      System.out.println("AddBasketController(doGet) productId : " + productId);
      
      //세션호출
      HttpSession session = request.getSession();
      
      //쓸 장바구니 리스트 생성
      List<Map<String, Object>> basketList = new ArrayList<>();

      if(session.getAttribute("basketList") != null) { // 만약에 세션에서 들고온 베스킷리스트가 널이 아니라면 
    	  basketList = (List<Map<String, Object>>)session.getAttribute("basketList");
      } else {
          session.setAttribute("basketList", basketList);
      }

      //Basket메서드 호출해서 값들 리스트에 담기
      List<Map<String, Object>> list = this.basketDao.selectBasketList(productId);
      
      for(Map<String, Object> m : list) {
    	  System.out.println("-------------basketList--------------");
    	  System.out.println("AddBasketController (doGet) productId :" + m.get("productId"));
    	  System.out.println("AddBasketController (doGet) photoName :" + m.get("photoName"));
    	  System.out.println("AddBasketController (doGet) productName :" + m.get("productName"));
    	  System.out.println("AddBasketController (doGet) gram :" + m.get("gram"));
    	  System.out.println("AddBasketController (doGet) price :" + m.get("price"));
    	  basketList.add(m);  
      }
      
      //리다이렉트
      response.sendRedirect(request.getContextPath()+"/basketListController");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    }

}