package factories;

import dao.HumanDao;
import service.HumanService;
import verify.HumanVerifier;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

public class HumanServiceFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static HumanServiceFactory instance = new HumanServiceFactory();
    private HumanService humanService;
    private HumanVerifier humanVerifier;
    private Connection connection;

    private HumanServiceFactory() {
        HumanDao humanDao = HumanDaoFactory.getInstance().getDao();
//        BaseObjectDao humanDao = HumanDaoFactory.getInstance().getDao();
        HumanVerifier humanVerifier = HumanVerifierFactory.getInstance().getHumanVerifier();
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String userServiceClassName = properties.getProperty("humanService.class");
            Class userServiceClass = Class.forName(userServiceClassName);
            Constructor constructor = userServiceClass.getConstructor(HumanDao.class, HumanVerifier.class);
            this.humanService = (HumanService) constructor.newInstance(humanDao, humanVerifier);
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

    public static HumanServiceFactory getInstance() {
        return instance;
    }

    public HumanService getHumanService() {
        return humanService;
    }
}
