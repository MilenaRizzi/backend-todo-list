package com.milenarizzi.todo.exception;


public class ExistingRecordException extends RuntimeException{
  public ExistingRecordException(String mensagem) {
    super(mensagem);
}
}
