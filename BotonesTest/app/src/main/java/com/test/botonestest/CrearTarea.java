package com.test.botonestest;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CrearTarea extends AppCompatActivity {

    private boolean noException;
    private final String DATE_SEPARATOR = "-";
    ArrayList<String> categoriasList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tarea);

        setMensaje("Fecha de creacion: "+getFechaCreacion());

        inicializarCategoriasList();
        actualizarAutoCompleteCategoriasList();

        Button botonCrear = findViewById(R.id.crear);
        Button botonCancelar = findViewById(R.id.cancelar);

        Toast.makeText(CrearTarea.this, "introduzca datos para crear tarea", Toast.LENGTH_SHORT).show();

        botonCrear.setOnClickListener(new View.OnClickListener() { // boton CREAR

            public void onClick(View view) {
                enviarTareaCreada();
            }
        });
        botonCancelar.setOnClickListener(new View.OnClickListener() { // boton CANCELAR

            public void onClick(View view) {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });

    } // cierro OnCreate

    void enviarTareaCreada() {
        String taskNombre, taskCategoria, taskDescription, taskFechaCreacion , taskFechaLimite;
        Intent toSend;
        noException = true;
        taskNombre = getTaskNombre();
        taskCategoria = getTaskCategoria();
        taskDescription = getTaskDescripcion();
        taskFechaCreacion = getFechaCreacion();
        taskFechaLimite = checkedFechaLimite();

        if (noException) {
            Uri dato = Uri.parse("content://tarea_creada/");
            toSend = new Intent(null, dato);

            toSend.putExtra("TASK_NAME", taskNombre);
            toSend.putExtra("TASK_CATEGORIA", taskCategoria);
            toSend.putExtra("TASK_DESCRIPTION", taskDescription);
            toSend.putExtra("TASK_FECHA_CREACION", taskFechaCreacion);
            toSend.putExtra("TASK_FECHA_LIMITE", taskFechaLimite);

            setResult(RESULT_OK, toSend);
            finish();
        }
    }

    String getTaskNombre() {
        EditText editTextNombre = findViewById(R.id.field_nombre);
        String taskName = editTextNombre.getText().toString();
        try {
            checkText("Nombre", taskName, 20);
        } catch (StringTooLongException sl) {
            noException = false;
            Toast.makeText(this, sl.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (NullFieldException nl) {
            noException = false;
            Toast.makeText(this, nl.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return taskName;
    }

    String getTaskCategoria(){
        AutoCompleteTextView autoCompleteTextCategorias = findViewById(R.id.field_categorias);
        String taskCategoria = autoCompleteTextCategorias.getText().toString();
        try {
            checkText("Categoria", taskCategoria, 20);
            existeCategoria(taskCategoria);
        } catch (StringTooLongException sl) {
            noException = false;
            Toast.makeText(this, sl.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (NullFieldException nl) {
            noException = false;
            Toast.makeText(this, nl.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (InUseCategoryException iuc) {
            showDialogCategoriaOption(autoCompleteTextCategorias, taskCategoria);
        }

        return taskCategoria;
    }
    void existeCategoria(String categoria) throws InUseCategoryException{
        boolean existe = false;
        for (int i = 0; i<categoriasList.size(); i++)
            if (categoria.equalsIgnoreCase(categoriasList.get(i)))
                existe = true;
        if (existe==false)
            throw new InUseCategoryException(categoria);
    }
    void showDialogCategoriaOption(final AutoCompleteTextView autoCompleteTextView, final String str){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Categoria "+str+" no existe");
        builder.setMessage("como esta caegoria todavia no existe, deseas crearla o volver y usar una categoria ya existente?");
        builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { // boton "Crear" del dialog
                String message = "Se ha creado "+str+" como una nueva categoria";
                Toast.makeText(CrearTarea.this, message, Toast.LENGTH_SHORT).show();
                categoriasList.add(str);
                actualizarAutoCompleteCategoriasList();
            }
        });
        builder.setNegativeButton("Volver", new DialogInterface.OnClickListener() { // boton "cancelar" del dialog
            @Override
            public void onClick(DialogInterface dialog, int which) {
                autoCompleteTextView.showDropDown();
                noException = false;
                Toast.makeText(CrearTarea.this, "Elige una de las categorias existentes", Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();
    }

    String getTaskDescripcion() {
        EditText editTextDescripcion = findViewById(R.id.field_descripcion);
        String taskDescription = editTextDescripcion.getText().toString();
        try {
            checkText("Descripcion", taskDescription, 140);
        } catch (StringTooLongException sl) {
            noException = false;
            Toast.makeText(this, sl.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (NullFieldException nl) {
            noException = false;
            Toast.makeText(this, nl.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return taskDescription;
    }

    void checkText (String field, String text, int limit) throws StringTooLongException, NullFieldException {
        if (text.length() > limit) {
            throw new StringTooLongException(field+" de Tarea", limit);
        }
        if (text.length() == 0) {
            throw new NullFieldException(field);
        }
    }

    String getFechaCreacion() {
        Calendar calendar = Calendar.getInstance();
        String
                day = Integer.toString(calendar.get(Calendar.DATE)),
                month = Integer.toString(calendar.get(Calendar.MONTH)+1),
                year = Integer.toString(calendar.get(Calendar.YEAR));
        return day + DATE_SEPARATOR + month + DATE_SEPARATOR +year;
    }

    String checkedFechaLimite(){
        String fechaLimite = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fechaLimite = getFechaLimite();
            Date date = dateFormat.parse(fechaLimite); // de String a date
            fechaLimite = dateFormat.format(date); // de date a String nuevamente para detectar errores de parseo
        } catch (NullFieldException nl) {
            noException = false;
            Toast.makeText(this, nl.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (ParseException e) {
            noException = false;
            Toast.makeText(this, "Error en la fecha...", Toast.LENGTH_SHORT).show();
        } catch (InvalidDateException id){
            noException = false;
            Toast.makeText(this, id.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return fechaLimite;
    }

    String getFechaLimite() throws NullFieldException, InvalidDateException {
        EditText editText_day = findViewById(R.id.field_day);
        EditText editText_month = findViewById(R.id.field_month);
        EditText editText_year = findViewById(R.id.field_year);

        String day, month, year, limitDate;
        day = editText_day.getText().toString();
        month = editText_month.getText().toString();
        year = editText_year.getText().toString();
        limitDate = day + DATE_SEPARATOR + month + DATE_SEPARATOR +year;

        isNullDate(day, month, year);
        isLimitDateOlder(limitDate);
        return limitDate;
    }
    void isNullDate (String day, String month, String year) throws NullFieldException {
        if (day.length() == 0 || month.length() == 0 || year.length() == 0)
            throw new NullFieldException("Dia, Mes y Año");
    }

    void isLimitDateOlder(String limitDate) throws InvalidDateException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date limite = null, creacion = null;
        try {
            limite = dateFormat.parse(limitDate);
            creacion = dateFormat.parse(getFechaCreacion());
        } catch (ParseException e) {
            noException = false;
            Toast.makeText(this, "Error en la fecha...", Toast.LENGTH_SHORT).show();
        }
        if (limite.before(creacion))
            throw new InvalidDateException("Limite imposible");
    }

    void inicializarCategoriasList(){
        // algun ciclo que me permita obtener las categorias del usuario
        // para probar mientras se usaran estos valores
        categoriasList.add("Familia");
        categoriasList.add("Social");
        categoriasList.add("Trabajo");
        categoriasList.add("Estudios");
    }
    void actualizarAutoCompleteCategoriasList(){
        AutoCompleteTextView categoriaTextField = findViewById(R.id.field_categorias);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, categoriasList);
        categoriaTextField.setAdapter(adapter);
        categoriaTextField.setThreshold(1);
    }
    void setMensaje(String mensaje) {
        TextView editTextMensaje = findViewById(R.id.mensaje);
        editTextMensaje.setText(mensaje);
    }
}




