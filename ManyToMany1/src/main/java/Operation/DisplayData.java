package Operation;

import Model.Courses;
import Model.Student;
import SessionHelper.Connection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class DisplayData {
    private static Scanner sc = new Scanner(System.in);
    public void displayAllData(){
        SessionFactory sessionFactory = Connection.getConnection();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("ENTER STUDENT ID ");
        int id = sc.nextInt();

        Query query = session.createQuery("from Student s where s.studentId = '"+id+"'");
        List<Student> studentList = query.getResultList();
        for (Student s : studentList){
            System.out.println(" STUDENT ID " +s.getStudentId());
            System.out.println(" STUDENT NAME " +s.getStudentName());
            System.out.println(" STUDENT AGE " +s.getAge());
            System.out.println(" STUDENT EMAIL " +s.getEmail());
            System.out.println("-------------------------------");
            List<Courses> coursesList = s.getCoursesList();
            for (Courses c : coursesList){
                System.out.println("COURSE ID " +c.getId());
                System.out.println("COURSE NAME " +c.getCourseName());
                System.out.println("COURSE DESCRIPTION " +c.getDescription());
                System.out.println("CREDITED HOURS "+c.getCreditHours());
                System.out.println("-----------------------------------");
            }
        }

    }
}
