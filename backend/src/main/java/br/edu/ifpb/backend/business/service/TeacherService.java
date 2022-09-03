package br.edu.ifpb.backend.business.service;

import br.edu.ifpb.backend.application.dto.request.TeacherRequest;
import br.edu.ifpb.backend.business.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> index();

    void saveTeacher(TeacherRequest teacherRequest);

    void removeTeacher(Long teacherId);

    void updateTeacher(TeacherRequest teacherRequest, Long teacherId);
}
