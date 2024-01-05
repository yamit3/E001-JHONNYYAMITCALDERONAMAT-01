package com.pichincha.cbe.controller;

import com.pichincha.cbe.service.dto.CommonResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class InsideAppController {

  @GetMapping("/check")
  public ResponseEntity<CommonResponseDto> reportPriceByUserId(@PathVariable("userId") Integer userId) {

    return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponseDto.builder().build());
  }



}
