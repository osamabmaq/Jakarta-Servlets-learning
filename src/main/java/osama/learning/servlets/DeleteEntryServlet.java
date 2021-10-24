package osama.learning.servlets;

import osama.learning.repos.EntryRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEntryServlet extends HttpServlet {
    private final EntryRepo entryRepo = EntryRepo.instance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/delete-entry.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        entryRepo.delete(key);
        req.setAttribute("event", "Entry deletion");
        req.getRequestDispatcher("/success-page.ftl").forward(req, resp);
    }
}
