package com.example.damo.djg;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayBills extends AppCompatActivity implements View.OnClickListener {

   private TextView textViewResult;
    ArrayList<String> map;

    //private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_bills);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        onInvoke("http://192.168.43.103");
    }
    //loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);
    public void onInvoke(String url) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit build = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ApiService api = build.create(ApiService.class);

        Call<List<ExResponse>> responseBodyCall = api.getData();

        responseBodyCall.enqueue(new Callback<List<ExResponse>>() {
            @Override
            public void onResponse(Call<List<ExResponse>> call, retrofit2.Response<List<ExResponse>> response) {
                if (response.isSuccessful()) {
                    textViewResult.setText("Adharnumber:\t" + response.body().get(0).getAdharnumber() + "\nAmunt:\t" +  response.body().get(0).getAmount() + "\nStatus:\t" +  response.body().get(0).getStatus() + "\nDate:\t" +  response.body().get(0).getDate());

                }
            }
            @Override
            public void onFailure(Call<List<ExResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }



    @Override
    public void onClick(View v) {

    }
}