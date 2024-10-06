package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Student;
import java.util.ArrayList;
import java.util.Random;

@RestController
public class StudentController {

    public static List<Student> students = new ArrayList<>();

    public StudentController() {
        Student student1 = new Student("Gerson", "Perez");
        Student student2 = new Student("Juan", "Gomez");
        Student student3 = new Student("Matias", "Jackson");
        Student student4 = new Student("Luis", "Camacho");
        Student student5 = new Student("Miguel", "Rodriguez");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping("/student/{firtstName}/{lastName}")
    public Student studentPathVariBLE(@PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName) {
        return new Student(firstName, lastName);
    }

    @GetMapping("/student/query")
    public Student studentQueryParam(@RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName) {
        return new Student(firstName, lastName);
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
        
    
    @PutMapping("/student/{firstName}")
    public ResponseEntity<Void> updateStudent(@PathVariable("firstName") String firstName, @RequestBody Student student) {
        boolean found = false;
        for (Student stud : students) {
            if (stud.getFistName().equals(firstName)) {
                stud.setFistName(student.getFistName());
                stud.setLastName(student.getLastName());
                found = true;
                
            }
        }
        if (!found) {
            return ResponseEntity.notFound().build(); // Retorna 404 si no se encontró
        }

        return ResponseEntity.ok().build(); // Retorna 200 si se actualizó correctamenteif (found){

    }
        

    

    @DeleteMapping("/student/{firstName}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("firstName") String firstName) {
        boolean flag=false;
        for (Student student : students) {
            if (student.getFistName().equals(firstName)) {
                students.remove(student);
                flag=true;
            }
        }
        if (!flag){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();

    }

}