package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ShopCar;
import com.briup.estore.bean.ShopCarExample;
import com.briup.estore.mapper.ShopCarMapper;
import com.briup.estore.util.SqlSessionUtil;

public class ShopCarDao {
	public List<ShopCar> selectShopCarByCustomerId(Integer cid) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
		ShopCarExample example = new ShopCarExample();
		example.createCriteria().andCustomerIdEqualTo(cid);
		List<ShopCar> shopCars = mapper.selectByExample(example);
		sqlSession.close();
		return shopCars;
	}
	
	public void insertShopCar(ShopCar shopCar) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
		mapper.insert(shopCar);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void deleteShopCarById(Integer id) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
		mapper.deleteByPrimaryKey(id);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void updateShopCarNumById(Integer id, Integer num) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
		ShopCar shopCar = new ShopCar();
		shopCar.setId(id);
		shopCar.setNum(num);
		mapper.updateByPrimaryKeySelective(shopCar);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<ShopCar> selectShopCarByBookId(Integer cid, Integer bid) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
		ShopCarExample example = new ShopCarExample();
		example.createCriteria().andCustomerIdEqualTo(cid).andBookIdEqualTo(bid);
		List<ShopCar> shopCars = mapper.selectByExample(example);
		sqlSession.close();
		return shopCars;
	}

	public void deleteShopCarByCustomerId(Integer cid) {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
		ShopCarExample example = new ShopCarExample();
		example.createCriteria().andCustomerIdEqualTo(cid);
		mapper.deleteByExample(example);
		sqlSession.commit();
		sqlSession.close();
	}
}
