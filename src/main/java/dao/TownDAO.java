package dao;

import model.Town;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TownDAO {

    public Integer saveTown(Town town){
        Integer townId = null;

        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        townId = (Integer) session.save(town);

        transaction.commit();
        session.close();

        return townId;
    }

    public void updateTown(Town town) {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.update(town);

        transaction.commit();
        session.close();
    }

    public void deleteTown(Town town){
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.delete(town);

        transaction.commit();
        session.close();
    }

    public List<Town> listTowns() {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Town> towns = session.createQuery("FROM Town").list();
        session.close();

        return towns;
    }

    public static Town findTownByID(int id) {
        Session session = Factory.getSessionFactory().openSession();

        Query query = session.createQuery("FROM Town WHERE id = :id");
        query.setParameter("id", id);
        Town town = (Town) query.getSingleResult();

        session.close();

        return town;
    }
}
