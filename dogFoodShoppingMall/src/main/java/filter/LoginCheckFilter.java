package filter;

import java.io.IOException; 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/loginCheck/*")
public class LoginCheckFilter implements Filter { // 로그인 안되어있으면 로그인 페이지로 이동

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	     if(request instanceof HttpServletRequest) { // request가 HttpServletRequest로 변경가능하다면 
			HttpServletRequest req = (HttpServletRequest)request; 
			HttpSession session = req.getSession(); //세션 불러오기 
			String memberId = (String)session.getAttribute("sessionMemberId"); // 현재 접속중인 아이디
			
			if(memberId == null) { // 로그인이 안돼있으면
				if(response instanceof HttpServletResponse) {
					((HttpServletResponse)response).sendRedirect(req.getContextPath()+"/loginDenied/loginController"); // 로그인 페이지로 이동
					
				} 
			}
	     }
	     chain.doFilter(request, response);
	}

}
