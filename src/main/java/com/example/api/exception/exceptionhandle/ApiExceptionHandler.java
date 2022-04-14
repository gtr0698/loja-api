package com.example.api.exception.exceptionhandle;

import com.example.api.exception.RegraException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RegraException.class)
    public ResponseEntity<Object> regraExptionHandle(RegraException ex, WebRequest request){
        var status = HttpStatus.BAD_REQUEST;

        var exceptionDto = new ExceptionDto();
        exceptionDto.setStatus(status.value());
        exceptionDto.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, exceptionDto, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var campos = new ArrayList<ExceptionDto.Campo>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();

            campos.add(new ExceptionDto.Campo(nome, mensagem));
        }

        var exceptionDto = new ExceptionDto();
        exceptionDto.setStatus(status.value());
        exceptionDto.setTitulo("Um ou mais campos estão inválidos. "
                + "Faça o preenchimento correto e tente novamente.");
        exceptionDto.setCampos(campos);

        return super.handleExceptionInternal(ex, exceptionDto, headers, status, request);
    }
}
