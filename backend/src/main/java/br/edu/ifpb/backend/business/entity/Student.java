package br.edu.ifpb.backend.business.entity;

import java.util.Date;

public class Student extends Profile {
    public Student(User user, String name, Date birthDate, String cpf, String rg) {
        super(user, name, birthDate, cpf, rg);
    }
}
