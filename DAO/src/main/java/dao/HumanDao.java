package dao;

import model.Human;

import java.util.List;

public interface HumanDao {
    List<Human> findAll();
    Human find(int id);
    int save(Human obj);
    void delete(int id);
    void update(Human obj);
}
