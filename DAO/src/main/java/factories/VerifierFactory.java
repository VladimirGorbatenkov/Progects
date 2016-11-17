package factories;

import verify.Verifier;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class VerifierFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static VerifierFactory instance = new VerifierFactory();
    private static Verifier verifier;

    private VerifierFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String verifierClassName = properties.getProperty("verifier.class");
            Class verifierClass = Class.forName(verifierClassName);
            Constructor constructor = verifierClass.getConstructor();
            this.verifier = (Verifier) constructor.newInstance();
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

    public static VerifierFactory getInstance() {
        return instance;
    }

    public static Verifier getVerifier() {
        return verifier;
    }
}
