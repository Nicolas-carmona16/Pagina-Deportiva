/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author PC
 */
public class Persona {
    private int id;
    private String nombres;
    private String apellidos;
    private String club;
    private String seleccion;

    public Persona(int id, String nombres, String apellidos, String club, String seleccion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.club = club;
        this.seleccion = seleccion;
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
    
    public String getSeleccion() {
        return seleccion;
    }
    
    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }
    
}
