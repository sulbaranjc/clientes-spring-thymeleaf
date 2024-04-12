package com.ilerna.clientes.service;
import com.ilerna.clientes.database.Conexion;
import com.ilerna.clientes.entity.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    Conexion c = new Conexion();
    public void alta(Cliente p) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        // Conversión de Date a String. tratamiento de la fecha para que sea aceptada por MySQL
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String strFechaFormateada = sdf.format(p.getFechaNacimiento());
        // estring de inserción
        String cadena = "INSERT INTO cliente(nombre, apellido, telefono, correo, direccion) VALUES ('"
                + p.getNombre() + "','"
                + p.getApellido() + "','"
                + p.getTelefono() + "','"
                + p.getCorreo() + "','"
                + p.getDireccion() + "');";
        //System.out.println(cadena);
        consulta.executeUpdate(cadena);
        consulta.close();
    }
    public List<Cliente> listar() throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM cliente");
        List<Cliente> lista = new ArrayList<>();

        while (rs.next()) {
            Cliente p = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("direccion")
            );
            lista.add(p);
        }
        rs.close();
        consulta.close();
        return lista;
    }
    public Cliente buscar(int id) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        ResultSet rs = consulta.executeQuery("SELECT * FROM cliente WHERE id = " + id);
        Cliente p = null;
        if (rs.next()) {
            p = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("direccion")
            );
        }
        rs.close();
        consulta.close();
        return p;
    }
    public void modificar(Cliente p) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        // Conversión de Date a String. tratamiento de la fecha para que sea aceptada por MySQL
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String strFechaFormateada = sdf.format(p.getFechaNacimiento());
        // String de actualización
        String cadena = "UPDATE cliente SET "
                + "nombre = '" + p.getNombre() + "', "
                + "apellido = '" + p.getApellido() + "', "
                + "telefono = '" + p.getTelefono() + "', "
                + "correo = '" + p.getCorreo() + "', "
                + "direccion = '" + p.getDireccion() + "' "
                + "WHERE id = " + p.getId();
        // System.out.println(cadena);
        consulta.executeUpdate(cadena);
        consulta.close();
    }
    public void eliminar(int id) throws SQLException {
        Statement consulta = c.conectar().createStatement();
        consulta.executeUpdate("DELETE FROM cliente WHERE id = " + id);
        consulta.close();
    }


}
