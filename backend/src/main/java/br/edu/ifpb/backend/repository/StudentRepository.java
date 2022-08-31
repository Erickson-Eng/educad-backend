package br.edu.ifpb.backend.repository;

import br.edu.ifpb.backend.business.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
