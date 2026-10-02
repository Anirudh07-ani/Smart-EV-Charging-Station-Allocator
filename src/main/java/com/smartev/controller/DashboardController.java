package com.smartev.controller;

import com.smartev.model.EVUser;
import com.smartev.service.UserService;
import com.smartev.repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DashboardController {

    @Autowired private ChargingStationRepository stationRepo;
    @Autowired private EVUserRepository userRepo;
    @Autowired private VehicleRepository vehicleRepo;
    @Autowired private BookingTransactionRepository bookingRepo;
    @Autowired private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String email, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes) {
        EVUser user = userService.authenticate(email, password);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/dashboard";
        }
        redirectAttributes.addFlashAttribute("error", "Invalid email or password");
        return "redirect:/login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        if (session != null) {
            session.invalidate();
        }
        redirectAttributes.addFlashAttribute("successMessage", "Logged out successfully.");
        return "redirect:/login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        long totalStations = stationRepo.count();
        long totalUsers = userRepo.count();
        long totalVehicles = vehicleRepo.count();
        int activeSessions = bookingRepo.countByStatus("CHARGING");
        int completedSessions = bookingRepo.countByStatus("COMPLETED");
        
        long availableSlots = stationRepo.findAll().stream().mapToLong(s -> s.getAvailableSlots() != null ? s.getAvailableSlots() : 0).sum();
        
        model.addAttribute("totalStations", totalStations);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalVehicles", totalVehicles);
        model.addAttribute("activeSessions", activeSessions);
        model.addAttribute("completedSessions", completedSessions);
        model.addAttribute("availableSlots", availableSlots);
        
        model.addAttribute("recentBookings", bookingRepo.findAll().stream().sorted((b1, b2) -> b2.getBookingId().compareTo(b1.getBookingId())).limit(5).toList());
        model.addAttribute("stations", stationRepo.findAll());
        
        return "dashboard";
    }
}
