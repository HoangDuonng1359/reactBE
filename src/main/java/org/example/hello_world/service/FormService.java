package org.example.hello_world.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.hello_world.entities.Form;
import org.example.hello_world.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;
    public List<Form> getAllForm(){
        return formRepository.findAll();
    }
    public ResponseEntity<?> createForm( Map<String, Object> data) throws JsonProcessingException {
        // Chuyển đổi dữ liệu formData thành chuỗi JSON
        String formData = new ObjectMapper().writeValueAsString(data.get("formData"));

        // Tạo một đối tượng FormData mới và lưu trữ nó
        Form newFormData = new Form(formData);
        formRepository.save(newFormData);

        return ResponseEntity.ok("Data saved successfully!");
    }
    public Form createForm(Form form) {
        if (form == null) {
            throw new IllegalArgumentException("Form cannot be null");
        }

        Optional<Form> existingForm = formRepository.findFormByUrl(form.getUrl());
        if (existingForm.isEmpty()) {
            return formRepository.save(form);
        } else {
            throw new IllegalStateException("Form with URL " + form.getUrl() + " already exists");
        }
    }
    public Optional<Form> getFormById(Long id){
        return formRepository.findById(id);
    }
    public Optional<Form> getFormByUrl(String url){
        return formRepository.findFormByUrl(url);
    }
    public void deleteFormById(Long id){
        formRepository.deleteById(id);
    }
}
