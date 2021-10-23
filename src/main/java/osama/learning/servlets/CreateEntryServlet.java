package osama.learning.servlets;

import osama.learning.model.Entry;
import osama.learning.model.User;
import osama.learning.repos.EntryRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateEntryServlet extends HttpServlet {
    private final EntryRepo entryRepo = EntryRepo.instance;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create-entry.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Entry entry = new Entry(req.getParameter("key"), req.getParameter("value"));
        entryRepo.add(entry);
        req.setAttribute("event", "Entry creation");
        req.getRequestDispatcher("/success-page.ftl").forward(req, resp);
    }
}
