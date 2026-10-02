package com.smartev.config;

import com.smartev.model.*;
import com.smartev.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(ChargingStationRepository stationRepo,
                                  EVUserRepository userRepo,
                                  VehicleRepository vehicleRepo,
                                  BookingTransactionRepository bookingRepo) {
        return args -> {
            if (stationRepo.count() == 0) {
                // Seed Charging Stations
                ChargingStation s1 = new ChargingStation();
                s1.setStationName("CyberHub Supercharger Alpha");
                s1.setLocation("Innovation District, Sector 4");
                s1.setNumberOfSlots(6);
                s1.setAvailableSlots(4);
                s1.setChargingType("DC Fast Charging");
                s1.setPricePerKwh(14.50);
                s1.setStatus("AVAILABLE");

                ChargingStation s2 = new ChargingStation();
                s2.setStationName("Silicon Tech Corridor Hub");
                s2.setLocation("Silicon Way Tech Park");
                s2.setNumberOfSlots(4);
                s2.setAvailableSlots(4);
                s2.setChargingType("DC Fast Charging");
                s2.setPricePerKwh(12.00);
                s2.setStatus("AVAILABLE");

                ChargingStation s3 = new ChargingStation();
                s3.setStationName("Metro Plaza FastHub");
                s3.setLocation("Metro City Central");
                s3.setNumberOfSlots(4);
                s3.setAvailableSlots(2);
                s3.setChargingType("AC");
                s3.setPricePerKwh(8.50);
                s3.setStatus("AVAILABLE");

                ChargingStation s4 = new ChargingStation();
                s4.setStationName("Aviation Gateway Depot");
                s4.setLocation("Airport Terminal 2 Transit Bay");
                s4.setNumberOfSlots(8);
                s4.setAvailableSlots(0);
                s4.setChargingType("DC Fast Charging");
                s4.setPricePerKwh(16.00);
                s4.setStatus("FULL");

                stationRepo.saveAll(Arrays.asList(s1, s2, s3, s4));

                // Seed EV Users / Drivers
                EVUser u1 = new EVUser();
                u1.setName("John Doe");
                u1.setEmail("john@example.com");
                u1.setPhone("+1 (555) 102-9384");
                u1.setPassword("password");

                EVUser u2 = new EVUser();
                u2.setName("Marcus Kim");
                u2.setEmail("m.kim@fleet.com");
                u2.setPhone("+1 (555) 302-8819");
                u2.setPassword("password");

                EVUser u3 = new EVUser();
                u3.setName("Elena Rostova");
                u3.setEmail("elena.r@mobility.org");
                u3.setPhone("+1 (555) 889-2031");
                u3.setPassword("password");

                userRepo.saveAll(Arrays.asList(u1, u2, u3));

                // Seed Vehicles
                Vehicle v1 = new Vehicle();
                v1.setModel("Tesla Model 3 Long Range");
                v1.setRegistrationNumber("CA-892-EV");
                v1.setBatteryCapacity(75.0);
                v1.setCurrentBatteryLevel(68.0);
                v1.setUser(u2);

                Vehicle v2 = new Vehicle();
                v2.setModel("Tata Nexon EV Max");
                v2.setRegistrationNumber("MH12AB1234");
                v2.setBatteryCapacity(40.5);
                v2.setCurrentBatteryLevel(45.0);
                v2.setUser(u1);

                Vehicle v3 = new Vehicle();
                v3.setModel("Hyundai Ioniq 5 AWD");
                v3.setRegistrationNumber("NY-441-IONIQ");
                v3.setBatteryCapacity(77.4);
                v3.setCurrentBatteryLevel(88.0);
                v3.setUser(u3);

                vehicleRepo.saveAll(Arrays.asList(v1, v2, v3));

                // Seed Sample Bookings
                // 1. Active Charging Session
                BookingTransaction b1 = new BookingTransaction();
                b1.setUser(u2);
                b1.setVehicle(v1);
                b1.setStation(s1);
                b1.setSlotNumber(4);
                b1.setStartTime(LocalDateTime.now().minusMinutes(38));
                b1.setStatus("CHARGING");
                b1.setEnergyConsumed(14.20);
                b1.setAmountBilled(17.22);

                // 2. Reserved Session
                BookingTransaction b2 = new BookingTransaction();
                b2.setUser(u3);
                b2.setVehicle(v3);
                b2.setStation(s3);
                b2.setSlotNumber(2);
                b2.setStartTime(LocalDateTime.now().plusHours(1));
                b2.setStatus("RESERVED");

                // 3. Completed Session with Receipt
                BookingTransaction b3 = new BookingTransaction();
                b3.setUser(u1);
                b3.setVehicle(v2);
                b3.setStation(s2);
                b3.setSlotNumber(1);
                b3.setStartTime(LocalDateTime.now().minusHours(3));
                b3.setEndTime(LocalDateTime.now().minusHours(2).minusMinutes(15));
                b3.setEnergyConsumed(22.50);
                b3.setAmountBilled(27.00);
                b3.setStatus("COMPLETED");

                bookingRepo.saveAll(Arrays.asList(b1, b2, b3));
            }
        };
    }
}
