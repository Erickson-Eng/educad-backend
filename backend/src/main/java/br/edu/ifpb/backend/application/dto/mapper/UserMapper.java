package br.edu.ifpb.backend.application.dto.mapper;

import br.edu.ifpb.backend.application.dto.request.UserRequest;
import br.edu.ifpb.backend.business.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User requestToUserEntity(UserRequest userRequest);
}
