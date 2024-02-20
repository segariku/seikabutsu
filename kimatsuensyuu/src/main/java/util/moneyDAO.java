package util;

import util.moneyBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class moneyDAO {
    private static final String DB_URL = "jdbc:sqlite:user.db";

    static public void insert(int user_id, int money) {
        String sql = "INSERT INTO money VALUES (?,?)";

        try (
                Connection connection = DriverManager.getConnection(DB_URL);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, money);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<moneyBean> selectById(int user_id) {
        List<moneyBean> resultList = new ArrayList<>();
        String sql = "SELECT * FROM money WHERE user_id = ?";

        try (
                Connection connection = DriverManager.getConnection(DB_URL);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, user_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    moneyBean money = new moneyBean(
                            resultSet.getInt("user_id"),
                            resultSet.getInt("money")
                    );
                    resultList.add(money);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public static void update(int user_id, int money) {
        String sql = "UPDATE money SET money = ? WHERE user_id = ?";

        try (
                Connection connection = DriverManager.getConnection(DB_URL);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setInt(1, money);
            preparedStatement.setInt(2, user_id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}