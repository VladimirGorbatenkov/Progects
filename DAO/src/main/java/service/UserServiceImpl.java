package service;

import verify.Verifier;
import dao.UsersDao;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UsersDao usersDao;
    private Verifier verifier;

    public UserServiceImpl(UsersDao usersDao, Verifier verifier) {
        this.usersDao = usersDao;
        this.verifier = verifier;
    }

    public boolean isRegistered(String name) {
        List<User> users = usersDao.findAll();

        for (User currentUser : users) {
            if (currentUser.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {

            usersDao.save(user);
    }

    public User getUser(int id) {
        verifier.userExist(usersDao, id);
        return usersDao.find(id);
    }

    public void update(User user) {
        usersDao.delete(user.getUserId());
        usersDao.save(user);
    }

    public List<User> findAll() {
        return usersDao.findAll();
    }

    @Override
    public void removeUser(int id) {
        usersDao.delete(id);
    }
}
