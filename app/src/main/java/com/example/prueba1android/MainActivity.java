package com.example.prueba1android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prueba1android.DAO.eventoDAO;
import com.example.prueba1android.DTO.eventoDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    //Seccion Spinner Generos Musicales
    Spinner generosMusicales;
    Spinner calificacion;
    //Seccion Calendario
    Button btnFecha;

    private int dia,mes,anio;
    private String genero,nota;

    Button btnAgregar;
    EditText artistaTxt;
    EditText txtFecha;
    EditText valorEntrada;
    ListView eventosLv;

    private ArrayAdapter<eventoDTO> evAdapter;
    private List<eventoDTO> eventos = new ArrayList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.eventosLv = findViewById(R.id.eventosLv);
        this.evAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,eventos);
        this.eventosLv.setAdapter(evAdapter);

        //fecha concierto
        this.btnFecha = findViewById(R.id.btnFecha);
        this.txtFecha = findViewById(R.id.txtFecha);
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

        //Errores


        //btnCrear
        this.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errores = new ArrayList<>();
                int Nota=0;
                String Artista = null;
                String Genero = null;
                int Precio = 0;
                String Fecha = null;
                int rango =0;

                try {
                    Nota = Integer.parseInt(calificacion.toString());
                    if (Nota <1.0 || Nota >3.0){
                        rango =1;
                    }
                    if (Nota >=4 || Nota <=5){
                        rango =2;
                    }
                    if (Nota >5 || Nota <=7){
                        rango =3;
                    }

                } catch (NumberFormatException e) {
                    errores.add("Debe ingresar una nota para clasificar el concierto");
                }

                try {
                    Artista+=artistaTxt.getText();
                    if (Artista == null){
                        errores.add("Debe ingresar un nombre de Artista");
                    }else{

                    }
                    Genero+= generosMusicales.getSelectedItem().toString();
                    if (Genero ==null){
                        errores.add("Debe ingresar el Genero Musical");
                    }
                    Fecha+=txtFecha.getText();
                    if (Fecha == null){
                        errores.add("Debe ingresar fecha del concierto");
                    }
                    Precio = Integer.parseInt(valorEntrada.getText().toString());
                    if (Precio < 1 ){
                        errores.add("Debe ingresar el valor de la entrada al concierto");
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                if (errores.isEmpty()){
                    eventoDAO.crearEvento();
                evAdapter.notifyDataSetChanged();

            }else {
                    mostrarErrores(errores);
                }
            }
        });

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
    //Fin spinner Generos Musicales y Calificacion

    public  void mostrarErrores(List<String> errores) {
        String mensaje = "";
        for (String e : errores) {
            mensaje += "-" + e + "\n";
        }

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("Error en el ingreso")
                .setMessage(mensaje)
                .setPositiveButton("Aceptar", null)
                .create()
                .show();
    }
}
