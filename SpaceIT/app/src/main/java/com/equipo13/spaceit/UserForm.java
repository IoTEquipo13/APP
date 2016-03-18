package com.equipo13.spaceit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class UserForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    EditText name, mail;
    String condition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        name = (EditText)findViewById(R.id.plateText);
        mail = (EditText) findViewById(R.id.mailText);
        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.places_names,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        condition = spinner.getSelectedItem().toString();
        getSupportActionBar().hide();
    }

    public void changeToPlates(View v){
        Intent plates = new Intent(this, PlatesRegistration.class);
        plates.putExtra("name", name.getText().toString());
        plates.putExtra("mail", mail.getText().toString());
        plates.putExtra("condition", condition);
        startActivity(plates);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        condition = spinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
      condition =  spinner.getSelectedItem().toString();
    }
}
