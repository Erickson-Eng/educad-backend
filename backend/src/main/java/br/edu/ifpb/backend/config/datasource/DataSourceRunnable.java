package br.edu.ifpb.backend.config.datasource;

import br.edu.ifpb.backend.business.entity.Role;
import br.edu.ifpb.backend.business.entity.Student;
import br.edu.ifpb.backend.business.entity.Teacher;
import br.edu.ifpb.backend.business.entity.User;
import br.edu.ifpb.backend.business.entity.enums.RoleName;
import br.edu.ifpb.backend.repository.RoleRepository;
import br.edu.ifpb.backend.repository.StudentRepository;
import br.edu.ifpb.backend.repository.TeacherRepository;
import br.edu.ifpb.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class DataSourceRunnable implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void run(String... args) throws Exception {

        Role roleUser = new Role(RoleName.ROLE_USER);
        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);

        roleRepository.saveAll(Arrays.asList(roleUser, roleAdmin));

        User user1 = new User(1L, "userlorem1", "password123", "usertest1@gmail.com");
        User user2 = new User(2L, "userlorem2", "password1234", "usertest2@gmail.com");
        User user3 = new User(3L, "userlorem3", "password12345", "usertest3@gmail.com");
        User user4 = new User(4L, "userlorem4", "password123", "usertest4@gmail.com");
        User user5 = new User(5L, "userlorem5", "password1234", "usertest5@gmail.com");
        User user6 = new User(6L, "userlorem6", "password12345", "usertest6@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6));

        Student student1 = new Student(1L, user1, "Jõao", LocalDate.now(), "123456111", "11112345");
        Student student2 = new Student(2L, user2, "Maria", LocalDate.now(), "123456222", "22212345");
        Student student3 = new Student(3L, user3, "Pedro", LocalDate.now(), "123456333", "33312345");

        studentRepository.saveAll(Arrays.asList(student1, student2, student3));

        Teacher teacher1 = new Teacher(4L, user4, "José", LocalDate.now(), "123456444", "44412345");
        Teacher teacher2 = new Teacher(5L, user5, "Joaquina", LocalDate.now(), "123456555", "55512345");
        Teacher teacher3 = new Teacher(6L, user6, "Ana", LocalDate.now(), "123456666", "66612345");

        teacherRepository.saveAll(Arrays.asList(teacher1, teacher2, teacher3));
    }
}
