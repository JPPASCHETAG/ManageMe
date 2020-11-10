package com.wgabrechnung.manageme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;
import java.util.HashMap;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        TextView register = findViewById(R.id.REGISTER_TEXT);
        register.setClickable(true);
        register.setMovementMethod(LinkMovementMethod.getInstance());

    }

    /**
     * Öffnet die Activity zur Registrierung
     * @param V View
     */
    public void openRegistrierung(View V){

        Intent activityRegister = new Intent(getApplicationContext(), registrierung.class);
        startActivity(activityRegister);

    }

    /**
     * Onclick LogIN
     * @param V View
     */
    public void loginBtn(View V){

        EditText mail = findViewById(R.id.LOGIN_MAIL);
        EditText passwort = findViewById(R.id.LOGIN_PASWORD);

        login(mail.getText().toString(),passwort.getText().toString(),null);

    }


    public void login(String strMail, String strPasswort, Context context){

         HashMap<String,String> URLparam = new HashMap<String,String>();
        URLparam.put("MAIL",strMail);
        URLparam.put("PASSWORT",strPasswort);
        URLparam.put("MODE","1");
        String strURL = CORE_HELPER.CREATE_URL(URLparam);

        if(context == null){
            context = getApplicationContext();
        }

        HTTP_REQUEST http_request = new HTTP_REQUEST(context,1);
        http_request.execute(strURL);


    }
}