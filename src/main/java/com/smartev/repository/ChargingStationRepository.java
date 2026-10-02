package com.smartev.repository;

import com.smartev.model.ChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargingStationRepository extends JpaRepository<ChargingStation, Long> {
    List<ChargingStation> findByLocationContainingIgnoreCase(String location);
    List<ChargingStation> findByStatus(String status);
    List<ChargingStation> findByChargingType(String chargingType);
}
