package factories;

import verify.HumanVerifier;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class HumanVerifierFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static HumanVerifierFactory instance = new HumanVerifierFactory();
    private static HumanVerifier humanVerifier;

    private HumanVerifierFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String verifierClassName = properties.getProperty("humanVerifier.class");
            Class verifierClass = Class.forName(verifierClassName);
            Constructor constructor = verifierClass.getConstructor();
            this.humanVerifier = (HumanVerifier) constructor.newInstance();
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

    public static HumanVerifierFactory getInstance() {
        return instance;
    }

    public static HumanVerifier getHumanVerifier() {
        return humanVerifier;
    }
}
