package com.example.prueba1android.DAO;

import com.example.prueba1android.DTO.eventoDTO;
import com.example.prueba1android.R;

import java.util.ArrayList;
import java.util.List;

public class eventoDAO {




    public static int Nota=0;
    public static String Artista = null;
    public static String Genero = null;
    public static int Precio = 0;
    public static String Fecha = null;
    public static int rango =0;
    public static List<eventoDTO> eventos = new ArrayList<>();
    
    public static void crearEvento(){


        eventoDTO e = new eventoDTO();
        e.setArtista(Artista);
        e.setFecha(Fecha);
        e.setGenero(Genero);
        e.setPrecio(Precio);
        e.setNota(Nota);
        //condicion para seleccion de imagen
        if (rango==3){
            e.setImg(R.drawable.icono_genial);
            if (rango==2){
                e.setImg(R.drawable.icono_regular);
                if (rango==1){
                    e.setImg(R.drawable.icono_malo);
                }
            }
        }
        eventos.add(e);


    }
    
}
