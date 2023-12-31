package com.prueba.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase que gestiona las excepciones mostradas durante el consumo de la API y transaccion a la bd
 */
@ControllerAdvice
public class ErrorHandler {

    private static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);
    public static final String CONSTRAINT_VIOLATION_EXCEPTION = "ConstraintViolationException: ";
    public static final String BUSINESS_EXCEPTION = "BusinessException: ";
    public static final String ERROR = "Error: ";
    public static final String METHOD_ARGUMENT_NOT_VALID_EXCEPTION = "MethodArgumentNotValidException: ";

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions(Exception exception) {
        LOGGER.error(ERROR, exception);
        return new ResponseEntity<>(INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        LOGGER.error(ERROR, exception);
        return new ResponseEntity<>("Error: " + exception.getCause().getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<String> handleBusinessExceptions(BusinessException exception) {
        LOGGER.error(BUSINESS_EXCEPTION, exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException exception) {
        Map<String, Object> response = new HashMap<>();

        if (exception.getConstraintViolations().size() > 0) {
            List<String> errors = exception.getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());

            response.put("Errors", errors);
        }

        LOGGER.error(CONSTRAINT_VIOLATION_EXCEPTION, exception);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, Object> response = new HashMap<>();


        if (exception.getBindingResult().hasErrors()) {
            List<String> errors = exception.getFieldErrors()
                    .stream()
                    .map(fieldError -> "El campo '" + fieldError.getField() + "' " + fieldError.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("Errors", errors);
        }

        LOGGER.error(METHOD_ARGUMENT_NOT_VALID_EXCEPTION, exception);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }

}
