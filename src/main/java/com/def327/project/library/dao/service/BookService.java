package com.def327.project.library.dao.service;

import com.def327.project.library.dao.entities.Book;

import java.util.List;

public interface BookService extends BaseService<Book> {

    List<Book> search(String... searchString);

    List<Book> findTopBooks(int limit);
}