package com.pichincha.cbe.exception;

import com.pichincha.cbe.domain.enums.ResponseStatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApplicationException extends  RuntimeException{

	private final ResponseStatusCode status;

}
