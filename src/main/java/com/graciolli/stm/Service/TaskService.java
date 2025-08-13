package com.graciolli.stm.Service;

import com.graciolli.stm.Repository.Task;
import com.graciolli.stm.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void createTask(Task task){
        taskRepository.saveAndFlush(task);
    }

    public List<Task> readAllTasks(){
        return taskRepository.findAll();
    }

    public Task readTasksById(Integer id){
        return taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );
    }

    /*
    TODO: Figure out how to manage tasks requests without all fields to update
    TODO: Build or find alternatives to the Builder Pattern!
    */
    public void updateTaskById(Integer id, Task taskUpdated) {
        Task taskEntity = readTasksById(id);
        taskEntity.setTitle(taskUpdated.getTitle());
        taskEntity.setDescription(taskUpdated.getDescription());
        taskEntity.setStatus(taskUpdated.getStatus());
        taskEntity.setUpdatedAt(new Date());
        taskRepository.saveAndFlush(taskEntity);
    }

    public void deleteTaskById(Integer id){
        taskRepository.deleteById(id);
    }
}
