package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.util.Tools;

@WebServlet("/index")
public class DefaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> cookiesMap = Tools.cookiesToMap(request.getCookies());
		
		if (Objects.equals(cookiesMap.get("permit"), "yes")) {
			session.setAttribute("permit", "yes");
			session.setAttribute("username", cookiesMap.get("username"));
			session.setAttribute("cid", cookiesMap.get("cid"));
			session.setAttribute("login_msg", "登录成功");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
