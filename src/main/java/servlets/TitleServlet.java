package servlets;

import model.Title;
import services.TitleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TitleServlet extends HttpServlet {
    private TitleService service = new TitleService();

    public void init(ServletConfig servletConfig){
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Title> titles = service.findAllTitles();
        req.setAttribute("titles", titles);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/title/showTitles.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");

        Title title = new Title();
        title.setName(name);

        service.saveTitle(title);

        resp.sendRedirect("/titles");
    }

    @Override
    protected void  doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Title title = service.findTitle(id);

        String name = req.getParameter("name");

        title.setName(name);

        service.updateTitle(title);

        resp.sendRedirect("/titles");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteTitle(service.findTitle(id));
        resp.sendRedirect("/titles");
    }


}
