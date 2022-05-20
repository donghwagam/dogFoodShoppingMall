package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ReviewDao;


@WebServlet("/loginCheck/insertReviewController")
public class InsertReviewController extends HttpServlet {
	
	private ReviewDao reviewDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int purchaseId = Integer.parseInt(request.getParameter("purchaseId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		System.out.println("InsertReviewController.doGet() purchaseId : " + purchaseId);
		System.out.println("InsertReviewController.doGet() productId : " + productId);
		
		request.setAttribute("purchaseId", purchaseId);
		request.setAttribute("productId", productId);
		
		this.reviewDao = new ReviewDao();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("purchaseId", purchaseId);
		map.put("productId", productId);
		
		int cnt = reviewDao.checkInsertReview(map);
		System.out.println("InsertReviewController.doGet() cnt : " + cnt);
		
		if (cnt == 0) {
			
			request.getRequestDispatcher("/WEB-INF/view/insertReview.jsp").forward(request, response);
			
		} else {
			
			request.getRequestDispatcher("/WEB-INF/view/checkInsertReview.jsp").forward(request, response);
		}
		
		
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String path = request.getSession().getServletContext().getRealPath("/insertReviewPhoto");
	System.out.println("insertReviewController.doPost() 사진 경로 : " + path);
	
	MultipartRequest multiReq = new MultipartRequest(request, path, 1024*1024*100, "utf-8", new DefaultFileRenamePolicy());
	
	// 그 외 입력값 처리
	int productId = Integer.parseInt(multiReq.getParameter("productId"));
	int purchaseId = Integer.parseInt(multiReq.getParameter("purchaseId"));
	String title = multiReq.getParameter("title");
	String reviewContent = multiReq.getParameter("reviewContent");
	int star= Integer.parseInt(multiReq.getParameter("star"));
	
	// <input type="file" name="reviewPhoto"> 처리
	String originalName = multiReq.getOriginalFileName("reviewPhoto");
	String photoName = multiReq.getFilesystemName("reviewPhoto");
	String photoType = multiReq.getContentType("reviewPhoto");
 	
	System.out.println("InsertReviewController.doPost() title : " + title);
	System.out.println("InsertReviewController.doPost() reviewContent : " + reviewContent);
	System.out.println("InsertReviewController.doPost() star : " + star);
	System.out.println("InsertReviewController.doPost() originalName : " + originalName);
	System.out.println("InsertReviewController.doPost() photoName : " + photoName);
	System.out.println("InsertReviewController.doPost() photoType : " + photoType);
	
	
	if(photoType.equals("image/gif") || photoType.equals("image/png") || photoType.equals("image/jpeg")) {
		System.out.println("DB에 사진이 들어갑니다!");
		this.reviewDao = new ReviewDao();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseId", purchaseId);
		map.put("productId", productId);
		map.put("title", title);
		map.put("reviewContent", reviewContent);
		map.put("star", star);
		map.put("originalName", originalName);
		map.put("photoName", photoName);
		map.put("photoType", photoType);
		
		reviewDao.insertReview(map);
		response.sendRedirect(request.getContextPath()+"/purchaseMemberListController");
	} else {
		System.out.println("이미지파일만 업로드해주세요!");
		File file = new File(path+"\\"+photoName);
		file.delete();
		response.sendRedirect(request.getContextPath()+"/loginCheck/insertReviewController");
	}
	
	}

}
