package services;

import dao.CountryCapitalTownDAO;
import model.CountryCapitalTownRel;

import java.util.List;

public class CountryCapitalService {

    private static CountryCapitalTownDAO countryCapitalDAO = new CountryCapitalTownDAO();

    public CountryCapitalService() {}

    public CountryCapitalTownRel findCountryCapital(int id) {
        return countryCapitalDAO.findCountryCapitalRelByCountryCapitalID(id);
    }

    public void saveCountryCapital(CountryCapitalTownRel countryCapital){
        countryCapitalDAO.saveCountryCapital(countryCapital);
    }

    public void updateCountryCapital(CountryCapitalTownRel countryCapital){
        countryCapitalDAO.updateCountryCapital(countryCapital);
    }

    public void deleteCountryCapital(CountryCapitalTownRel countryCapital){
        countryCapitalDAO.deleteCountryCapital(countryCapital);
    }

    public static List<CountryCapitalTownRel> findAllCountryCapiitals() {
        return countryCapitalDAO.listCountriesCapitals();
    }

    public static List<CountryCapitalTownRel> findAllCountryCapiitalsByTownID(int id) {
        return countryCapitalDAO.findAllCountryCapitalRelByCapitalID(id);
    }
}
