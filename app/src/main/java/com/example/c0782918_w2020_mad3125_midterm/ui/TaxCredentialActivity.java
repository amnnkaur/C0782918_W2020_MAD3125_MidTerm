package com.example.c0782918_w2020_mad3125_midterm.ui;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


import com.example.c0782918_w2020_mad3125_midterm.R;
import com.example.c0782918_w2020_mad3125_midterm.model.CRACustomer;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class TaxCredentialActivity extends AppCompatActivity {


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
    @BindView(R.id.radioGroup) RadioGroup radioGroup;
    @BindView(R.id.radioButtonMale) RadioButton radioButtonMale;
    @BindView(R.id.radioButtonFemale) RadioButton radioButtonFemale;
    @BindView(R.id.radioButtonOther) RadioButton radioButtonOther;

    RadioButton rb;
    int age;
    Date birthDate;
    CRACustomer customerData;
    String pattern = "^(\\d{3}-\\d{3}-\\d{3})|(\\d{9})$";
    String gender = "Male";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_credential);

        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButtonMale:
                        gender = "Male";
                        break;
                    case R.id.radioButtonFemale:
                        gender = "Female";
                        break;
                    case R.id.radioButtonOther:
                        gender = "Other";
                        break;
                }
            }
        });

    }


    public void datePickImageButton(View view) {
        DatePickerDialog datePickerDialog;
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(TaxCredentialActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        textViewDate.setText(dayOfMonth + "-"
                                + (monthOfYear + 1) + "-" + year);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        try {
                            birthDate = formatter.parse(textViewDate.getText().toString());
                            LocalDate localDate = LocalDate.of(year, monthOfYear + 1, dayOfMonth);
                            LocalDate now = LocalDate.now();
                            Period difference = Period.between(localDate, now);
                            age = difference.getYears();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void onSubmitButtonClicked(View view) {
        if (textViewSIN.getText().toString().isEmpty() && textViewSIN.getText().toString().matches(pattern)) {
            textViewSIN.setError("Please enter valid SIN No.");
        }else if (textViewFirstName.getText().toString().isEmpty()) {
            textViewFirstName.setError("Please enter First Name");
        } else if (textViewLastName.getText().toString().isEmpty()) {
            textViewLastName.setError("Please enter Last Name");
        } else if (textViewDate.getText().toString().isEmpty()) {
            textViewDate.setError("Please enter Birth Date");
        }else if(age<18) {
            textViewDate.setText("You are not eligible to file tax");
            textViewDate.setTextColor(Color.parseColor("#9B0000"));
        } else if (textViewGrossIncome.getText().toString().isEmpty()) {
            textViewGrossIncome.setError("Please enter Gross Income");
        } else if (textViewRRSP.getText().toString().isEmpty()) {
            textViewRRSP.setError("Please enter RRSP Contribution");
        }else{
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(TaxCredentialActivity.this);
            alertBuilder.setTitle("Tax Filed!");
            alertBuilder.setMessage("Are you sure to proceed with filing Tax?");
            alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    customerData = new CRACustomer(textViewSIN.getText().toString(),
                            textViewFirstName.getText().toString(),
                            textViewLastName.getText().toString(),
                            textViewDate.getText().toString(),
                            Double.parseDouble(textViewGrossIncome.getText().toString()),
                            Double.parseDouble(textViewRRSP.getText().toString()),gender,age);
                    Bundle myBundle = new Bundle();
                    myBundle.putSerializable("myBundle", (Serializable) customerData);
                    Intent mIntent = new Intent(TaxCredentialActivity.this, TaxDetailActivity.class);
                    mIntent.putExtra("customerObject", myBundle);
                    startActivity(mIntent);
                }
            });
            alertBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog taxAlert = alertBuilder.create();
            taxAlert.show();
        }


    }
}
