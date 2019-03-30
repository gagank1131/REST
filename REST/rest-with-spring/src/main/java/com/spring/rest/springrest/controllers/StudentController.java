package com.spring.rest.springrest.controllers;

import com.spring.rest.springrest.entities.Student;
import com.spring.rest.springrest.exceptions.StudentNotFoundException;
import com.spring.rest.springrest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@ControllerAdvice
@RestController
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    MessageSource messageSource;
    
    @GetMapping("/students")
    List<Student> getStudent(){
        return studentService.getAllStudents();
    }
    
    @GetMapping("/students/{id}")
    Optional<Student> getStudentById(@PathVariable Long id){
        
         return studentService.getStudentById(id);
    }
    
    //question 5 and 3
    @PostMapping(value = "/students",produces = "application/xml")
    Student saveStudents(@RequestBody Student student){
    
        studentService.save(student);
    
//        URI uri=ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("{id}").buildAndExpand(student.getId()).toUri();
//
//        return ResponseEntity.created(uri).build();
        return student;
       
    }
    
    @PutMapping("/students/{id}")
    Student updateStudent(@PathVariable Long id,@RequestBody Student student){
        studentService.update(id,student);
        return student;
    }
    
    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id){
      studentService.deleteStudent(id);
    }
    
    // QUESTION 2
    
    @GetMapping("/students/question2/{id}")
    Optional<Student> getUser(@PathVariable Long id){
        Optional<Student> student = studentService.getStudentById(id);
        if(student.isPresent()){
            return studentService.getStudentById(id);
            
        }else {
            throw  new StudentNotFoundException("student not found");
        }
        
    }
    
    
    //Question 3
    @PostMapping("/students/question3")
    ResponseEntity<Student> getStudent(@Valid @RequestBody Student student){
        studentService.save(student);
    
        URI uri= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}").buildAndExpand(student.getId()).toUri();
    
        return ResponseEntity.created(uri).build();
    
    }
    
    // Question 4
    
    @GetMapping("/question4")
    String hello(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
        System.out.println("hello world");
//        System.out.println(locale.getLanguage());
        return messageSource.getMessage("good.morning.message",null,locale);
    }
    
    @GetMapping("/question4.2")
    String helloWorld(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
    
}
