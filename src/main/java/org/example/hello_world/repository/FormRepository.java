package org.example.hello_world.repository;

import org.example.hello_world.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormRepository  extends JpaRepository<Form,Long> {
    Optional<Form> findFormByUrl(String url);
}
