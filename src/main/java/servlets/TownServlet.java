package servlets;

import model.Title;
import model.Town;
import services.TownService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TownServlet extends HttpServlet {

    private TownService service = new TownService();

    public void init(ServletConfig servletConfig){
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Town> towns = service.findAllTowns();
        req.setAttribute("towns", towns);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/towns/showTowns.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");

        Town town = new Town();
        town.setName(name);

        service.saveTown(town);

        resp.sendRedirect("/towns");
    }

    @Override
    protected void  doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Town town = service.findTown(id);

        String name = req.getParameter("name");

        town.setName(name);

        service.updateTown(town);

        resp.sendRedirect("/towns");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteTown(service.findTown(id));
        resp.sendRedirect("/towns");
    }

}
