package com.milenarizzi.todo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRequest {

  @NotEmpty(message = "Campo obrigatório")
  @Size(min = 3, max = 200)
  private String description;

  private boolean completed;
}
