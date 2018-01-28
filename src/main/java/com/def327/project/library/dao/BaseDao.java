package com.def327.project.library.dao;

import com.def327.project.library.domain.AbstractBase;

import java.math.BigInteger;
import java.util.List;

/**
 * Created def327 on 1/28/18.
 */
public interface BaseDao<T extends AbstractBase> {

    List<T> getAll();

    T get(BigInteger id);

    T save(T obj);

    void delete(T object);
}