package com.equipo13.spaceit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstSteps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_steps);
        getSupportActionBar().hide();
    }

    public void changeToForm(View v){
        Intent form = new Intent(this, UserForm.class);
        startActivity(form);
    }
}
