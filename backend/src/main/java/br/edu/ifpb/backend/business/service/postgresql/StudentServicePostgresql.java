package br.edu.ifpb.backend.business.service.postgresql;

import br.edu.ifpb.backend.application.dto.request.StudentRequest;
import br.edu.ifpb.backend.application.dto.request.UserRequest;
import br.edu.ifpb.backend.business.entity.Student;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.service.StudentService;
import br.edu.ifpb.backend.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServicePostgresql implements StudentService {
    private StudentRepository studentRepository;

    private UserServicePostgresql userServicePostgresql;

    public List<Student> index() {
        return studentRepository.findAll();
    }

    public boolean saveStudent(StudentRequest studentRequest) {
        User userEntity = userServicePostgresql.registerUser(
                new UserRequest(studentRequest.getUsername(), studentRequest.getPassword(), studentRequest.getEmail())
        );

        Student studentEntity = new Student(
                userEntity.getId(),
                userEntity,
                studentRequest.getName(),
                studentRequest.getBirthDate(),
                studentRequest.getCpf(),
                studentRequest.getRg()
        );

        studentRepository.save(studentEntity);

        return true;
    }

    public boolean removeStudent(Long studentId) {
        try {
            if (studentRepository.existsById(studentId)) {
                studentRepository.deleteById(studentId);
                return true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateStudent(StudentRequest studentRequest, Long studentId) {
        Student studentById =  studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Student by ID " + studentId + " does not exist.")
        );

        studentById.setBirthDate(studentRequest.getBirthDate());
        studentById.setCpf(studentRequest.getCpf());
        studentById.setName(studentRequest.getName());
        studentById.setRg(studentRequest.getRg());

        userServicePostgresql.updateUser(
                new UserRequest(studentRequest.getUsername(), studentRequest.getPassword(), studentRequest.getEmail()),
                studentById.getUser().getId()
        );

        studentRepository.save(studentById);

        return true;
    }
}
