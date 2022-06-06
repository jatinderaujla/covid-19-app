package com.example.repository;

import com.example.enums.SlotAvailabilityStatus;
import com.example.model.VaccinationSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Jatinder
 * @since 1.0.0
 */
public interface VaccinationSlotRepository extends JpaRepository<VaccinationSlot, Integer> {

    boolean existsBySlotDateAndHospitalNameAndSlotAvailabilityStatus(LocalDate slotDate, String hospitalName, SlotAvailabilityStatus slotAvailabilityStatus);

    Optional<VaccinationSlot> findBySlotDateAndHospitalNameAndSlotAvailabilityStatus(LocalDate slotDate, String hospitalName, SlotAvailabilityStatus available);
}
