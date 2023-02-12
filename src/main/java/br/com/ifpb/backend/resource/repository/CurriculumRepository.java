package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}