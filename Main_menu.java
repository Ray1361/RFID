package com.cybernaptics.rfidv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_menu extends AppCompatActivity {

    Button viewProduct, editProduct, viewBin, editBin, addProduct, addBin, logout;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        db = new DatabaseHelper(this);

        viewProduct = (Button) findViewById(R.id.viewProduct);
        editProduct = (Button) findViewById(R.id.editProduct);
        viewBin = (Button) findViewById(R.id.viewBin);
        editBin = (Button) findViewById(R.id.editBin);
        addProduct = (Button) findViewById(R.id.addProduct);
        addBin = (Button) findViewById(R.id.addBin);
        logout = (Button) findViewById(R.id.logout);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main_menu.this, AddProduct.class);
                startActivity(i);
            }
        });

        viewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewProduct = new Intent(Main_menu.this, DisplayProduct.class);
                startActivity(viewProduct);
            }
        });

    }
}
