package services;

import dao.RulerCountryDAO;
import model.RulerCountryRel;

import java.util.List;


public class RulerCountryService {

    private static RulerCountryDAO rulerCountryDAO = new RulerCountryDAO();

    public RulerCountryService() {}

    public RulerCountryRel findRulerCountry(int id) {
        return rulerCountryDAO.findRulerCountryRelByRulerCountryID(id);
    }

    public void saveRulerCountry(RulerCountryRel rulerCountry){
        rulerCountryDAO.saveRulerCountry(rulerCountry);
    }

    public void updateRulerCountry(RulerCountryRel rulerCountry){
        rulerCountryDAO.updateRulerCountry(rulerCountry);
    }

    public void deleteRulerCountry(RulerCountryRel rulerCountry){
        rulerCountryDAO.deleteRulerCountry(rulerCountry);
    }

    public static List<RulerCountryRel> findAllRulerCountry() {
        return rulerCountryDAO.listRulersCountry();
    }
}
