package com.studentapp.service;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDTO;
import com.studentapp.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public Student addStudent(Student student) {
       return iStudentRepository.save(student);

    }

    @Override
    public void updateStudent(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        iStudentRepository.deleteById(studentId);
    }

    @Override
    public Student getById(int studentId) {
        return iStudentRepository.findById(studentId).get();

    }

    @Override
    public List<Student> getAll() {
        //an interface used for sorting by the property/instance variable
        //use the static method "by" of sort
        Sort sort=Sort.by("name");
        return iStudentRepository.findAll(sort);

    }

    @Override
    public List<Student> getByDept(String dept) {
        return iStudentRepository.findByDepartment(dept);
    }

    @Override
    public List<Student> getByCity(String city) {
        Sort sort=Sort.by(Sort.Direction.ASC,"name");
        return iStudentRepository.findByAddressCity(city,sort);
    }

    @Override
    public List<Student> getByDeptAndCity(String dept, String city) {
        return iStudentRepository.findByDeptAndCity(dept,city);
    }

    @Override
    public List<Student> getByState(String state) {
        return iStudentRepository.findByState(state);
    }

    @Override
    public StudentDTO getByStudentId(int studentId) {
        return iStudentRepository.findByStudentId(studentId);
    }


}
