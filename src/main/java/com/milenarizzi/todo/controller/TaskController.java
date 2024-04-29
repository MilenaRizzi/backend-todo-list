package com.milenarizzi.todo.controller;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milenarizzi.todo.dto.TaskRequest;
import com.milenarizzi.todo.dto.TaskResponse;
import com.milenarizzi.todo.model.Task;
import com.milenarizzi.todo.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
  
  @Autowired
  private TaskService taskService;

  @Autowired
  private ModelMapper mapper;

  @GetMapping
  public ResponseEntity<List<TaskResponse>> getAllTasks() {
    var tasks = taskService.getAllTasks();
    var resp = tasks.stream().map(task -> mapper.map(task, TaskResponse.class)).toList();
    return ResponseEntity.ok().body(resp);
  }

  @PostMapping
  public ResponseEntity<TaskResponse> createTask(@RequestBody @Valid TaskRequest request) {
    Task task = mapper.map(request, Task.class);
    taskService.createTask(task);
    var resp = mapper.map(task, TaskResponse.class);
    return ResponseEntity.created(URI.create(task.getId().toString())).body(resp);
  }

  @PutMapping("{id}")
  public ResponseEntity<TaskResponse> updateTask(@PathVariable Integer id, @RequestBody @Valid TaskRequest request) {
    var task = mapper.map(request, Task.class);
    task.setId(id);
    task = taskService.updateTask(task);
    var resp = mapper.map(task, TaskResponse.class);
    return ResponseEntity.ok().body(resp);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> excluir(@PathVariable Integer id) {
    taskService.deleteTask(id);
    return ResponseEntity.noContent().build();
  }
}
