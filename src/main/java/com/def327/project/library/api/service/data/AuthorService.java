package com.def327.project.library.api.service.data;

import com.def327.project.library.dao.entities.Author;

import java.util.List;

public interface AuthorService extends BaseService<Author> {

    List<Author> search(String... searchString);
}