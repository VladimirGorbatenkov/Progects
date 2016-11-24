package dao;

import factories.ConnectionFactory;
import model.Human;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HumanDaoPgImpl implements HumanDao{
    private Human obj;
    // language=SQL
    private final String SQL_SELECT_PEOPLE = "SELECT * FROM people;";
    private final String SQL_SELECT_HUMAN = "SELECT * FROM people WHERE id=?;";
    private final String SQL_DELETE_HUMAN = "DELETE FROM people WHERE id=?;";
    private final String SQL_INSERT_HUMAN = "INSERT INTO people(name, age, city) VALUES(?, ?, ?);";
    private final String SQL_UPDATE_HUMAN = "UPDATE people SET name=?, age=?, city=? WHERE id=?;";

    @Override
    public List<Human> findAll() {
        List<Human> list = new ArrayList<Human>();
        try {
            Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_PEOPLE);
            while (resultSet.next()) {
                this.obj = new Human(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("city"));
                list.add(obj);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return list;
    }

    @Override
    public Human find(int id) {
        try {
            PreparedStatement preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(SQL_SELECT_HUMAN);
            preparedStatement.setInt(1, id);

            if (preparedStatement.execute()) {
                ResultSet resultSet = preparedStatement.getResultSet();
                resultSet.next();
                this.obj = new Human(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("city"));
                return obj;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int save(Human obj) {
        try {
            PreparedStatement preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(SQL_INSERT_HUMAN);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getAge());
            preparedStatement.setString(3, obj.getCity());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return 0;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(SQL_DELETE_HUMAN);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

        } catch (SQLException e) {
//            System.out.println("Нет такого пользователя");
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void update(Human obj) {
        try {
            PreparedStatement preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(SQL_UPDATE_HUMAN);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getAge());
            preparedStatement.setString(3, obj.getCity());
            preparedStatement.setInt(4, obj.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
