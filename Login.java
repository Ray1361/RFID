package com.cybernaptics.rfidv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText mail, password1;

    Button login;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);

        mail = (EditText) findViewById(R.id.editText3);
        password1 = (EditText) findViewById(R.id.editText4);

        login = (Button) findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mail.getText().toString();
                String password = password1.getText().toString();
                Boolean Checkmailpass = db.emailpassword(email, password);
                if(Checkmailpass==true) {
                    Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, Main_menu.class);
                    startActivity(intent);
                }
                else
                   Toast.makeText(getApplicationContext(), "Retry", Toast.LENGTH_LONG).show();

            }
        });
    }
}


