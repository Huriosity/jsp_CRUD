package dao;

import model.CountryCapitalTownRel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CountryCapitalTownDAO {

    public void saveCountryCapital(CountryCapitalTownRel countryCapital){
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.save(countryCapital);

        transaction.commit();
        session.close();
    }

    public void updateCountryCapital(CountryCapitalTownRel countryCapital) {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.update(countryCapital);

        transaction.commit();
        session.close();
    }

    public void deleteCountryCapital(CountryCapitalTownRel countryCapital){
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.delete(countryCapital);

        transaction.commit();
        session.close();
    }

    public List<CountryCapitalTownRel> listCountriesCapitals() {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<CountryCapitalTownRel> countryCapitalTownRels = session.createQuery("FROM CountryCapitalTownRel").list();
        session.close();

        return countryCapitalTownRels;
    }

    public static CountryCapitalTownRel findCountryCapitalRelByCountryCapitalID(int id) {
        Session session = Factory.getSessionFactory().openSession();
        Query query = session.createQuery("FROM CountryCapitalTownRel WHERE id = :id");
        query.setParameter("id", id );

        CountryCapitalTownRel countryCapitalTownRel = (CountryCapitalTownRel) query.getSingleResult();

        session.close();

        return countryCapitalTownRel;
    }

    public static  List<CountryCapitalTownRel> findAllCountryCapitalRelByCapitalID(int capitalID) {
        Session session = Factory.getSessionFactory().openSession();
        Query query = session.createQuery("FROM CountryCapitalTownRel WHERE town.id = :id");
        query.setParameter("town.id", capitalID );

        List<CountryCapitalTownRel> countryCapitalTownRels =  query.list();

        session.close();

        return countryCapitalTownRels;
    }

}
