package br.com.ifpb.backend.business.entity;

import br.com.ifpb.backend.business.entity.enums.CourseType;
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
@Table(name = "curriculum")
@EntityListeners(AuditingEntityListener.class)
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 5074811513930613155L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String course;
    @Column(nullable = false)
    private String college;
    @Column(nullable = false)
    private CourseType qualification;
    @Column(nullable = false)
    private LocalDate yearOfCompletion;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "id")
    private Teacher teacher;


    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;


}