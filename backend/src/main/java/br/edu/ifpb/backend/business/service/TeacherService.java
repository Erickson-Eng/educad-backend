package br.edu.ifpb.backend.business.service;

import br.edu.ifpb.backend.application.dto.request.TeacherRequest;
import br.edu.ifpb.backend.business.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> index();

    boolean saveTeacher(TeacherRequest teacherRequest);

    boolean removeTeacher(Long teacherId);

    boolean updateTeacher(TeacherRequest teacherRequest, Long teacherId);
}
