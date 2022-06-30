package com.test.plan.errors;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(PlanNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> customHandleNotFound(Exception ex, WebRequest request) {

		CustomErrorResponse error = new CustomErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(LocalDateTime.now());
		error.setError(ex.getMessage());

		return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<CustomErrorResponse> handleConstraintViolationException(HttpServletResponse response, Exception ex) throws IOException {
//		response.sendError(HttpStatus.BAD_REQUEST.value());
		
		CustomErrorResponse error = new CustomErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(LocalDateTime.now());
		error.setError(ex.getMessage());

		return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.NOT_FOUND);
		
	}

	@Override
	//@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());
		body.put("status message", status.toString());

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);

	}
}
