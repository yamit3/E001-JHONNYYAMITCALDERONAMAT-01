package com.pichincha.cbe.controller;

import com.pichincha.cbe.service.dto.CommonResponseDto;
import com.pichincha.cbe.service.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  @PostMapping
  public ResponseEntity<CommonResponseDto> login(@RequestBody LoginRequestDto request) {


    return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponseDto.builder().build());
  }

}
