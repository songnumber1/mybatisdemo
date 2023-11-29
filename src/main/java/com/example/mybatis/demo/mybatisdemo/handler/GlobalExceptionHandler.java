package com.example.mybatis.demo.mybatisdemo.handler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String RED_UNDERLINED = "\033[4;31m";

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(Exception e, HandlerMethod method, HttpServletRequest request) {
        exactErrorLog(e, method, INTERNAL_SERVER_ERROR, request);
        
        return new ResponseEntity<>(e.toString(), null, INTERNAL_SERVER_ERROR);
    }

    private void exactErrorLog(Exception e, HandlerMethod handlerMethod, HttpStatus httpStatus, HttpServletRequest request) {
        String errorDate = ANSI_YELLOW + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()) + ANSI_RESET;
        String requestURI = ANSI_CYAN + request.getRequestURI() + ANSI_RESET;
        String exceptionName = ANSI_PURPLE + e.getClass().getSimpleName() + ANSI_RESET;
        String status = ANSI_RED + httpStatus.toString() + ANSI_RESET;
        String controllerName = ANSI_GREEN + handlerMethod.getMethod().getDeclaringClass().getSimpleName() + ANSI_RESET;
        String methodName = ANSI_BLUE + handlerMethod.getMethod().getName() + ANSI_RESET;
        String message = ANSI_RED + e.getMessage() + ANSI_RESET;
        String lineNumber = RED_UNDERLINED + e.getStackTrace()[0].getLineNumber() + ANSI_RESET;
        logger.error("\n[Time: {} | Class: {} | Method: {} | LineNumber: {} | Path: {} | Exception: {} | Status: {} | Message: {}]\n", errorDate, controllerName, methodName, lineNumber, requestURI, exceptionName, status, message);
    }
}