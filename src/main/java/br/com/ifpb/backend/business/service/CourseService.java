package br.com.ifpb.backend.business.service;

import br.com.ifpb.backend.business.entity.Course;

import java.util.List;

public interface CourseService {


    Course save (Course course);

    Course update(Long id, Course course);

    List<Course> findCourseByName(String name);

    Course findCourseById(Long id);

}
