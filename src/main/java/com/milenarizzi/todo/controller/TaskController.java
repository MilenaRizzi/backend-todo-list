package com.milenarizzi.todo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milenarizzi.todo.model.Task;
import com.milenarizzi.todo.service.TaskService;

@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
  
  @Autowired
  private TaskService taskService;

  @GetMapping
  public ResponseEntity<List<Task>> getAllTasks() {
    var task = taskService.getAllTasks();
    return ResponseEntity.ok().body(task);
  }

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody Task task) {
    taskService.createTask(task);
    return ResponseEntity.created(URI.create(task.getId().toString())).body(task);
  }
   
  @DeleteMapping("{id}")
  public ResponseEntity<?> excluir(@PathVariable Integer id) {
    taskService.deleteTask(id);
    return ResponseEntity.noContent().build();
  }
}
