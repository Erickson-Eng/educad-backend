package br.com.ifpb.backend.business.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 7792032644799725186L;
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cellphone;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

}