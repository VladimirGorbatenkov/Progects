package dao;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoFileImpl implements UsersDao{
    private final String FILE_BASE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\users_base.dat";

    List<User> users;

    public UsersDaoFileImpl() {
        this.users = new ArrayList<User>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_BASE_NAME))){
            users = (List<User>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        return this.users;
    }

    public User find(int id) {
        return users.get(id);
    }

    public int save(User user) {
        //если такой пользователь уже есть, то возвращаем -1
        //его сохранять не надо, он такой уже есть
        if (users.indexOf(user) > -1 ) {
            return -1;
        }
        User userForSave = new User(user.getUserName(), user.getUserLogin(), user.getUserPassword());
        this.users.add(userForSave);
        //у сохраненного юзера устанавливаем userId
        users.get(users.indexOf(userForSave)).setUserId(users.indexOf(userForSave));
        toFile();
        return users.indexOf(userForSave);
    }

    public void delete(int userId) {
        try {
            if ( users.get(userId) != null) {
                users.remove(userId);
                toFile();
            }
        }
        catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }
    }

    public void update(int id, User user) {
        delete(id);
        save(user);
        toFile();
    }

    private void toFile() {
        for (User currentUser : users) {
            currentUser.setUserId(users.indexOf(currentUser));
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_BASE_NAME))){
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
