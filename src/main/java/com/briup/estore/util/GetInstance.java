package com.briup.estore.util;

import com.briup.estore.dao.BookDao;
import com.briup.estore.dao.CategoryDao;
import com.briup.estore.dao.CustomerDao;
import com.briup.estore.dao.OrderDao;
import com.briup.estore.dao.OrderlineDao;
import com.briup.estore.dao.ShopCarDao;
import com.briup.estore.server.BookServer;
import com.briup.estore.server.CategoryServer;
import com.briup.estore.server.CostomerServer;
import com.briup.estore.server.OrderServer;
import com.briup.estore.server.ShopCarServer;

public class GetInstance {
	public static final CostomerServer COSTOMER_SERVER = new CostomerServer();
	public static final CustomerDao COSTOMER_DAO = new CustomerDao();
	public static final BookDao BOOK_DAO = new BookDao();
	public static final BookServer BOOK_SERVER = new BookServer();
	public static final CategoryDao CATEGORY_DAO = new CategoryDao();
	public static final CategoryServer CATEGORY_SERVER = new CategoryServer();
	public static final OrderDao ORDER_DAO = new OrderDao();
	public static final OrderServer ORDER_SERVER = new OrderServer();
	public static final OrderlineDao ORDERLINE_DAO = new OrderlineDao();
	public static final ShopCarDao SHOPCAR_DAO = new ShopCarDao();
	public static final ShopCarServer SHOPCAR_SERVER = new ShopCarServer();
	public static final IdWorker ID = new IdWorker();
}
