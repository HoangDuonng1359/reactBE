package org.example.hello_world.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status = "ACTIVE";
    private String type = "NORMAL";
}
