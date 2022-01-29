//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    private final Connection connection = Util.getConnection();
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS MyTest.Users" +
//                    "(id INT auto_increment," +
//                    " name     VARCHAR(50) not null," +
//                    "lastName VARCHAR(50) not null, " +
//                    "age      INT         not null," +
//                    "PRIMARY KEY (id))");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate("DROP TABLE MyTest.Users");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String str = "INSERT INTO MyTest.Users(name,lastName,age) VALUES(?,?,?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(str)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate("DELETE FROM MyTest.Users where id");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<>();
//        String str = "SELECT id,name,lastName,age FROM MyTest.Users";
//
//        try (Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(str);
//
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                userList.add(user);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return userList;
//    }
//
//    public void cleanUsersTable() {
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate("DELETE FROM MyTest.Users");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//}