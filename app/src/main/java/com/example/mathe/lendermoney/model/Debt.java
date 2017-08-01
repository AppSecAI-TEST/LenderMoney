package com.example.mathe.lendermoney.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by mathe on 31/07/2017.
 */

public class Debt implements Serializable {

    private int id;
    private String name;
    private String phone;
    private String notes;
    private BigDecimal debtOriginal;
    private BigDecimal debtTax;
    private Double interest;
    private org.joda.time.LocalDate debtDate;
    private org.joda.time.LocalDate payDay;
    private org.joda.time.LocalDate calculateDay;

    public Debt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getDebtOriginal() {
        return debtOriginal;
    }

    public void setDebtOriginal(BigDecimal debtOriginal) {
        this.debtOriginal = debtOriginal;
    }

    public BigDecimal getDebtTax() {
        return debtTax;
    }

    public void setDebtTax(BigDecimal debtTax) {
        this.debtTax = debtTax;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public org.joda.time.LocalDate getDebtDate() {
        return debtDate;
    }

    public void setDebtDate(org.joda.time.LocalDate debtDate) {
        this.debtDate = debtDate;
    }

    public org.joda.time.LocalDate getPayDay() {
        return payDay;
    }

    public void setPayDay(org.joda.time.LocalDate payDay) {
        this.payDay = payDay;
    }

    public org.joda.time.LocalDate getCalculateDay() {
        return calculateDay;
    }

    public void setCalculateDay(org.joda.time.LocalDate calculateDay) {
        this.calculateDay = calculateDay;
    }
}
