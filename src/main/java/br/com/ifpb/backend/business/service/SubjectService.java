package br.com.ifpb.backend.business.service;

import br.com.ifpb.backend.business.entity.Subject;

public interface SubjectService {


    Subject save (Subject subject);

    Subject update (Long id, Subject subject);


}
