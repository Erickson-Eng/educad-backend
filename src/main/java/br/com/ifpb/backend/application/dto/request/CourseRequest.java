package br.com.ifpb.backend.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    @NotNull
    private String name;
    @NotNull
    private String courseType;
    @NotNull
    private Long collegeId;

}
