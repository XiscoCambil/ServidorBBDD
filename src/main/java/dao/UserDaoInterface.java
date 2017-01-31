package dao;

import pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDaoInterface {
    User findUser(String userName) throws SQLException;
    List<User> findUser(String username,boolean rool) throws SQLException;
    void insertUser(String userName,String password,String[] roles) throws SQLException;
    List<User> getUsers() throws SQLException;
    void deleteUser(String userName) throws SQLException;
}
