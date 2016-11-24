package dao;

import model.BaseObject;

import java.util.List;

public interface BaseObjectDao<T extends BaseObject> {
    List<T> findAll();
    T find(int id);
//    int save (T obj);
    void delete(int id);
    void update(int id, T obj);
}
