package br.com.ifpb.backend.business.entity.composite_key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DisciplinesTaughtPK implements Serializable {
    private static final long serialVersionUID = 656614889487771797L;

    @Column(name = "period_id")
    private Long periodId;

    @Column(name = "team_id")
    private Long teacherId;

    @Column(name = "subject_id")
    private Long subjectId;
}
