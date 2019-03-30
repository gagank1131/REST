package com.spring.rest.springrest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties(value = {"age","id"})
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Size(min = 2,message = "Name should have at least 2 characters")
    String name;
    
    Integer standard;
    
    Integer age;
    
    String city;
    
    Float percentage;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getStandard() {
        return standard;
    }
    
    public void setStandard(Integer standard) {
        this.standard = standard;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public Float getPercentage() {
        return percentage;
    }
    
    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
