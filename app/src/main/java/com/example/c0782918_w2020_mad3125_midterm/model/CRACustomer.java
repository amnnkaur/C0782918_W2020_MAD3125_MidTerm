package com.example.c0782918_w2020_mad3125_midterm.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;



public class CRACustomer implements Serializable {
    public String personSINNumber;
    public String firstName;
    public String lastName;
    public String fullName;
    public String birthDate;
    public String gender;
    public int age;
    public LocalDate taxFilingDate;
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
    DecimalFormat df = new DecimalFormat("#.##");

    public CRACustomer() {
    }

    public CRACustomer(String personSINNumber, String firstName, String lastName, String birthDate, double grossIncome, double rrspContributed, String gender, int age) {
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

    public String getPersonSINNumber() {
        return personSINNumber;
    }

    public void setPersonSINNumber(String personSINNumber) {
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
        return (this.lastName.toUpperCase() + " " + this.firstName);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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


    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocalDate getTaxFilingDate() {

        taxFilingDate = LocalDate.now();

        return taxFilingDate;
    }

    public void setTaxFilingDate(LocalDate taxFilingDate) {
        this.taxFilingDate = taxFilingDate;
    }

    public double getGrossIncome() {
        this.grossIncome = Double.valueOf(df.format(grossIncome));
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getFederalTax() {

        Double firstTaxRate = 0.15, secondTaxRate = 0.205, thirdTaxRate = 0.26, fourthTaxRate = 0.29, fifthTaxRate = 0.33;
        Double firstBaseAmount = 0.0, secondBaseAmount = (47630 - 12069.00), thirdBaseAmount = (95259 - 47630.00), fourthBaseAmount = (147667 - 95259.00), fifthBaseAmount = (210371 - 147667.00);

        Double income = getTotalTaxableIncome();

        if (income <= 12069) {

            this.federalTax = firstBaseAmount ;

        } else if (income > 12069.01 && income <= 47630) {

            this.federalTax = firstBaseAmount + ((income - 12069) * firstTaxRate);

        } else if (income > 47630.01 && income <= 95259) {

           this.federalTax = firstBaseAmount + (secondBaseAmount * firstTaxRate) + ((income-47630) * secondTaxRate);

        } else if (income > 95259.01 && income <= 147667) {

            this.federalTax = firstBaseAmount + (secondBaseAmount * firstTaxRate) + (thirdBaseAmount * secondTaxRate) + ((income-95259) * thirdTaxRate);

        }else if (income > 147667.01 && income <= 210371) {

            this.federalTax = firstBaseAmount + (secondBaseAmount * firstTaxRate) + (thirdBaseAmount * secondTaxRate) + (fourthBaseAmount * thirdTaxRate) + ((income-147667) * fourthTaxRate);

        } else {

            this.federalTax = firstBaseAmount + (secondBaseAmount * firstTaxRate) + (thirdBaseAmount * secondTaxRate) + (fourthBaseAmount * thirdTaxRate) + (fifthBaseAmount * fourthTaxRate) + ((income - 210371) * fifthTaxRate);

        }

        this.federalTax = Double.valueOf(df.format(federalTax));
        return federalTax;
    }

    public void setFederalTax(double federalTax) {
        this.federalTax = federalTax;
    }

    public double getProvincialTax() {

        Double firstTaxRate = 0.0505, secondTaxRate = 0.0915, thirdTaxRate = 0.1116, fourthTaxRate = 0.1216, fifthTaxRate = 0.1316;
        Double firstBaseAmount = 0.0, secondBaseAmount = (43906 - 10582.00), thirdBaseAmount = (87813 - 43906.00), fourthBaseAmount = (150000 - 87813.00), fifthBaseAmount = (220000 - 150000.00);


        double income = getTotalTaxableIncome();

        if(income < 10582) {
            this.provincialTax = firstBaseAmount ;

        }else if(income < 43906 && income >= 10582.01){
            this.provincialTax = firstBaseAmount + ((income - 10582) * firstTaxRate);

        }else if(income < 87813 && income >= 43906.01){
            this.provincialTax = firstBaseAmount + (secondBaseAmount * firstTaxRate) + ((income-43906) * secondTaxRate);

        }else if(income < 150000 && income >= 87813.01){
            this.provincialTax = firstBaseAmount + (secondBaseAmount * firstTaxRate) + (thirdBaseAmount * secondTaxRate) + ((income-87813) * thirdTaxRate);

        }else if(income < 220000 && income >= 150000.01){
            this.provincialTax = firstBaseAmount + (secondBaseAmount * firstTaxRate) + (thirdBaseAmount * secondTaxRate) + (fourthBaseAmount * thirdTaxRate) + ((income-150000) * fourthTaxRate);

        }else{
            this.provincialTax = firstBaseAmount + (secondBaseAmount * firstTaxRate) + (thirdBaseAmount * secondTaxRate) + (fourthBaseAmount * thirdTaxRate) + (fifthBaseAmount * fourthTaxRate) + ((income - 220000) * fifthTaxRate);

        }


        this.provincialTax = Double.valueOf(df.format(provincialTax));
        return provincialTax;

    }

    public void setProvincialTax(double provincialTax) {
        this.provincialTax = provincialTax;
    }

    public double getCpp() {

        double maxAnnualEarning = this.grossIncome;

        if (maxAnnualEarning < 57400.00) {
            this.cpp = maxAnnualEarning * (5.10 / 100);
        } else {
            this.cpp = 57400.00 * (5.10 / 100);
        }

        this.cpp = Double.valueOf(df.format(cpp));
        return cpp;

    }

    public void setCpp(double cpp) {
        this.cpp = cpp;
    }

    public double getEi() {

        double maxInsurableIncome = this.grossIncome;

        if (maxInsurableIncome < 53100.00) {
            this.ei = maxInsurableIncome * (1.62 / 100);
        } else {
            this.ei = 53100.00 * (1.62 / 100);
        }

        this.ei = Double.valueOf(df.format(ei));
        return ei;
    }

    public void setEi(double ei) {
        this.ei = ei;
    }

    public double getRrspContributed() {

        this.rrspContributed = Double.valueOf(df.format(rrspContributed));
        return rrspContributed;
    }

    public void setRrspContributed(double rrspContributed) {
        this.rrspContributed = rrspContributed;
    }

    public double getCarryForwardRRSP() {

        double carryFwdRRSP = getRrspContributed();

        this.carryForwardRRSP = getMaxRRSP() - carryFwdRRSP;

        this.carryForwardRRSP = Double.valueOf(df.format(carryFwdRRSP));
        return carryForwardRRSP;
    }

    public void setCarryForwardRRSP(double carryForwardRRSP) {
        this.carryForwardRRSP = carryForwardRRSP;
    }

    public double getMaxRRSP() {

        this.maxRRSP = getGrossIncome() * 0.18;

        this.maxRRSP = Double.valueOf(df.format(maxRRSP));
        return maxRRSP;
    }

    public void setMaxRRSP(double maxRRSP) {
        this.maxRRSP = maxRRSP;
    }


    public double getTotalTaxableIncome() {

        if (getRrspContributed() > getMaxRRSP()) {
            this.totalTaxableIncome = getGrossIncome() - (getCpp() + getEi() + getMaxRRSP());
        } else {
            this.totalTaxableIncome = getGrossIncome() - (getCpp() + getEi() + getRrspContributed());
        }

        this.totalTaxableIncome = Double.valueOf(df.format(totalTaxableIncome));
        return totalTaxableIncome;
    }


    public void setTotalTaxableIncome(double totalTaxableIncome) {
        this.totalTaxableIncome = totalTaxableIncome;
    }

    public double getTotalTaxPayed() {

        this.totalTaxPayed = getFederalTax() + getProvincialTax();

        this.totalTaxPayed = Double.valueOf(df.format(totalTaxPayed));
        return totalTaxPayed;
    }

    public void setTotalTaxPayed(double totalTaxPayed) {
        this.totalTaxPayed = totalTaxPayed;
    }

}
