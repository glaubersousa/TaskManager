package com.isystem.taskmanagerapi.controller;

import com.isystem.taskmanagerapi.model.Task;
import com.isystem.taskmanagerapi.model.TaskDTO;
import com.isystem.taskmanagerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAll().stream()
                .map(task -> new TaskDTO(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(),
                        task.getDeliveryDate(), task.getCreator(), task.getResponsible(), task.getStatus().getDisplayName(), task.getStatus().getCode()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(t -> ResponseEntity.ok(new TaskDTO(t.getId(), t.getTitle(), t.getDescription(), t.getCreationDate(),
                        t.getDeliveryDate(), t.getCreator(), t.getResponsible(), t.getStatus().getDisplayName(), t.getStatus().getCode())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TaskDTO createTask(@RequestBody Task task) {
        Task savedTask = taskService.save(task);
        return new TaskDTO(savedTask.getId(), savedTask.getTitle(), savedTask.getDescription(), savedTask.getCreationDate(),
                savedTask.getDeliveryDate(), savedTask.getCreator(), savedTask.getResponsible(), savedTask.getStatus().getDisplayName(), savedTask.getStatus().getCode());
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setTitle(taskDetails.getTitle());
            existingTask.setDescription(taskDetails.getDescription());
            existingTask.setCreationDate(taskDetails.getCreationDate());
            existingTask.setDeliveryDate(taskDetails.getDeliveryDate());
            existingTask.setCreator(taskDetails.getCreator());
            existingTask.setResponsible(taskDetails.getResponsible());
            existingTask.setStatus(taskDetails.getStatus());
            Task updatedTask = taskService.save(existingTask);
            return ResponseEntity.ok(new TaskDTO(updatedTask.getId(), updatedTask.getTitle(), updatedTask.getDescription(), updatedTask.getCreationDate(),
                    updatedTask.getDeliveryDate(), updatedTask.getCreator(), updatedTask.getResponsible(), updatedTask.getStatus().getDisplayName(), updatedTask.getStatus().getCode()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<TaskDTO> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
