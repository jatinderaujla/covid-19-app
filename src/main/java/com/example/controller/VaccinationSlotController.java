package com.example.controller;

import com.example.model.VaccinationSlot;
import com.example.service.VaccinationSlotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jatinder
 * @since 1.0.0
 */
@RestController
@RequestMapping("/v1/slots")
public class VaccinationSlotController {

    private final VaccinationSlotService vaccinationSlotService;

    public VaccinationSlotController(VaccinationSlotService vaccinationSlotService) {
        this.vaccinationSlotService = vaccinationSlotService;
    }

    @GetMapping
    public ResponseEntity<Object> vaccinationSlots(){
        List<VaccinationSlot> vaccinationSlots = vaccinationSlotService.fetchVaccinationSlots();
        return ResponseEntity.ok().body(vaccinationSlots);
    }

}

