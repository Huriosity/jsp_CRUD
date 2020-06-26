package dao;

import model.RulerCountryRel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RulerCountryDAO {

    public void saveRulerCountry(RulerCountryRel rulerCountryRel){
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.save(rulerCountryRel);

        transaction.commit();
        session.close();
    }

    public void updateRulerCountry(RulerCountryRel rulerCountryRel) {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.update(rulerCountryRel);

        transaction.commit();
        session.close();
    }

    public void deleteRulerCountry(RulerCountryRel rulerCountryRel){
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.delete(rulerCountryRel);

        transaction.commit();
        session.close();
    }

    public List<RulerCountryRel> listRulersCountry() {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<RulerCountryRel> rulerCountryRels = session.createQuery("FROM RulerCountryRel").list();
        session.close();

        return rulerCountryRels;
    }

    public static RulerCountryRel findRulerCountryRelByRulerCountryID(int id) {
        Session session = Factory.getSessionFactory().openSession();
        Query query = session.createQuery("FROM RulerCountryRel WHERE id = :id");
        query.setParameter("id", id );

        RulerCountryRel rulerCountryRel = (RulerCountryRel) query.getSingleResult();

        session.close();

        return rulerCountryRel;
    }
}
