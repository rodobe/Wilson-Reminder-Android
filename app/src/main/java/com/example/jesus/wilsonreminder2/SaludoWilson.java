package com.example.jesus.wilsonreminder2;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.zip.Inflater;

public class SaludoWilson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo_wilson);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tittleSaludo);
        setSupportActionBar(toolbar);

    }
}
