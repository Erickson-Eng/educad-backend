package br.edu.ifpb.backend.application.controller;

import br.edu.ifpb.backend.business.entity.Student;
import br.edu.ifpb.backend.business.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;


@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    @GetMapping
    public ArrayList<Student> index() {
        System.out.println("Testando rota de listagem de estudantes");

        Student student1 = new Student(
                new User(
                        0L,
                        "Usuário",
                        "senha123",
                        "usuario@gmail.com"),
                "Usuário",
                new Date(),
                "12862305430",
                "123456789");

        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(student1);
        arrayList.add(student1);
        arrayList.add(student1);

        System.out.println(arrayList);

        return arrayList;
    }
}
