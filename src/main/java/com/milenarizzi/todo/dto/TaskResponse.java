package com.milenarizzi.todo.dto;

import lombok.Data;

@Data
public class TaskResponse {
  
  private Integer id;
  private String description;
  private boolean completed;
}
