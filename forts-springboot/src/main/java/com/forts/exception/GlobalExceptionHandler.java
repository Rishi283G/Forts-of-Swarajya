package com.forts.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Global exception handler for the application
 * Provides centralized error handling and custom error pages
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handle 404 - Not Found errors
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(NoHandlerFoundException ex, Model model) {
        logger.warn("404 Not Found: {}", ex.getRequestURL());
        model.addAttribute("errorMessage", "Page not found");
        model.addAttribute("errorCode", "404");
        return "error";
    }

    /**
     * Handle null pointer exceptions
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleNullPointer(NullPointerException ex, Model model) {
        logger.error("Null pointer exception occurred", ex);
        model.addAttribute("errorMessage", "An internal error occurred. Please try again later.");
        model.addAttribute("errorCode", "500");
        return "error";
    }

    /**
     * Handle illegal argument exceptions
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgument(IllegalArgumentException ex, Model model) {
        logger.warn("Invalid argument: {}", ex.getMessage());
        model.addAttribute("errorMessage", "Invalid request: " + ex.getMessage());
        model.addAttribute("errorCode", "400");
        return "error";
    }

    /**
     * Handle all other exceptions
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGenericException(Exception ex, Model model) {
        logger.error("Unexpected error occurred", ex);
        model.addAttribute("errorMessage", "An unexpected error occurred. Please try again later.");
        model.addAttribute("errorCode", "500");
        return "error";
    }
}
