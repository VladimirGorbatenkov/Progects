package factories;

import verify.Verifier;
import dao.UsersDao;
import service.UserService;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class UserServiceFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static UserServiceFactory instance = new UserServiceFactory();
    private UserService userService;
    private Verifier verifier;

    private UserServiceFactory() {
        UsersDao usersDao = DaoFactory.getInstance().getDao();
        Verifier verifier = VerifierFactory.getInstance().getVerifier();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String userServiceClassName = properties.getProperty("userService.class");
            Class userServiceClass = Class.forName(userServiceClassName);
            Constructor constructor = userServiceClass.getConstructor(UsersDao.class, Verifier.class);
            this.userService = (UserService) constructor.newInstance(usersDao, verifier);
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

    public static UserServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }
}
