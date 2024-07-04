package org.example.hello_world.repository;

import org.example.hello_world.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
    @Query(value = "select * from task t where t.status = :status and t.type :type" , nativeQuery = true)
    List<TaskEntity> getAllByStatusAndType();
}
