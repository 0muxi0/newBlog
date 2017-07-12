package com.Lee.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class Myfilter extends StrutsPrepareAndExecuteFilter {
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String url = request.getRequestURI();
		if ("/newBlog/background/jsp/imageUp.jsp".equals(url)
				|| "/newBlog/background/jsp/fileUp.jsp".equals(url)) {
			// System.out.println("使用自定义的过滤器");
			chain.doFilter(req, res);
		} else {
			// System.out.println("使用默认的过滤器");
			super.doFilter(req, res, chain);
		}
		
	}

}
