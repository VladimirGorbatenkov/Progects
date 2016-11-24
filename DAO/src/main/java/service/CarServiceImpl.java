package service;

import dao.CarDao;
import model.Car;
import verify.CarVerifier;

import java.util.List;

public class CarServiceImpl implements CarService {

    private CarDao dao;
    private CarVerifier carVerifier;

    public CarServiceImpl(CarDao dao, CarVerifier carVerifier) {
        this.dao = dao;
        this.carVerifier = carVerifier;
    }

    public boolean isRegistered(String model_name) {
        List<Car> car = dao.findAll();

        for (Car currentHuman : car) {
            if (currentHuman.getModelName().equals(model_name)) {
                return true;
            }
        }
        return false;
    }

    public void add(Car car) {
        dao.save(car);
    }

    public Car get(int id) {
        carVerifier.carExist(dao, id);
        return dao.find(id);
    }

    public void update(Car car) {
        dao.update(car);
    }

    public List<Car> findAll() {
        return dao.findAll();
    }

    @Override
    public void remove(int id) {
        dao.delete(id);
    }
}
