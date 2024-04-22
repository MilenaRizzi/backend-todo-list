package com.milenarizzi.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milenarizzi.todo.exception.RegistroNaoExistenteException;
import com.milenarizzi.todo.model.Task;
import com.milenarizzi.todo.repository.TaskRepository;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;
  
  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  public Task createTask(Task task) {
    return taskRepository.save(task);
  }

  public void deleteTask(Integer id) {
    boolean exist = taskRepository.existsById(id);
    if (!exist) {
      throw new RegistroNaoExistenteException();
    }
    taskRepository.deleteById(id);
  }
  
}
