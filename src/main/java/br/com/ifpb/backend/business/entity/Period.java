package br.com.ifpb.backend.business.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "period")
@EntityListeners(AuditingEntityListener.class)
public class Period implements Serializable {
    private static final long serialVersionUID = -6549820613187687039L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer periodCode;
    private LocalDate periodStartDate;
    private LocalDate periodEndDate;

    @OneToMany(mappedBy = "period", fetch = FetchType.EAGER, targetEntity = TeacherSubject.class)
    private List<TeacherSubject> teacherSubjects;

    @OneToMany(mappedBy = "period", fetch = FetchType.EAGER, targetEntity = StudentSubject.class)
    private List<StudentSubject> studentSubjectList;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;

}