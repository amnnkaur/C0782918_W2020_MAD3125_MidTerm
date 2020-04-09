package com.example.c0782918_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    Bundle fetchData;
    CRACustomer object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_detail);

        ButterKnife.bind(this);

        fetchedData();

    }

    public void fetchedData(){
        Intent intent = getIntent();
        if (intent.hasExtra("userObject")){
            fetchData = intent.getBundleExtra("customerObject");
            object = (CRACustomer) fetchData.getSerializable("myBundle");

            textViewSIN.setText(String.valueOf(object.getPersonSINNumber()));
            textViewName.setText(object.getFullName());
            textViewBirthDate.setText(String.valueOf(object.getBirthDate()));
            textViewAge.setText(object.getAge());
            textViewGender.setText(String.valueOf(object.getGender()));
            textViewTaxDate.setText(String.valueOf(object.getTaxFilingDate()));
            textViewGross.setText(String.valueOf(object.getGrossIncome()));
            textViewCPP.setText(String.valueOf(object.getCpp()));
            textViewEI.setText(String.valueOf(object.getEi()));
            textViewRRSP.setText(String.valueOf(object.getRrspContributed()));
            textViewCarryFwd.setText(String.valueOf(object.getCarryForwardRRSP()));
            textViewMaxRRSP.setText(String.valueOf(object.getMaxRRSP()));
            textViewFederal.setText(String.valueOf(object.getFederalTax()));
            textViewProvincial.setText(String.valueOf(object.getProvincialTax()));
            textViewTotalTaxIncome.setText(String.valueOf(object.getTotalTaxableIncome()));
            textViewTotalTaxPay.setText(String.valueOf(object.getTotalTaxPayed()));

        }
    }

}

