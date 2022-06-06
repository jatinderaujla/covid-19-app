package com.example.repository;

import com.example.model.VaccinationSlotBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Jatinder
 * @since 1.0.0
 */
public interface VaccinationSlotBookingRepository extends JpaRepository<VaccinationSlotBooking, Integer> {
    Optional<VaccinationSlotBooking> findByAadhaarCardNo(String aadhaarCardNo);
}
