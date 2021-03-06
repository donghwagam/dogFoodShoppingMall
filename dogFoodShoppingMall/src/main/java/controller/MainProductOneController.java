package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MainProductDao;
import dao.QnaDao;
import dao.ReviewDao;
import vo.Category;
import vo.Qna;
import vo.ProductPhoto;
@WebServlet("/mainProductOneController")
public class MainProductOneController extends HttpServlet {
	private MainProductDao mainProductDao; //맴버 변수 MainProductDao 선언
	private ReviewDao reviewDao;
	private QnaDao qnaDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); // 세션 정보 불러오기
		// 선택한 상품의 productId값을 받아옴
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("MainProductOneController.doGet() productId : " + productId);
		
		// 로그인한 memberId를 받아옴
		String memberId = (String)session.getAttribute("sessionMemberId");
		System.out.println("MainProductOneController.doGet() memberId : " + memberId);
		
		request.setAttribute("productId", productId);
		
		this.mainProductDao = new MainProductDao(); // dao 호출
		
		// 선택한 상품 상세정보 불러오는 리스트
		List<Map<String, Object>> list = mainProductDao.selectProductOne(productId);
		System.out.println("MainProductOneController.doGet() list size : " + list.size());
		
		// 선택한 상품 상세정보 페이지에서 리뷰 불러오는 리스트
		this.reviewDao = new ReviewDao();
		List<Map<String, Object>> selectReviewList = reviewDao.selectReview(productId);
		request.setAttribute("selectReviewList", selectReviewList);
		System.out.println("MainProductController.doGet() selectReviewList size : " + selectReviewList.size());
		
		// 선택한 상품 리뷰 count 가져오는 메서드
		int reviewCnt = reviewDao.selectCountReview(productId);
		request.setAttribute("reviewCnt", reviewCnt);
		System.out.println("MainProductOneController.doGet() reviewCnt : " + reviewCnt);
		
		// 선택한 상품 상세정보 페이지에서 qna 불러오는 리스트
		this.qnaDao = new QnaDao();
		List<Qna> selectQnaList = qnaDao.selectQna(productId);
		request.setAttribute("selectQnaList", selectQnaList);
		System.out.println("MainProductController.doGet() selectQnaList size : " + selectQnaList.size());
		
		// 선택한 상품 qna 질문 count 가져오는 메서드
		int qnaCnt = qnaDao.selectCountQna(productId);
		request.setAttribute("qnaCnt", qnaCnt);
		System.out.println("MainProductOneController.doGet() qnaCnt : " + qnaCnt);
		
		
		// 상품의 평점을 나타내는 메서드
		double star = reviewDao.selectStarAverage(productId);
		request.setAttribute("star", star);
		
		// 카테고리 정보 불러오는 리스트
		List<Category> categoryList =  mainProductDao.selectCategoryList();
		
		//정보제공용 사진 불러오는 리스트 
		List<ProductPhoto> photoList = mainProductDao.selectPhotoList(productId);
		
		System.out.println("MainProductController.doGet() categoryList size :" + categoryList.size());
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("photoList", photoList);
		request.setAttribute("list", list);
		request.setAttribute("memberId", memberId);
		
		request.getRequestDispatcher("/WEB-INF/view/mainProductOne.jsp").forward(request, response);
	}

}
