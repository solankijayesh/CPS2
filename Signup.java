package com.example.damo.djg;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Signup extends AppCompatActivity {
    Spinner s;
    EditText e1, e3, e4, e5, e6, e7, e8;
    final String[] choices = {"Select Area","North Coimbatore","Kavundampalayam","Saravanampatti","rspuram","Gandhipuram","Saibabacolony","Thudiyalur"};
    String name = null, contact = null, dob = null, age = null, adharnumber = null, password = null, address = null, returnedstring;
    HttpClient httpclient;
    String area ="";
    HttpPost httppost;
    ResponseHandler<String> response;
    List<NameValuePair> nameValuePairs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        e1 = (EditText) findViewById(R.id.name);
        e3 = (EditText) findViewById(R.id.contact);
        e4 = (EditText) findViewById(R.id.dob);
        e5 = (EditText) findViewById(R.id.age);
        e6 = (EditText) findViewById(R.id.adharnumber);
        e7 = (EditText) findViewById(R.id.password);
        e8 = (EditText) findViewById(R.id.address);
        s=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> a = new ArrayAdapter<String>(Signup.this, android.R.layout.simple_spinner_item, choices);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);
        nameValuePairs = new ArrayList<NameValuePair>();
        httpclient = new DefaultHttpClient();
        response = new BasicResponseHandler();

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                area = (String) parent.getItemAtPosition(position);
                //Toast.makeText(parent.getContext(), "Selected: " + area, Toast.LENGTH_LONG).show();

                // Notify the selected item text
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


/*    public void Reload(View v) {
        name = e1.getText().toString();
        address = e2.getText().toString();
        contact = e3.getText().toString();
        dob = e4.getText().toString();
        age = e5.getText().toString();
        adharnumber = e6.getText().toString();
        password = e7.getText().toString();
        gender = e8.getText().toString();
       if (name.equals("") || address.equals("")  || contact.equals("")  || dob.equals("")  || age.equals("") || adharnumber.equals("")  || password.equals("")  || gender.equals("") ) {
            Toast.makeText(getApplicationContext(), "Please enter all the details", Toast.LENGTH_LONG).show();
        } else {
            nameValuePairs.add(new BasicNameValuePair("name", name));
            nameValuePairs.add(new BasicNameValuePair("address", address));
            nameValuePairs.add(new BasicNameValuePair("contact", contact));
            nameValuePairs.add(new BasicNameValuePair("dob", dob));
            nameValuePairs.add(new BasicNameValuePair("age", age));
            nameValuePairs.add(new BasicNameValuePair("adharnumber", adharnumber));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            nameValuePairs.add(new BasicNameValuePair("gender", gender));
            httppost = new HttpPost("http://10.0.2.2/useracc.php");
            try {
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8));
                returnedstring = httpclient.execute(httppost, response);
                Intent i = new Intent(Signup.this, ServiceMenu.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), returnedstring, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Hello"+e.toString(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }

    }*/


    public void Reload(View v) {
        name = e1.getText().toString();
        //address = e2.getText().toString();
        contact = e3.getText().toString();
        dob = e4.getText().toString();
        age = e5.getText().toString();
        adharnumber = e6.getText().toString();
        password = e7.getText().toString();
        address = e8.getText().toString();

        if (name.equals("") || area.equals("")|| contact.equals("") || dob.equals("") || age.equals("") || adharnumber.equals("") || password.equals("") || address.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter all the details", Toast.LENGTH_LONG).show();
        } else {
            // Change base URL to your upload server URL.
            Retrofit build = new Retrofit.Builder()
                    .baseUrl("http://192.168.43.103")
                    .build();
            ApiService service = build.create(ApiService.class);

            System.out.println("Token:"+SharedPrefManager.getInstance(Signup.this).getDeviceToken());

            Call<ResponseBody> call = service.signUp(name, area, contact, dob, age, adharnumber, password, address,SharedPrefManager.getInstance(Signup.this).getDeviceToken());

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    // Do
                    if (response.isSuccessful()) {
                        Toast.makeText(Signup.this, "Sign up", Toast.LENGTH_SHORT).show();
                        try {
                            System.out.println(response.body().string() + ":Successful");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Url:" + response.raw().request().url());
                        Intent i = new Intent(Signup.this,ServiceMenu.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(Signup.this, "Fails", Toast.LENGTH_SHORT).show();
                        System.out.println("Url:" + response.raw().request().url());
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();

                }
            });
        }
    }
}





















