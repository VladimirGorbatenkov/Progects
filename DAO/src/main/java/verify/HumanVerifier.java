package verify;

import dao.HumanDao;

public interface HumanVerifier {
    void userExist(HumanDao dao, int userId);
}
