package com.smartev.service;

import com.smartev.exception.*;
import com.smartev.model.*;
import com.smartev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.List;

@Service
public class StationService {
    @Autowired private ChargingStationRepository stationRepo;

    public List<ChargingStation> getAllStations() { return stationRepo.findAll(); }
    public ChargingStation getStationById(Long id) { return stationRepo.findById(id).orElseThrow(() -> new StationNotFoundException("Station not found")); }
    public ChargingStation saveStation(ChargingStation station) { return stationRepo.save(station); }
    public void deleteStation(Long id) { stationRepo.deleteById(id); }
    public List<ChargingStation> searchStations(String location) { return stationRepo.findByLocationContainingIgnoreCase(location); }
}
