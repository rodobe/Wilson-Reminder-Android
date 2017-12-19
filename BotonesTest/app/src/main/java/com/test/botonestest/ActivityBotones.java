package com.test.botonestest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

//Toast.makeText(ActivityBotones.this, "", Toast.LENGTH_SHORT).show();

public class ActivityBotones extends AppCompatActivity {

    private Button botonCrear, botonNota;
    private LinearLayout linearLayout;
    private ScrollView scrollView;

    private Button[] buttonList = new Button[100];
    private Tarea[] taskList = new Tarea[100];

    private int listID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones);

        scrollView = findViewById(R.id.scrollView);
        linearLayout = findViewById(R.id.content);
        botonCrear = findViewById(R.id.crear_tarea);
        botonNota = findViewById(R.id.imageView);

        botonNota.setGravity(Gravity.START);
        esTareaMostable(botonNota, false);

        botonCrear.setOnClickListener(new View.OnClickListener() { // boton CREAR

            public void onClick(View view) {
                crearTarea();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case Activity.RESULT_OK:
                taskList[listID] = recibirDatos(data);

                botonNota.setText(taskList[listID].getNombre()+"\n"+taskList[listID].getFecha_limite());
                esTareaMostable(botonNota, true);
                Toast.makeText(this, "Tarea "+taskList[listID].getNombre()+" creada exitosamente!", Toast.LENGTH_SHORT).show();

                break;
            case Activity.RESULT_CANCELED:
                setMensaje("Creacion de nueva Tarea cancelada");
                break;
        }
    }

    void crearTarea() {
        Intent intent = new Intent(this, CrearTarea.class);
        final int CODIGO_ACTIVADO = 1;
        startActivityForResult(intent, CODIGO_ACTIVADO);
    }

    Tarea recibirDatos (Intent data){
        Uri dato = data.getData();
        String nombreTarea = data.getStringExtra("TASK_NAME");
        String categoriaTarea = data.getStringExtra("TASK_CATEGORIA");
        String descripcionTarea = data.getStringExtra("TASK_DESCRIPTION");
        String fechaCreacionTarea = data.getStringExtra("TASK_FECHA_CREACION");
        String fechaLimiteTarea = data.getStringExtra("TASK_FECHA_LIMITE");
        return  new Tarea(nombreTarea, categoriaTarea, descripcionTarea, fechaCreacionTarea, fechaLimiteTarea);
    }
    
    void editTask(int ID) {

    }

    void setMensaje(String mensaje) {
        TextView mostrador_ActivityBotones = findViewById(R.id.mostrador);
        mostrador_ActivityBotones.setText(mensaje);
    }
    void esTareaMostable (Button button, boolean activado){
        int visibilidad = View.INVISIBLE;
        if (activado)
            visibilidad = View.VISIBLE;
        button.setVisibility(visibilidad);
        button.setFocusable(activado);
    }
}



