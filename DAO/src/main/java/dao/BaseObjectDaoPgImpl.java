package dao;

import factories.ConnectionFactory;
import model.BaseObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseObjectDaoPgImpl<T extends BaseObject> implements BaseObjectDao{
    private List<T> list;
    private T obj;
    // language=SQL
    private final String SQL_SELECT_USER =
            "SELECT * FROM " +  obj.getClass().getName().substring(obj.getClass().getName().lastIndexOf('.')+1 , obj.getClass().getName().length()).toLowerCase() + ";";

    @Override
    public List<T> findAll() {
        try {
            list.clear();

            Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_USER);

            while (resultSet.next()) {
                Class tClass = obj.getClass();
                Constructor constructor = tClass.getConstructor();
                this.obj = (T) constructor.newInstance();

                for (int i = 0; i < obj.getClass().getDeclaredFields().length; i++) {
                    obj.getClass().getDeclaredFields()[i].set(obj , resultSet.getObject(obj.getClass().getDeclaredFields()[i].getName()));
                }
                list.add(obj);
                System.out.println(resultSet.getInt("id") + "," + resultSet.getString("name"));
            }

/*
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
            preparedStatement.setInt(1, 10);
            preparedStatement.setString(2, "Petya");

            preparedStatement.execute();
*/
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public T find(int id) {
        return null;
    }

/*
    @Override
    public int save(T obj) {
        return 0;
    }
*/

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, BaseObject obj) {

    }
}
