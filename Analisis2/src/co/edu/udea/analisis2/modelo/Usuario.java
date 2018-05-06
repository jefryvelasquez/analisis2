/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.analisis2.modelo;

import java.util.List;

/**
 *
 * @author Telecentro
 */
public class Usuario extends Persona{
    
    List <Prestamo> prestamos;
    List <Reserva>  reservas;

    public Usuario() {
    }

    public Usuario(String id, String nombres, String apellidos, char genero, String edad, String telefono, String email, String contraseña) {
        super(id, nombres, apellidos, genero, edad, telefono, email, contraseña);
    }
    
    
     
}
