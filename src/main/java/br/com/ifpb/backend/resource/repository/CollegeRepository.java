package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
}