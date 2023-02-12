package br.com.ifpb.backend.business.entity;

import br.com.ifpb.backend.business.entity.enums.CourseType;
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
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
public class Course implements Serializable {
    private static final long serialVersionUID = 5670614670929957949L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private College college;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, targetEntity = Subject.class)
    private List<Subject> courseSubjects;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;

}