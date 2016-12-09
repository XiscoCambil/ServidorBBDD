package Controler;

//import Clases.Injector;
import Clases.Injector;
import Dao.UserDaoImplement;
import Pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by blackwidow on 30/11/16.
 */
public class UserControler extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UserDaoImplement UseDao = (UserDaoImplement) Injector.getCache().getBean("userDao");
            //UserDaoImplement UseDao = new UserDaoImplement();
            User usuario = UseDao.findUser("xisco",true);
            List<User> usuarios = new ArrayList<User>();
            usuarios.add(usuario);
            System.out.println(usuario.getName()+" "+usuario.getPassword());
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("user", usuarios);
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
