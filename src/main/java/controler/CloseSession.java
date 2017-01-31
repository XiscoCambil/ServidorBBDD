package controler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by blackwidow on 31/01/17.
 */
public class CloseSession extends HttpServlet {

    public void doGet(HttpServletRequest request,
                              HttpServletResponse response)
            throws ServletException, IOException {
            request.getSession().invalidate();
            response.sendRedirect("/index");
    }
}
