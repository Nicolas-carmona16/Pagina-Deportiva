/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class Conexion {
    private static Connection con=null;
    private static final String url = "jdbc:mysql://localhost:3306/ejemplo001";
    private static final String user = "root"; 
    private static final String password = ""; 
    public static Connection Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            System.out.println("ERROR "+e);
        }
        return con;
    }

}
