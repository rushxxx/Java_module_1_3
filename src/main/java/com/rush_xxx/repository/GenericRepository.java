package com.rush_xxx.repository;

public interface GenericRepository <T, ID>{
    T getById(ID id);
    void remove(ID id);
}
