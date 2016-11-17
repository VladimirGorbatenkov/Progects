package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;


public class UsersDaoArrayListImpl implements UsersDao {

    List<User> users;

    public UsersDaoArrayListImpl() {
        this.users = new ArrayList<User>();
    }
    public List<User> findAll() {
        return this.users;
    }

    public void update(int id, User user) throws IndexOutOfBoundsException{
        //у сохранемого юзера устанавливаем userId = id для поддержки связности
        User userForSave = new User(user.getUserName(), user.getUserLogin(), user.getUserPassword());
        User userForUpdate = users.get(id);
        userForUpdate = userForSave;
    }

    public int save(User user) {
        User userForSave = new User(user.getUserName(), user.getUserLogin(), user.getUserPassword());
        this.users.add(userForSave);
        //у сохраненного юзера устанавливаем userId
        users.get(users.indexOf(userForSave)).setUserId(users.indexOf(userForSave));
        for (User currentUser : users) {
            currentUser.setUserId(users.indexOf(currentUser));
        }
        return users.indexOf(userForSave);
    }

    public User find(int id) throws IndexOutOfBoundsException{
        return users.get(id);
    }

    public void delete(int id) throws IndexOutOfBoundsException{
        users.remove(id);
        for (User currentUser : users) {
            currentUser.setUserId(users.indexOf(currentUser));
        }
    }
}
