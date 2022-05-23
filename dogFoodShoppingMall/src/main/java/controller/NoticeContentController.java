package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.NoticeDao;
import vo.Notice;

@WebServlet("/noticeContentController")
public class NoticeContentController extends HttpServlet {
	
	private NoticeDao noticeDao;
	private AdminDao adminDao; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); // 세션정보 호출하기
		String memberId = (String)session.getAttribute("sessionMemberId"); // memberId변수에 세션정보 담기
		
		adminDao = new AdminDao(); // selectAdminFilterList 메서드 호출을 위한 객체생성
		int level = adminDao.selectAdminFilterList(memberId); // memberId의 반환값level을 변수level에 담기
		
		noticeDao = new NoticeDao();
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		
		System.out.println("noticeId ---------------" +noticeId);
		Notice content = noticeDao.selectContent(noticeId);
		
		request.setAttribute("level", level);	
		request.setAttribute("content", content);
		request.getRequestDispatcher("/WEB-INF/view/noticeContent.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
