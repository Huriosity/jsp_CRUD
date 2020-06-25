package dao;

import model.Country;
import model.Title;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CountryDAO {

    public Integer saveCountry(Country country){
        Integer titleId = null;

        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        titleId = (Integer) session.save(country);

        transaction.commit();
        session.close();

        return titleId;
    }

    public void updateCountry(Country country) {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.update(country);

        transaction.commit();
        session.close();
    }

    public void deleteCountry(Country country){
        System.out.println("its delete title metod");
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.delete(country);

        transaction.commit();
        session.close();
    }

    public List<Country> listCountries() {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Country> countries = session.createQuery("FROM Country").list();
        session.close();

        return countries;
    }

    public static Country findCountryByID(int id) {
        Session session = Factory.getSessionFactory().openSession();

        Query query = session.createQuery("FROM Country WHERE id = :id");
        query.setParameter("id", id);
        Country country = (Country) query.getSingleResult();

        session.close();

        return country;
    }
}
