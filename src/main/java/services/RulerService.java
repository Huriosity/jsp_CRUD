package services;


import dao.RulerDAO;
import model.Ruler;

import java.util.List;

public class RulerService {

    private RulerDAO rulerDAO = new RulerDAO();

    public RulerService() {

    }

    public Ruler findRuler(int id) {
        return rulerDAO.findRulerByID(id);
    }

    public void saveRuler(Ruler ruler){
        rulerDAO.saveRuler(ruler);
    }

    public void updateRuler(Ruler ruler){
        rulerDAO.updateRuler(ruler);
    }

    public void deleteRuler(Ruler ruler){
        rulerDAO.deleteRuler(ruler);
    }

    public List<Ruler> findAllRulers() {
        return rulerDAO.listRullers();
    }



}
