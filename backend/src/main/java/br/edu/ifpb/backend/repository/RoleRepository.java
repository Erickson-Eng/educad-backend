package br.edu.ifpb.backend.repository;

import br.edu.ifpb.backend.business.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}