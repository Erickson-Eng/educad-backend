package br.edu.ifpb.backend.business.entity;

import java.util.Date;

public class Teacher extends Profile{
    public Teacher(User user, String name, Date birthDate, String cpf, String rg) {
        super(user, name, birthDate, cpf, rg);
    }
}
