package br.edu.ifpb.backend.business.service.postgresql;

import br.edu.ifpb.backend.application.dto.mapper.UserMapper;
import br.edu.ifpb.backend.application.dto.request.UserRequest;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.service.UserService;
import br.edu.ifpb.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServicePostgresql implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public void registerUser(UserRequest userRequest) {
        User entity  = userMapper.requestToUserEntity(userRequest);
        try {
            if (!verifyIfExist(userRequest.getUsername())){
                entity.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
                userRepository.save(entity);
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }


    protected Boolean verifyIfExist(String usernameOrEmail){
        return userRepository.findByUsername(usernameOrEmail).isPresent();
    }
}
