package br.com.ifpb.backend.business.entity;

import br.com.ifpb.backend.business.entity.composite_key.StudentSubjectPK;
import br.com.ifpb.backend.business.entity.enums.SubjectStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Table(name = "student_subject")
@EntityListeners(AuditingEntityListener.class)
public class StudentSubject implements Serializable {
    private static final long serialVersionUID = 2679442977315404251L;


    @EmbeddedId
    @Column(unique = true, nullable = false)
    private StudentSubjectPK studentSubjectPK;

    @MapsId("subjectId")
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "subject_id", updatable = false, referencedColumnName = "id")
    private Subject subject;

    @MapsId("periodId")
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "period_id", updatable = false, referencedColumnName = "id")
    private Period period;

    @MapsId("studentId")
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "student_id", updatable = false, referencedColumnName = "id")
    private Student student;

    @Enumerated(EnumType.STRING)
    private SubjectStatus status;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;
}