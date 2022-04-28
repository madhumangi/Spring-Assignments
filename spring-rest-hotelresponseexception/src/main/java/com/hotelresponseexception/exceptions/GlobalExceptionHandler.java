package com.hotelresponseexception.exceptions;

import com.hotelresponseexception.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Method not allowed");
        String error=ex.getMessage();
        List<String> messages= Arrays.asList(error,"Method not supported");
        ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Media type not supported");
        String error=ex.getMessage();
        List<String> messages= Arrays.asList(error,"Invalid media type");
        ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);

    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       headers.add("desc","Path variable is missing");
       String error=ex.getMessage();
       List<String> messages=Arrays.asList(error,"Missing path variable");
       ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);


        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Req param is missing");
        String error=ex.getMessage();
        List<String> messages=Arrays.asList(error,"Invalid request parameter");
        ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Invalid data type");
        String error=ex.getMessage();
        List<String> messages=Arrays.asList(error,"Invalid data type");
        ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<Object> handleHotelNotFound(Exception ex){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Camera Not Found");
        String error=ex.getMessage();
        List<String> messages=Arrays.asList(error,"Camera not available");
        ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }

    @ExceptionHandler(HotelIdNotFoundException.class)
    public ResponseEntity<Object> handleHotelIdNotFound(Exception ex){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Camera Id Not Found");
        String error=ex.getMessage();
        List<String> messages=Arrays.asList(error,"Camera Id not available");
        ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOther(Exception ex){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Other Exception");
        String error=ex.getMessage();
        List<String> messages=Arrays.asList(error,"Other type of exception");
        ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),HttpStatus.NOT_ACCEPTABLE,HttpStatus.NOT_ACCEPTABLE.value(), error,messages);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }
}
