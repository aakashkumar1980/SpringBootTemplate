package com.java.aadityadesigners.common.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse error = new ErrorResponse("Server Error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /** [START] Custom Exception Handlers */
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse("Resource Not Found", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(EntityNotFoundException ex) {
        ErrorResponse error = new ErrorResponse("Resource Not Found", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
        ErrorResponse error = new ErrorResponse("Bad Request", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException ex) {
        ErrorResponse error = new ErrorResponse("Unauthorized", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
    /** [END] Custom Exception Handlers */


    /**
     * Constraint violation exception handler
     * @param ex ConstraintViolationException
     * @return ResponseEntity
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        String error = "Invalid input data";
        String message = ex.getConstraintViolations().stream()
                .map(x -> x.getPropertyPath() + ": " + x.getMessage())
                .collect(Collectors.joining(", "));
        ErrorResponse errorResponse = new ErrorResponse(error, message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    } 
    /**
     * Exception to be thrown when a method argument fails validation perhaps as a result of @Valid style validation, or perhaps because it is required.
     * @param ex MethodArgumentNotValidException
     * @return ResponseEntity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        String error = "Invalid input data";
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getField() + ": " + x.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ErrorResponse errorResponse = new ErrorResponse(error, message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Exception thrown when the request body is not in a readable format, such as JSON or XML.
     * @param ex HttpMessageNotReadableException
     * @return ResponseEntity
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        ErrorResponse error = new ErrorResponse("Invalid Request", "Invalid data format");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception is thrown when the requested HTTP method is not supported by the current endpoint
     * @param ex HttpRequestMethodNotSupportedException
     * @return ResponseEntity
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        ErrorResponse error = new ErrorResponse("Method Not Allowed", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * Exception is thrown when the requested media type is not supported by the current endpoint.
     * @param ex HttpMediaTypeNotSupportedException
     * @return ResponseEntity
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
        ErrorResponse error = new ErrorResponse("Unsupported Media Type", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
    /**
     * Exception is thrown when the requested media type is not acceptable by the current endpoint.
     * @param ex HttpMediaTypeNotAcceptableException
     * @return ResponseEntity
     */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex) {
        ErrorResponse error = new ErrorResponse("Not Acceptable", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
       

}

