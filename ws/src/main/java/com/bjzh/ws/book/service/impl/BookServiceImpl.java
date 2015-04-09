package com.bjzh.ws.book.service.impl;

import com.bjzh.ws.book.entity.Book;
import com.bjzh.ws.book.service.IBookService;

public class BookServiceImpl implements IBookService {

	public Book getBookById(int id) {
		Book book = new Book(id, "china");
		return book;
	}

}