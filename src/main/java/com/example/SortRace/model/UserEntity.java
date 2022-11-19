package com.example.SortRace.model;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "image")
    String image;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "active")
    Boolean active;

    @Column(name = "code")
    String code;

    @Column(name = "role")
    String role;
}
