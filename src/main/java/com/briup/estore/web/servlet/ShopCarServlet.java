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

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.util.GetInstance;
import com.briup.estore.util.Tools;

@WebServlet("/shopCar")
public class ShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer cid = Integer.valueOf((String) session.getAttribute("cid"));
		String bookId = request.getParameter("id");
		if (Objects.nonNull(bookId)) {
			GetInstance.SHOPCAR_SERVER.selectAndUpdateShopCarByBookId(cid, Integer.valueOf(bookId));
			response.sendRedirect(request.getContextPath() + "/shopCar");
			return;
		} else {
			Map<ShopCar, Book> map = GetInstance.SHOPCAR_SERVER.selectShopCarByCustomerId(cid);
			session.setAttribute("shopCar", map);
			session.setAttribute("sumValue", Tools.sumPrice(map));
			request.getRequestDispatcher("WEB-INF/shopCar.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
