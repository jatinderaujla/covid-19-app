package com.example.service;

import com.example.enums.SlotAvailabilityStatus;
import com.example.model.VaccinationSlot;
import com.example.repository.VaccinationSlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Jatinder
 * @since 1.0.0
 */
@Service
public class VaccinationSlotService {

    private final VaccinationSlotRepository vaccinationSlotRepository;

    public VaccinationSlotService(VaccinationSlotRepository vaccinationSlotRepository) {
        this.vaccinationSlotRepository = vaccinationSlotRepository;
    }

    public List<VaccinationSlot> saveAllSlots(List<VaccinationSlot> vaccinationSlots){
        return vaccinationSlotRepository.saveAll(vaccinationSlots);
    }

    public Optional<VaccinationSlot> isSlotAvailable(LocalDate slotDate, String hospitalName){
        return vaccinationSlotRepository.findBySlotDateAndHospitalNameAndSlotAvailabilityStatus(slotDate, hospitalName, SlotAvailabilityStatus.AVAILABLE);
    }

    public List<VaccinationSlot> fetchVaccinationSlots() {
        return vaccinationSlotRepository.findAll();
    }

    public void deleteAll() {
        vaccinationSlotRepository.deleteAll();
    }
}
