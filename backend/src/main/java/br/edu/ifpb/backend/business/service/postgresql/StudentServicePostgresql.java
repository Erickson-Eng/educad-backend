package br.edu.ifpb.backend.business.service.postgresql;

import br.edu.ifpb.backend.business.entity.Student;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServicePostgresql implements StudentService {
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
