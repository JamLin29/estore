package com.briup.estore.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Order;
import com.briup.estore.bean.ex.OrderEX;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.OrderLineExample;
import com.briup.estore.mapper.OrderLineMapper;
import com.briup.estore.mapper.OrderMapper;
import com.briup.estore.util.EstoreException;
import com.briup.estore.util.ExceptionEnum;
import com.briup.estore.util.GetInstance;
import com.briup.estore.util.SqlSessionUtil;

public class OrderServer {
	public List<Order> selectOrderByCustomerId(Integer cid) {
		if(Objects.isNull(cid)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		return GetInstance.ORDER_DAO.selectOrderByCustomerId(cid);
	}
	
	public List<OrderEX> selectOrderEXByCustomerId(Integer cid) {
		List<Order> orders = selectOrderByCustomerId(cid);
		List<OrderEX> orderEXs = new ArrayList<>();
		orders.forEach(o -> {
			OrderEX orderEX = new OrderEX();
			orderEX.setOrder(o);
			List<OrderLine> orderLines = GetInstance.ORDERLINE_DAO.selectOrderLineByOrderId(o.getId());
			orderEX.setOrderLines(orderLines);
			List<Book> bookList = new ArrayList<>();
			orderLines.forEach(ol -> {
				Book book = GetInstance.BOOK_DAO.selectBookById(ol.getBookId());
				bookList.add(book);
			});
			orderEX.setBook(bookList);
			orderEXs.add(orderEX);
		});
		return orderEXs;
	}
	
	public void insertOrder(OrderEX orderEX) {
		if(Objects.isNull(orderEX)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		GetInstance.ORDER_DAO.insertOrder(orderEX.getOrder());
		OrderLineMapper lineMapper = sqlSession.getMapper(OrderLineMapper.class);
		for (OrderLine orderLine : orderEX.getOrderLines()) {
			lineMapper.insert(orderLine);
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void deleteOrder(Integer id) {
		if(Objects.isNull(id)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		OrderLineMapper lineMapper = sqlSession.getMapper(OrderLineMapper.class);
		OrderLineExample example = new OrderLineExample();
		example.createCriteria().andOrderIdEqualTo(id);
		lineMapper.deleteByExample(example);
		sqlSession.commit();
		
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		mapper.deleteByPrimaryKey(id);
		sqlSession.commit();
		sqlSession.close();
	}
}
