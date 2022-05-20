package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import vo.Notice;

@WebServlet("/noticeContentController")
public class NoticeContentController extends HttpServlet {
	
	private NoticeDao noticeDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		noticeDao = new NoticeDao();
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		
		System.out.println("noticeId ---------------" +noticeId);
		Notice content = noticeDao.selectContent(noticeId);
		
		request.setAttribute("content", content);
		request.getRequestDispatcher("/WEB-INF/view/noticeContent.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
