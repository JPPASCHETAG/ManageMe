package com.wgabrechnung.manageme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class registrierung extends AppCompatActivity {

    EditText VORNAME;
    EditText NACHNAME;
    EditText MAIL;
    EditText PASSWORT;
    EditText PASSWORT_AGAIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrierung);

        //Eingabefelder setzen
        VORNAME = findViewById(R.id.VORNAME);
        NACHNAME = findViewById(R.id.NACHNAME);
        MAIL = findViewById(R.id.MAIL);
        PASSWORT = findViewById(R.id.PASSWORT);
        PASSWORT_AGAIN = findViewById(R.id.PASSWORT_AGAIN);


    }

    /**
     * Führt den Registrierungs versuch aus.
     * @param V View
     */
    public void register(View V){
        String strInputVorname = VORNAME.getText().toString();
        String strInputNachname = NACHNAME.getText().toString();
        String strinputMail = MAIL.getText().toString();
        String strInputPasswort = PASSWORT.getText().toString();
        String strInputPasswort2 = PASSWORT_AGAIN.getText().toString();


        if(strInputNachname.equals("") || strinputMail.equals("") || strInputPasswort.equals("") || strInputPasswort2.equals("")){

            Toast.makeText(getApplicationContext(),"Bitte alle Felder ausfüllen", Toast.LENGTH_LONG).show();
            return;
        }

        if(!strInputPasswort.equals(strInputPasswort2)){
            Toast.makeText(getApplicationContext(),"Passwort stimmt nicht überein!", Toast.LENGTH_LONG).show();
            return;
        }else{

            //Hier muss dann
            HashMap<String, String> URLparam = new HashMap<String, String>();
            URLparam.put("MODE","0");
            URLparam.put("VORNAME",strInputVorname);
            URLparam.put("NACHNAME",strInputNachname);
            URLparam.put("MAIL",strinputMail);
            URLparam.put("PASSWORT",strInputPasswort);
            String strURL = CORE_HELPER.CREATE_URL(URLparam);

            System.out.println(strURL);

            HTTP_REQUEST http_request = new HTTP_REQUEST(getApplicationContext(),0);
            http_request.execute(strURL);

        }

    }


}