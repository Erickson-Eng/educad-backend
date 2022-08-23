package br.edu.ifpb.backend.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public String index() {
        System.out.println("Testando rota");
        return "Test";
    }
}
