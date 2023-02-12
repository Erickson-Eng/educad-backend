package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.StudentSubject;
import br.com.ifpb.backend.business.entity.composite_key.StudentSubjectPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, StudentSubjectPK> {
}