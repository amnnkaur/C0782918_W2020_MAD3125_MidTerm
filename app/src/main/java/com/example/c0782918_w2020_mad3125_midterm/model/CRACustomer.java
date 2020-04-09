package com.example.c0782918_w2020_mad3125_midterm.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.Date;


public class CRACustomer
{
    public long personSINNumber;
    public String firstName;
    public String lastName;
    public String fullName;
    public Date birthDate;
    public String gender;
    public int age;
    public Date taxFilingDate;
    public double grossIncome;
    public double federalTax;
    public double provincialTax;
    public double cpp;
    public double ei;
    public double rrspContributed;
    public double carryForwardRRSP;
    public double maxRRSP;
    public double totalTaxableIncome;
    public double totalTaxPayed;

    public CRACustomer() {}

    public CRACustomer(long personSINNumber, String firstName, String lastName, String fullName,
                       Date birthDate, String gender, int age, Date taxFilingDate,
                       double grossIncome, double federalTax, double provincialTax, double cpp, double ei,
                       double rrspContributed, double carryForwardRRSP,double maxRRSP, double totalTaxableIncome, double totalTaxPayed)
    {
        this.personSINNumber = personSINNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.age = age;
        this.taxFilingDate = taxFilingDate;
        this.grossIncome = grossIncome;
        this.federalTax = federalTax;
        this.provincialTax = provincialTax;
        this.cpp = cpp;
        this.ei = ei;
        this.rrspContributed = rrspContributed;
        this.carryForwardRRSP = carryForwardRRSP;
        this.maxRRSP = maxRRSP;
        this.totalTaxableIncome = totalTaxableIncome;
        this.totalTaxPayed = totalTaxPayed;
    }

    public long getPersonSINNumber() {
        return personSINNumber;
    }

    public void setPersonSINNumber(long personSINNumber) {
        this.personSINNumber = personSINNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return (this.lastName.toUpperCase() +" "+ this.firstName);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getTaxFilingDate() {

     //   taxFilingDate = LocalDate.now();

        return taxFilingDate;
    }

    public void setTaxFilingDate(Date taxFilingDate) {
        this.taxFilingDate = taxFilingDate;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(double federalTax) {
        this.federalTax = federalTax;
    }

    public double getProvincialTax() {
        return provincialTax;
    }

    public void setProvincialTax(double provincialTax) {
        this.provincialTax = provincialTax;
    }

    public double getCpp() {

        double maxAnnualEarning = this.grossIncome;

        if(maxAnnualEarning < 57400.00){
            this.cpp = maxAnnualEarning * (5.10/100);
        }
        else{
            this.cpp = 57400.00 * (5.10/100);
        }
        return cpp;

    }

    public void setCpp(double cpp) {
        this.cpp = cpp;
    }

    public double getEi() {

        double maxInsurableIncome = this.grossIncome;

        if (maxInsurableIncome <53100.00){
            this.ei = maxInsurableIncome * (1.62/100);
        }else{
            this.ei = 53100.00 * (1.62/100);
        }
        return ei;
    }

    public void setEi(double ei) {
        this.ei = ei;
    }

    public double getRrspContributed() {
        return rrspContributed;
    }

    public void setRrspContributed(double rrspContributed) {
        this.rrspContributed = rrspContributed;
    }

    public double getCarryForwardRRSP() {

        double carryFwdRRSP = this.rrspContributed;

        this.carryForwardRRSP = getMaxRRSP() - carryFwdRRSP;

        return carryForwardRRSP;
    }

    public void setCarryForwardRRSP(double carryForwardRRSP) {
        this.carryForwardRRSP = carryForwardRRSP;
    }

    public double getTotalTaxableIncome() {
        return totalTaxableIncome;
    }

    public double getMaxRRSP() {

        maxRRSP = this.grossIncome * (18/100);

        return maxRRSP;
    }

    public void setMaxRRSP(double maxRRSP) {
        this.maxRRSP = maxRRSP;
    }

    public void setTotalTaxableIncome(double totalTaxableIncome) {
        this.totalTaxableIncome = totalTaxableIncome;
    }

    public double getTotalTaxPayed() {
        return totalTaxPayed;
    }

    public void setTotalTaxPayed(double totalTaxPayed) {
        this.totalTaxPayed = totalTaxPayed;
    }
}
