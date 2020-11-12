package com.wgabrechnung.manageme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    String USER_ID;
    Boolean STAY_LOGGED_IN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        USER_ID = sharedPreferences.getString("UNIQUE_ID", "noID");
        STAY_LOGGED_IN = sharedPreferences.getBoolean("STAY_LOGGED_IN", false);

        //wenn keine id gestezt ist einen Dialog um alle SystemVariablen zu setzen
        if(USER_ID.equals("noID") || !STAY_LOGGED_IN){

            if(USER_ID.equals("noID")){
                //Zur Registrierung weiterleiten
                Intent activityRegister = new Intent(getApplicationContext(),registrierung.class);
                startActivity(activityRegister);
            }else{
                //Zum logIn weiterleiten
                Intent activityLogIn = new Intent(getApplicationContext(), LogIn.class);
                startActivity(activityLogIn);
            }

        }else{
            //Variablen setzen
            CORE_SETTINGS core_settings = new CORE_SETTINGS();
            //und Startseite öffnen
            Intent activityStartseite = new Intent(getApplicationContext(), startseite.class);
            startActivity(activityStartseite);
        }
    }
}