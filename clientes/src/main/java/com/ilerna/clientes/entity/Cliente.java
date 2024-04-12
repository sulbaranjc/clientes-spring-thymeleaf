package com.ilerna.clientes.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Cliente {
    private int id; // Autoincremental, no incluido en el constructor
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String telefono, String correo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Cliente(int id, String nombre, String apellido, String telefono, String correo, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    @Override
    public String toString() {

        return String.format("%-4d %-20s %-20s %-15s %-25s %-35s",
                id,
                nombre,
                apellido,
                telefono,
                correo,
                direccion);
    }
}

