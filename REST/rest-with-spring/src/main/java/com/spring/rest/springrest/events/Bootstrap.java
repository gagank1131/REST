package com.spring.rest.springrest.events;

import com.spring.rest.springrest.entities.Student;
import com.spring.rest.springrest.entities.User;
import com.spring.rest.springrest.repositories.StudentRepository;
import com.spring.rest.springrest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Bootstrap {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;
    
    @EventListener(ContextRefreshedEvent.class)
    void setUp(){

        if(!userRepository.findAll().iterator().hasNext()) {
            IntStream.range(0, 10).forEach(e -> {
                User user = new User();
                user.setAge(20 + e);
                user.setName("name" + e);
                userRepository.save(user);
            });
        }
    }
    
    @EventListener(ContextRefreshedEvent.class)
    void setUpStudent(){

        if(!studentRepository.findAll().iterator().hasNext()) {
            IntStream.range(0, 10).forEach(e -> {
                Student s = new Student();
                s.setAge(20 + e);
                s.setName("name" + e);
                s.setCity("delhi");
                s.setStandard(10);
                s.setPercentage(90.5f);
                studentRepository.save(s);
            });
        }
    }

}
