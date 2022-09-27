/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modeloDAO;

import com.modelo.Persona;
import java.util.List;

/**
 *
 * @author PC
 */
public interface InterfacePersonaDAO {
    public List<Persona>getPersonas();
    public Persona getId(int id);
    public int add(Persona p);
    public int update(Persona p);
    public int delete(int id);
}
