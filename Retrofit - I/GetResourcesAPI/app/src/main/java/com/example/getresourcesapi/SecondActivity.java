package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView mtvnumber;
    private TextView mtvName;
    private TextView mtvYear;
    private TextView mtvCompany;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initviews();
        if (getIntent() != null) {
            String firstname = getIntent().getStringExtra("firstname");
            String year = getIntent().getStringExtra("year");
            String company = getIntent().getStringExtra("company");
            String number = getIntent().getStringExtra("userid");
            String colour = getIntent().getStringExtra("colour");

            mtvName.setText(firstname);
            mtvYear.setText(year);
            mtvCompany.setText(company);
            mtvnumber.setText(number);
            linearLayout.setBackgroundColor(Color.parseColor(colour));


        }

    }

    private void initviews() {
        mtvName = findViewById(R.id.tvName);
        mtvCompany = findViewById(R.id.tvCompany);
        mtvnumber = findViewById(R.id.tvnumber);
        mtvYear = findViewById(R.id.tvYear);
        linearLayout = findViewById(R.id.colour);

    }
}