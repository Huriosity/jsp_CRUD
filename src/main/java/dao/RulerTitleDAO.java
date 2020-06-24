package dao;

import com.github.Huriosity.InputUtils;
import model.Ruler;
import model.RullerMainTitleRel;
import model.Title;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class RulerTitleDAO {

    public Integer saveRulerMainTitle(RullerMainTitleRel rulerMainTitle){
        Integer rulerMainTitleId = null;

        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        rulerMainTitleId = (Integer) session.save(rulerMainTitle);

        transaction.commit();
        session.close();

        return rulerMainTitleId;
    }

    public void updateRulerTitle(RullerMainTitleRel rullerMainTitleRel) {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.update(rullerMainTitleRel);

        transaction.commit();
        session.close();

    }

    public void deleteRulerTitle(RullerMainTitleRel rulerTitle){
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.delete(rulerTitle);

        transaction.commit();
        session.close();

    }

    public List<RullerMainTitleRel> listRullersMainTitle() {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<RullerMainTitleRel> rullersMainTitle = session.createQuery("FROM RullerMainTitleRel").list();
        session.close();

        return rullersMainTitle;
    }

    public static RullerMainTitleRel findRulerMainTitleRelByID(int rulerID) {
        Session session = Factory.getSessionFactory().openSession();
        Query query = session.createQuery("FROM RullerMainTitleRel WHERE ruller_id = :id");
        query.setParameter("id", rulerID);

        RullerMainTitleRel rullerMainTitleRel = (RullerMainTitleRel) query.getSingleResult();

        session.close();

        return rullerMainTitleRel;
    }
}
