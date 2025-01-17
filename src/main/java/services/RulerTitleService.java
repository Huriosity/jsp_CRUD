package services;

import dao.RulerTitleDAO;
import model.RullerMainTitleRel;

import java.util.List;

public class RulerTitleService {
    private static RulerTitleDAO rulerTitleDAO = new RulerTitleDAO();

    public RulerTitleService() {

    }

    public RullerMainTitleRel findRulerTitle(int id) {
        return rulerTitleDAO.findRulerMainTitleRelByID(id);
    }

    public void saveRulerTitle(RullerMainTitleRel title){
        rulerTitleDAO.saveRulerMainTitle(title);
    }

    public void updateRulerTitle(RullerMainTitleRel title){
        rulerTitleDAO.updateRulerTitle(title);
    }

    public void deleteRulerTitle(RullerMainTitleRel title){
        rulerTitleDAO.deleteRulerTitle(title);
    }

    public static List<RullerMainTitleRel> findAllTitles() {
        return rulerTitleDAO.listRullersMainTitle();
    }
}
