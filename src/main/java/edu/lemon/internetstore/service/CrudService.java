package edu.lemon.internetstore.service;

import java.util.List;

public interface CrudService<T, U> {

    void addData(T data);
    List<T> getAllData();
    List<T> getDataByKey(U key);
    void saveObject(T object);
    boolean updateByKey(T object, U key);
    boolean deleteByKey(T object, U key);

}
