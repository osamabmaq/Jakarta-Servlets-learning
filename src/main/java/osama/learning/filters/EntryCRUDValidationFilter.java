package osama.learning.filters;

import osama.learning.exceptions.NotEnoughParametersException;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EntryCRUDValidationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String key = req.getParameter("key");
        String value = req.getParameter("value");

        String path = req.getContextPath().replace("/entry/", "");

        if (needsBothParameters(path) && anyIsNull(key, value))
            throw new NotEnoughParametersException();
        else if (needsKeyParameterOnly(path) && anyIsNull(key))
            throw new NotEnoughParametersException();
        chain.doFilter(req, res);
    }

    private boolean anyIsNull(String... elements) {
        for (String element : elements) {
            if (element == null)
                return true;
        }
        return false;
    }

    private boolean needsBothParameters(String path) {
        return path.startsWith("create") || path.startsWith("update");
    }

    private boolean needsKeyParameterOnly(String path) {
        return path.startsWith("read") || path.startsWith("delete");
    }
}
