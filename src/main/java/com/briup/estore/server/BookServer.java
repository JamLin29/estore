package com.briup.estore.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.briup.estore.bean.Book;
import com.briup.estore.util.EstoreException;
import com.briup.estore.util.ExceptionEnum;
import com.briup.estore.util.GetInstance;

public class BookServer {
	public List<List<Book>> selectBookHalf() {
		List<Book> allBooks = GetInstance.BOOK_DAO.selectAllBook();
		Collections.shuffle(allBooks);
		List<List<Book>> list = new ArrayList<>();
		list.add(allBooks.subList(0, 5));
		list.add(allBooks.subList(5, 10));
		return list;
	}
	
	public List<Book> selectBookByCategory(Integer cid) {
		if (Objects.isNull(cid)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		return GetInstance.BOOK_DAO.selectBookByCategory(cid);
	}
	
	public Book selectBookById(Integer id) {
		if (Objects.isNull(id)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		return GetInstance.BOOK_DAO.selectBookById(id);
	}
}
