package com.smartev.controller;

import com.smartev.model.BookingTransaction;
import com.smartev.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    
    @Autowired private BookingService bookingService;
    @Autowired private StationService stationService;
    @Autowired private UserService userService;
    @Autowired private VehicleService vehicleService;

    @GetMapping
    public String listBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "bookings/list";
    }

    @GetMapping("/new")
    public String newBookingForm(Model model) {
        model.addAttribute("booking", new BookingTransaction());
        model.addAttribute("stations", stationService.getAllStations());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "bookings/form";
    }

    @PostMapping("/save")
    public String createBooking(@ModelAttribute("booking") BookingTransaction booking) {
        bookingService.createBooking(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/start/{id}")
    public String startCharging(@PathVariable Long id) {
        bookingService.startCharging(id);
        return "redirect:/bookings";
    }

    @GetMapping("/stop/{id}")
    public String stopCharging(@PathVariable Long id, Model model) {
        BookingTransaction completedBooking = bookingService.stopCharging(id);
        model.addAttribute("booking", completedBooking);
        return "bookings/receipt";
    }

    @GetMapping("/receipt/{id}")
    public String viewReceipt(@PathVariable Long id, Model model) {
        BookingTransaction booking = bookingService.getBookingById(id);
        if (!"COMPLETED".equals(booking.getStatus())) {
            return "redirect:/bookings";
        }
        model.addAttribute("booking", booking);
        return "bookings/receipt";
    }
}
