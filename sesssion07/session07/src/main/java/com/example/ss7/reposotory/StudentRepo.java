package com.example.ss7.reposotory;

import com.example.ss7.modal.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class StudentRepo {
    List<Student> students=new ArrayList<>(
            Arrays.asList(
                    new Student(1,"a",false,20,"Ninh Bình"),
                    new Student(2,"anh",true,20,"Hưng Yên")
            )
    );

    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;

    }
    public void  addStudent(Student student){
        students.add(student);
    }
}
