package com.pichincha.cbe.domain.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ResponseStatusCode {

  OK("0", "success"),
  INVALID_INPUT("2", "Invalid input"),
  REPEATED_REGISTRY("3", "The user has already been registered."),
  MAX_COURSE_NUMBER("4", "The registration of a user is only allowed up to 5 courses."),
  UNDEFINED_VALUE("-1","status not found")
  ;


  private final String code;
  private final String message;

  ResponseStatusCode(String code, String message){
    this.code = code;
    this.message = message;
  }

  public static ResponseStatusCode findByCode(String code) {
    return Arrays.stream(values()).filter(ennum -> ennum.getCode().equals(code)).findFirst()
        .orElse(UNDEFINED_VALUE);
  }
}
