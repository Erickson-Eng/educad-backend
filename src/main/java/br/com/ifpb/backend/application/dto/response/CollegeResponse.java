package br.com.ifpb.backend.application.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeResponse {

    private Long id;
    @JsonProperty("address")
    private AddressResponse addressResponse;
}
