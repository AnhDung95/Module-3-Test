package com.example.module3test.dao;

import com.example.module3test.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/testmodule3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "dung25081995";
    private static final String INSERT_USERS_SQL= "INSERT INTO Students" + "  (name, birthDay, address, phone, email,Classroom) VALUES " +
            " (?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID= "select id,birthDay, address, phone, email,Classroom from Students where id =?";
    private static final String SELECT_ALL_USERS= "select * from Students";
    private static final String DELETE_USERS_SQL= "delete from Students where id = ?;";
    private static final String UPDATE_USERS_SQL= "update Students set name = ?,birthDay=?,address= ?, phone =?,email=?,Classroom=? where id = ?;";

    public UserDAO() {
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void insertUser(User user) throws SQLException{
        System.out.println(INSERT_USERS_SQL);
        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getBirthDay());
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setString(4,user.getPhone());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(5,user.getClassroom());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String birthDay = rs.getString("birthDay");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String Classroom = rs.getString("Classroom");
                user = new User(id, name, birthDay,address,phone, email,Classroom);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String birthDay = rs.getString("birthDay");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String Classroom = rs.getString("Classroom");
                users.add(new User(id, name,birthDay,address,phone, email,Classroom));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getBirthDay());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getClassroom());
            statement.setInt(7, user.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

