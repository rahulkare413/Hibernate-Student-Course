package Operation;

import Model.Courses;
import SessionHelper.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class UpdateData {
    private static Scanner sc = new Scanner(System.in);

    public void updateData(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER COURSE ID ");
        int id = sc.nextInt();

        System.out.println("ENTER UPDATED COURSE NAMES ");
        String name = sc.next().toUpperCase();

        System.out.println("ENTER COURSE DURATION IN HOURS ");
        double hrs = sc.nextDouble();

        System.out.println("ENTER COURSE DESCRIPTION ");
        String description = sc.next();
        sc.nextLine();


        Courses c1 = session.load(Courses.class,id);
        c1.setCourseName(name);
        c1.setCreditHours(hrs);
        c1.setDescription(description);

        session.update(c1);
        tx.commit();
        session.close();
        System.out.println("DATA UPDATED SUCCESSFULLY !!");
    }

}
