package br.com.ifpb.backend.business.entity;

import br.com.ifpb.backend.business.entity.composite_key.DisciplinesTaughtPK;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "teach_subject")
@EntityListeners(AuditingEntityListener.class)
public class TeacherSubject implements Serializable {
    private static final long serialVersionUID = -6048487438335283366L;

    @EmbeddedId
    @Column(unique = true, nullable = false)
    private DisciplinesTaughtPK disciplinesTaughtPK;

    @MapsId("periodId")
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "period_id", updatable = false, referencedColumnName = "id")
    private Period period;


    @MapsId("teacherId")
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "team_id", updatable = false, referencedColumnName = "id")
    private Teacher teacher;


    @MapsId("subjectId")
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "subject_id", updatable = false, referencedColumnName = "id")
    private Subject subject;


}