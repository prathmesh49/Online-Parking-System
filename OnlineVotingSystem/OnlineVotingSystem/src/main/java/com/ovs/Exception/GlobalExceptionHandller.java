package com.ovs.Exception;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandller {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> methodArgNotValidException(WebRequest wr, Exception e) {
        ErrorDetails details = new ErrorDetails();
        details.setDesc(wr.getDescription(false));
        details.setMessage(e.getLocalizedMessage());
        details.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> reservationNotFoundException(WebRequest wr, Exception e) {
        ErrorDetails details = new ErrorDetails();
        details.setDesc(wr.getDescription(false));
        details.setMessage(e.getLocalizedMessage());
        details.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetails> validationException(WebRequest wr, Exception e) {
        ErrorDetails details = new ErrorDetails();
        details.setDesc(wr.getDescription(false));
        details.setMessage(e.getLocalizedMessage());
        details.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDetails> illegalArgsException(WebRequest wr, Exception e) {
        ErrorDetails details = new ErrorDetails();
        details.setDesc(wr.getDescription(false));
        details.setMessage(e.getLocalizedMessage());
        details.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetails> customException(WebRequest wr, Exception e) {
        ErrorDetails details = new ErrorDetails();
        details.setDesc(wr.getDescription(false));
        details.setMessage(e.getLocalizedMessage());
        details.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> notFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
        ErrorDetails details = new ErrorDetails();
        details.setDesc(req.getDescription(false));
        details.setMessage(nfe.getLocalizedMessage());
        details.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}
