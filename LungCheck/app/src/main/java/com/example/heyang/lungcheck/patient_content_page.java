package com.example.heyang.lungcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class patient_content_page extends AppCompatActivity {
    Button btnRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_content_page);
        btnRecord=(Button)findViewById(R.id.ButtonRecord);
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3= new Intent(patient_content_page.this, InstructionsOne.class);
                startActivity(intent3);
            }
        });
    }
}
