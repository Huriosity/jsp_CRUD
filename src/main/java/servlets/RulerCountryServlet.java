package servlets;

import dao.CountryDAO;
import dao.RulerDAO;
import model.RulerCountryRel;
import services.RulerCountryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RulerCountryServlet  extends HttpServlet {


    private RulerCountryService service = new RulerCountryService();

    public void init(ServletConfig servletConfig){
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<RulerCountryRel> rulerCountryRels = service.findAllRulerCountry();
        req.setAttribute("rulerCountryRels", rulerCountryRels);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/rulerCountry/showRulerCountries.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int rulerID =Integer.parseInt(req.getParameter("rulerID"));
        int countryID = Integer.parseInt(req.getParameter("countryID"));

        Integer yearOfReign = com.github.Huriosity.InputUtils.getInteger(req.getParameter("year_of_reign"));
        Integer yearEndOfReign = com.github.Huriosity.InputUtils.getInteger(req.getParameter("year_end_of_reign"));

        RulerCountryRel rulerCountryRel = new RulerCountryRel();

        rulerCountryRel.setRuler(RulerDAO.findRulerByID(rulerID));
        rulerCountryRel.setCountry(CountryDAO.findCountryByID(countryID));
        rulerCountryRel.setYear_of_reign(yearOfReign);
        rulerCountryRel.setYear_end_of_reign(yearEndOfReign);

        service.saveRulerCountry(rulerCountryRel);

        resp.sendRedirect("/rulerCountryRels");
    }

    @Override
    protected void  doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        RulerCountryRel rulerCountryRel = service.findRulerCountry(id);

        Integer countryID = Integer.parseInt(req.getParameter("countryID"));
        Integer yearOfReign = com.github.Huriosity.InputUtils.getInteger(req.getParameter("year_of_reign"));
        Integer yearEndOfReign = com.github.Huriosity.InputUtils.getInteger(req.getParameter("year_end_of_reign"));

        rulerCountryRel.setCountry(CountryDAO.findCountryByID(countryID));
        rulerCountryRel.setYear_of_reign(yearOfReign);
        rulerCountryRel.setYear_end_of_reign(yearEndOfReign);

        service.updateRulerCountry(rulerCountryRel);

        resp.sendRedirect("/rulerCountryRels");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteRulerCountry(service.findRulerCountry(id));
        resp.sendRedirect("/rulerCountryRels");
    }
}
