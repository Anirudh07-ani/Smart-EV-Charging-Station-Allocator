package com.smartev.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
        StationNotFoundException.class,
        UserNotFoundException.class,
        VehicleNotFoundException.class,
        SlotUnavailableException.class,
        InvalidBookingException.class
    })
    public String handleCustomExceptions(RuntimeException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        return "redirect:/error-page"; // We'll create a generic error-page mapping
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred: " + ex.getMessage());
        return "redirect:/error-page";
    }
}
