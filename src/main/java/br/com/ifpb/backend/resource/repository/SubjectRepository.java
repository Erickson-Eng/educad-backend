package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}