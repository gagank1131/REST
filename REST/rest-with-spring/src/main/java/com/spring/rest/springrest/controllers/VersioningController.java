package com.spring.rest.springrest.controllers;


import com.spring.rest.springrest.entities.StudentV1;
import com.spring.rest.springrest.entities.StudentV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class VersioningController {
    
    //using uri
    @GetMapping("/v1")
    public List<StudentV1> getStudents()
    {
        return Arrays.asList(new StudentV1("gagan kushwaha"),new StudentV1("arpit gupta"));
    }
    @GetMapping("/v2")
    public List<StudentV2> getVersion2Students()
    {
        return Arrays.asList(new StudentV2("gagan","kushwaha"),new StudentV2("arpit","gupta"));
    }
    
    //Parameter Versioning
    @GetMapping(value = "/param",params = "version=1")
    public List<StudentV1> getStudentsV1ByParam() {
        return Arrays.asList(new StudentV1("gagan kushwaha"),new StudentV1("arpit gupta"));
    }
    
    @GetMapping(value = "/param",params = "version=2")
    public List<StudentV2> getStudentsV2ByParam() {
        return Arrays.asList(new StudentV2("gagan","kushwaha"),new StudentV2("arpit","gupta"));
    }
    
    //Header Versioning
    @GetMapping(value = "/header",headers = "API-VERSION=1")
    public List<StudentV1> getPersonHeader1() {
        return Arrays.asList(new StudentV1("gagan kushwaha"),new StudentV1("arpit gupta"));
    }
    
    @GetMapping(value = "/header",headers = "API-VERSION=2")
    public List<StudentV2>getPersonHeader2() {
        return Arrays.asList(new StudentV2("gagan","kushwaha"),new StudentV2("arpit","gupta"));
    }
    
}
