package com.example.model;

import com.example.enums.BookingStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="vaccination_slot_bookings")
public class VaccinationSlotBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private String personName;
    private Integer age;
    private LocalDate bookingDate;
    private BookingStatus bookingStatus;
    @Column(unique = true)
    private String mobile;
    @Column(unique = true)
    private String aadhaarCardNo;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private VaccinationSlot vaccinationSlot;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAadhaarCardNo() {
        return aadhaarCardNo;
    }

    public void setAadhaarCardNo(String aadhaarCardNo) {
        this.aadhaarCardNo = aadhaarCardNo;
    }

    public VaccinationSlot getVaccinationSlot() {
        return vaccinationSlot;
    }

    public void setVaccinationSlot(VaccinationSlot vaccinationSlot) {
        this.vaccinationSlot = vaccinationSlot;
    }

}
