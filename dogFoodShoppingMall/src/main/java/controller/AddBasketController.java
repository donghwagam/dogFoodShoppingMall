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
import vo.GuestBasket;

@WebServlet("/addBasketController")
public class AddBasketController extends HttpServlet {
	private BasketDao basketDao;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.basketDao = new BasketDao();
      System.out.println("START");
      //요청값 불러오기
      int productId = Integer.parseInt(request.getParameter("productId"));
      //디버깅
      System.out.println("AddBasketController(doGet) productId : " + productId);
            
      //쓸 장바구니 리스트 생성
      List<GuestBasket> basketList = new ArrayList<>();
      
      //세션호출
      HttpSession session = request.getSession();

	  //Basket메서드 호출해서 상품정보 객체에 담기
      GuestBasket guestBasket = this.basketDao.selectGuestBasketList(productId); 
      guestBasket.setQuantity(1); // 수량을 1로 정해주기
      
      if(session.getAttribute("basketList") != null) { // 장바구니에 상품이 담겨있다면
    	  
    	  basketList = (List<GuestBasket>)session.getAttribute("basketList"); // 세션에 저장된 장바구니리스트를 들고와서 basketList에 저장 
    	  
    	  boolean chk = false;
          for(int i=0; i<basketList.size(); i=i+1) {
        	if(basketList.get(i).getProductId() == productId) { // 현재 장바구니에 동일한 상품이 있을 때 
        		int cnt = basketList.get(i).getQuantity();
        		basketList.get(i).setQuantity(cnt+1);
        		chk = true;
        		break;
        	 }
          }
          
          if(!chk) {
        	 basketList.add(guestBasket);
          }  
          
          for(int i=0; i<basketList.size(); i+=1) {
        	  System.out.println("-------------basket-------");
        	  System.out.println("AddBasketController (doGet) productId :" + basketList.get(i).getProductId());
        	  System.out.println("AddBasketController (doGet) photoName :" + basketList.get(i).getPhotoName());
        	  System.out.println("AddBasketController (doGet) productName :" + basketList.get(i).getProductName());
        	  System.out.println("AddBasketController (doGet) gram :" + basketList.get(i).getGram());
        	  System.out.println("AddBasketController (doGet) price :" + basketList.get(i).getPrice());
        	  System.out.println("AddBasketController (doGet) quantity :" + basketList.get(i).getQuantity());
          }
    	  
      }else { // 장바구니에 상품이 하나도 없다면
    	 System.out.println("tq "+guestBasket);
    	 basketList.add(guestBasket);
      }
      
      session.setAttribute("basketList", basketList);
      
      System.out.println("END");
     
      //리다이렉트
      response.sendRedirect(request.getContextPath()+"/basketListController");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    }

}