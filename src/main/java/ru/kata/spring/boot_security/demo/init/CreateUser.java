//package ru.kata.spring.boot_security.demo.init;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.model.Role;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.repo.RoleRepo;
//import ru.kata.spring.boot_security.demo.repo.UserRepos;
//
//import javax.annotation.PostConstruct;
//import java.util.Set;
//
//@Component
//public class CreateUser {
//    private final UserRepos userRepo;
//    private final RoleRepo roleRepo;
//
//    @Autowired
//    public CreateUser(UserRepos userRepos, RoleRepo roleRepo) {
//        this.userRepo = userRepos;
//        this.roleRepo = roleRepo;
//    }
//
//    @PostConstruct
//    public void runObjectCreated() {
//        Role adminRole = new Role("ROLE_ADMIN");
//        Role userRole = new Role("ROLE_USER");
//
//        roleRepo.save(adminRole);
//        roleRepo.save(userRole);
//
//        userRepo.save(new User("user", "user","1234" ,Set.of(userRole)));
//        userRepo.save(new User("admin", "admin","1234",Set.of(adminRole)));
//    }
//}