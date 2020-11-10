package com.wgabrechnung.manageme;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class KontoAdapter extends ArrayAdapter {

    private final Activity context;

    private final String[] nameArray;
    private final String[] betragArray;
    private final String[] artArray;


    public KontoAdapter(Activity context, String[] arrName, String[] arrBetrag, String[] arrArt){

        super(context,R.layout.konto_list_item);

        this.nameArray = arrName;
        this.betragArray = arrBetrag;
        this.artArray = arrArt;
        this.context = context;
    }

    @NotNull
    public View getView(int position, View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        @SuppressLint("ViewHolder")
        View rowView=inflater.inflate(R.layout.konto_list_item, null,true);
        rowView.setId(View.generateViewId());

        //Die einzelnen Komponenten im ListView
        TextView nameTextField = rowView.findViewById(R.id.UmsatzName);
        TextView betragTextField = rowView.findViewById(R.id.UmsatzBetrag);
        TextView ArtTextField = rowView.findViewById(R.id.UmsatzArt);

        //this code sets the values of the objects to values from the arrays
        if(nameArray.length == 0){
            nameTextField.setText("Es wurden noch keine Projekte angelegt");
        }else {
            nameTextField.setText(nameArray[position]);
            betragTextField.setText(betragArray[position]);
            ArtTextField.setText(artArray[position]);

        }


        return rowView;

    }

}
