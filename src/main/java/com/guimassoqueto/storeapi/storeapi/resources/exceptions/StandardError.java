package com.guimassoqueto.storeapi.storeapi.resources.exceptions;

public class StandardError {
  private Integer status;
  private String message;
  private Long timeStamp;

  public StandardError(Integer status, String message, Long timesStamp) {
    this.status = status;
    this.message = message;
    this.timeStamp = timesStamp;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getTimeStamp() {
    return this.timeStamp;
  }

  public void setTimeStamp(Long timeStamp) {
    this.timeStamp = timeStamp;
  }
}
