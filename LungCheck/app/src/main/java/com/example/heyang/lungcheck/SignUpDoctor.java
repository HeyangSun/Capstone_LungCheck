package com.example.heyang.lungcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpDoctor extends AppCompatActivity {

    EditText hospital, lisence;
    Button btnsaveInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_doctor);
        hospital =(EditText)findViewById(R.id.TextHospital);
        lisence = (EditText)findViewById(R.id.TextLisence);
        btnsaveInfo =(Button)findViewById(R.id.ButtonSaveDoc);
        btnsaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpDoctor.this, DoctorPage1.class);
                startActivity(intent);
            }
        });
    }
}