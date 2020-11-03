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
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.util.GetInstance;
import com.briup.estore.util.Tools;

@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer cid = Integer.valueOf((String) session.getAttribute("cid"));
		Customer customerInf = GetInstance.COSTOMER_SERVER.selectCustomerById(cid);
		request.setAttribute("customerInf", customerInf);
		String bookId = request.getParameter("id");
		if (Objects.isNull(bookId)) {
			Map<ShopCar, Book> map = GetInstance.SHOPCAR_SERVER.selectShopCarByCustomerId(cid);
			session.setAttribute("shopCar", map);
			session.setAttribute("sumValue", Tools.sumPrice(map));
			request.setAttribute("payString", "?buynow=no");
		} else {
			Book book = GetInstance.BOOK_SERVER.selectBookById(Integer.valueOf(bookId));
			Map<ShopCar, Book> map = Tools.bookToOrderMap(book, cid);
			session.setAttribute("shopCar", map);
			session.setAttribute("sumValue", book.getPrice());
		}
		request.getRequestDispatcher("WEB-INF/confirm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
