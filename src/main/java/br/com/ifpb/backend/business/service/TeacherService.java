package br.com.ifpb.backend.business.service;

import br.com.ifpb.backend.business.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher save (Teacher teacher);

    Teacher update (Long id, Teacher teacher);

    Teacher getTeacherById(Long id);

    List<Teacher> getTeacherByName(String name);
}
