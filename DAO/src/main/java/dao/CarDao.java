package dao;

import model.Car;

import java.util.List;

public interface CarDao {
    List<Car> findAll();
    Car find(int id);
    int save(Car obj);
    void delete(int id);
    void update(Car obj);
}
