package services;

import dao.CountryDAO;
import dao.TitleDAO;
import model.Country;
import model.Title;

import java.util.List;

public class CountryService {
    private CountryDAO countryDAO = new CountryDAO();

    public CountryService() {

    }

    public Country findCountry(int id) {
        return countryDAO.findCountryByID(id);
    }

    public void saveCountry(Country country){
        countryDAO.saveCountry(country);
    }

    public void updateCountry(Country country){
        countryDAO.updateCountry(country);
    }

    public void deleteCountry(Country country){
        countryDAO.deleteCountry(country);
    }

    public List<Country> findAllCountries() {
        return countryDAO.listCountries();
    }
}
