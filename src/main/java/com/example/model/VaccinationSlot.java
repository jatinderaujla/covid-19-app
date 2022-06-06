package com.example.model;

import com.example.enums.SlotAvailabilityStatus;
import com.example.enums.VaccineType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vaccination_slots")
public class VaccinationSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer slotId;
    private LocalDate slotDate;
    private String hospitalName;
    private String location;
    private VaccineType vaccineType = VaccineType.COVAXIN;
    private Integer noOfSlots;
    private SlotAvailabilityStatus slotAvailabilityStatus;

    public VaccinationSlot() {
    }

    public VaccinationSlot(LocalDate slotDate,
                           String hospitalName,
                           String location,
                           VaccineType vaccineType,
                           Integer noOfSlots,
                           SlotAvailabilityStatus slotAvailabilityStatus) {
        this.slotDate = slotDate;
        this.hospitalName = hospitalName;
        this.location = location;
        this.vaccineType = vaccineType;
        this.noOfSlots = noOfSlots;
        this.slotAvailabilityStatus = slotAvailabilityStatus;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public LocalDate getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(LocalDate slotDate) {
        this.slotDate = slotDate;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Integer getNoOfSlots() {
        return noOfSlots;
    }

    public void setNoOfSlots(Integer noOfSlots) {
        this.noOfSlots = noOfSlots;
    }

    public SlotAvailabilityStatus getSlotAvailabilityStatus() {
        return slotAvailabilityStatus;
    }

    public void setSlotAvailabilityStatus(SlotAvailabilityStatus slotAvailabilityStatus) {
        this.slotAvailabilityStatus = slotAvailabilityStatus;
    }
}
