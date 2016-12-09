package Pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blackwidow on 30/11/16.
 */
public class User {
    private String name;
    private String password;
    private String host;
    private List<Rol> roles = new ArrayList<Rol>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
