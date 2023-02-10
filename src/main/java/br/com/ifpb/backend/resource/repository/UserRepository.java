package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}