package com.bmarques.rabbitmqpoc.util;

public class MessageBodyDto {

  private Integer id;
  private String message;

  public MessageBodyDto() {
  }

  public MessageBodyDto(Integer id, String message) {
    this.id = id;
    this.message = message;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
