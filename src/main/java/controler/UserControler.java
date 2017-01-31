package controler;

import clases.Injector;
import dao.RolDaoImplement;
import dao.UserDaoImplement;
import pojo.Rol;
import pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by blackwidow on 30/11/16.
 */
public class UserControler extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        UserDaoImplement UseDao = (UserDaoImplement) Injector.getCache().getBean("userDao");
        RolDaoImplement RolDao = (RolDaoImplement) Injector.getCache().getBean("rolDao");
        List<User> usuarios = null;
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

        if(request.isUserInRole("administrador")){
            Enumeration paramNames = request.getParameterNames();
            if (paramNames.hasMoreElements()) {
                while (paramNames.hasMoreElements()) {
                    String paramName = (String) paramNames.nextElement();
                    String[] paramValues = request.getParameterValues(paramName);
                    if (paramValues[0] != "" && paramName.equals("delete")) {
                        try {
                            UseDao.deleteUser(paramValues[0]);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        throw new ServletException();
                    }
                }
            }
        }
        try {
            usuarios = UseDao.getUsers();
            List<Rol> roles = RolDao.getRoles();
            request.setAttribute("user", usuarios);
            request.setAttribute("check_rol", roles);
            request.setAttribute("name",request.getUserPrincipal().getName());
            if(request.isUserInRole("administrador")){
                request.setAttribute("admin",true);
            }else{
                request.setAttribute("admin",false);
            }
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        String user_name = request.getParameter("nombre");
        String user_pass = request.getParameter("password");
        String[] roles = request.getParameterValues("rol");
        try {
            UserDaoImplement userDao = (UserDaoImplement) Injector.getCache().getBean("userDao");
            userDao.insertUser(user_name, user_pass, roles);
            response.sendRedirect("/index");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
