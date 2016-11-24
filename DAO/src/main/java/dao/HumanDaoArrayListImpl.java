package dao;

import model.Human;

import java.util.ArrayList;
import java.util.List;


public class HumanDaoArrayListImpl implements HumanDao {

    List<Human> human;

    public HumanDaoArrayListImpl() {
        this.human = new ArrayList<Human>();
    }
    public List<Human> findAll() {
        return this.human;
    }

    public void update(Human human) throws IndexOutOfBoundsException{
        //у сохранемого юзера устанавливаем userId = id для поддержки связности
        Human humanForSave = new Human(human);
        Human humanForUpdate = this.human.get(human.getId());
        humanForUpdate = humanForSave;
    }

    public int save(Human human) {
        Human humanForSave = new Human(0, human.getName(), human.getAge(), human.getCity());
        this.human.add(humanForSave);
        //у сохраненного юзера устанавливаем userId
        this.human.get(this.human.indexOf(humanForSave)).setId(this.human.indexOf(humanForSave));
        for (Human currentHuman : this.human) {
            currentHuman.setId(this.human.indexOf(currentHuman));
        }
        return this.human.indexOf(humanForSave);
    }

    public Human find(int id) throws IndexOutOfBoundsException{
        return human.get(id);
    }

    public void delete(int humanId) throws IndexOutOfBoundsException{
        human.remove(humanId);
        for (Human currentHuman : human) {
            currentHuman.setId(human.indexOf(currentHuman));
        }
    }
}
