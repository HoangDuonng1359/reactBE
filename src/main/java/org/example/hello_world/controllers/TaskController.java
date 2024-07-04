package org.example.hello_world.controllers;

import org.example.hello_world.requests.task.request.GetListTaskRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @GetMapping
    public GetListTaskRequest getAllTasks(GetListTaskRequest getListTaskRequest){
        return getListTaskRequest;
    }

}
