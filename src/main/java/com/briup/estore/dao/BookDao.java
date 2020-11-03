package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.BookExample;
import com.briup.estore.mapper.BookMapper;
import com.briup.estore.util.SqlSessionUtil;

public class BookDao {
	public List<Book> selectAllBook() {
		SqlSession session = SqlSessionUtil.getSqlSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> books = mapper.selectByExample(null);
		session.close();
		return books;
	}
	
	public List<Book> selectBookByCategory(Integer cid) {
		SqlSession session = SqlSessionUtil.getSqlSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		BookExample bookExample = new BookExample();
		bookExample.createCriteria().andCategoryIdEqualTo(cid);
		List<Book> books = mapper.selectByExample(bookExample);
		session.close();
		return books;
	}
	
	public Book selectBookById(Integer id) {
		SqlSession session = SqlSessionUtil.getSqlSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		Book book = mapper.selectByPrimaryKey(id);
		session.close();
		return book;
	}
}
