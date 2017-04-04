package com.example.damo.djg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        final EditText username= (EditText) findViewById(R.id.editText);
        final EditText password= (EditText) findViewById(R.id.editText2);
        Button login= (Button) findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("user") && password.getText().toString().equals("user"))
                {
                    Toast.makeText(AdminLogin.this,"logging in",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(AdminLogin.this,AdminServices.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(AdminLogin.this,"Error in logging in",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
