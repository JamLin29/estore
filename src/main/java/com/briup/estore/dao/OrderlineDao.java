package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.OrderLineExample;
import com.briup.estore.mapper.OrderLineMapper;
import com.briup.estore.util.SqlSessionUtil;

public class OrderlineDao {
	public List<OrderLine> selectOrderLineByOrderId(Integer oid) {
		SqlSession session = SqlSessionUtil.getSqlSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		OrderLineExample example = new OrderLineExample();
		example.createCriteria().andOrderIdEqualTo(oid);
		List<OrderLine> orderLines = mapper.selectByExample(example);
		session.close();
		return orderLines;
	}
}
