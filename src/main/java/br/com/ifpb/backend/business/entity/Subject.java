package br.com.ifpb.backend.business.entity;

import br.com.ifpb.backend.business.entity.enums.SubjectArea;
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
@Table(name = "subject")
@EntityListeners(AuditingEntityListener.class)
public class Subject implements Serializable {
    private static final long serialVersionUID = -3888892375564443567L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Integer period;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "course_id")
    private Course course;

    @Enumerated(EnumType.STRING)
    private SubjectArea subjectArea;

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER, targetEntity = TeacherSubject.class)
    private List<TeacherSubject> teacherSubjectList;

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER, targetEntity = StudentSubject.class)
    private List<StudentSubject> studentSubjectList;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;
}