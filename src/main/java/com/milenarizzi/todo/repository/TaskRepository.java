package com.milenarizzi.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milenarizzi.todo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
  
}
