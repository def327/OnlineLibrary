package com.def327.project.library.dao;

import com.def327.project.library.domain.Genre;

import java.util.List;


public interface GenreDao extends BaseDao<Genre> {

    List<Genre> search(String... searchString);
}