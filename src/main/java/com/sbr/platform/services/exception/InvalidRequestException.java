package com.sbr.platform.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Duplicate userId!.. Try again later")
public class InvalidRequestException extends RuntimeException {

}
