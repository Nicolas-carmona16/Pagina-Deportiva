/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Persona;
import com.modeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    PersonaDAO dAO;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        List<Persona>personas=new ArrayList<>();
        switch(accion) {
            case "listar":
                dAO=new PersonaDAO();
                personas=dAO.getPersonas();
                request.setAttribute("Personas", personas);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "nuevo":
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
            case "Agregar":
                int r=0;
                String nombres=request.getParameter("txtNombres");
                String apellidos=request.getParameter("txtApellidos");
                String club=request.getParameter("txtClub");
                String seleccion=request.getParameter("txtSeleccion");
                Persona p = new Persona();
                p.setNombres(nombres);
                p.setApellidos(apellidos);
                p.setClub(club);
                p.setSeleccion(seleccion);
                r=dAO.add(p);
                if(r!=0) {
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "Successfully added");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                } else {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "Error when saving to database");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
            case "Editar":
                int id=Integer.valueOf(request.getParameter("id"));
                Persona persona=dAO.getId(id);
                request.setAttribute("persona", persona);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "Actualizar":
                String nombres1=request.getParameter("txtNombres");
                String apellidos1=request.getParameter("txtApellidos");
                String club1=request.getParameter("txtClub");
                String seleccion1=request.getParameter("txtSeleccion");
                int idPersona=Integer.valueOf(request.getParameter("txtId"));
                Persona per = new Persona(idPersona, nombres1, apellidos1, club1, seleccion1);
                int respuesta=dAO.update(per);
                if(respuesta!=0) {
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "Successfully updated");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                } else {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "Error updating in database");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
            case "Delete":
                int idperso=Integer.valueOf(request.getParameter("id"));
                int res=dAO.delete(idperso);
                if(res!=0) {
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "Successfully removed");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                } else {
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "Error when deleting in database");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
