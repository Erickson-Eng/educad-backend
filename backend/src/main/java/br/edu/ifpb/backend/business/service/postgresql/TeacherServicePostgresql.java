package br.edu.ifpb.backend.business.service.postgresql;

import br.edu.ifpb.backend.application.dto.request.TeacherRequest;
import br.edu.ifpb.backend.application.dto.request.UserRequest;
import br.edu.ifpb.backend.business.entity.Teacher;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.service.TeacherService;
import br.edu.ifpb.backend.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherServicePostgresql implements TeacherService {
    private TeacherRepository teacherRepository;

    private UserServicePostgresql userServicePostgresql;

    public List<Teacher> index() {
        return teacherRepository.findAll();
    }

    @Override
    public boolean saveTeacher(TeacherRequest teacherRequest) {
        User userEntity = userServicePostgresql.registerUser(
                new UserRequest(teacherRequest.getUsername(), teacherRequest.getPassword(), teacherRequest.getEmail())
        );

        Teacher teacherEntity = new Teacher(
                userEntity.getId(),
                userEntity,
                teacherRequest.getName(),
                teacherRequest.getBirthDate(),
                teacherRequest.getCpf(),
                teacherRequest.getRg()
        );

        teacherRepository.save(teacherEntity);

        return true;
    }

    @Override
    public boolean removeTeacher(Long teacherId) {
        try {
            if (teacherRepository.existsById(teacherId)) {
                teacherRepository.deleteById(teacherId);
                return true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateTeacher(TeacherRequest teacherRequest, Long teacherId) {
        Teacher teacherById = teacherRepository.findById(teacherId).orElseThrow(
                () -> new RuntimeException("Teacher by ID " + teacherId + " does not exist.")
        );

        teacherById.setBirthDate(teacherRequest.getBirthDate());
        teacherById.setCpf(teacherRequest.getCpf());
        teacherById.setName(teacherRequest.getName());
        teacherById.setRg(teacherRequest.getRg());

        userServicePostgresql.updateUser(
                new UserRequest(teacherRequest.getUsername(), teacherRequest.getPassword(), teacherRequest.getEmail()),
                teacherById.getUser().getId()
        );

        teacherRepository.save(teacherById);

        return true;
    }
}
