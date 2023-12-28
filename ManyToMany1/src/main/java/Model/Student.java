package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "student_id")
    private int studentId;

@Column(name = "student_name")
    private String studentName;

@Column(name = "student_age")
    private int age;

@Column(name = "student_email")
    private String email;

@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
@JoinTable(name = "student_course",joinColumns =@JoinColumn(name = "course_ref"),inverseJoinColumns = @JoinColumn(name = "student_ref"))
    private List<Courses> coursesList;

        public void addCourses(Courses c){
            if (coursesList==null){
                coursesList = new LinkedList<>();
            }
            coursesList.add(c);


}

}
