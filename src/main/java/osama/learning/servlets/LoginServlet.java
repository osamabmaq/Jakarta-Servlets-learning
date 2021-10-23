package osama.learning.servlets;

import osama.learning.model.User;
import osama.learning.repos.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class LoginServlet extends HttpServlet {
    private final UserRepo userRepo = UserRepo.instance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUser(req);

        Optional<User> userInRepo = userRepo.get(user.getName());

        userInRepo.stream()
                .filter((u) -> userInRepo.isPresent() && userInRepo.get().passwordEquals(user))
                .forEach((u) -> req.getSession().setAttribute("username", u.getName()));

        userInRepo.stream()
                .filter((u) -> userInRepo.isEmpty() || !userInRepo.get().passwordEquals(user))
                .forEach((u) -> req.getSession().removeAttribute("username"));
        //FIXME: this line permits every request to go to the read-all page even if the request is not logged in
        req.getRequestDispatcher("/entry/readAll").forward(req, resp);
    }


    private User getUser(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        return new User(username, password.toCharArray());
    }
}
