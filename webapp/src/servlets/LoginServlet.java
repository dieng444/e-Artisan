package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.User;
import users.UserDBHandler;

/**
 * A servlet that handles the login form.
 *
 * @author Macky Dieng
 * @author Baptiste Vannesson
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String email = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = null;
        req.setCharacterEncoding("UTF-8");

        try {
            if (new UserDBHandler().getDb().isValidUser(email, password)) {
                user = new UserDBHandler().getDb().retrieve(email);
                session.setAttribute("currentUser", user);

                if (user.getRole().equals("admin")){
                    resp.sendRedirect("admin");
                } else {
                    resp.sendRedirect("accueil");
                }
            } else {
                this.performError(req,resp,new Exception());
            }

        } catch (Exception e) {
            this.performError(req,resp,e);
        }

    }

    private void performError(HttpServletRequest req,HttpServletResponse resp,Exception e)
            throws ServletException, IOException {

        String msg = "Connexion refusée : ce compte n'existe pas dans notre base de données.";
        req.setAttribute("errorLogin", msg);
        this.getServletContext().getRequestDispatcher(req.getContextPath()).forward( req, resp );

    }

}
