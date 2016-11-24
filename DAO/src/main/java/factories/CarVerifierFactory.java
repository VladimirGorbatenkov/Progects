package factories;

import verify.CarVerifier;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CarVerifierFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static CarVerifierFactory instance = new CarVerifierFactory();
    private static CarVerifier carVerifier;

    private CarVerifierFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String verifierClassName = properties.getProperty("carVerifier.class");
            Class verifierClass = Class.forName(verifierClassName);
            Constructor constructor = verifierClass.getConstructor();
            this.carVerifier = (CarVerifier) constructor.newInstance();
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

    public static CarVerifierFactory getInstance() {
        return instance;
    }

    public static CarVerifier getCarVerifier() {
        return carVerifier;
    }
}
