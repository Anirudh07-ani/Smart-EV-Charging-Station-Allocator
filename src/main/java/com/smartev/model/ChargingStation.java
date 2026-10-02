package com.smartev.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stations")
public class ChargingStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationId;

    private String stationName;
    private String location;
    
    private Integer numberOfSlots;
    private Integer availableSlots;
    
    private String chargingType; // AC, DC Fast Charging
    private Double pricePerKwh;
    
    private String status; // AVAILABLE, FULL, MAINTENANCE, INACTIVE

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookingTransaction> bookings = new ArrayList<>();

    // Getters and Setters
    public Long getStationId() { return stationId; }
    public void setStationId(Long stationId) { this.stationId = stationId; }

    public String getStationName() { return stationName; }
    public void setStationName(String stationName) { this.stationName = stationName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getNumberOfSlots() { return numberOfSlots; }
    public void setNumberOfSlots(Integer numberOfSlots) { this.numberOfSlots = numberOfSlots; }

    public Integer getAvailableSlots() { return availableSlots; }
    public void setAvailableSlots(Integer availableSlots) { this.availableSlots = availableSlots; }

    public String getChargingType() { return chargingType; }
    public void setChargingType(String chargingType) { this.chargingType = chargingType; }

    public Double getPricePerKwh() { return pricePerKwh; }
    public void setPricePerKwh(Double pricePerKwh) { this.pricePerKwh = pricePerKwh; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<BookingTransaction> getBookings() { return bookings; }
    public void setBookings(List<BookingTransaction> bookings) { this.bookings = bookings; }
}
