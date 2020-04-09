package com.example.c0782918_w2020_mad3125_midterm.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import com.example.c0782918_w2020_mad3125_midterm.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class PersonInformationEntryActivity extends AppCompatActivity {

    /*private TextView textViewSIN;
    private TextView textViewFirstName;
    private TextView textViewLastName;
    private TextView textViewDate;
    private TextView textViewGrossIncome;
    private TextView textViewRRSP;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private RadioButton radioButtonOther;*/

    @BindView(R.id.txtSin)
    TextView textViewSIN;
    @BindView(R.id.txtFirstName)
    TextView textViewFirstName;
    @BindView(R.id.txtLastName)
    TextView textViewLastName;
    @BindView(R.id.txtDate)
    TextView textViewDate;
    @BindView(R.id.txtGrossIncome)
    TextView textViewGrossIncome;
    @BindView(R.id.txtRRSP)
    TextView textViewRRSP;
    int age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information_entry);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSubmit)
    public void onSubmitButtonClicked() {
        if (textViewSIN.getText().toString().isEmpty()) {
            textViewSIN.setError("Please enter SIN No.");
        } else if (textViewFirstName.getText().toString().isEmpty()) {
            textViewFirstName.setError("Please enter First Name");
        } else if (textViewLastName.getText().toString().isEmpty()) {
            textViewLastName.setError("Please enter Last Name");
        } else if (textViewDate.getText().toString().isEmpty()) {
            textViewDate.setError("Please enter Birth Date");
        } else if (textViewGrossIncome.getText().toString().isEmpty()) {
            textViewGrossIncome.setError("Please enter Gross Income");
        } else if (textViewRRSP.getText().toString().isEmpty()) {
            textViewRRSP.setError("Please enter RRSP Contribution");
        } else {

            ;
        }
    }



}