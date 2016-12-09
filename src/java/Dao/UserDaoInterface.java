package Dao;

import Pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDaoInterface {
    List<User> getUsers();
    User findUser(String userName) throws SQLException;
    User findUser(String username,boolean rool) throws SQLException;
}
