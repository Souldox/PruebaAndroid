package com.example.prueba1android.DAO;

import android.content.Context;

import com.example.prueba1android.DTO.eventoDTO;

import java.util.ArrayList;

public class eventoDAO extends eventoDTO {

    private Context context;
    private ArrayList<eventoDTO> listItem;

    public eventoDAO(String nota, String genero, String artista, String fecha, int precio, Context context, ArrayList<eventoDTO> listItem) {
        super(nota, genero, artista, fecha, precio);
        this.context = context;
        this.listItem = listItem;
    }



}
