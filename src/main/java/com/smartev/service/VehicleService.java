package com.smartev.service;

import com.smartev.exception.*;
import com.smartev.model.*;
import com.smartev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {
    @Autowired private VehicleRepository vehicleRepo;
    @Autowired private EVUserRepository userRepo;
    
    public List<Vehicle> getAllVehicles() { return vehicleRepo.findAll(); }
    public Vehicle getVehicleById(Long id) { return vehicleRepo.findById(id).orElseThrow(() -> new VehicleNotFoundException("Vehicle not found")); }
    
    public Vehicle saveVehicle(Vehicle vehicle) { 
        if(vehicle.getUser() != null && vehicle.getUser().getUserId() != null) {
            EVUser user = userRepo.findById(vehicle.getUser().getUserId())
                .orElseThrow(() -> new UserNotFoundException("Assigned user does not exist"));
            vehicle.setUser(user);
        } else {
            throw new InvalidBookingException("Vehicle must belong to a registered user.");
        }
        return vehicleRepo.save(vehicle); 
    }
    
    public void deleteVehicle(Long id) { vehicleRepo.deleteById(id); }
    public List<Vehicle> getVehiclesByUserId(Long userId) { return vehicleRepo.findByUser_UserId(userId); }
}
