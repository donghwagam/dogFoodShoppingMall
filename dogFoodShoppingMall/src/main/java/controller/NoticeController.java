package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import vo.Notice;

@WebServlet("/noticeController")
public class NoticeController extends HttpServlet {
	
	private NoticeDao noticeDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		noticeDao = new NoticeDao();
		List<Notice> noticeList = noticeDao.selectNoticeList();
		
		for(Notice n : noticeList) {
			System.out.println(n.getNoticeId());
			System.out.println(n.getNoticeTitle());
			System.out.println(n.getCreateDate());
		}
		
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("/WEB-INF/view/notice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
