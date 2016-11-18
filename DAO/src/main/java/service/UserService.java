package service;

import model.User;

import java.util.List;

public interface UserService {
    boolean isRegistered(String name);
    void addUser(User user);
    User getUser(int id);
    void update(User user);
    void removeUser(int id);
    List<User> findAll();
}
