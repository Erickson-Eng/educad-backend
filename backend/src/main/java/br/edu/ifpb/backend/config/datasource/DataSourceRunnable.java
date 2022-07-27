package br.edu.ifpb.backend.config.datasource;

import br.edu.ifpb.backend.business.entity.Role;
import br.edu.ifpb.backend.business.entity.enums.RoleName;
import br.edu.ifpb.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class DataSourceRunnable implements CommandLineRunner {

    @Autowired
    private RoleRepository repository;

    @Override
    public void run(String... args) throws Exception {

        Role roleUser = new Role(RoleName.ROLE_USER);
        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
        repository.saveAll(Arrays.asList(roleUser, roleAdmin));
    }
}
