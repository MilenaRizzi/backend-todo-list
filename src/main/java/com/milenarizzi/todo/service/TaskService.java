package com.milenarizzi.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milenarizzi.todo.exception.RecordNotFoundException;
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

  public Task consult(Integer id) {
    // Optional<Task> taskOpt = taskRepository.findById(id);
    // if (taskOpt.isEmpty()) {
    // throw new RegistroNaoExistenteException();
    // }
    // return taskOpt.get();
    return taskRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Task não encontrada com código informado"));

  }

  public Task updateTaskChecked(Task data) {
    var task = this.consult(data.getId());
    task.setCompleted(!task.isCompleted());
    return taskRepository.save(task);
  }

  public Task updateTaskDescription(Task data) {
    var task = this.consult(data.getId());
    task.setDescription(data.getDescription());
    return taskRepository.save(task);
  }

  public void deleteTask(Integer id) {
    boolean exist = taskRepository.existsById(id);
    if (!exist) {
      throw new RecordNotFoundException("Task nao encontrada com código informado para exclusao");
    }
    taskRepository.deleteById(id);
  }

}
