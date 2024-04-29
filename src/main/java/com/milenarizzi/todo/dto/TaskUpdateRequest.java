package com.milenarizzi.todo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TaskUpdateRequest {
  
  @NotEmpty(message = "Campo obrigatório")
  private String description;

  @NotNull
  private boolean completed;  
}
