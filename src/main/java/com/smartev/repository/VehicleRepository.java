package com.smartev.repository;

import com.smartev.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByRegistrationNumberContainingIgnoreCase(String registrationNumber);
    List<Vehicle> findByUser_UserId(Long userId);
}
