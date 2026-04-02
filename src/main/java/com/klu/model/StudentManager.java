package com.klu.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Student;
import com.klu.exception.StudentNotFoundException;
import com.klu.repository.StudentRepository;

@Service
public class StudentManager {

    @Autowired
    StudentRepository sr;

    // URL:
    // POST http://localhost:8080/crud/insert
    public String insertData(Student s1) {
        sr.save(s1);
        return "data was inserted successfully";
    }

    // URL:
    // GET http://localhost:8080/crud/alldata
    public List<Student> getData() {
        return sr.findAll();
    }

    // URL:
    // GET http://localhost:8080/crud/getbyid/1
    public Student getDataById(Long sid) {
        Optional<Student> s1 = sr.findById(sid);

        if (s1.isPresent()) {
            return s1.get();
        } else {
            throw new StudentNotFoundException("Student with provided id " + sid + " not found");
        }
    }

    // URL:
    // PUT http://localhost:8080/crud/updateall/1
    public String updateData(Long sid, Student s2) {
        Optional<Student> s3 = sr.findById(sid);

        if (s3.isPresent()) {
            Student s4 = s3.get();
            s4.setSname(s2.getSname());
            s4.setSdept(s2.getSdept());
            sr.save(s4);
            return "Student updated successfully";
        }
        else {
            throw new StudentNotFoundException("Student with id " + sid + " not found");
        }
    }

    // URL:
    // PATCH http://localhost:8080/crud/updatename/1?sname=Ram
    public String updateName(Long sid, String sname) {
        Optional<Student> s2 = sr.findById(sid);

        if (s2.isPresent()) {
            Student s3 = s2.get();
            s3.setSname(sname);
            sr.save(s3);
            return "Student name updated successfully";
        }
        else {
            throw new StudentNotFoundException("Student with id " + sid + " not found");
        }
    }

    // URL:
    // PATCH http://localhost:8080/crud/updatedept/1?sdept=ECE
    public String updateDept(Long sid, String sdept) {

        Optional<Student> s1 = sr.findById(sid);

        if (s1.isPresent()) {
            Student s2 = s1.get();
            s2.setSdept(sdept);
            sr.save(s2);
            return "Student department updated successfully";
        }
        else {
            throw new StudentNotFoundException("Student with id " + sid + " not found");
        }
    }

    // URL:
    // DELETE http://localhost:8080/crud/delete/1
    public String deleteData(Long sid) {

        Optional<Student> s1 = sr.findById(sid);

        if (s1.isPresent()) {
            sr.deleteById(sid);
            return "Student deleted successfully";
        }
        else {
            throw new StudentNotFoundException("Student with id " + sid + " not found");
        }
    }
}
