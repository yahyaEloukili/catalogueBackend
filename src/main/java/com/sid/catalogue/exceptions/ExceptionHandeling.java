package com.sid.catalogue.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import  javax.ws.rs.*;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.Objects;

import javax.persistence.NoResultException;

import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.sid.catalogue.entities.HttpResponse;

import javassist.tools.web.BadHttpRequest;



@RestControllerAdvice()
public class ExceptionHandeling implements ErrorController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private static final String ACCOUNT_LOCKED = "Your account has been locked. Please contact administration";
    private static final String METHOD_IS_NOT_ALLOWED = "This request method is not allowed on this endpoint. Please send a '%s' request";
    private static final String INTERNAL_SERVER_ERROR_MSG = "An error occurred while processing the request";
    private static final String INCORRECT_CREDENTIALS = "Username / password incorrect. Please try again";
    private static final String ACCOUNT_DISABLED = "Your account has been disabled. If this is an error, please contact administration";
    private static final String ERROR_PROCESSING_FILE = "Error occurred while processing file";
    private static final String NOT_ENOUGH_PERMISSION = "You do not have enough permission";
    private static final String bad_request = "Ybad request";
    public static final String ERROR_PATH = "/error";

   /* @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<com.sid.catalogue.entities.HttpResponse> internalServerErrorException(HttpMessageNotReadableException exception) {
       
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }*/
/*
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<HttpResponse> methodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        HttpMethod supportedMethod = Objects.requireNonNull(exception.getSupportedHttpMethods()).iterator().next();
        return createHttpResponse(METHOD_NOT_ALLOWED, String.format(METHOD_IS_NOT_ALLOWED, supportedMethod));
    }
   
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<com.sid.catalogue.entities.HttpResponse> internalServerErrorException(HttpMessageNotReadableException exception) {
       
        return createHttpResponse(BAD_REQUEST, "json mapping");
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<HttpResponse> exception2(ConstraintViolationException exception) {
       
        return createHttpResponse(INTERNAL_SERVER_ERROR,"not unique");
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> exception(Exception exception) {
       
        return createHttpResponse(INTERNAL_SERVER_ERROR,exception.getCause().toString());
    }*/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> exception(Exception exception) {
      return createHttpResponse(BAD_REQUEST,  exception.getMessage());
    }
   /* @ExceptionHandler(NoResultException.class)
    public ResponseEntity<HttpResponse> notFoundException(NoResultException exception) {
        LOGGER.error(exception.getMessage());
        return createHttpResponse(NOT_FOUND, exception.getMessage());
    }
  
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HttpResponse> notFoundExceptioné(ResourceNotFoundException exception) {
        LOGGER.error(exception.getMessage());
        return createHttpResponse(NOT_FOUND, exception.getMessage());
    }
  */


    private ResponseEntity<com.sid.catalogue.entities.HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new com.sid.catalogue.entities.HttpResponse(httpStatus.value(), httpStatus,
                httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus);
    }

@Override
public String getErrorPath() {
	// TODO Auto-generated method stub
	return null;
}
 


   
}
