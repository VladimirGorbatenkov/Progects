package factories;

import dao.CarDao;
import service.CarService;
import verify.CarVerifier;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

public class CarServiceFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static CarServiceFactory instance = new CarServiceFactory();
    private CarService carService;
    private CarVerifier carVerifier;
    private Connection connection;

    private CarServiceFactory() {
        CarDao carDao = CarDaoFactory.getInstance().getDao();
        CarVerifier carVerifier = CarVerifierFactory.getInstance().getCarVerifier();
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String userServiceClassName = properties.getProperty("carService.class");
            Class userServiceClass = Class.forName(userServiceClassName);
            Constructor constructor = userServiceClass.getConstructor(CarDao.class, CarVerifier.class);
            this.carService = (CarService) constructor.newInstance(carDao, carVerifier);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static CarServiceFactory getInstance() {
        return instance;
    }

    public CarService getCarService() {
        return carService;
    }
}
