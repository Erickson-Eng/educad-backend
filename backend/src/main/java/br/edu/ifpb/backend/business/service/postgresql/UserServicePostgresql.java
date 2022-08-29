package br.edu.ifpb.backend.business.service.postgresql;

import br.edu.ifpb.backend.application.dto.mapper.UserMapper;
import br.edu.ifpb.backend.application.dto.request.UserRequest;
import br.edu.ifpb.backend.business.entity.Role;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.service.UserService;
import br.edu.ifpb.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServicePostgresql implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public void registerUser(UserRequest userRequest) {
        User entity  = createCommonUser(userRequest);
        try {
            if (!verifyIfExist(userRequest.getUsername())){
                userRepository.save(entity);
            }
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    protected User createCommonUser(UserRequest userRequest) {
        return User.builder()
                .email(userRequest.getEmail())
                .password(new BCryptPasswordEncoder().encode(userRequest.getPassword()))
                .username(userRequest.getUsername())
                .roles(Collections.singletonList(new Role(1L, null)))
                .build();
    }
    protected boolean verifyIfExist(String usernameOrEmail){
        return userRepository.findByUsername(usernameOrEmail).isPresent();
    }
}
