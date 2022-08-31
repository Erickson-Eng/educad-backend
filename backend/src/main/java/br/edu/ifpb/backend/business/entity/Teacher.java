package br.edu.ifpb.backend.business.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Teacher extends Profile {
    public Teacher(Long id, User user, String name, Date birthDate, String cpf, String rg) {
        super(id, user, name, birthDate, cpf, rg);
    }

    public Teacher() {
    }
}
