package br.com.ifpb.backend.business.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "student")
public class Student extends Profile {
    private static final long serialVersionUID = -8462839205685358024L;

    private LocalDate entryDate;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Course course;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, targetEntity = StudentSubject.class)
    private List<StudentSubject> studentSubjectList;



}