package com.smartev.controller;

import com.smartev.model.ChargingStation;
import com.smartev.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stations")
public class StationController {
    
    @Autowired private StationService stationService;

    @GetMapping
    public String listStations(Model model, @RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("stations", stationService.searchStations(search));
        } else {
            model.addAttribute("stations", stationService.getAllStations());
        }
        return "stations/list";
    }

    @GetMapping("/new")
    public String newStationForm(Model model) {
        model.addAttribute("station", new ChargingStation());
        return "stations/form";
    }

    @PostMapping("/save")
    public String saveStation(@ModelAttribute("station") ChargingStation station) {
        stationService.saveStation(station);
        return "redirect:/stations";
    }

    @GetMapping("/edit/{id}")
    public String editStationForm(@PathVariable Long id, Model model) {
        model.addAttribute("station", stationService.getStationById(id));
        return "stations/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
        return "redirect:/stations";
    }
}
