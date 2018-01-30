package com.def327.project.library.dao.service;

import com.def327.project.library.dao.entities.Publisher;

import java.util.List;

public interface PublisherService extends BaseService<Publisher> {

    List<Publisher> search(String... searchString);
}