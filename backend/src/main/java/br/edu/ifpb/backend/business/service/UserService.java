package br.edu.ifpb.backend.business.service;

import br.edu.ifpb.backend.application.dto.request.UserRequest;

public interface UserService {

    void registerUser (UserRequest userRequest);

}
