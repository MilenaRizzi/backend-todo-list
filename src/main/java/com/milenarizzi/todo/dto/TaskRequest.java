package com.milenarizzi.todo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequest {

  @NotEmpty(message = "Campo obrigatório")
  private String description;

  @NotNull
  private boolean completed;
}
