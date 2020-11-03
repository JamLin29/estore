package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.estore.util.AlipayConfig;

@WebServlet("/paying")
public class PayingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            AlipayClient alipayClient = AlipayConfig.getAlipayClient();
            //设置请求参数
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            AlipayTradePayModel model = new AlipayTradePayModel();
            
            model.setOutTradeNo(request.getAttribute("paying_id").toString()); // 设定订单号，不可重复
            model.setTotalAmount(request.getAttribute("paying_total").toString()); // 设置订单金额
            model.setSubject((String)request.getAttribute("paying_name")); // 订单名字
            
            model.setBody(System.currentTimeMillis() + ""); // 订单描述
            model.setProductCode("FAST_INSTANT_TRADE_PAY"); // 产品码
            alipayRequest.setBizModel(model); // 设置参数
            alipayRequest.setReturnUrl(AlipayConfig.return_url); // 设置回调地址
            
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
