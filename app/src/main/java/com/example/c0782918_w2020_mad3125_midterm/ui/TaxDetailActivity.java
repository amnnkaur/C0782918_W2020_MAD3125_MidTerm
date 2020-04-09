package com.example.c0782918_w2020_mad3125_midterm.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.c0782918_w2020_mad3125_midterm.R;
import com.example.c0782918_w2020_mad3125_midterm.model.CRACustomer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaxDetailActivity extends AppCompatActivity {

    @BindView(R.id.textViewSIN) TextView textViewSIN;
    @BindView(R.id.textViewName) TextView textViewName;
    @BindView(R.id.textViewBirthDate) TextView textViewBirthDate;
    @BindView(R.id.textViewAge) TextView textViewAge;
    @BindView(R.id.textViewGender) TextView textViewGender;
    @BindView(R.id.textViewTaxDate) TextView textViewTaxDate;
    @BindView(R.id.textViewGross) TextView textViewGross;
    @BindView(R.id.textViewCPP) TextView textViewCPP;
    @BindView(R.id.textViewEI) TextView textViewEI;
    @BindView(R.id.textViewFederal) TextView textViewFederal;
    @BindView(R.id.textViewProvincial) TextView textViewProvincial;
    @BindView(R.id.textViewRRSP) TextView textViewRRSP;
    @BindView(R.id.textViewCarryFwd) TextView textViewCarryFwd;
    @BindView(R.id.textViewMaxRRSP) TextView textViewMaxRRSP;
    @BindView(R.id.textViewTotalTaxIncome) TextView textViewTotalTaxIncome;
    @BindView(R.id.textViewTotalTaxPay) TextView textViewTotalTaxPay;

    Bundle customerBundle;
    CRACustomer customer;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_detail);

        ButterKnife.bind(this);

        customerDetails();

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void customerDetails(){
        Intent intent = getIntent();
        if (intent.hasExtra("customerObject")){
            customerBundle = intent.getBundleExtra("customerObject");
            customer = (CRACustomer) customerBundle.getSerializable("myBundle");

            textViewSIN.setText(String.valueOf(customer.getPersonSINNumber()));
            textViewName.setText(customer.getFullName());
            textViewBirthDate.setText(String.valueOf(customer.getBirthDate()));
            textViewAge.setText(String.valueOf(customer.getAge()));
            textViewGender.setText(String.valueOf(customer.getGender()));
            textViewTaxDate.setText(String.valueOf(customer.getTaxFilingDate()));
            textViewGross.setText(String.valueOf(customer.getGrossIncome()) + "$");
            textViewCPP.setText(String.valueOf(customer.getCpp())+ "$");
            textViewEI.setText(String.valueOf(customer.getEi())+ "$");
            textViewRRSP.setText(String.valueOf(customer.getRrspContributed())+ "$");
            textViewCarryFwd.setText(String.valueOf(customer.getCarryForwardRRSP())+ "$");
            if(customer.getCarryForwardRRSP()<0){
                textViewCarryFwd.setTextColor(Color.parseColor("#9B0000"));
            }
            textViewMaxRRSP.setText(String.valueOf(customer.getMaxRRSP())+ "$");
            textViewFederal.setText(String.valueOf(customer.getFederalTax())+ "$");
            textViewProvincial.setText(String.valueOf(customer.getProvincialTax())+ "$");
            textViewTotalTaxIncome.setText(String.valueOf(customer.getTotalTaxableIncome())+ "$");
            textViewTotalTaxPay.setText(String.valueOf(customer.getTotalTaxPayed())+ "$");

        }
    }

}

