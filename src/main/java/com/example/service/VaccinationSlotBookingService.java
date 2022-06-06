package com.example.service;

import com.example.dto.BookSlot;
import com.example.enums.BookingStatus;
import com.example.exception.AvailabilityStateException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.VaccinationSlot;
import com.example.model.VaccinationSlotBooking;
import com.example.repository.VaccinationSlotBookingRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Jatinder
 * @since 1.0.0
 */

@Service
public class VaccinationSlotBookingService {

    private final VaccinationSlotBookingRepository vaccinationSlotBookingRepository;
    private final VaccinationSlotService vaccinationSlotService;

    public VaccinationSlotBookingService(VaccinationSlotBookingRepository vaccinationSlotBookingRepository,
                                         VaccinationSlotService vaccinationSlotService) {
        this.vaccinationSlotBookingRepository = vaccinationSlotBookingRepository;
        this.vaccinationSlotService = vaccinationSlotService;
    }

    public boolean cancelVaccinationSlot(String aadhaarCardNo) {
        VaccinationSlotBooking vaccinationSlotBooking = vaccinationSlotBookingRepository.findByAadhaarCardNo(aadhaarCardNo).map(obj -> {
            obj.setBookingStatus(BookingStatus.CANCELED);
            return obj;
        }).orElseThrow(() -> new ResourceNotFoundException("Booking details not available"));

        vaccinationSlotBookingRepository.save(vaccinationSlotBooking);
        return true;
    }

    public VaccinationSlotBooking bookVaccinationSlot(BookSlot bookSlot) {
        Optional<VaccinationSlot> vaccinationSlot = vaccinationSlotService.isSlotAvailable(bookSlot.getSlotDate(), bookSlot.getHospitalName());

        vaccinationSlot.orElseThrow(() -> new AvailabilityStateException(MessageFormat.format("Slot not available on {0}", bookSlot.getSlotDate())));

        VaccinationSlot vaccinationSlot1 = vaccinationSlot.get();

        if(!(countBookedVaccination(bookSlot.getSlotDate(), bookSlot.getHospitalName()) < vaccinationSlot1.getNoOfSlots())){
            throw new AvailabilityStateException(MessageFormat.format("{0} Slot is already booked", bookSlot.getSlotDate()));
        }

        VaccinationSlotBooking vaccinationSlotBooking = new VaccinationSlotBooking();
        vaccinationSlotBooking.setBookingDate(LocalDate.now());
        vaccinationSlotBooking.setAadhaarCardNo(bookSlot.getAadhaarCard());
        vaccinationSlotBooking.setPersonName(bookSlot.getPersonName());
        vaccinationSlotBooking.setBookingStatus(BookingStatus.BOOKED);
        vaccinationSlotBooking.setAge(bookSlot.getAge());
        vaccinationSlotBooking.setMobile(bookSlot.getMobile());
        vaccinationSlotBooking.setVaccinationSlot(vaccinationSlot1);

        return vaccinationSlotBookingRepository.save(vaccinationSlotBooking);
    }

    public int countBookedVaccination(LocalDate slotDate, String hospitalName){
        ExampleMatcher vaccinationSlotExampleMatcher = ExampleMatcher.matching().withIgnoreCase();
        VaccinationSlotBooking vaccinationSlotBooking = new VaccinationSlotBooking();
        VaccinationSlot vaccinationSlot = new VaccinationSlot();
        vaccinationSlot.setSlotDate(slotDate);
        vaccinationSlot.setHospitalName(hospitalName);
        vaccinationSlotBooking.setVaccinationSlot(vaccinationSlot);
        Example<VaccinationSlotBooking> vaccinationSlotExample = Example.of(vaccinationSlotBooking);
        return (int) vaccinationSlotBookingRepository.count(vaccinationSlotExample);
    }

    public void deleteAllBookingSlots(){
        vaccinationSlotBookingRepository.deleteAll();
    }
}
