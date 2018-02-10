package com.def327.project.library.api.service.data;

import com.def327.project.library.dao.entities.AbstractBase;

import java.math.BigInteger;
import java.util.List;

/**
 * Created def327 on 1/28/18.
 */
public interface BaseService<T extends AbstractBase> {

    List<T> getAll();

    T get(BigInteger id);

    T save(T obj);

    void delete(T object);
}