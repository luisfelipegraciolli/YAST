package com.graciolli.stm.Controller;


import com.graciolli.stm.Repository.Task;
import com.graciolli.stm.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task){
        Task created = taskService.createTask(task);
        return ResponseEntity.created(URI.create("/tasks/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        return ResponseEntity.ok(taskService.readAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Integer id){
        return ResponseEntity.ok(taskService.readTasksById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable Integer id,  @RequestBody Task task){
        return ResponseEntity.ok((taskService.updateTaskById(id, task)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Integer id){
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
