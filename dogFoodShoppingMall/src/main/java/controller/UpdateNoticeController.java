package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.el.fmt.RequestEncodingTag;

import dao.NoticeDao;
import vo.Notice;

@WebServlet("/updateNoticeController")
public class UpdateNoticeController extends HttpServlet {
	
	private NoticeDao noticeDao; // 멤버변수생성
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.noticeDao = new NoticeDao(); // selectContent 메서드호출을 위한 객체생성  
		
		int noticeId = Integer.parseInt(request.getParameter("noticeId")); // noticeId값 받아오기
		System.out.println("UpdateNoticeController.doGet() noticeId : " + noticeId); // 디버깅

		Notice updateContent = noticeDao.selectContent(noticeId); // Notice객체의 변수에 메서드

		request.setAttribute("updateContent", updateContent);
		request.getRequestDispatcher("/WEB-INF/view/updateNotice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.noticeDao = new NoticeDao(); // updateContent 메서드 호출을 위한 객체생성
		
		// 요청값 받아오기
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		// 디버깅
		System.out.println("UpdateNoticeController.doPost() noticeId : " + noticeId);
		System.out.println("UpdateNoticeController.doPost() noticeTitle : " + noticeTitle);
		System.out.println("UpdateNoticeController.doPost() noticeContent : " + noticeContent);
		
		// 데이터 바인디
		Notice notice = new Notice();
		notice.setNoticeId(noticeId);
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		
		// 공지사항 수정할 메서드 호출
		int row = this.noticeDao.updateNotice(notice);
			
		if(row != 1) {
			response.sendRedirect(request.getContextPath()+"/updateNoticeController?noticeId= " + noticeId);
		} else {
			response.sendRedirect(request.getContextPath()+"/noticeContentController?noticeId=" + noticeId);
		}
	}

}
