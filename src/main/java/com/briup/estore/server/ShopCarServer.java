package com.briup.estore.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.util.EstoreException;
import com.briup.estore.util.ExceptionEnum;
import com.briup.estore.util.GetInstance;

public class ShopCarServer {
	public Map<ShopCar, Book> selectShopCarByCustomerId(Integer cid) {
		if (Objects.isNull(cid)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		List<ShopCar> shopCars = GetInstance.SHOPCAR_DAO.selectShopCarByCustomerId(cid);
		Map<ShopCar, Book> map = new HashMap<>();
		shopCars.forEach(shopCar -> {
			Integer bid = shopCar.getBookId();
			Book book = GetInstance.BOOK_DAO.selectBookById(bid);
			map.put(shopCar, book);
		});
		return map;
	}
	
	public void selectAndUpdateShopCarByBookId(Integer cid, Integer bid) {
		if (Objects.isNull(cid) && Objects.isNull(bid)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		List<ShopCar> shopCars = GetInstance.SHOPCAR_DAO.selectShopCarByBookId(cid, bid);
		if (!shopCars.isEmpty()) {
			shopCars.forEach(shopCar -> {
				updateShopCarNumById(shopCar.getId(), shopCar.getNum() + 1);
			});
		} else {
			ShopCar shopCar = new ShopCar();
			shopCar.setBookId(bid);
			shopCar.setCustomerId(cid);
			shopCar.setNum(1);
			insertShopCar(shopCar);
		}
	}
	
	public void insertShopCar(ShopCar shopCar) {
		if (Objects.isNull(shopCar)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		GetInstance.SHOPCAR_DAO.insertShopCar(shopCar);
	}
	
	public void deleteShopCarById(Integer id) {
		if (Objects.isNull(id)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		GetInstance.SHOPCAR_DAO.deleteShopCarById(id);
	}
	
	public void deleteShopCarByCustomerId(Integer cid) {
		if (Objects.isNull(cid)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		GetInstance.SHOPCAR_DAO.deleteShopCarByCustomerId(cid);
	}
	
	public void updateShopCarNumById(Integer id, Integer num) {
		if (Objects.isNull(id) || Objects.isNull(num)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		GetInstance.SHOPCAR_DAO.updateShopCarNumById(id, num);
	}
}
