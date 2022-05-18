package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DogDao;

@WebServlet("/deleteDogController")
public class DeleteDogController extends HttpServlet {
   private DogDao dogDao;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.dogDao = new DogDao();
      
      // 요청값 불러오기
      int memberDogId = Integer.parseInt(request.getParameter("memberDogId"));
      
      //삭제 구현 위한 메서드 호출해서 강아지 정보 삭제
      dogDao.deleteDog(memberDogId);
      
      //삭제 했으면 다시 회원 정보 보여주는 컨트롤러로 리다이렉트
      response.sendRedirect(request.getContextPath()+"/memberOneController");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
   }

}