package com.example.controller;

import com.example.dto.BookSlot;
import com.example.enums.BookingStatus;
import com.example.model.VaccinationSlotBooking;
import com.example.service.VaccinationSlotBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * @author Jatinder
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/slots/booking")
public class VaccinationSlotBookingController {

    private final VaccinationSlotBookingService vaccinationSlotBookingService;

    public VaccinationSlotBookingController(VaccinationSlotBookingService vaccinationSlotBookingService) {
        this.vaccinationSlotBookingService = vaccinationSlotBookingService;
    }

    @PostMapping
    public ResponseEntity<Object> bookVaccineSlot(@RequestBody BookSlot bookSlot) {
        VaccinationSlotBooking vaccinationSlotBooking = vaccinationSlotBookingService.bookVaccinationSlot(bookSlot);
        String message = BookingStatus.BOOKED.equals(vaccinationSlotBooking.getBookingStatus())
                ? "Vaccination booked successfully for date: " + vaccinationSlotBooking.getBookingDate()
                : "Vaccination booking failed";
        return ResponseEntity.created(URI.create("")).body(message);
    }

    @PutMapping(value = "cancel/{aadhaar-card-no}")
    public ResponseEntity<Object> cancelVaccinationSlot(@PathVariable("aadhaar-card-no") String aadhaarCardNo) {
        boolean isSlotCancelled = vaccinationSlotBookingService.cancelVaccinationSlot(aadhaarCardNo);
        return ResponseEntity.ok(isSlotCancelled ? "Booking cancelled successfully" : "Booking cancellation failed");
    }
}

