package com.equipo13.spaceit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView zone = (TextView)findViewById(R.id.zone);
        Intent intent = getIntent();
        zone.setText(intent.getStringExtra("zone"));

    }
    public void cerrar(View v){
        System.exit(0);
        Intent salida=new Intent( Intent.ACTION_MAIN); //Llamando a la activity principal
        finish();
    }
}
