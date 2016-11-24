package verify;

import dao.CarDao;

public class CarVerifierImpl implements CarVerifier {
    public void carExist(CarDao dao, int id) {
        boolean isExist = false;
        // запрос в файл/бд проверки, есть там пользователь или нет
        try {
            dao.find(id);
        }
        catch (RuntimeException e) {
            throw new IllegalArgumentException("Car not found");
        }
/*
        if (!isExist) {
            throw new IllegalArgumentException("Human not found");
        }
*/
    }
}
