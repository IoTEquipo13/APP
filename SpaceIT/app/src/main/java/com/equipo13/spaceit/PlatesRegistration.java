package com.equipo13.spaceit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PlatesRegistration extends AppCompatActivity {

    String name,plates, photo, mail, condition;
    JSONObject prefZone;
    EditText platesEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plates_registration);
        getSupportActionBar().hide();
        Intent a = getIntent();
        name = a.getStringExtra("name");
        photo = "No hay foto";
        mail = a.getStringExtra("mail");
        condition = a.getStringExtra("condition");
        platesEdit = (EditText)findViewById(R.id.plateText);
    }

    public void changeToProfile(View v) {
        plates = platesEdit.getText().toString();
        JSONObject js = new JSONObject();
        try {
            JSONObject jsonobject_zones = new JSONObject();
            jsonobject_zones.put("0", "Zone1");
            jsonobject_zones.put("1", "Zone1");
            jsonobject_zones.put("2", "Zone1");
            jsonobject_zones.put("3", "Zone1");
            jsonobject_zones.put("4", "Zone1");
            jsonobject_zones.put("5", "Zone1");
            jsonobject_zones.put("6", "Zone1");

            js.put("Plate", plates.toString());
            js.put("Photo", "No hay u.u");
            js.put("Name", name.toString());
            js.put("Mail", mail.toString());
            js.put("PrefSegment", jsonobject_zones);
            js.put("Condition", condition.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("json", js.toString());
        Intent profile = new Intent(this, Profile.class);
        startActivity(profile);

    }

    public void registerUser(){
        JSONObject js = new JSONObject();
        try {
            JSONObject jsonobject_zones = new JSONObject();
            jsonobject_zones.put("0", "Zone1");
            jsonobject_zones.put("1", "Zone1");
            jsonobject_zones.put("2", "Zone1");
            jsonobject_zones.put("3", "Zone1");
            jsonobject_zones.put("4", "Zone1");
            jsonobject_zones.put("5", "Zone1");
            jsonobject_zones.put("6", "Zone1");
            js.put("Plate", "Expreso");
            js.put("Photo", "dasdasdas");
            js.put("Name", "Eric Reyes");
            js.put("Mail", "eladler@hotmail.com");
            js.put("PrefSegment", jsonobject_zones);
            js.put("Condition", "Normal");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("json", js.toString());
        // end of json build
        //start of API CALL
        String url = "https://greenheadapi.azurewebsites.net/api/user/register/";
        com.android.volley.toolbox.JsonObjectRequest req = new JsonObjectRequest(
                Request.Method.POST, url, js,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("waiting","waiting ...");
                        Log.d("RESPONSE", response.toString());

                        // msgResponse.setText(response.toString());
                        //hideProgressDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("ERROR", "Error: " + error.getMessage());
                Log.d("Error", error.toString());

                //hideProgressDialog();
            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(req);
    }//end of method send
}
