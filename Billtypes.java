package com.example.damo.djg;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Billtypes extends Activity {
    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billtypes);
        final RadioButton electicity = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton water = (RadioButton) findViewById(R.id.radioButton5);
        final RadioButton house = (RadioButton) findViewById(R.id.radioButton6);
        b1 = (Button) findViewById(R.id.button9);
        b2 = (Button) findViewById(R.id.button4);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Billtypes.this, ServiceMenu.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (electicity.isChecked()) {
                    Intent intent = new Intent(Billtypes.this, Electicity_bill.class);
                    startActivity(intent);
                }
                else if (water.isChecked()) {
                    Intent intent = new Intent(Billtypes.this, WaterTax.class);
                    startActivity(intent);
                }
                else if (house.isChecked()) {
                    Intent intent = new Intent(Billtypes.this, HouseBill.class);
                    startActivity(intent);
                }
            }
        });
    }
}
