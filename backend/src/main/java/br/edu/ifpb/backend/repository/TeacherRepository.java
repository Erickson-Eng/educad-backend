package br.edu.ifpb.backend.repository;

import br.edu.ifpb.backend.business.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
