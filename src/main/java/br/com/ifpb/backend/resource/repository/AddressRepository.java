package br.com.ifpb.backend.resource.repository;

import br.com.ifpb.backend.business.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}