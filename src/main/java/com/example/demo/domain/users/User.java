package com.example.demo.domain.users;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    public User(RequestUser requestUser){
        this.email = requestUser.email();
    }

}
