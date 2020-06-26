package servlets;

import dao.CountryDAO;
import dao.RulerDAO;
import dao.TownDAO;
import model.CountryCapitalTownRel;
import model.RulerCountryRel;
import services.CountryCapitalService;
import services.RulerCountryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CountryCapitalServlet extends HttpServlet {

    private CountryCapitalService service = new CountryCapitalService();

    public void init(ServletConfig servletConfig){
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CountryCapitalTownRel> countriesCapitals = service.findAllCountryCapiitals();
        req.setAttribute("countriesCapitals", countriesCapitals);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/countriesCapitals/showCountriesCapitals.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int countryID = Integer.parseInt(req.getParameter("countryID"));
        int townID =Integer.parseInt(req.getParameter("townID"));

        Integer capitalStartYear = com.github.Huriosity.InputUtils.getInteger(req.getParameter("capital_start_year"));
        Integer capitalEndYear = com.github.Huriosity.InputUtils.getInteger(req.getParameter("capital_end_year"));

        CountryCapitalTownRel countryCapital = new CountryCapitalTownRel();

        countryCapital.setCountry(CountryDAO.findCountryByID(countryID));
        countryCapital.setTown(TownDAO.findTownByID(townID));
        countryCapital.setCapital_start_year(capitalStartYear);
        countryCapital.setCapital_end_year(capitalEndYear);

        service.saveCountryCapital(countryCapital);

        resp.sendRedirect("/countriesCapitals");
    }

    @Override
    protected void  doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CountryCapitalTownRel countryCapital = service.findCountryCapital(id);

        Integer townID = Integer.parseInt(req.getParameter("townID"));
        Integer capitalStartYear = com.github.Huriosity.InputUtils.getInteger(req.getParameter("capital_start_year"));
        Integer capitalEndYear = com.github.Huriosity.InputUtils.getInteger(req.getParameter("capital_end_year"));

        model.Town town = dao.TownDAO.findTownByID(townID);

        countryCapital.setTown(town);
        countryCapital.setCapital_start_year(capitalStartYear);
        countryCapital.setCapital_end_year(capitalEndYear);

        service.updateCountryCapital(countryCapital);

        resp.sendRedirect("/countriesCapitals");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteCountryCapital(service.findCountryCapital(id));
        resp.sendRedirect("/countriesCapitals");
    }


}
