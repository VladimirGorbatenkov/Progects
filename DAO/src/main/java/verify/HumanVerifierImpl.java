package verify;

import dao.HumanDao;

public class HumanVerifierImpl implements HumanVerifier {
    public void userExist(HumanDao dao, int id) {
        boolean isExist = false;
        // запрос в файл/бд проверки, есть там пользователь или нет
        try {
            dao.find(id);
        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException("Human not found");
        }
/*
        if (!isExist) {
            throw new IllegalArgumentException("Human not found");
        }
*/
    }
}
