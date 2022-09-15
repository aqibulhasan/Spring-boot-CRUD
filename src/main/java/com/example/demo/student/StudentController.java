package com.example.demo.student;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping()
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @GetMapping(path="{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
         this.studentService.deleteStudent(studentId);
    }

    @PostMapping(path="{studentId}")
    public void updateStudent(@RequestBody Student student,@PathVariable Long studentId){
            this.studentService.updateStudent(student,studentId);
    }
}
