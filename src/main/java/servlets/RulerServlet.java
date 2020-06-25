package servlets;

import dao.TitleDAO;
import model.Ruler;
import model.RullerMainTitleRel;
import model.Title;
import services.RulerService;
import services.RulerTitleService;
import services.TitleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//@WebServlet("/rulers")
public class RulerServlet extends HttpServlet {

    private RulerService service = new RulerService();

    public void init(ServletConfig servletConfig){
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Ruler> rulers = service.findAllRulers();
        List<RullerMainTitleRel> titles = RulerTitleService.findAllTitles();

        req.setAttribute("rulers", rulers);
        req.setAttribute("titles", titles);

        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/rulers/showRulers.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("вот тт");
        String name = req.getParameter("name");
        Integer year_of_birth = com.github.Huriosity.InputUtils.getInteger(req.getParameter("year_of_birth"));
        Integer year_of_death = com.github.Huriosity.InputUtils.getInteger(req.getParameter("year_of_death"));
        Integer testatorID    = com.github.Huriosity.InputUtils.getInteger(req.getParameter("testatorID"));

        Ruler ruler = new Ruler();
        ruler.setName(name);
        ruler.setYear_of_birth(year_of_birth);
        ruler.setYear_of_death(year_of_death);

        Ruler testator = null;
        if(testatorID != null) {
            testator = service.findRuler(testatorID);
            ruler.setTestator(testator);
            testator.addRulerHeir(ruler);
        }

        service.saveRuler(ruler);
        if(testator != null) {
            service.updateRuler(testator);
        }

        resp.sendRedirect("http://localhost:8085/rulers");
    }

    @Override
    protected void  doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Ruler ruler = service.findRuler(id);

        String name = req.getParameter("name");
        Integer year_of_birth = com.github.Huriosity.InputUtils.getInteger(req.getParameter("year_of_birth"));
        Integer year_of_death = com.github.Huriosity.InputUtils.getInteger(req.getParameter("year_of_death"));
        Integer testatorID    = com.github.Huriosity.InputUtils.getInteger(req.getParameter("testatorID"));

        ruler.setName(name);
        ruler.setYear_of_birth(year_of_birth);
        ruler.setYear_of_death(year_of_death);

        Ruler testator = null;
        if(testatorID != null) {
            testator = service.findRuler(testatorID);
            testator.addRulerHeir(ruler);
        } else {
            ruler.setTestator(testator);
        }


        System.out.println("ХАХАХАХА");
        System.out.println(ruler);
        service.updateRuler(ruler);
        if(testator != null) {
            // testator.addRulerHeir(ruler);
            service.updateRuler(testator);
        }

        resp.sendRedirect("http://localhost:8085/rulers");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteRuler(service.findRuler(id));
        resp.sendRedirect("http://localhost:8085/rulers");
    }

}
