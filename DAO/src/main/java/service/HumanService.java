package service;

import model.Human;

import java.util.List;

public interface HumanService {
    boolean isRegistered(String name);
    void add(Human human);
    Human get(int id);
    void update(Human human);
    void remove(int id);
    List<Human> findAll();
}
