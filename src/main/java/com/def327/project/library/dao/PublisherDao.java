package com.def327.project.library.dao;

import com.def327.project.library.domain.Publisher;

import java.util.List;

public interface PublisherDao extends BaseDao<Publisher> {

    List<Publisher> search(String... searchString);
}