package filter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;


public class CorsFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("utf-8");
		HttpServletResponse res = (HttpServletResponse) response;
		request.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=UTF-8");  
		   res.setHeader("Access-Control-Allow-Origin", "*");  
		   res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
		   res.setHeader("Access-Control-Max-Age", "0");  
		   res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");  
		   res.setHeader("Access-Control-Allow-Credentials", "true");  
		   res.setHeader("XDomainRequestAllowed","1");  
		   response.setCharacterEncoding("utf-8");
		   chain.doFilter(request, response);  
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
