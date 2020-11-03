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
import com.briup.estore.bean.ex.OrderEX;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.util.GetInstance;
import com.briup.estore.util.Tools;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer cid = Integer.valueOf((String) session.getAttribute("cid"));
		String payString = request.getParameter("buynow");
		if (Objects.nonNull(payString)) {
			GetInstance.SHOPCAR_SERVER.deleteShopCarByCustomerId(cid);
			response.sendRedirect(request.getContextPath() + "/pay");
			return;
		}
		@SuppressWarnings("unchecked")
		Map<ShopCar, Book> map = (Map<ShopCar, Book>) session.getAttribute("shopCar");
		OrderEX orderEX = Tools.orderSure(map, cid);
		GetInstance.ORDER_SERVER.insertOrder(orderEX);
		
		request.setAttribute("paying_id", orderEX.getOrder().getId());
		request.setAttribute("paying_total", orderEX.getOrder().getTotal());
		request.setAttribute("paying_name", "书籍订单" + orderEX.getOrder().getId());
		request.getRequestDispatcher("paying").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
