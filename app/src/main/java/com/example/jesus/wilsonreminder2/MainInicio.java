package com.example.jesus.wilsonreminder2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainInicio extends AppCompatActivity {

    private  View activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tittle);
        setContentView(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public View getActivity() {
        return activity;
    }



    public void iniciarSesion(View view) {
        EditText usuario = (EditText)findViewById(R.id.txtUsuario);
        String usuariox = usuario.getText().toString();
        Pattern path = Pattern.compile(usuariox);
        Matcher match = path.matcher("/(0-9)/b");
        if (match.find()){
            Toast.makeText(MainInicio.this, "Usuario inválido", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(MainInicio.this, "Bienvenido", Toast.LENGTH_LONG).show();
            Intent login = new Intent(this, SaludoWilson.class);
            startActivity(login);
        }

    }

    public void registrarForm(View view) {
        Intent registrar = new Intent(this, RegistroUsuario.class);
        startActivity(registrar);
    }

}
