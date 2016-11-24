package dao;

import factories.ConnectionFactory;
import model.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDaoPgImpl implements CarDao{
    private Car obj;
    // language=SQL
    private final String SQL_SELECT_CARS = "SELECT * FROM cars;";
    private final String SQL_SELECT_CAR = "SELECT * FROM cars WHERE id=?;";
    private final String SQL_DELETE_CAR = "DELETE FROM cars WHERE id=?;";
    private final String SQL_INSERT_CAR = "INSERT INTO cars(model_name, probeg, owner_id) VALUES(?, ?, ?);";
    private final String SQL_UPDATE_CAR = "UPDATE cars SET model_name=?, probeg=?, owner_id=? WHERE id=?;";

    @Override
    public List<Car> findAll() {
        List<Car> list = new ArrayList<Car>();
        try {
            Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_CARS);
            while (resultSet.next()) {
                this.obj = new Car(resultSet.getInt("id"), resultSet.getString("model_name"), resultSet.getInt("probeg"), resultSet.getInt("owner_id"));
                list.add(obj);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return list;
    }

    @Override
    public Car find(int id) {
        try {
            PreparedStatement preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(SQL_SELECT_CAR);
            preparedStatement.setInt(1, id);

            if (preparedStatement.execute()) {
                ResultSet resultSet = preparedStatement.getResultSet();
                resultSet.next();
                this.obj = new Car(resultSet.getInt("id"), resultSet.getString("model_name"), resultSet.getInt("probeg"), resultSet.getInt("owner_id"));
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
    public int save(Car obj) {
        try {
            PreparedStatement preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(SQL_INSERT_CAR);
            preparedStatement.setString(1, obj.getModelName());
            preparedStatement.setInt(2, obj.getProbeg());
            preparedStatement.setInt(3, obj.getOwnerId());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return 0;
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(SQL_DELETE_CAR);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void update(Car obj) {
        try {
            PreparedStatement preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(SQL_UPDATE_CAR);
            preparedStatement.setString(1, obj.getModelName());
            preparedStatement.setInt(2, obj.getProbeg());
            preparedStatement.setInt(3, obj.getOwnerId());
            preparedStatement.setInt(4, obj.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
