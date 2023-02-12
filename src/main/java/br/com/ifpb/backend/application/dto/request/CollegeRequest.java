package br.com.ifpb.backend.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeRequest {

    private String name;
    @JsonProperty("address")
    private AddressRequest addressRequest;
}
