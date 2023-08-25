package io.miswah.secondbrain.controller;

import io.miswah.secondbrain.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
public class BaseController {

    @ExceptionHandler(ResponseStatusException.class)
    public @ResponseBody ResponseEntity handleResponseStatusException(ResponseStatusException e) {
        log.error(e.getMessage(),e);
        ErrorResponse errorResponse=new ErrorResponse(e.getStatusCode().value(),e.getReason(),e.getMessage());
        return new ResponseEntity(errorResponse, e.getStatusCode());
    }
    @ExceptionHandler(Exception.class)
    public @ResponseBody ResponseEntity handleException(Exception e) {
        log.error(e.getMessage(),e);
        HttpStatus httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse=new ErrorResponse(httpStatus.value(),httpStatus.getReasonPhrase(),"Something Went Wrong");
        return new ResponseEntity(errorResponse,
                httpStatus);
    }

}
