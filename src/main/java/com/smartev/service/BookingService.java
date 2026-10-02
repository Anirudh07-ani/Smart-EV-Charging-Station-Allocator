package com.smartev.service;

import com.smartev.exception.*;
import com.smartev.model.*;
import com.smartev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.List;

@Service
public class BookingService {
    @Autowired private BookingTransactionRepository bookingRepo;
    @Autowired private ChargingStationRepository stationRepo;
    @Autowired private EVUserRepository userRepo;
    @Autowired private VehicleRepository vehicleRepo;

    public List<BookingTransaction> getAllBookings() { return bookingRepo.findAll(); }
    public BookingTransaction getBookingById(Long id) { return bookingRepo.findById(id).orElseThrow(() -> new InvalidBookingException("Booking not found")); }
    
    @Transactional
    public BookingTransaction createBooking(BookingTransaction booking) {
        ChargingStation station = stationRepo.findById(booking.getStation().getStationId())
            .orElseThrow(() -> new StationNotFoundException("Station not found"));
            
        EVUser user = userRepo.findById(booking.getUser().getUserId())
            .orElseThrow(() -> new UserNotFoundException("User not found"));
            
        Vehicle vehicle = vehicleRepo.findById(booking.getVehicle().getVehicleId())
            .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));
            
        if (!vehicle.getUser().getUserId().equals(user.getUserId())) {
            throw new InvalidBookingException("The selected vehicle does not belong to the user.");
        }
            
        if (station.getAvailableSlots() <= 0 || "MAINTENANCE".equals(station.getStatus()) || "INACTIVE".equals(station.getStatus())) {
            throw new SlotUnavailableException("No charging slot is currently available at this station.");
        }
        
        station.setAvailableSlots(station.getAvailableSlots() - 1);
        if (station.getAvailableSlots() == 0) {
            station.setStatus("FULL");
        }
        stationRepo.save(station);
        
        booking.setStation(station);
        booking.setUser(user);
        booking.setVehicle(vehicle);
        booking.setStatus("RESERVED");
        return bookingRepo.save(booking);
    }
    
    @Transactional
    public BookingTransaction startCharging(Long bookingId) {
        BookingTransaction booking = getBookingById(bookingId);
        if (!"RESERVED".equals(booking.getStatus())) {
            throw new InvalidBookingException("Can only start reserved bookings");
        }
        booking.setStatus("CHARGING");
        booking.setStartTime(LocalDateTime.now());
        return bookingRepo.save(booking);
    }
    
    @Transactional
    public BookingTransaction stopCharging(Long bookingId) {
        BookingTransaction booking = getBookingById(bookingId);
        if (!"CHARGING".equals(booking.getStatus())) {
            throw new InvalidBookingException("Booking is not currently charging");
        }
        
        booking.setEndTime(LocalDateTime.now());
        booking.setStatus("COMPLETED");
        
        long minutes = Duration.between(booking.getStartTime(), booking.getEndTime()).toMinutes();
        if (minutes <= 0) minutes = 1; 
        
        double assumedPowerKw = 7.0; 
        double energyConsumed = (minutes / 60.0) * assumedPowerKw;
        energyConsumed = Math.round(energyConsumed * 100.0) / 100.0;
        
        booking.setEnergyConsumed(energyConsumed);
        
        double price = booking.getStation().getPricePerKwh() != null ? booking.getStation().getPricePerKwh() : 15.0;
        double amount = energyConsumed * price;
        booking.setAmountBilled(Math.round(amount * 100.0) / 100.0);
        
        ChargingStation station = booking.getStation();
        station.setAvailableSlots(station.getAvailableSlots() + 1);
        if ("FULL".equals(station.getStatus())) {
            station.setStatus("AVAILABLE");
        }
        stationRepo.save(station);
        
        return bookingRepo.save(booking);
    }
}
