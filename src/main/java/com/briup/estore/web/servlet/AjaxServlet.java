package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.util.GetInstance;

@WebServlet("/ajax/*")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String method = req.getParameter("method");
			if (!Objects.isNull(method)) {
				Method aMethod = this.getClass().getDeclaredMethod(method, 
						HttpServletRequest.class, HttpServletResponse.class);
				aMethod.setAccessible(true);
				aMethod.invoke(this, req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		try {
			String username = req.getParameter("username");
			boolean is_UsernameOk = GetInstance.COSTOMER_SERVER.checkUsername(username);
			if (is_UsernameOk) {
				writer.print("YES");
			} else {
				writer.print("NO");
			}
			writer.flush();
		} catch (Exception e) {
			writer.print("ERROR");
			writer.flush();
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	@SuppressWarnings("unused")
	private void deleteShopCarBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		try {
			String shopcarId = req.getParameter("id");
			GetInstance.SHOPCAR_SERVER.deleteShopCarById(Integer.valueOf(shopcarId));
			writer.print("YES");
			writer.flush();
		} catch (Exception e) {
			writer.print("ERROR");
			writer.flush();
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	@SuppressWarnings("unused")
	private void updateShopCarBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		try {
			Integer shopcarId = Integer.valueOf(req.getParameter("id"));
			Integer num = Integer.valueOf(req.getParameter("num"));
			GetInstance.SHOPCAR_SERVER.updateShopCarNumById(shopcarId, num);
			writer.print("YES");
			writer.flush();
		} catch (Exception e) {
			writer.print("ERROR");
			writer.flush();
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	@SuppressWarnings("unused")
	private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		try {
			Integer orderId = Integer.valueOf(req.getParameter("id"));
			GetInstance.ORDER_SERVER.deleteOrder(orderId);
			writer.print("YES");
			writer.flush();
		} catch (Exception e) {
			writer.print("ERROR");
			writer.flush();
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
}
