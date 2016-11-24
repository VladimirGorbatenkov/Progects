package factories;

import dao.HumanDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String PROPERTIES_FILE_NAME = "C:\\Курсы Java\\Progect\\DAO\\src\\main\\resources\\dao.properties";
    private static ConnectionFactory instance;
    private static Connection connection;

    static {
        instance = new ConnectionFactory();
    }

    private ConnectionFactory() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
            String urlBase = properties.getProperty("url.base");
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(urlBase, name, password);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }

}
