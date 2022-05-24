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
      
      request.getRequestDispatcher("/WEB-INF/view/deleteMember.jsp").forward(request, response); // 회원탈퇴 페이지 연결
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.memberDao = new MemberDao();
      
      HttpSession session = request.getSession(); // 현재 세션 받아오기
      
      String memberId = (String) session.getAttribute("sessionMemberId"); // memberId 받아오기   
      String checkPw = request.getParameter("checkPw"); // 내가 쓴 checkPw 받아오기 
      
      int memberDogId = -1; // 등록한 강아지가 없을때는 -1로 넘어가게 함
      memberDogId = memberDao.selectMemberDogId(memberId); // memberDogId 받아오기
      
      int row = memberDao.deleteMember(memberDogId, memberId, checkPw); // 메서드 실행 후 반환값(현재 로그인 된 ID,PW) 저장
      
      if(row == 1) {
         System.out.println("회원 탈퇴 성공!");
         request.getSession().invalidate(); // 기존 세션을 지우고 새로운 세션공간을 부여 //메인페이지로 갔을때 로그인해제 구현하기 위함
         response.sendRedirect(request.getContextPath()+"/mainPageController");
      } else {
         System.out.println("회원 탈퇴 실패!");
         response.sendRedirect(request.getContextPath()+"/deleteMemberController?msg=wrongpassword");
      }

   }

}