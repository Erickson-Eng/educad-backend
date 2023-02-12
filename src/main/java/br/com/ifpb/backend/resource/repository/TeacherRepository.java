package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}