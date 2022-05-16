package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;


@WebServlet("/purchaseTotalListController")
public class PurchaseTotalListController extends HttpServlet {
	private AdminDao adminDao; // 지역변수 AdminDao 선언 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		this.adminDao = new AdminDao(); // AdminDao 호출 
		
		//------------------------검색--------------------------------------
		String memberId = request.getParameter("memberId"); // memberId 정보 받아오기 
		System.out.println("PurchaseTotalListController memberId : " + memberId); // memberId 디버깅 
		
		String status = ""; //  배송상태 변수 
		if (!status.equals("")) { // status 값이 null 이 아니면 
			status = request.getParameter("status"); // 받은 status 값을 변수에 저장 
		
		}
		System.out.println("PurchaseTotalListController status : " + status);
		
		String aDate = ""; // 주문일 검색하는변수 
		if(!aDate.equals("")) { // aDate값이 null이 아니면 
			aDate = request.getParameter("aDate"); // 받은 aDate값을 변수에 저장 
		}
		System.out.println("PurchaseTotalListController aDate : " + aDate);
		
		String bDate = ""; // 주문일 검색하는 변수 
		if (!bDate.equals("")) { // bDate 값이 null이 아니면 
			bDate = request.getParameter("bDate"); // bDate를변수에 저장
		}
		System.out.println("PurchaseTotalListController bDate : " + bDate);
		// -----------------------패이징---------------------------
		int currentPage = 1;  // 현재 페이지 
		if (request.getParameter("currentPage") != null ) { // 현재패이지값이 null 이 아니면 
			currentPage = Integer.parseInt(request.getParameter("currentPage")); // 현재 페이지 값 불러
		}
		
		int rowPerPage = 10; // 한패이지당 회원정보 10개씩 출력 
		int beginRow = (currentPage - 1)*rowPerPage;
		// 멤버 정보 출력 메서드 
		List<Map<String ,Object>> list = adminDao.selectPurchaseTotalListByPage(beginRow, rowPerPage, memberId, status,aDate,bDate);
		// 디버깅
		System.out.println("PurchaseTotalListController selectPurchaseTotalListByPage list.size() : " + list.size());
		
		// 페이지 끝 구하기 
		int lastPage = 0; // 마지막 페이지 
		
		int totalCount = adminDao.selectMemberTotalRow(); // 전체 리스트 수
		
		lastPage = (int)Math.ceil((double)totalCount / (double)rowPerPage); // 마지막 페이지 구하기
		
		request.setAttribute("list", list);
		request.setAttribute("memberId",memberId);
		request.setAttribute("status",status);
		request.setAttribute("aDate", aDate);
		request.setAttribute("bDate", bDate);
		request.getRequestDispatcher("WEB-INF/view/purchaseTotalList.jsp").forward(request, response);
	}

}
