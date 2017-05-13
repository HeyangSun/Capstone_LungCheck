package com.example.heyang.lungcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText txtEmail, txtPassword, txtAge, txtName, txtGender, txtPlace;
    CheckBox chkBoxDoctor;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtName= (EditText)findViewById(R.id.TextName);
        txtEmail= (EditText)findViewById(R.id.TextEmail);
        txtAge= (EditText)findViewById(R.id.TextAge);
        txtPassword=(EditText)findViewById(R.id.TextPassword);
        txtGender=(EditText)findViewById(R.id.TextGender);
        txtPlace=(EditText)findViewById(R.id.TextPlace);
        btnSave=(Button)findViewById(R.id.ButtonSave);
        chkBoxDoctor=(CheckBox)findViewById(R.id.checkBoxDoctor) ;
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkBoxDoctor.isChecked()){
                    Intent intent1= new Intent(SignUp.this,SignUpDoctor.class);
                    startActivity(intent1);
                }
                else{
                    Intent intent2 =new Intent(SignUp.this, patient_content_page.class);
                    startActivity(intent2);
                }

            }
        });
    }
}