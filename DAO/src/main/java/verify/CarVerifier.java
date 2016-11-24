package verify;

import dao.CarDao;

public interface CarVerifier {
    void carExist(CarDao dao, int id);
}
