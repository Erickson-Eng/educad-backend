package br.edu.ifpb.backend.business.entity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Student extends Profile {
    public Student(Long id, User user, String name, LocalDate birthDate, String cpf, String rg) {
        super(id, user, name, birthDate, cpf, rg);
    }

    public Student() {
    }

    @Override
    public String toString() {
        return String.format("Student{Name: %s, CPF: %s, RG: %s}", this.getName(), this.getCpf(), this.getRg());
    }
}
