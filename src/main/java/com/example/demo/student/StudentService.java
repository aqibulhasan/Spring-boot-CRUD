package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional=studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw  new IllegalStateException("No student found with this id");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Student student, Long studentId) {
        Student existingStudent=studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException("student with id"+studentId + "not exist"));

        if(student.getName()!=null && !Objects.equals(existingStudent.getName(),student.getName())){
            existingStudent.setName(student.getName());
        }
    }
}
