package SessionHelper;

import Model.Courses;
import Model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {

    public static SessionFactory getConnection(){
        Configuration cfg = new Configuration();
        cfg.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Courses.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        return sessionFactory;
    }
}
