package com.cybernaptics.rfidv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    DatabaseHelper db;

    EditText prodName, prodWei, prodBin;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        db = new DatabaseHelper(this);

        prodName = (EditText) findViewById(R.id.prodName);
        prodWei = (EditText) findViewById(R.id.prodWei);
        prodBin = (EditText) findViewById(R.id.prodBin);

        add = (Button) findViewById(R.id.btnadd);

   add.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           String s1 = prodName.getText().toString();
           String s2 = prodWei.getText().toString();
           String s3 = prodBin.getText().toString();

           if (s1.equals("") || s2.equals("") || s3.equals("")){
               Toast.makeText(getApplicationContext(), "Fill in empty field(s)", Toast.LENGTH_LONG).show();
           } else {
               Boolean productinsert = db.productinsert(s1,s2,s3);
               if (productinsert == true) {
                   Toast.makeText(getApplicationContext(), "Insertion, complete", Toast.LENGTH_LONG).show();
               }
               if (productinsert == false){
                   Toast.makeText(getApplicationContext(), "Retry", Toast.LENGTH_LONG).show();
               }
           }
       }

     });

    }
}
