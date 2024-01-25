package com.cbfacademy.apiassessment.Core;

import java.util.Optional;

import com.cbfacademy.apiassessment.Model.Employee;

public interface Repository<T, ID> {

    Iterable<Employee> findAll();

    Optional<Employee> findById(ID id);

    T save(T entity);

    void delete(T entity);
}