package com.ecommerce.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionCheckFilter implements Filter {

	private String contextPath;

	@Override
	public void init(FilterConfig fc) throws ServletException {
		contextPath = fc.getServletContext().getContextPath();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if (req.getSession().getAttribute("LOGIN_USER") == null) {
			if (req.getSession().getAttribute("FIRST_TIME") == null) {

				// res.sendRedirect(contextPath + "/logout.jsp");
			} else {
				res.sendRedirect(contextPath + "/logout.jsp");
			}
		}
	}

	@Override
	public void destroy() {
	}
}