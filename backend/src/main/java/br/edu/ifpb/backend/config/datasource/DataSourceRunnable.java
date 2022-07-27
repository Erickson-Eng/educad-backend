package br.edu.ifpb.backend.config.datasource;

import br.edu.ifpb.backend.business.entity.Role;
import br.edu.ifpb.backend.business.entity.enums.RoleName;
import br.edu.ifpb.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class DataSourceRunnable implements Runnable{

    @Autowired
    private RoleRepository repository;

    @Override
    public void run() {
        Role roleUser = new Role(null, RoleName.ROLE_USER, null, null);
        Role roleAdmin = new Role(null, RoleName.ROLE_ADMIN, null, null);

        repository.saveAll(Arrays.asList(roleUser, roleAdmin));
    }
}
