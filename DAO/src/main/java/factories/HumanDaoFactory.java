package factories;

import dao.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class HumanDaoFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static HumanDaoFactory instance;
    private HumanDao dao;

    static {
        instance = new HumanDaoFactory();
    }

    private HumanDaoFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String daoClassName = properties.getProperty("human.dao.class");
            Class daoClass = Class.forName(daoClassName);
            Constructor constructor = daoClass.getConstructor();
            this.dao = (HumanDao) constructor.newInstance();
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

    public static HumanDaoFactory getInstance() {
        return instance;
    }

    public HumanDao getDao() {
        return dao;
    }

}
