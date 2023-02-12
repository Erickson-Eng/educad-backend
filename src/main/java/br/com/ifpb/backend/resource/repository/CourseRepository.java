package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}