package com.example;

import com.example.enums.SlotAvailabilityStatus;
import com.example.enums.VaccineType;
import com.example.model.VaccinationSlot;
import com.example.service.VaccinationSlotBookingService;
import com.example.service.VaccinationSlotService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class Covid19AppApplication implements CommandLineRunner {

    private final VaccinationSlotService vaccinationSlotService;
    private final VaccinationSlotBookingService vaccinationSlotBookingService;

    public Covid19AppApplication(VaccinationSlotService vaccinationSlotService, VaccinationSlotBookingService vaccinationSlotBookingService) {
        this.vaccinationSlotService = vaccinationSlotService;
        this.vaccinationSlotBookingService = vaccinationSlotBookingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Covid19AppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        List<VaccinationSlot> slots = new ArrayList<>(10);

        List<String> addressList = Arrays.asList(
                "Dilshad Garden Delhi",
                "Okhla, Delhi",
                "Jasola Vihar, Delhi",
                "Jawaharlal Nehru Marg, Delhi",
                "Punjabi Bagh",
                "Sec-13, Noida",
                "Sec 72, Noida",
                "Sec 32, Noida"
        );

        List<String> hospitals = Arrays.asList(
                "Fortis Flt. Lt. Rajan Dhall Hospital",
                "Fortis Hospital Shalimar Bagh",
                "Fortis La Femme Greater Kailash",
                "Govind Ballabh Pant Hospital",
                "Guru Teg Bahadur Hospital",
                "Holy Family Hospital",
                "Indraprastha Apollo Hospital",
                "Lok Nayak Hospital",
                "Maharaja Agrasen Hospital",
                "Max Med Centre & Institute of Cancer Care");

        Random random = new Random();
        for (int i = 1; i <= 10; i++) {

            VaccinationSlot vaccinationSlot = new VaccinationSlot(LocalDate.of(2022, 06, random.nextInt(29) + 1),
                    hospitals.get(random.nextInt(hospitals.size() - 1)),
                    addressList.get(random.nextInt(addressList.size() - 1)),
                    VaccineType.COVAXIN,
                    20,
                    i % 2 == 0 ? SlotAvailabilityStatus.AVAILABLE : SlotAvailabilityStatus.BOOKED
            );
            slots.add(vaccinationSlot);
        }
        //sort to keep date in order
        slots.sort(Comparator.comparing(VaccinationSlot::getSlotDate));
        vaccinationSlotBookingService.deleteAllBookingSlots();
        vaccinationSlotService.deleteAll();
        List<VaccinationSlot> slots1 = vaccinationSlotService.saveAllSlots(slots);
    }
}
