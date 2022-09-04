package br.edu.ifpb.backend.business.service;

import br.edu.ifpb.backend.application.dto.request.StudentRequest;
import br.edu.ifpb.backend.business.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> index();

    boolean saveStudent(StudentRequest studentRequest);

    boolean removeStudent(Long studentId);

    boolean updateStudent(StudentRequest studentRequest, Long studentId);
}
