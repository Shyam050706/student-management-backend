package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Student;
import com.klu.model.StudentManager;

@RestController
@RequestMapping("/crud")
public class StudentController {

    @Autowired
    StudentManager sm;

    @PostMapping("/insert")
    public String insert(@RequestBody Student s2) {
        return sm.insertData(s2);
    }

    @GetMapping("/alldata")
    public List<Student> getAllData() {
        return sm.getData();
    }
    
    @GetMapping("/getbyid/{sid}")
    public Student getById(@PathVariable Long sid) {
        return sm.getDataById(sid);
    }
    
    @PutMapping("/updateall/{sid}")
    public String updateStudent(@PathVariable Long sid,@RequestBody Student s1) {
        return sm.updateData(sid, s1);
    }
    @PatchMapping("/updatename/{sid}")
    public String updateName(@PathVariable Long sid,@RequestParam String sname) {
        return sm.updateName(sid, sname);
    }
    
    @PatchMapping("/updatedept/{sid}")
    public String updateDept(@PathVariable Long sid,@RequestParam String sdept) {
        return sm.updateDept(sid,sdept);
    }

    // DELETE
    @DeleteMapping("/delete/{sid}")
    @ResponseBody
    public String deleteData(@PathVariable Long sid) {
        sm.deleteData(sid);
        return "Student deleted successfully";
    }


}
