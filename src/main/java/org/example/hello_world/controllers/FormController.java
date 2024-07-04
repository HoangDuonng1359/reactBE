package org.example.hello_world.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.hello_world.entities.Form;
import org.example.hello_world.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/form")
public class FormController {
    @Autowired
    private FormService formService;
    @GetMapping
    public List<Form> getAllForms(){
        return formService.getAllForm();
    }
    @PostMapping
    public ResponseEntity<?> createForm(@RequestBody Form form) {
        try {
            Form createdForm = formService.createForm(form);
            return new ResponseEntity<>(createdForm, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable Long id){
        formService.deleteFormById(id);
    }
    @GetMapping("/url/{url}")
    public Optional<Form> getFormByUrl(@PathVariable String url){
        return formService.getFormByUrl(url);
    }
    @GetMapping("/{id}")
    public Optional<Form> getFormById(@PathVariable Long id){
        return formService.getFormById(id);
    }
}
