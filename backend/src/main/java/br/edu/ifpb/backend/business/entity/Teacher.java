package br.edu.ifpb.backend.business.entity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Teacher extends Profile {
    public Teacher(Long id, User user, String name, LocalDate birthDate, String cpf, String rg) {
        super(id, user, name, birthDate, cpf, rg);
    }

    public Teacher() {
    }
}
