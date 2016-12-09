package Dao;

import Clases.Injector;
import Clases.Injector;
import DataBase.DataBase;
import Pojo.Rol;
import Pojo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by blackwidow on 30/11/16.
 */
public class UserDaoImplement implements UserDaoInterface {
    private DataBase ddbb;

    private List<User> usuarios = new ArrayList<User>();

    public UserDaoImplement() throws SQLException, ClassNotFoundException {
    }

    public List<User> getUsuarios() throws SQLException {
        String users = "SELECT user,host,password FROM user";
        PreparedStatement ps = ddbb.getCon().prepareStatement(users);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            User user = (User)Injector.getCache().getBean("user");
            user.setHost(rs.getString("host"));
            user.setName(rs.getString("user"));
            user.setPassword(rs.getString("password"));
            usuarios.add(user);
        }
        return usuarios;
    }

    public List<User> getUsers() {
        return null;
    }

    public User findUser(String userName) throws SQLException {
        String users = "SELECT user_name,user_pass FROM user where user_name= ?";
        PreparedStatement ps = ddbb.getCon().prepareStatement(users);
        ps.setString(1,userName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            User user = (User)Injector.getCache().getBean("user");
            user.setName(rs.getString("user_name"));
            user.setPassword(rs.getString("user_pass"));
            return user;
        }
        return null;
    }

    public User findUser(String username, boolean rool) throws SQLException {
        String sql = "SELECT u.user_name,u.user_pass ";
        sql += rool?",ur.role_name ":"";
        sql += "FROM user as u ";
        sql += rool?"INNER JOIN user_roles as ur ON u.user_name = ur.user_name ":"";
        sql += "WHERE u.user_name = ?";
        System.out.println(sql);
        PreparedStatement ps = ddbb.getCon().prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            User user = (User)Injector.getCache().getBean("user");
            user.setName(rs.getString("user_name"));
            user.setPassword(rs.getString("user_pass"));
            if(rool) {
                Rol rol = (Rol) Injector.getCache().getBean("rol");
                rol.setRol_name(rs.getString("role_name"));
                List<Rol> roles = new ArrayList<Rol>();
                roles.add(rol);
                user.setRoles(roles);
            }
            return user;
        }
        return null;
    }

    public void setDdbb(DataBase ddbb) {
        this.ddbb = ddbb;
    }
}
