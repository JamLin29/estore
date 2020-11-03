package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.util.GetInstance;

@WebServlet("/viewBook")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		if (Objects.isNull(id)) {
			request.getRequestDispatcher("viewBook.jsp").forward(request, response);
			return;
		}
		Book book = GetInstance.BOOK_SERVER.selectBookById(Integer.valueOf(id));
		session.setAttribute("viewBookInf", book);
		request.getRequestDispatcher("viewBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
