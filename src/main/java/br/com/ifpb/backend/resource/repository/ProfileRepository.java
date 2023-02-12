package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}