package com.smartev.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class StationManager extends EVUser {

    private String employeeId;
    
    private String managementRegion;

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getManagementRegion() { return managementRegion; }
    public void setManagementRegion(String managementRegion) { this.managementRegion = managementRegion; }
}
