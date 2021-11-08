package com.rush_xxx.controller;

import java.util.List;

public interface GenericController <T, ID>{
    void create(T t);
    T read(ID id);
    void update (ID id, T t);
    void delete(ID id);
    List readAll();
}
