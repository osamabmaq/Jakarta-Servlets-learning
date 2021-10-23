package osama.learning.filters;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (!isValidRequest(req))
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            chain.doFilter(req, res);
    }

    /**
     * @param req the HttpServletRequest of the incoming request
     * @return true if the request method is not POST, and if the request method is POST then it returns true
     * if the username and password request parameters exist
     */
    private boolean isValidRequest(HttpServletRequest req) {
        if (!req.getMethod().equals("POST"))
            return true;
        return usernameAndPasswordExist(req);
    }

    private boolean usernameAndPasswordExist(HttpServletRequest req) {
        return req.getParameter("username") != null && req.getParameter("password") != null;
    }
}
