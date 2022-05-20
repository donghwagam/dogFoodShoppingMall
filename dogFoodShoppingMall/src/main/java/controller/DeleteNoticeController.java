package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import vo.Notice;

@WebServlet("/deleteNoticeController")
public class DeleteNoticeController extends HttpServlet {
  
	private NoticeDao noticeDao; // 멤버변수 생성
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticeDao = new NoticeDao(); // deleteNotice 메서드 호출을 위한 객체생성
		
		// noticeId값 들고오기
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		
		// 데이터 바인딩
		Notice notice = new Notice();
		notice.setNoticeId(noticeId);
		
		// 메서드호출
		int row = noticeDao.deleteNotice(notice);
		
		// 성공실패 확인
		if(row != 1) {
			response.sendRedirect(request.getContextPath()+"/noticeContentController");
			System.out.println("DeleteNoticeController.doGet 공지사항 삭제실패");
		} else {
			response.sendRedirect(request.getContextPath()+"/noticeController");
			System.out.println("DeleteNoticeController.doGet 공지사항 삭제성공");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
