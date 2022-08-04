package br.edu.ifpb.backend.business.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class Profile implements Serializable {
    private User user;

    @Column(nullable = false, unique = true)
    private String name;
    @Column()
    private Date birthDate;
    @Column()
    private String cpf;
    @Column()
    private String rg;
}
