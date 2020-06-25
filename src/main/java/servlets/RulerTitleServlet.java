package servlets;

import dao.RulerDAO;
import dao.TitleDAO;
import model.RullerMainTitleRel;
import model.Title;
import model.Town;
import services.RulerTitleService;
import services.TownService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.sax.SAXResult;
import java.io.IOException;
import java.util.List;

public class RulerTitleServlet extends HttpServlet {

    private RulerTitleService service = new RulerTitleService();

    public void init(ServletConfig servletConfig){
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<RullerMainTitleRel> rulerTitleRels = service.findAllTitles();
        req.setAttribute("rulerTitleRels", rulerTitleRels);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/rulerTitle/showRulerTitles.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Integer rulerID =Integer.parseInt(req.getParameter("rulerID"));
        Integer titleID = Integer.parseInt(req.getParameter("titleID"));

        Integer gotTheTitleIn = com.github.Huriosity.InputUtils.getInteger(req.getParameter("Got_the_title_in"));
        Integer lostTheTitleIn = com.github.Huriosity.InputUtils.getInteger(req.getParameter("Lost_the_title_in"));

        RullerMainTitleRel rullerMainTitleRel = new RullerMainTitleRel();

        rullerMainTitleRel.setRuller_id(rulerID);
        rullerMainTitleRel.setRuler(RulerDAO.findRulerByID(rulerID));

        rullerMainTitleRel.setTitle(TitleDAO.findTitleByID(titleID));

      //  rullerMainTitleRel.addRullerMainTitleRels(TitleDAO.findTitleByID(titleID));
        rullerMainTitleRel.setGot_the_title_in(gotTheTitleIn);
        rullerMainTitleRel.setLost_the_title_in(lostTheTitleIn);

        service.saveRulerTitle(rullerMainTitleRel);

        resp.sendRedirect("/rulerTitleRels");
    }

    @Override
    protected void  doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        RullerMainTitleRel rullerMainTitleRel = service.findRulerTitle(id);

        Integer titleID = Integer.parseInt(req.getParameter("titleID"));
        Integer gotTheTitleIn = com.github.Huriosity.InputUtils.getInteger(req.getParameter("Got_the_title_in"));
        Integer lostTheTitleIn = com.github.Huriosity.InputUtils.getInteger(req.getParameter("Lost_the_title_in"));

        rullerMainTitleRel.setTitle(TitleDAO.findTitleByID(titleID));
        rullerMainTitleRel.setGot_the_title_in(gotTheTitleIn);
        rullerMainTitleRel.setLost_the_title_in(lostTheTitleIn);

        service.updateRulerTitle(rullerMainTitleRel);

        resp.sendRedirect("/rulerTitleRels");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("rulerID"));
        service.deleteRulerTitle(service.findRulerTitle(id));
        resp.sendRedirect("/rulerTitleRels");
    }


}
