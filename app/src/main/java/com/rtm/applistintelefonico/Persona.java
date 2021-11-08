package com.rtm.applistintelefonico;

public class Persona {
    private String nombre;
    private char genero;
    private String numero;
    public Persona(String nombre,char genero, String num){
        this.nombre=nombre;
        this.genero=genero;
        this.numero = num;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
