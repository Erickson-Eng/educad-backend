package br.edu.ifpb.backend.business.service.postgresql;

import br.edu.ifpb.backend.application.dto.request.StudentRequest;
import br.edu.ifpb.backend.application.dto.request.UserRequest;
import br.edu.ifpb.backend.business.entity.Role;
import br.edu.ifpb.backend.business.entity.Student;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public void createStudent(StudentRequest studentRequest) {
        Student entity  = createCommonStudent(studentRequest);
        try {
            if (!verifyIfExist(userRequest.getUsername())){
                userRepository.save(entity);
            }
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    protected Student createCommonStudent(StudentRequest studentRequest){
        return Student.builder()
                .email(userRequest.getEmail())
                .password(new BCryptPasswordEncoder().encode(userRequest.getPassword()))
                .username(userRequest.getUsername())
                .roles(Collections.singletonList(new Role(1L, null)))
                .build();
    }
}
