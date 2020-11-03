package com.briup.estore.web.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.util.Tools;

@WebFilter(value = {"/login", "/register"})
public class LoginedFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String permit = (String) session.getAttribute("permit");
		
		if (Objects.equals(permit, "yes")) {
			if (Objects.equals(req.getParameter("exit"), "yes")) {
				chain.doFilter(req, resp);
				return;
			}
			session.setAttribute("index_msg", "您已登录，无需重复登陆");
			resp.sendRedirect(req.getContextPath() + "/index");
			return;
		}

		Map<String, String> cookiesMap = Tools.cookiesToMap(req.getCookies());
		if (Objects.equals(cookiesMap.get("permit"), "yes")) {
			session.setAttribute("permit", "yes");
			session.setAttribute("username", cookiesMap.get("username"));
			session.setAttribute("cid", cookiesMap.get("cid"));
			session.setAttribute("index_msg", "登录成功");
			resp.sendRedirect(req.getContextPath() + "/index");
			return;
		}

		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
