package org.example.hello_world.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String userName;
    private String fullName;
    private String gender;
    private String password;

    public User() {

    }
}
