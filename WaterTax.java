package com.example.damo.djg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WaterTax extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_tax);
        EditText e1= (EditText) findViewById(R.id.editText10);
        EditText e2= (EditText) findViewById(R.id.editText11);
        Button b1= (Button) findViewById(R.id.button8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(WaterTax.this,SampleActivity.class);
                startActivity(intent);
            }
        });
    }
}
