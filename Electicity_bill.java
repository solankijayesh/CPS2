package com.example.damo.djg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sasidhar.smaps.payumoney.MakePaymentActivity;
import com.sasidhar.smaps.payumoney.PayUMoney_Constants;
import com.sasidhar.smaps.payumoney.Utils;

import java.util.HashMap;

public class Electicity_bill extends AppCompatActivity {

    Button b1;
    Button payu;

    private HashMap<String, String> params = new HashMap<>();
    EditText totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electicity_bill);
        b1= (Button) findViewById(R.id.buyitbtn);
        payu= (Button) findViewById(R.id.payu);
        totalAmount= (EditText) findViewById(R.id.editText5);
        init();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Electicity_bill.this,SampleActivity.class);
                startActivity(intent);
            }
        });
        payu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Electicity_bill.this, MakePaymentActivity.class);
                intent.putExtra(PayUMoney_Constants.ENVIRONMENT, PayUMoney_Constants.ENV_DEV);
                intent.putExtra(PayUMoney_Constants.PARAMS, params);

                startActivityForResult(intent, PayUMoney_Constants.PAYMENT_REQUEST);
            }
        });
    }


    private synchronized void init() {

        params.put(PayUMoney_Constants.KEY, "Qkjr2wnS");
        params.put(PayUMoney_Constants.TXN_ID, "TiKGDBD8UH");
        params.put(PayUMoney_Constants.AMOUNT, "300");
        params.put(PayUMoney_Constants.PRODUCT_INFO, "product_info");
        params.put(PayUMoney_Constants.FIRST_NAME, "Corporation");
        params.put(PayUMoney_Constants.EMAIL, "wannayou0077gmail.com");
        params.put(PayUMoney_Constants.PHONE, "9629435444");
        params.put(PayUMoney_Constants.SURL, "success_url");
        params.put(PayUMoney_Constants.FURL, "failure_url");
        params.put(PayUMoney_Constants.UDF1, "");
        params.put(PayUMoney_Constants.UDF2, "");
        params.put(PayUMoney_Constants.UDF3, "");
        params.put(PayUMoney_Constants.UDF4, "");
        params.put(PayUMoney_Constants.UDF5, "");

        String hash = Utils.generateHash(params, "salt");

        params.put(PayUMoney_Constants.HASH, hash);
        params.put(PayUMoney_Constants.SERVICE_PROVIDER, "payu_paisa");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PayUMoney_Constants.PAYMENT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Payment Success,", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Payment Failed | Cancelled.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
