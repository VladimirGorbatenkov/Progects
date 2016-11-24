package service;

import dao.HumanDao;
import verify.HumanVerifier;
import model.Human;

import java.util.List;

public class HumanServiceImpl implements HumanService {

    private HumanDao dao;
    private HumanVerifier humanVerifier;

    public HumanServiceImpl(HumanDao dao, HumanVerifier humanVerifier) {
        this.dao = dao;
        this.humanVerifier = humanVerifier;
    }

    public boolean isRegistered(String name) {
        List<Human> human = dao.findAll();

        for (Human currentHuman : human) {
            if (currentHuman.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void add(Human human) {
        dao.save(human);
    }

    public Human get(int id) {
        humanVerifier.userExist(dao, id);
        return dao.find(id);
    }

    public void update(Human human) {
        dao.update(human);
    }

    public List<Human> findAll() {
        return dao.findAll();
    }

    @Override
    public void remove(int id) {
        dao.delete(id);
    }
}
