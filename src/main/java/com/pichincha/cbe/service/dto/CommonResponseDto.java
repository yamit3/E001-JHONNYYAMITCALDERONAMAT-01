package com.pichincha.cbe.service.dto;

import com.pichincha.cbe.domain.enums.ResponseStatusCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonResponseDto {
  String code;
  String message;
  String token;

  public static CommonResponseDto build(ResponseStatusCode status){
    return CommonResponseDto.builder().code(status.getCode()).message(status.getMessage()).build();
  }
}
