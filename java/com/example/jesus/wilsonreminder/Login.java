package com.example.jesus.wilsonreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView registrar;
    EditText usuario;
    EditText pass;
    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registrar= (TextView) findViewById(R.id.tv_registrar);
        usuario= (EditText) findViewById(R.id.et_usuario);
        pass= (EditText) findViewById(R.id.et_pass);
        entrar= (Button) findViewById(R.id.btn_entrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentReg = new Intent(Login.this, SaludoWilson.class);
                startActivity(IntentReg);
            }
        });
    }
}
