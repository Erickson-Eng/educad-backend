package br.edu.ifpb.backend.config.datasource;

import br.edu.ifpb.backend.business.entity.Role;
import br.edu.ifpb.backend.business.entity.Student;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.entity.enums.RoleName;
import br.edu.ifpb.backend.business.service.UserService;
import br.edu.ifpb.backend.repository.RoleRepository;
import br.edu.ifpb.backend.repository.StudentRepository;
import br.edu.ifpb.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class DataSourceRunnable implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Role roleUser = new Role(RoleName.ROLE_USER);
        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
        roleRepository.saveAll(Arrays.asList(roleUser, roleAdmin));

        User user1 = new User(1L, "Usuáriolorem1", "password123", "usuarioteste1@gmail.com");
        User user2 = new User(2L, "Usuáriolorem2", "password1234", "usuarioteste2@gmail.com");
        User user3 = new User(3L, "Usuáriolorem3", "password1235", "usuarioteste3@gmail.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Student student1 = new Student(1L, user1, "Jõao", LocalDate.now(), "123456789", "10264789");
        Student student2 = new Student(2L, user2, "Maria", LocalDate.now(), "123986789", "10264789");
        Student student3 = new Student(3L, user3, "Pedro", LocalDate.now(), "123456765", "11164789");

        studentRepository.saveAll(Arrays.asList(student1, student2, student3));
    }
}
