package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "courseIdGene")
    @SequenceGenerator(name = "courseIdGene",allocationSize = 100000,initialValue = 1000)

    @Column(name = "course_id")
    private int id ;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "description")
    private String description;
    @Column(name = "credit_hours")
    private double creditHours;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "student_course",joinColumns = @JoinColumn(name = "student_ref"), inverseJoinColumns = @JoinColumn(name = "course_ref"))
    private List<Student> studentList;

    public void addStudents(Student s){
        if (studentList== null){
            studentList = new LinkedList<>();
        }
        studentList.add(s);
    }
}
