package com.example.damo.djg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BillNotify extends AppCompatActivity {
    Button b1;
    EditText e1;
    Spinner s1;
    ArrayList<String> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        b1= (Button) findViewById(R.id.button12);
        e1= (EditText) findViewById(R.id.editText4);
        s1= (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> a = new ArrayAdapter<String>(BillNotify.this, android.R.layout.simple_spinner_item, map);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(a);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent= new Intent(Notification.this,)
                sendChatMessage(e1.getText().toString(),s1.getSelectedItem().toString());
            }
        });

    }
    // second paste here
    public void sendChatMessage(String messages,String adharnumber){
        System.out.println(messages);
        System.out.println(adharnumber);

        if (messages.equals("")) {
            messages ="Hello No Value";
        }

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit build = new Retrofit.Builder()
                .baseUrl("http://192.168.43.103")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ApiService api = build.create(ApiService.class);

        Call<ResponseBody> responseBodyCall = api.sendChat(messages,"",adharnumber);

        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.v("Response",response.body().toString());
                    System.out.println("url:"+response.raw().request().url());
                    Toast.makeText(BillNotify.this,"sent successfully", Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
