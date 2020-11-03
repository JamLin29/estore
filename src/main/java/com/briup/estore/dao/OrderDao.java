package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Order;
import com.briup.estore.bean.OrderExample;
import com.briup.estore.mapper.OrderMapper;
import com.briup.estore.util.SqlSessionUtil;

public class OrderDao {
	public List<Order> selectOrderByCustomerId(Integer cid) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		OrderExample example = new OrderExample();
		example.createCriteria().andCustomerIdEqualTo(cid);
		List<Order> orders = mapper.selectByExample(example);
		sqlSession.close();
		return orders;
	}
	
	public void insertOrder(Order order) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		mapper.insert(order);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void deleteOrder(Integer id) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		mapper.deleteByPrimaryKey(id);
		sqlSession.commit();
		sqlSession.close();
	}
}
