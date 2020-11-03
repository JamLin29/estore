package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.util.Tools;

@WebServlet("/return")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tradeNo = request.getParameter("trade_no");
		if (Objects.isNull(tradeNo)) {
			response.sendRedirect("index");
			return;
		}
		boolean status = Tools.checkOrderStatus(tradeNo);
		if (status) {
			request.getRequestDispatcher("WEB-INF/payOK.jsp").forward(request, response);
		} else {
			request.setAttribute("trade_no", tradeNo);
			request.getRequestDispatcher("WEB-INF/payWaiting.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
