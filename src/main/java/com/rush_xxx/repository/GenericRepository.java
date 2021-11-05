package com.rush_xxx.repository;

import java.util.Collection;

public interface GenericRepository <T, ID>{
    T getById(ID id);
    void remove(ID id);
    Collection<T> viewAll();
}
