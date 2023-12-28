package Operation;

import Model.Courses;
import Model.Student;
import SessionHelper.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.Scanner;

public class InsertData {
    private static Scanner sc = new Scanner(System.in);
    public Student addStudentsData(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("ENTER STUDENT NAME ");
        String name = sc.next();
        System.out.println("ENTER STUDENT AGE ");
        int age = sc.nextInt();
        System.out.println("ENTER STUDENT EMAIL ID ");
        String email = sc.next();

        Student s1 = new Student();
        s1.setStudentName(name);
        s1.setAge(age);
        s1.setEmail(email);

        System.out.println("HOW MANY COURSES YOU WANT BE ADDED ");
        int count = sc.nextInt();
        for (int i = 0 ; i<count ; i++){
            Courses c1 = addCourseDetails();
            s1.addCourses(c1);
        }
        session.save(s1);
        tx.commit();
        session.close();


        return s1 ;

    }

    public Courses addCourseDetails(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER COURSE NAME ");
        String course = sc.next().toUpperCase();
        System.out.println("ENTER DESCRIPTION OF COURSES ");
        String description = sc.next();
        sc.nextLine();
        System.out.println("ENTER COURSE DURATION IN HOURS ");
        double hrs = sc.nextDouble();

        Courses c1 = new Courses();
        c1.setCourseName(course);
        c1.setDescription(description);
        c1.setCreditHours(hrs);

        session.save(c1);
        tx.commit();
        session.close();
        return c1;
    }
}
