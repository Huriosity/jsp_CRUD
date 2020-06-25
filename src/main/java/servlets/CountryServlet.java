package servlets;

import model.Country;
import services.CountryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CountryServlet extends HttpServlet {
    private CountryService service = new CountryService();

    public void init(ServletConfig servletConfig){
        try {
            super.init(servletConfig);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Country> countries = service.findAllCountries();
        req.setAttribute("countries", countries);
        RequestDispatcher dispatcher = req.getRequestDispatcher("pages/countries/showCountries.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");

        Country country = new Country();
        country.setName(name);

        service.saveCountry(country);

        resp.sendRedirect("/countries");
    }

    @Override
    protected void  doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Country country = service.findCountry(id);

        String name = req.getParameter("name");

        country.setName(name);

        service.updateCountry(country);

        resp.sendRedirect("/countries");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteCountry(service.findCountry(id));
        resp.sendRedirect("/countries");
    }
}
