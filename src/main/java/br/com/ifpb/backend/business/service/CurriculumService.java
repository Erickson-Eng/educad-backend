package br.com.ifpb.backend.business.service;

import br.com.ifpb.backend.business.entity.Curriculum;

import java.util.List;

public interface CurriculumService {

    Curriculum save (Curriculum curriculum);

    Curriculum update (Long id, Curriculum curriculum);

    List<Curriculum> listAllCurriculumFromTeacher (Long teacherId);
}
