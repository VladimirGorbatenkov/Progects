package factories;

import dao.*;
import service.UserService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DaoFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static DaoFactory instance;
    private UsersDao dao;

    static {
        instance = new DaoFactory();
    }

    private DaoFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String daoClassName = properties.getProperty("dao.class");
            Class daoClass = Class.forName(daoClassName);
            Constructor constructor = daoClass.getConstructor();
            this.dao = (UsersDao) constructor.newInstance();
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

    public static DaoFactory getInstance() {
        return instance;
    }

    public UsersDao getDao() {
        return dao;
    }

}
