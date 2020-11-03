package com.briup.estore.bean.ex;

import java.util.List;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Order;
import com.briup.estore.bean.OrderLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEX {
	private Order order;
	private List<OrderLine> orderLines;
	private List<Book> book;
}
