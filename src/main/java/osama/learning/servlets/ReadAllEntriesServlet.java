package osama.learning.servlets;

import osama.learning.model.Entry;
import osama.learning.repos.EntryRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReadAllEntriesServlet extends HttpServlet {
    private final EntryRepo entryRepo = EntryRepo.instance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/read-all-entries.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("entries", entryRepo.getAll());
        req.getRequestDispatcher("/show-entries.ftl").forward(req, resp);
    }
}
