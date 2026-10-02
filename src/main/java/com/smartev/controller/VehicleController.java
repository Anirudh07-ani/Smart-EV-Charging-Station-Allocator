package com.smartev.controller;

import com.smartev.model.Vehicle;
import com.smartev.service.VehicleService;
import com.smartev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired private VehicleService vehicleService;
    @Autowired private UserService userService;

    @GetMapping
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "vehicles/list";
    }

    @GetMapping("/new")
    public String newVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("users", userService.getAllUsers());
        return "vehicles/form";
    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }
}
