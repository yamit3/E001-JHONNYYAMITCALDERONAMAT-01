package com.pichincha.cbe.exception;

import com.pichincha.cbe.service.dto.CommonResponseDto;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static lombok.AccessLevel.PRIVATE;

@ControllerAdvice
@FieldDefaults(level = PRIVATE)
@Log4j2
public class ApplicationExceptionHandler {


    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<CommonResponseDto> handleHttpException(ApplicationException exception) {
        log.error(String.format("Application error: %s: %s",exception.getStatus().getCode(),exception.getStatus().getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .header(HttpHeaders.CONTENT_TYPE, "application/json" )
            .body(CommonResponseDto.build(exception.getStatus()));
    }
}
