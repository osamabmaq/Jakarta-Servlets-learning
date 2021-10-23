package osama.learning.servlets;

import osama.learning.model.Entry;
import osama.learning.repos.EntryRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateEntryServlet extends HttpServlet {
    private final EntryRepo entryRepo = EntryRepo.instance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/update-entry.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Entry entry = new Entry(req.getParameter("key"), req.getParameter("value"));
        entryRepo.update(entry);
        req.setAttribute("message", "Entry update");
        req.getRequestDispatcher("/success-page.ftl").forward(req, resp);
    }
}
