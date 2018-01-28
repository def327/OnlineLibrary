package com.def327.project.library.dao;

import com.def327.project.library.domain.Author;

import java.util.List;

public interface AuthorDao extends BaseDao<Author> {

    List<Author> search(String... searchString);
}