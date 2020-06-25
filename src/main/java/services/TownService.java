package services;

import dao.TownDAO;
import model.Town;

import java.util.List;

public class TownService {
    private TownDAO townDAO = new TownDAO();

    public TownService() {

    }

    public Town findTown(int id) {
        return townDAO.findTownByID(id);
    }

    public void saveTown(Town town){
        townDAO.saveTown(town);
    }

    public void updateTown(Town town){
        townDAO.updateTown(town);
    }

    public void deleteTown(Town town){
        townDAO.deleteTown(town);
    }

    public List<Town> findAllTowns() {
        return townDAO.listTowns();
    }
}
