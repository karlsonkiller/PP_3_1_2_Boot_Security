package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "role")
    private String nameRole;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(String nameRole) {
        this.nameRole = nameRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role() {
    }

    public void addUserToRole(User user) {
        users.add(user);
    }

    @Override
    public String getAuthority() {
        return null;
    }

}
