package com.yogesh.coding.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yogesh.coding.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<Map<String, String>> handleUnexpectedTypeException(UnexpectedTypeException ex) {
	    Map<String, String> errorMap = new HashMap<>();
	    
	    // Provide a custom error message without the stack trace
	    errorMap.put("error", "An unexpected type exception occurred.");

	    // Create a response entity with the error map and HTTP status code
	    return ResponseEntity.badRequest().body(errorMap);
	}


	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiResponse> handleApiException(ApiException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, true);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}


}
