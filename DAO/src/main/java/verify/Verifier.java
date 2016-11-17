package verify;

import dao.UsersDao;

public interface Verifier {
    void userExist(UsersDao usersDao, int userId);
}
