package com.cbfacademy.apiassessment.Core;

import java.util.List;

public interface Repository<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T entity);

    void delete(T entity);
}