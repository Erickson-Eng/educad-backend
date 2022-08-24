package br.edu.ifpb.backend.application.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    @GetMapping
    public String index(){
        System.out.println("Testando rota");
        return "Okay";
    }
}
