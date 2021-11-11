package eu.kocka.jeopardyBackEnd.support;

import eu.kocka.jeopardyBackEnd.dto.ErrorDto;
import eu.kocka.jeopardyBackEnd.exception.NotFoundException;
import org.hibernate.PropertyValueException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalRestExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleEntityNotFound(NotFoundException ex){
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorDto> handleSqlException(SQLException ex){
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ErrorDto> handlePropertyException(PropertyValueException ex){
        String message = "Property " + ex.getPropertyName() + " can't be null.";
        return new ResponseEntity<>(new ErrorDto(message), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorDto> handleEmptyResultException(EmptyResultDataAccessException ex){
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
