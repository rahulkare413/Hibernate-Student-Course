package Operation;

import Model.Courses;
import SessionHelper.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class DeleteData {
    private static Scanner sc = new Scanner(System.in);

    public void deleteData(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER COURSE ID TO DELETE THE COURSE ");
        int id = sc.nextInt();

        Courses c1 = session.load(Courses.class,id);

        session.delete(c1);
        tx.commit();
        session.close();
        System.out.println("DATA DELTED SUCCESSFULLY ");
    }
}
