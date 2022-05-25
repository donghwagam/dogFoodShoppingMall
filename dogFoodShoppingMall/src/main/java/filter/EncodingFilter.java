package filter;

import java.io.IOException; 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
 
@WebFilter("/*") // 어떤 경로로 들어오던 필터실행
public class EncodingFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		// 필터 실행 되기 전
		request.setCharacterEncoding("utf-8"); 
		
		System.out.println("utf-8 인코딩 필터 실행"); // 디버깅
		
		chain.doFilter(request, response); 
		// 필터 실행 된 후
		
	}

	
}
