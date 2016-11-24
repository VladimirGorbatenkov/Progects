package factories;

import dao.CarDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CarDaoFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static CarDaoFactory instance;
    private CarDao dao;

    static {
        instance = new CarDaoFactory();
    }

    private CarDaoFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String daoClassName = properties.getProperty("car.dao.class");
            Class daoClass = Class.forName(daoClassName);
            Constructor constructor = daoClass.getConstructor();
            this.dao = (CarDao) constructor.newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static CarDaoFactory getInstance() {
        return instance;
    }

    public CarDao getDao() {
        return dao;
    }

}
