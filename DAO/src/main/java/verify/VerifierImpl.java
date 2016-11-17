package verify;

import dao.UsersDao;

public class VerifierImpl implements Verifier{
    public void userExist(UsersDao usersDao, int userId) {
        boolean isExist = false;
        // запрос в файл/бд проверки, есть там пользователь или нет
        try {
            usersDao.find(userId);
        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException("User not found");
        }
/*
        if (!isExist) {
            throw new IllegalArgumentException("User not found");
        }
*/
    }
}
