package com.capgemini.pecunia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({Exception.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handlerGenericException(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"There is some technical issue!");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}
	
	 @ExceptionHandler(IdNotFound.class)
	    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	    @ResponseBody
	    public ResponseEntity<ErrorResponse> adviceIdNotFound(IdNotFound e) {
				ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Id not found!");
		        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	    }

	 
}
	 
