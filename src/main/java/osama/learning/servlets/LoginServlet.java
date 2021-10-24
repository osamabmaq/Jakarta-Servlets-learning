package osama.learning.servlets;

import osama.learning.model.User;
import osama.learning.repos.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private final UserRepo userRepo = UserRepo.instance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User incomingUser = extractUser(req);
        if (userRepo.exists(incomingUser)) {
            req.getSession().setAttribute("username", incomingUser.getName());
            resp.sendRedirect(req.getContextPath() + "/entry/readAll");
        } else {
            req.getSession().removeAttribute("username");
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    private User extractUser(HttpServletRequest req) {
        String username = req.getParameter("username");
        char[] password = req.getParameter("password").toCharArray();
        return new User(username, password);
    }
}
