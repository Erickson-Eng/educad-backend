package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}