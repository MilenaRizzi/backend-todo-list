package com.milenarizzi.todo.exception;

public class RecordNotFoundException extends RuntimeException{
  public RecordNotFoundException(String mensagem) {
    super(mensagem);
}
}