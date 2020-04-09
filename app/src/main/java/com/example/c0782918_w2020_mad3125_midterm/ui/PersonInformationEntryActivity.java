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
    public void onSubmitButtonClicked(){
        if (textViewSIN.getText().toString().isEmpty()) {
            textViewSIN.setError("Please enter SIN No.");
        }else if (textViewFirstName.getText().toString().isEmpty()) {
            textViewFirstName.setError("Please enter First Name");
        } else if (textViewLastName.getText().toString().isEmpty()) {
            textViewLastName.setError("Please enter Last Name");
        } else if (textViewDate.getText().toString().isEmpty()) {
            textViewDate.setError("Please enter Birth Date");
        } else if (textViewGrossIncome.getText().toString().isEmpty()) {
            textViewGrossIncome.setError("Please enter Gross Income");
        } else if (textViewRRSP.getText().toString().isEmpty()) {
            textViewRRSP.setError("Please enter RRSP Contribution");
        }else{
            new MaterialAlertDialogBuilder(PersonInformationEntryActivity.this)
                    .setTitle("Tax Filed!")
                    .setMessage("Are you sure to proceed with filing Tax?")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent mIntent = new Intent(PersonInformationEntryActivity.this, TaxDetailActivity.class);

                            startActivity(mIntent);

                        }
                    })
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
            ;}
    } ;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.imageButtonDate)
    public void datePick(View view){
        DatePickerDialog datePickerDialog;
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(PersonInformationEntryActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        textViewDate.setText(sdf.toString());
                        try {
                            Date dateOfBirth = sdf.parse(textViewDate.getText().toString());
                            LocalDate l1 = LocalDate.of(year, monthOfYear + 1, dayOfMonth);
                            LocalDate now1 = LocalDate.now();
                            Period diff1 = Period.between(l1, now1);
                            age = diff1.getYears();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        if(age<18){
                            new MaterialAlertDialogBuilder(PersonInformationEntryActivity.this)
                                    .setTitle("ERROR!")
                                    .setMessage("You are not eligible to file Tax.")
                                    .setCancelable(false)
                                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();
                        }
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

}

