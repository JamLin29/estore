package com.briup.estore.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.servlet.http.Cookie;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.briup.estore.bean.Book;
import com.briup.estore.bean.Order;
import com.briup.estore.bean.ex.OrderEX;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopCar;

public class Tools {
	
	public static Map<String, String> cookiesToMap(Cookie[] cookies) {
		Map<String, String> map = new HashMap<>();
		if (Objects.isNull(cookies)) {
			return map;
		}
		for (Cookie cookie : cookies) {
			map.put(cookie.getName(), cookie.getValue());
		}
		return map;
	}
	
	public static double sumPrice(Map<ShopCar, Book> map) {
		double sum = 0.0;
		for (Entry<ShopCar, Book> entry : map.entrySet()) {
			sum += entry.getKey().getNum() * entry.getValue().getPrice();
		}
		return sum;
	}
	
	public static OrderEX orderSure(Map<ShopCar, Book> map, Integer cid) {
		Order order = new Order();
		Integer oid = Math.abs((int)GetInstance.ID.nextId());
		order.setId(oid);
		order.setTotal(Float.valueOf((float)sumPrice(map)));
		order.setCustomerId(cid);
		order.setOrderdate(new Date());
		
		List<OrderLine> list = new ArrayList<>();
		for (Entry<ShopCar, Book> entry : map.entrySet()) {
			OrderLine orderLine = new OrderLine();
			orderLine.setNum(entry.getKey().getNum());
			orderLine.setBookId(entry.getValue().getId());
			orderLine.setOrderId(oid);
			list.add(orderLine);
		}
		OrderEX orderEX = new OrderEX();
		orderEX.setOrder(order);
		orderEX.setOrderLines(list);
		return orderEX;
	}
	
	public static Map<ShopCar, Book> bookToOrderMap(Book book, Integer cid) {
		Map<ShopCar, Book> map = new HashMap<>();
		ShopCar shopCar = new ShopCar();
		shopCar.setBookId(book.getId());
		shopCar.setNum(1);
		shopCar.setCustomerId(cid);
		map.put(shopCar, book);
		return map;
	}
	
	public static boolean checkOrderStatus(String tradeNo) {
		try {
			AlipayClient alipayClient = AlipayConfig.getAlipayClientGBK();
			AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("{\"trade_no\":\"")
				.append(tradeNo).append("\"}");
			request.setBizContent(stringBuilder.toString());
			AlipayTradeQueryResponse response = alipayClient.execute(request);
			if(response.isSuccess() &&
					Objects.equals(response.getTradeStatus(), "TRADE_SUCCESS")){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
