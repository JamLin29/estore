package com.briup.estore.server;

import java.util.List;
import java.util.Map;

import com.briup.estore.bean.Category;
import com.briup.estore.util.GetInstance;

public class CategoryServer {
	public Map<Category, List<Category>> selectCategoryMap() {
		return GetInstance.CATEGORY_DAO.selectCategoryMap();
	}
}
