package br.edu.ifpb.backend.business.service.postgresql;

import br.edu.ifpb.backend.application.dto.request.StudentRequest;
import br.edu.ifpb.backend.business.entity.Student;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.service.StudentService;
import br.edu.ifpb.backend.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServicePostgresql implements StudentService {
    private StudentRepository studentRepository;

    public List<Student> index() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(StudentRequest studentRequest) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(studentRequest.getPassword());

        Student entity = new Student(1L, new User(1L, studentRequest.getUsername(),
                    encryptedPassword,
                    studentRequest.getEmail()),
                studentRequest.getName(),
                studentRequest.getBirthDate(),
                studentRequest.getCpf(),
                studentRequest.getRg());

        studentRepository.save(entity);
    }

}
