package dao;

import com.github.Huriosity.InputUtils;
import model.Ruler;
import model.Title;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class TitleDAO {

    public Integer saveTitle(Title title){
        Integer titleId = null;

        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        titleId = (Integer) session.save(title);

        transaction.commit();
        session.close();

        return titleId;

    }

    public void updateTitle(Title title) {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.update(title);

        transaction.commit();
        session.close();
    }

    public void deleteTitle(Title title){
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.delete(title);

        transaction.commit();
        session.close();
    }

    public List<Title> listTitles() {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Title> titles = session.createQuery("FROM Title").list();
        session.close();

        return titles;
    }

    public static Title findTitleByID(int id) {
        Session session = Factory.getSessionFactory().openSession();

        Query query = session.createQuery("FROM Title WHERE id = :id");
        query.setParameter("id", id);
        Title title = (Title) query.getSingleResult();

        session.close();

        return title;
    }
}
