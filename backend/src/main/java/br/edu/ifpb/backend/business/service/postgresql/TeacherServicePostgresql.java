package br.edu.ifpb.backend.business.service.postgresql;

import br.edu.ifpb.backend.application.dto.request.TeacherRequest;
import br.edu.ifpb.backend.business.entity.Teacher;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.service.TeacherService;
import br.edu.ifpb.backend.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherServicePostgresql implements TeacherService {
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> index() {
        return teacherRepository.findAll();
    }

    @Override
    public void saveTeacher(TeacherRequest teacherRequest) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(teacherRequest.getPassword());

        Teacher entity = new Teacher(
                1L,
                new User(
                        1L,
                        teacherRequest.getUsername(),
                        encryptedPassword,
                        teacherRequest.getEmail()
                ),
                teacherRequest.getName(),
                teacherRequest.getBirthDate(),
                teacherRequest.getCpf(),
                teacherRequest.getRg()
        );

        teacherRepository.save(entity);
    }

    @Override
    public void removeTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    @Override
    public void updateTeacher(TeacherRequest teacherRequest, Long teacherId) {
        // String encryptedPassword = new BCryptPasswordEncoder().encode(studentRequest.getPassword());

        Teacher teacherById;

        try {
            teacherById = teacherRepository.findById(teacherId).orElseThrow(
                    () -> new Exception("Teacher by ID " + teacherId + " does not exist.")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        teacherById.setBirthDate(teacherRequest.getBirthDate());
        teacherById.setCpf(teacherRequest.getCpf());
        teacherById.setName(teacherRequest.getName());
        teacherById.setRg(teacherRequest.getRg());

        teacherById.getUser().setEmail(teacherRequest.getEmail());
        teacherById.getUser().setUsername(teacherRequest.getUsername());
        // studentById.getUser().setPassword(encryptedPassword);

        teacherRepository.save(teacherById);
    }
}
