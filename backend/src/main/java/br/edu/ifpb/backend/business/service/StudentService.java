package br.edu.ifpb.backend.business.service;

import br.edu.ifpb.backend.application.dto.request.StudentRequest;
import br.edu.ifpb.backend.business.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> index();

    void saveStudent(StudentRequest studentRequest);
}
