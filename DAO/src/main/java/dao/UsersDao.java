package dao;

import model.User;

import java.util.List;

public interface UsersDao {
    List<User> findAll();
    User find(int id);
    int save (User user);
    void delete(int userId);
    void update(int id, User user);
}
