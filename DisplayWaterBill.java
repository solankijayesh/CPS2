package com.example.damo.djg;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisplayWaterBill extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewResult;
    ArrayList<String> map;

    //private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_bills);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        onInvoke("http://10.0.0.1/waterbill.php");
    }

    //loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);
    public void onInvoke(String url) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DisplayWaterBill.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void showJSON(String response) {
        String adharnumber = "";
        String amount = "";
        String status = "";
        String date = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(config.JSON_ARRAY);
            for (int i = 0; i < result.length(); i++) {
                map = new ArrayList<>();
                JSONObject collegeData = result.getJSONObject(i);
                adharnumber = collegeData.getString(config.KEY_ADHARNUMBER);
                amount = collegeData.getString(config.KEY_AMOUNT);
                status = collegeData.getString(config.KEY_STATUS);
                date = collegeData.getString(config.KEY_DATE);
                map.add(adharnumber);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        textViewResult.setText("Adharnumber:\t" + adharnumber + "\nAmunt:\t" + amount + "\nStatus:\t" + status + "\nDate:\t" + date);
    }

    @Override
    public void onClick(View v) {

    }
}