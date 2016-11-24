package dao;

import model.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HumanDaoFileImpl implements HumanDao {
    private final String FILE_BASE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\users_base.dat";

    List<Human> human;
    private int maxHumanId = -1;

    public HumanDaoFileImpl() {
        this.human = new ArrayList<Human>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_BASE_NAME))){
            human = (List<Human>) objectInputStream.readObject();
            for (Human currentHuman : human) {
                if (currentHuman.getId() > maxHumanId) {
                    maxHumanId = currentHuman.getId();
                };
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Human> findAll() {
        return this.human;
    }

    public Human find(int id) {
        return human.get(id);
    }

    public int save(Human human) {
        //если такой пользователь уже есть, то возвращаем -1
        //его сохранять не надо, он такой уже есть
        if (this.human.indexOf(human) > -1 ) {
            return -1;
        }
        Human humanForSave = new Human(human);
        this.human.add(humanForSave);
        //у сохраненного юзера устанавливаем userId
        maxHumanId++;
        this.human.get(this.human.indexOf(humanForSave)).setId(maxHumanId);
        toFile();
        return this.human.indexOf(humanForSave);
    }

    public void delete(int humanId) {
        try {
            if ( human.get(humanId) != null) {
                for (Human currentHuman : human) {
                    if (currentHuman.getId() == humanId) {
                        human.remove(human.indexOf(currentHuman));
                        toFile();
                        return;
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }
    }

    public void update(Human human) {
        if ( this.human.get(human.getId()) != null) {
            Human humanForUpdate = this.human.get(human.getId());
            humanForUpdate.setName(human.getName());
            humanForUpdate.setAge(human.getAge());
            humanForUpdate.setCity(human.getCity());
            toFile();
        }

    }
//TODO: Проверить update на файле

    private void toFile() {
/*
        for (Human currentUser : human) {
            currentUser.setId(human.indexOf(currentUser));
        }
*/
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_BASE_NAME))){
            objectOutputStream.writeObject(human);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
