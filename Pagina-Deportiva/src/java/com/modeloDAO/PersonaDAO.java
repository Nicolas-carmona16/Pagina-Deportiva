/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modeloDAO;

import com.config.Conexion;
import com.modelo.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class PersonaDAO implements InterfacePersonaDAO{

    @Override
    public List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>();
        String sql="Select * from persona";
        try {
         PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Persona p=new Persona();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setApellidos(rs.getString(3));
                p.setClub(rs.getString(4));
                p.setSeleccion(rs.getString(5));
                personas.add(p);
            }
        } catch (Exception e) {
            System.out.println("ERROR "+e);
        }
        return personas;
    }

    @Override
    public Persona getId(int id) {
        String sql="Select * from persona where idPersona=?";
        Persona persona=new Persona();
        try {
         PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
         ps.setInt(1,id);
         ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                persona.setId(rs.getInt(1));
                persona.setNombres(rs.getString(2));
                persona.setApellidos(rs.getString(3));
                persona.setClub(rs.getString(4));
                persona.setSeleccion(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("ERROR "+e);
        }
        return persona;
    }

    @Override
    public int add(Persona p) {
        int resultado=0;
        String sql="insert into persona(Nombres,Apellidos,Club,Seleccion)values(?,?,?,?)";
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellidos());
            ps.setString(3, p.getClub());
            ps.setString(4, p.getSeleccion());
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("EROOR to add in DB"+e);
        }
        return resultado;
    }

    @Override
    public int update(Persona p) {
        int resultado=0;
        String sql="update persona set Nombres=?,Apellidos=?,Club=?,Seleccion=? where idPersona=?";
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getApellidos());
            ps.setString(3, p.getClub());
            ps.setString(4, p.getSeleccion());
            ps.setInt(5, p.getId());
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("EROOR to update in DB"+e);
        }
        return resultado;
    }

    @Override
    public int delete(int id) {
        int resultado=0;
        String sql="delete from persona where idPersona="+id;
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("EROOR to delete in DB"+e);
        }
        return resultado;
    }
    
}
