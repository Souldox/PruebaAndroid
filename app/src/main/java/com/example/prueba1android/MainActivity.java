package com.example.prueba1android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    //Seccion Spinner Generos Musicales
    Spinner generosMusicales;

    //Seccion Calendario
    Button btnFecha;
    EditText txtFecha;
    private int dia,mes,anio;
    private String genero,nota;

    //Seccion Calificacion

    Spinner calificacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fecha concierto
        this.btnFecha = findViewById(R.id.btnFecha);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        btnFecha.setOnClickListener(this);

        //generos musicales
        generosMusicales=findViewById(R.id.spinnerGeneros);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.spinnerGeneros,
                                    android.R.layout.simple_spinner_item);
        generosMusicales.setAdapter(adapter);
        generosMusicales.setOnItemClickListener(this);


        //calificacion
        this.calificacion = findViewById(R.id.spinnerCalificacion);
        calificacion.setAdapter(adapter);
        calificacion.setOnItemClickListener(this);




    }
    @Override
    public void onClick(View view) {
        if (view ==btnFecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    txtFecha.setText(i2+ "/"+(i1+1)+"/"+i );
                }
            },dia,mes,anio);

            datePickerDialog.show();
        }
    }
    //FIN CALENDARIO

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (view==generosMusicales) {
            Toast.makeText(parent.getContext(),
                    "Genero Seleccionado: " + parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT).show();
            genero+= parent.getItemAtPosition(position).toString();
        }
        if (view==calificacion){
            Toast.makeText(parent.getContext(),
                    "Nota Seleccionada: " + parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT).show();
            nota+= parent.getItemAtPosition(position).toString();
        }

    }
    //Fin spinner Generos Musicales





}
