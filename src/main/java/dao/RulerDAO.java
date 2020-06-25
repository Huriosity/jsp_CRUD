package dao;

import com.github.Huriosity.InputUtils;
import model.Ruler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;


public class RulerDAO {
    public void start() {
        System.out.println((System.getProperty("user.dir")));
        SessionFactory sessionFactory = Factory.getSessionFactory(); ////////////// &&&&&&&&&&&&&&&&&&&

        RulerDAO rulerDAO = new RulerDAO();

        System.out.println("Test  case");

        // rulerDAO.addRuler();

        System.out.println("List of Rullers:");
        rulerDAO.listRullers();
    }

    public Integer addRuler(){

        String name = "";
        Integer year_of_birth;
        Integer year_of_death ;
        Ruler testator;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя ");
        name = scanner.nextLine();

        while (true){
            System.out.println("Введите year_of_birth");
            year_of_birth = InputUtils.getInteger();

            System.out.println("Введите year_of_death");
            year_of_death = InputUtils.getInteger();

            if (year_of_birth != null && year_of_death != null) {
                if (year_of_birth > year_of_death) {
                    System.out.println("Остоpожнее молодой человек! year_of_birth > year_of_death. Введите заного");
                } else {
                    break;
                }
            } else {
                break;
            }

        }
        System.out.println("Введите testatorID");
        Integer testatorID = InputUtils.getInteger();
        if(testatorID != null){
            testator = RulerDAO.findRulerByID(testatorID);
        } else {
            testator = null;
        }

        Ruler ruler = new Ruler();// (name, year_of_birth, year_of_death, testator);
        ruler.setName(name);
        ruler.setYear_of_birth(year_of_birth);
        ruler.setYear_of_death(year_of_death);

        ruler.setTestator(testator);
        testator.addRulerHeir(ruler);

        Integer result = saveRuler(ruler);
        updateRuler(testator);

        return result;
    }

    public Integer saveRuler(Ruler ruler){
        Integer rulerId = null;

        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        rulerId = (Integer) session.save(ruler);
        session.evict(ruler);

        transaction.commit();
        session.close();

        return rulerId;

    }

    public void startUpdateRuler(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Ruler id");
        int id = InputUtils.getInt();
        Ruler ruler = RulerDAO.findRulerByID(id);
        while (true){
            System.out.println("Would you like to change the ruler name? (y/n)");
            String choose = scanner.nextLine();
            if(choose.equals("y")){
                System.out.println("Old name: " + ruler.getName());
                System.out.println("Enter new name: ");
                ruler.setName(scanner.nextLine());
                break;
            } else if(choose.equals("n")){
                break;
            }
        }

        while (true){
            System.out.println("Would you like to change the ruler year of birth? (y/n)");
            String choose = scanner.nextLine();
            if(choose.equals("y")){
                System.out.println("Old year of birth: " + ruler.getYear_of_birth());
                System.out.println("Enter new year of birth: ");
                Integer year_of_birth = InputUtils.getInteger();
                ruler.setYear_of_birth(year_of_birth);
                break;
            } else if(choose.equals("n")){
                break;
            }
        }

        while (true){
            System.out.println("Would you like to change the ruler year of death? (y/n)");
            String choose = scanner.nextLine();
            if(choose.equals("y")){
                System.out.println("Old year of death: " + ruler.getYear_of_death());
                System.out.println("Enter new year of death: ");
                Integer year_of_death = InputUtils.getInteger();
                ruler.setYear_of_death(year_of_death);
                break;
            } else if(choose.equals("n")){
                break;
            }
        }
        while (true){
            System.out.println("Would you like to change the ruler testator? (y/n)");
            String choose = scanner.nextLine();
            if(choose.equals("y")){
                System.out.println("Old testator: " + ruler.getTestator());
                System.out.println("Enter new testator: ");
                int testatorID = InputUtils.getInt();
                Ruler testator = RulerDAO.findRulerByID(testatorID);
                ruler.setTestator(testator);
                break;
            } else if(choose.equals("n")){
                break;
            }
        }

       updateRuler(ruler);
    }

    public void updateRuler(Ruler ruler){
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();



        session.evict(ruler);
        session.merge(ruler);
        session.flush();

        /*Ruler testator = ruler.getTestator();
        testator.addRulerHeir(ruler);

        session.evict(testator);
        session.update(testator);*/

        transaction.commit();
        session.close();

    }

    public void deleteRuler(Ruler ruler){
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.delete(ruler);

        transaction.commit();
        session.close();

    }

    public List<Ruler> listRullers() {
        Session session = Factory.getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Ruler> rulers = session.createQuery("FROM Ruler").list();
        for (Ruler ruler : rulers) {
            System.out.println(ruler);
            System.out.println("\n================\n");
        }
        session.close();
        return rulers;
    }

    public static Ruler findRulerByID(int id) {
        Session session = Factory.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Ruler WHERE id = :id");
        query.setParameter("id", id);
        Ruler ruler = (Ruler) query.getSingleResult();

        System.out.println("ХОБА");
        System.out.println(ruler);

        session.close();

        return ruler;
    }
}
