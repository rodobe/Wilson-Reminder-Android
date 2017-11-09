package com.example.jesus.wilsonreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegistroWilson extends AppCompatActivity {
    EditText nombre, apellido, fechaNac, pass1, pass2, usuario;
    Button registro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_wilson);


        nombre= (EditText) findViewById(R.id.et_nombre);
        apellido= (EditText) findViewById(R.id.et_apellido);
        fechaNac= (EditText) findViewById(R.id.et_fechaNacimiento);
        pass1= (EditText) findViewById(R.id.et_1pass);
        pass2= (EditText) findViewById(R.id.et_2pass);
        usuario= (EditText) findViewById(R.id.et_usuario);
        registro= (Button) findViewById(R.id.tv_registrar);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg = new Intent(RegistroWilson.this, Login.class);
                startActivity(IntentReg);
            }
        });

    }
}

