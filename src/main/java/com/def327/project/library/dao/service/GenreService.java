package com.def327.project.library.dao.service;

import com.def327.project.library.dao.entities.Genre;

import java.util.List;


public interface GenreService extends BaseService<Genre> {

    List<Genre> search(String... searchString);
}