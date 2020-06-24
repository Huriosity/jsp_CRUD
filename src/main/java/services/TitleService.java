package services;

import dao.TitleDAO;
import model.Title;

import java.util.List;

public class TitleService {
    private TitleDAO titleDAO = new TitleDAO();

    public TitleService() {

    }

    public Title findTitle(int id) {
        return titleDAO.findTitleByID(id);
    }

    public void saveTitle(Title title){
        titleDAO.saveTitle(title);
    }

    public void updateTitle(Title title){
        titleDAO.updateTitle(title);
    }

    public void deleteTitle(Title title){
        titleDAO.deleteTitle(title);
    }

    public List<Title> findAllTitles() {
        return titleDAO.listTitles();
    }
}
