package br.com.ifpb.backend.business.service;

import br.com.ifpb.backend.business.entity.Address;

public interface AddressService {


    Address save (Address address);

    Address update(Long id, Address address);

    Address delete(Long id);

    Address findById(Long id);
}
