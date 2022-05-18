package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

@WebServlet("/deleteMemberController")
public class DeleteMemberController extends HttpServlet {
   private MemberDao memberDao; // 멤버변수 MemberDao선언
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.getRequestDispatcher("/WEB-INF/view/deleteMember.jsp").forward(request, response); // 회원타 페이지 연결
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.memberDao = new MemberDao();
      
      HttpSession session = request.getSession(); // 현재 세션 받아오기
      
      String memberId = (String) session.getAttribute("sessionMemberId"); // memberId 받아오기   
      String checkPw = request.getParameter("checkPw"); // 내가 쓴 checkPw 받아오기 
      
      int memberDogId = -1;
      /*
      memberDogId = memberDao.selectMemberDogIdAndCheckPw(memberId); // memberDogId 받아오기
      if(memberDogId == -1) { // 사용자가 등록한 애견이 없다면 
         response.sendRedirect(request.getContextPath()+"/deleteMemberController");
         return;
      } else {
         System.out.println("삭제성공 ------------------------");
         response.sendRedirect(request.getContextPath()+"/mainPageController");
      }
      */
      memberDao.deleteMember(memberDogId, memberId, checkPw); // 메서드 실행 후 반환값(현재 로그인 된 ID,PW) 저장

   }

}