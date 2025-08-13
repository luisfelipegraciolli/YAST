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

    public Task createTask(Task task){
        taskRepository.saveAndFlush(task);
        return task;
    }

    public List<Task> readAllTasks(){
        return taskRepository.findAll();
    }

    public Task readTasksById(Integer id){
        return taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );
    }

    public Task updateTaskById(Integer id, Task updatedTask) {
        Task existingTask = readTasksById(id);
        applyNonNullUpdates(existingTask, updatedTask);
        Date now = new Date();
        existingTask.setUpdatedAt(now);
        taskRepository.saveAndFlush(existingTask);
        return existingTask;
    }

    private void applyNonNullUpdates(Task target, Task source) {
        if (source.getTitle() != null) {
            target.setTitle(source.getTitle());
        }
        if (source.getDescription() != null) {
            target.setDescription(source.getDescription());
        }
        if (source.getStatus() != null) {
            target.setStatus(source.getStatus());
        }
    }

    public void deleteTaskById(Integer id){
        taskRepository.deleteById(id);
    }
}
