package com.studentapp.service;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    Student addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);

    Student getById(int StudentId);
    List<Student> getAll();


    List<Student> getByDept(String dept);
    List<Student> getByCity(String city);
    List<Student> getByDeptAndCity(String dept,String city);
    List<Student> getByState(String state);


    //projection
    StudentDTO getByStudentId(int studentId);
}
