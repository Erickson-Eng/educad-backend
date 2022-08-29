package br.edu.ifpb.backend.business.entity;

import lombok.Builder;

import java.util.Date;

@Builder
public class Student extends Profile {
    public Student(User user, String name, Date birthDate, String cpf, String rg) {
        super(user, name, birthDate, cpf, rg);
    }

    @Override
    public String toString() {
        return String.format("Student{Name: %s, CPF: %s, RG: %s}", this.getName(), this.getCpf(), this.getRg());
    }
}
