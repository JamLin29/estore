package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.util.GetInstance;
import com.briup.estore.util.Tools;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Map<String, String> cookiesMap = Tools.cookiesToMap(req.getCookies());
		if (Objects.equals(req.getParameter("exit"), "yes")) {
			session.removeAttribute("permit");
			session.removeAttribute("username");
			session.removeAttribute("cid");
			session.setAttribute("index_msg", "您已成功退出登录！");
			cookiesMap.forEach((k, v) -> {
				Cookie cookie = new Cookie(k, null);
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			});
			resp.sendRedirect(req.getContextPath() + "/index");
			return;
		}
		req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String name = req.getParameter("name");
			String password = req.getParameter("password");

			Customer customer = new Customer();
			customer.setUsername(name);
			customer.setPassword(password);
			Integer customerId = GetInstance.COSTOMER_SERVER.login(customer);
			if (Objects.nonNull(customerId)) {
				session.setAttribute("permit", "yes");
				session.setAttribute("username", name);
				session.setAttribute("cid", customerId);
				session.setAttribute("index_msg", "您已成功登录！");
				Cookie permitCookie = new Cookie("permit", "yes");
				Cookie usernameCookie = new Cookie("username", name);
				Cookie cidCookie = new Cookie("cid", customerId.toString());
				permitCookie.setMaxAge(60 * 60 * 24);
				usernameCookie.setMaxAge(60 * 60 * 24);
				cidCookie.setMaxAge(60 * 60 * 24);
				resp.addCookie(permitCookie);
				resp.addCookie(usernameCookie);
				resp.addCookie(cidCookie);
				resp.sendRedirect(req.getContextPath() + "/index");
			} else {
				session.setAttribute("login_msg", "登录失败：用户名或密码错误");
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("login_msg", "登录失败："+e.getMessage());
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
