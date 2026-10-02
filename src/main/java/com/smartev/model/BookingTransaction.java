package com.smartev.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class BookingTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private Integer slotNumber;
    
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    private Double energyConsumed;
    private Double amountBilled;
    
    private String status; // RESERVED, CHARGING, COMPLETED, CANCELLED

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private ChargingStation station;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private EVUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    // Getters and Setters
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public Integer getSlotNumber() { return slotNumber; }
    public void setSlotNumber(Integer slotNumber) { this.slotNumber = slotNumber; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public Double getEnergyConsumed() { return energyConsumed; }
    public void setEnergyConsumed(Double energyConsumed) { this.energyConsumed = energyConsumed; }

    public Double getAmountBilled() { return amountBilled; }
    public void setAmountBilled(Double amountBilled) { this.amountBilled = amountBilled; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public ChargingStation getStation() { return station; }
    public void setStation(ChargingStation station) { this.station = station; }

    public EVUser getUser() { return user; }
    public void setUser(EVUser user) { this.user = user; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
