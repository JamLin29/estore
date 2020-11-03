package com.briup.estore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Category;
import com.briup.estore.bean.CategoryExample;
import com.briup.estore.mapper.CategoryMapper;
import com.briup.estore.util.SqlSessionUtil;

public class CategoryDao {
	public Map<Category, List<Category>> selectCategoryMap() {
		SqlSession session = SqlSessionUtil.getSqlSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		CategoryExample fatherIdIsNull = new CategoryExample();
		fatherIdIsNull.createCriteria().andFatherIdIsNull();
		List<Category> categories = mapper.selectByExample(fatherIdIsNull);
		Map<Category, List<Category>> map = new HashMap<>();
		
		categories.forEach(c -> {
			Integer id = c.getId();
			if (Objects.nonNull(id)) {
				CategoryExample example = new CategoryExample();
				example.createCriteria().andFatherIdEqualTo(id);
				List<Category> selectByExample = mapper.selectByExample(example);
				map.put(c, selectByExample);
			}
		});
		session.close();
		return map;
	}
}
