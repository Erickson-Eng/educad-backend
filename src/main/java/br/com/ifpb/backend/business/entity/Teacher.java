package br.com.ifpb.backend.business.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class Teacher extends Profile {
    private static final long serialVersionUID = 8755259904703877916L;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, targetEntity = Curriculum.class)
    private List<Curriculum> curriculumList;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, targetEntity = TeacherSubject.class)
    private List<TeacherSubject> teacherSubjects;
}