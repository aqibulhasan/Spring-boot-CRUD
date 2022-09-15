package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {

            Student aqib=new Student(
                    "aqib",
                    "aqibulhasan956@gmail.com",
                    LocalDate.of(1995, Month.JULY,3)
            );
            Student rakib=new Student(
                    "rakib",
                    "aqibulhasan956@gmail.com",
                    LocalDate.of(1995, Month.JULY,3)
            );
            repository.saveAll(List.of(aqib,rakib));
        };

    }
}
