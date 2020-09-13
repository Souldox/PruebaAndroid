package com.example.prueba1android.DTO;

public class eventoDTO {

    public String nota,genero,artista,fecha;
    public int precio;


    public eventoDTO(String nota, String genero, String artista, String fecha, int precio) {
        this.nota = nota;
        this.genero = genero;
        this.artista = artista;
        this.fecha = fecha;
        this.precio = precio;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return artista + " " + genero + " "+precio+"$"+fecha+" "+nota+" ";
    }
}
