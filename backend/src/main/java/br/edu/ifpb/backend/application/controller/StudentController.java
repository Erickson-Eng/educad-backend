package br.edu.ifpb.backend.application.controller;

import br.edu.ifpb.backend.business.entity.Student;
import br.edu.ifpb.backend.business.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public ArrayList<Student> index() {
        return studentService.index();
    }
}
