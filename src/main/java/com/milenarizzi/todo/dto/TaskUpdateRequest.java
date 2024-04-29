package com.milenarizzi.todo.dto;

import lombok.Data;

@Data
public class TaskUpdateRequest {
  
  private String description;

  private boolean completed;  
}