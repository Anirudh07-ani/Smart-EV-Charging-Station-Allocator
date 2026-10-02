package com.smartev.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USER")
public class EVUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    
    @Column(unique = true)
    private String email;
    
    private String phone;
    
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookingTransaction> bookings = new ArrayList<>();

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Vehicle> getVehicles() { return vehicles; }
    public void setVehicles(List<Vehicle> vehicles) { this.vehicles = vehicles; }

    public List<BookingTransaction> getBookings() { return bookings; }
    public void setBookings(List<BookingTransaction> bookings) { this.bookings = bookings; }

    // Helper method
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.setUser(this);
    }
}
