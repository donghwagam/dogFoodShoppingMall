package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.NoticeDao;
import vo.Notice;

@WebServlet("/noticeController")
public class NoticeController extends HttpServlet {
	
	private NoticeDao noticeDao;
	private AdminDao adminDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); // 세션정보불러오기
		String memberId = (String) session.getAttribute("sessionMemberId"); // memberId 변수에 세션정보저장
		
		adminDao = new AdminDao();
		
		int level = adminDao.selectAdminFilterList(memberId);
		
		noticeDao = new NoticeDao();
		List<Notice> noticeList = noticeDao.selectNoticeList();
		
		for(Notice n : noticeList) {
			System.out.println(n.getNoticeId());
			System.out.println(n.getNoticeTitle());
			System.out.println(n.getCreateDate());
		}
		
		request.setAttribute("level", level);
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("/WEB-INF/view/notice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
