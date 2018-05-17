package com.cybernaptics.rfidv3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DisplayProduct extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper db;
    ListView displayProd;
    Cursor cursor;
    ListAdapterProduct listAdapterProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);
        db = new DatabaseHelper(getApplicationContext());

        displayProd = (ListView)findViewById(R.id.displayProd);
        sqLiteDatabase = db.getReadableDatabase();
        cursor = db.getProduct();
        listAdapterProduct = new ListAdapterProduct(getApplicationContext(),R.layout.row_product);
        displayProd.setAdapter(listAdapterProduct);

        if(cursor.moveToFirst()){
            do {

                String name, weight, bin;
                name=cursor.getString(1);
                weight=cursor.getString(2);
                bin=cursor.getString(3);
                DataProviderProduct dataProviderProduct = new DataProviderProduct(name, weight,bin);
                listAdapterProduct.add(dataProviderProduct);

            }
                while (cursor.moveToNext());
            }
        }
    }

