package br.com.ifpb.backend.business.service;

import br.com.ifpb.backend.business.entity.College;

import java.util.List;

public interface CollegeService {


    College save (College college);

    College update(Long id, College college);

    List<College> getCollegeByName(String name);

    College getCollegeById(Long id);
}
