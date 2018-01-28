package com.def327.project.library.dao;

import com.def327.project.library.domain.Book;

import java.util.List;

public interface BookDao extends BaseDao<Book> {

    List<Book> search(String... searchString);

    List<Book> findTopBooks(int limit);
}