package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeDao;
import vo.Notice;

@WebServlet("/insertNoticeController")
public class InsertNoticeController extends HttpServlet {
	
	private NoticeDao noticeDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/insertNotice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.noticeDao = new NoticeDao(); // 메서드 사용을 위한 NoticeDao 객체생성
		
			
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		Notice notice = new Notice(); // notice 데이터바인딩
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		
		System.out.println("InsertNoticeController.doPost() noticeTitle : "+noticeTitle);
		System.out.println("InsertNoticeController.doPost() noticeContent : "+noticeContent);
		
		int row = noticeDao.insertNoitce(notice);
		
		if(row != 1) {
			System.out.println("공지사항 입력 실패");
			response.sendRedirect(request.getContextPath()+"/insertNoticeController");
		} else {
			System.out.println("공지사항 입력 성공");
			response.sendRedirect(request.getContextPath()+"/noticeController");
		}
		
	}

}
