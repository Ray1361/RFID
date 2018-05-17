package com.cybernaptics.rfidv3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapterProduct extends ArrayAdapter {
    List list = new ArrayList();
    public ListAdapterProduct(@NonNull Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler {
        TextView NAME, WEIGHT, BIN;
    }

    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    public int getCount(){
        return list.size();
    }

    public Object getItem(int position){
        return  list.get(position);
    }

    public View getView(int position, View convetView, ViewGroup parent){
        View row = convetView;
        LayoutHandler layoutHandler;
        if (row==null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_product,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME=(TextView)row.findViewById(R.id.prodName);
            layoutHandler.WEIGHT=(TextView)row.findViewById(R.id.prodWeight);
            layoutHandler.BIN=(TextView)row.findViewById(R.id.prodBin);
            row.setTag(layoutHandler);

        }else {
            layoutHandler = (LayoutHandler)row.getTag();
        }

        DataProviderProduct dataProviderProduct = (DataProviderProduct)this.getItem(position);
        layoutHandler.NAME.setText(dataProviderProduct.getName());
        layoutHandler.WEIGHT.setText(dataProviderProduct.getWeight());
        layoutHandler.BIN.setText(dataProviderProduct.getBin());

        return row;
    }
}
