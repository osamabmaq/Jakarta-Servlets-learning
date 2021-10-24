package osama.learning.servlets.errorhandling;

import osama.learning.model.AppError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorsHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processError(req, resp);
    }

    private void processError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("error");
        AppError error = new AppError(req);
        resp.setStatus(error.getStatusCode());
        req.setAttribute("error", error);
        req.getRequestDispatcher("/error/error-page.ftl").forward(req, resp);
    }
}
