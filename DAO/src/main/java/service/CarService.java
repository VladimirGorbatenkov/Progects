package service;

import model.Car;

import java.util.List;

public interface CarService {
    boolean isRegistered(String name);
    void add(Car car);
    Car get(int id);
    void update(Car car);
    void remove(int id);
    List<Car> findAll();
}
