package com.example.jesus.wilsonreminder2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroUsuario extends AppCompatActivity {

    private View activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tittleRegistrar);
        setContentView(toolbar);

    }

    /*public View getActivity(){
        return activity;
    }*/

    /*public void validacionNombre(View view){
        EditText nombre = (EditText) getActivity().findViewById(R.id.txtNombre);
        if ()
    }*/

    public void registrado(View view){

        EditText nombres = (EditText)findViewById(R.id.txtNombre);
        String usuarioNombre = nombres.getText().toString();
        Pattern path = Pattern.compile(usuarioNombre);
        Matcher match = path.matcher("[0-9]/b"); //este es el peo XD no me sale esta validación
        if (match.find()){
            Toast.makeText(RegistroUsuario.this, "Usuario inválido", Toast.LENGTH_LONG).show();
            Intent registrar = new Intent(this, RegistroUsuario.class);
            startActivity(registrar);
        }
        EditText apellidos = (EditText)findViewById(R.id.txtApellido1);
        String usuarioApellido = nombres.getText().toString();
        Pattern path1 = Pattern.compile(usuarioApellido);
        Matcher match1 = path1.matcher("/(0-9)/b");
        if (match1.find()){
            Toast.makeText(RegistroUsuario.this, "Usuario inválido", Toast.LENGTH_LONG).show();
            Intent registrar = new Intent(this, RegistroUsuario.class);
            startActivity(registrar);
        }

        EditText contraseñas = (EditText)findViewById(R.id.txtContraseñaReg);
        String usuarioContraseña = nombres.getText().toString();
        Pattern path3 = Pattern.compile(usuarioContraseña);
        Matcher match3 = path3.matcher("/(0-9)/b");
        if (match3.find()){
            Toast.makeText(RegistroUsuario.this, "Usuario inválido", Toast.LENGTH_LONG).show();
            Intent registrar = new Intent(this, RegistroUsuario.class);
            startActivity(registrar);
        }
        EditText confirmContraseñas = (EditText)findViewById(R.id.txtContraseñaRegConfirm);
        String usuarioConfContraseña = nombres.getText().toString();
        Pattern path4 = Pattern.compile(usuarioConfContraseña);
        Matcher match4 = path4.matcher("/(0-9)/b");
        if (match4.find()){
            Toast.makeText(RegistroUsuario.this, "Usuario inválido", Toast.LENGTH_LONG).show();
            Intent registrar = new Intent(this, RegistroUsuario.class);
            startActivity(registrar);
        }
        //DatePicker fechaNac = (DatePicker) findViewById(R.id.datePicker);

        String n,a,a2,c,confC;
        n = nombres.getText().toString();
        a = apellidos.getText().toString();
        c = contraseñas.getText().toString();
        confC = confirmContraseñas.getText().toString();
        JSONObject usuario = new JSONObject();
        try{
            usuario.put("Nombre", n);
            usuario.put("Primer Apellido", a);
            usuario.put("Contraseña", c);
            usuario.put("Confirmación de Contraseña", confC);
        }catch(JSONException error){}
        Intent login = new Intent(this, MainInicio.class);
        startActivity(login);
    }

}
