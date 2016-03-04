package learnit.model;
import java.sql.*;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoginModel {


    public static final String USR_TBL_SELECT = "SELECT * FROM tbl_user";

    private String message="";
    private String message2="temp";
    private String driverName = "org.gjt.mm.mysql.Driver";

    public String getMessage2() throws ClassNotFoundException, SQLException {


        SessionFactory factory;

        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List userDetails;
            userDetails = session.createQuery("FROM UserDetails").list();
            for (Iterator iterator =
                 userDetails.iterator(); iterator.hasNext();){
                UserDetails userdetails = (UserDetails) iterator.next();
                message = String.format("UserName is this %s User Id is %s Email Id is %s", userdetails.getUserName(),
                        userdetails.getId(), userdetails.getEmail());

            }
            tx.commit();
            message2=message;
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return message2;
    }
    public void setMessage2(String message2) {
        this.message2 = message2;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}