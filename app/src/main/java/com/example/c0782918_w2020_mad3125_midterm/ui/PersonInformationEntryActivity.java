package com.example.c0782918_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


import com.example.c0782918_w2020_mad3125_midterm.R;

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
    @BindView(R.id.radioButtonMale)
    RadioButton radioButtonMale;
    @BindView(R.id.radioButtonFemale)
    RadioButton radioButtonFemale;
    @BindView(R.id.radioButtonOther)
    RadioButton radioButtonOther;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroupGender;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information_entry);

        ButterKnife.bind(this);
    }
}
