package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")

    public Student getStudent(){
        Student student = new Student(
                1,
                "Ramesh",
                "Fadatare"
        );
        return student;
    }

    //http://localhost:8080/students
    @GetMapping("students")

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ramesh","Fadatare"));
        students.add(new Student(2,"umesh","Fadatare"));
        students.add(new Student(3,"Nandu","siva"));
        students.add(new Student(4,"Mukthesh","Varma"));
        students.add(new Student(5,"Chaithanya","Harshika"));
        return students;

    }
    //Spring boot REST API with path variable
    //{id} - URI template variable
    //http://localhost:8080/students/1/ramesh/fadatare

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,@PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName)
    {
        return new Student(studentId,firstName,lastName);


    }
}
