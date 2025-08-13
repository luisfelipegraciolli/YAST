package com.graciolli.stm.Controller;


import com.graciolli.stm.Repository.Task;
import com.graciolli.stm.Service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="tasks/")
public class TaskController {
    private final TaskService taskService;

    TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createTask(@RequestBody Task task){
        taskService.createTask(task);
        return ResponseEntity.ok().build();
    }


    // TODO: Rewrite this later for cleaner code
    @GetMapping("/listALl")
    public ResponseEntity<List<Task>> listAllTasks(){
        return ResponseEntity.ok(taskService.readAllTasks());
    }

    @GetMapping("/listById")
    public ResponseEntity<Task> getTaskById(@RequestParam Integer id){
        return ResponseEntity.ok(taskService.readTasksById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateTaskById(@RequestParam Integer id, @RequestBody Task task){
        taskService.updateTaskById(id, task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteTaskById(@RequestParam Integer id){
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }
}
