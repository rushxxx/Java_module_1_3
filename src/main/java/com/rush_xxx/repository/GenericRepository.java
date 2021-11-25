package com.rush_xxx.repository;

import java.util.List;

public interface GenericRepository <T, ID>{
    T getById(ID id);
    void deleteById(ID id);
    List<T> getAll();
    T save(T t);
    T update (T t);
}