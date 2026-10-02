package com.smartev.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String model;
    
    @Column(unique = true)
    private String registrationNumber;
    
    private Double batteryCapacity; // in kWh
    private Double currentBatteryLevel; // percentage 0-100

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private EVUser user;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookingTransaction> bookings = new ArrayList<>();

    // Getters and Setters
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public Double getBatteryCapacity() { return batteryCapacity; }
    public void setBatteryCapacity(Double batteryCapacity) { this.batteryCapacity = batteryCapacity; }

    public Double getCurrentBatteryLevel() { return currentBatteryLevel; }
    public void setCurrentBatteryLevel(Double currentBatteryLevel) { this.currentBatteryLevel = currentBatteryLevel; }

    public EVUser getUser() { return user; }
    public void setUser(EVUser user) { this.user = user; }

    public List<BookingTransaction> getBookings() { return bookings; }
    public void setBookings(List<BookingTransaction> bookings) { this.bookings = bookings; }
}
