package com.wgabrechnung.manageme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class startseite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startseite);
    }

    public void openSettings(View V){
        Intent activitySetting = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(activitySetting);
    }

    //@todo implement correct class names
    public void openKonto(View V){
        Intent activityKonto = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(activityKonto);
    }

    public void openProjects(View V){
        Intent activityProjects = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(activityProjects);
    }

    public void openTodo(View V){
        Intent activityTodo = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(activityTodo);
    }

    public void openCalendar(View V){
        Intent activityCalendar = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(activityCalendar);
    }

}