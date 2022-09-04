package br.edu.ifpb.backend.business.service;

import br.edu.ifpb.backend.application.dto.request.UserRequest;
import br.edu.ifpb.backend.business.entity.User;

public interface UserService {

    User registerUser(UserRequest userRequest);

    boolean updateUser(UserRequest userRequest, Long userId);

}
