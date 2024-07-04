package org.example.hello_world.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    @Column(columnDefinition = "JSON")
    private String widgets;
    public Form() {

    }

    public Form(String widgets) {
        this.widgets = widgets;
    }

    public Form(String title, String url, String widgets) {
        this.title = title;
        this.url = url;
        this.widgets = widgets;
    }
}
