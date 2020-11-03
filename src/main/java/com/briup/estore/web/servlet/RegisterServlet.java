package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.util.GetInstance;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			String permit = req.getParameter("permit");
			if (!Objects.equals(permit, "yes")) {
				session.setAttribute("register-msg", "您未勾选服务协议！");
				resp.sendRedirect(req.getContextPath() + "/register");
				return;
			}
			
			String name = req.getParameter("username");
			String password = req.getParameter("password");
			String zip = req.getParameter("zip");
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			
			Customer customer = new Customer();
			customer.setUsername(name);
			customer.setPassword(password);
			customer.setZip(zip);
			customer.setAddress(address);
			customer.setPhone(phone);
			customer.setEmail(email);
			
			GetInstance.COSTOMER_SERVER.register(customer);
			
			session.setAttribute("login_msg", "注册成功，请登录");
			resp.sendRedirect(req.getContextPath() + "/login");
			
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("register_msg", "注册失败："+e.getMessage());
			resp.sendRedirect(req.getContextPath() + "/register");
		}
	}
}
