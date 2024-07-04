package org.example.hello_world.requests.task.request;

import lombok.Data;

@Data
public class GetListTaskRequest {
    private String type;
    private String status;
}
