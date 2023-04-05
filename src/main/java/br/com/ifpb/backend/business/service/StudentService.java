package br.com.ifpb.backend.business.service;

import br.com.ifpb.backend.business.entity.Student;

import java.util.List;

public interface StudentService {

    Student save (Student student);

    Student update (Long id, Student student);

    List<Student> listAllStudentsEnrolledInCourse(Long courseId);
}
