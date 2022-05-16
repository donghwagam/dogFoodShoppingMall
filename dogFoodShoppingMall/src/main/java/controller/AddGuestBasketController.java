package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import vo.GuestBasket;

@WebServlet("/addGuestBasketController")
public class AddGuestBasketController extends HttpServlet {
	private BasketDao basketDao;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.basketDao = new BasketDao();
     
      System.out.println("AddGuestBasketController BEGIN");
      
      //요청값 불러오기
      int productId = Integer.parseInt(request.getParameter("productId"));
      //디버깅
      System.out.println("AddGuestBasketController(doGet) productId : " + productId);
            
      //쓸 장바구니 리스트 생성
      List<GuestBasket> guestBasketList = new ArrayList<>();
      
      //세션호출
      HttpSession session = request.getSession();

	  //Basket메서드 호출해서 상품정보 객체에 담기
      GuestBasket guestBasket = this.basketDao.selectGuestBasketList(productId); 
      guestBasket.setQuantity(1); // 수량을 1로 정해주기
      
      if(session.getAttribute("guestBasketList") != null) { // 장바구니에 상품이 담겨있다면
    	  
    	  guestBasketList = (List<GuestBasket>)session.getAttribute("guestBasketList"); // 세션에 저장된 장바구니리스트를 들고와서 basketList에 저장 
    	  
    	  boolean chk = false; // 원래 있던 상품인지 아닌지를 체크하기 위한 변수 
          for(int i=0; i<guestBasketList.size(); i=i+1) { // 리스트 전체를 돌리면서
        	if(guestBasketList.get(i).getProductId() == productId) { // 현재 장바구니에 동일한 상품이 있을 때
        		
        		int cnt = guestBasketList.get(i).getQuantity(); // quantity값을 들고와서 cnt에 저장한 후  
        		guestBasketList.get(i).setQuantity(cnt+1); // cnt의 값을 하나 더해주고 quantity에 지정해준다
        		chk = true; // quantity값 바꿔줬으면 chk값 true로 변경
        		break; 
        	 }
          }
          
          if(!chk) { // 원래 있던 상품이 아니라면 
        	 guestBasketList.add(guestBasket); // 새로운 상품 넣어주기
          }  
          
          //디버깅
          for(int i=0; i<guestBasketList.size(); i+=1) {
        	  System.out.println("-------------basket-------");
        	  System.out.println("AddBasketController (doGet) productId :" + guestBasketList.get(i).getProductId());
        	  System.out.println("AddBasketController (doGet) photoName :" + guestBasketList.get(i).getPhotoName());
        	  System.out.println("AddBasketController (doGet) productName :" + guestBasketList.get(i).getProductName());
        	  System.out.println("AddBasketController (doGet) gram :" + guestBasketList.get(i).getGram());
        	  System.out.println("AddBasketController (doGet) price :" + guestBasketList.get(i).getPrice());
        	  System.out.println("AddBasketController (doGet) quantity :" + guestBasketList.get(i).getQuantity());
          }
    	  
      }else { // 장바구니에 상품이 하나도 없다면
    	  guestBasketList.add(guestBasket); // 새로운 상품 넣어주기
    	  session.setAttribute("guestBasketList", guestBasketList);
      }
      
      System.out.println("AddGuestBasketController END");
     
      //리다이렉트
      response.sendRedirect(request.getContextPath()+"/basketListController");
    }
}