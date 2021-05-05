    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;

/**
 *
 * @author alang
 */
    public class Medico extends Persona {
    private String especialidad;
    private ArrayList<Paciente> pacientes;
    private String contrasena;
    
    public Medico(String id, String nombre, int edad, char genero, String especialidad, String contrasena){
        super(id, nombre, edad, genero);
        this.especialidad = especialidad;
        pacientes = new ArrayList<Paciente>();
        this.contrasena = contrasena;
    }
    public Medico(){
  
    }
    public String obtenerEspecialidad(){
        return this.especialidad;
    }
    
    public ArrayList<Paciente> obtenerPacientes(){
        return this.pacientes;
    }
    
    public void agregarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }
    
    public String obtenerContrasena(){
        return this.contrasena;
    }
    
    public void actualizarContrasena(String contrasena){
        this.contrasena = contrasena;   
    }
    public String obtenerInformacion(){
        return "ID:" + id +";Nombre:" + nombre +";Edad:" + edad +
                ";Género:" + genero +";Especialidad:" + especialidad +
                ";Contraseña:" + contrasena;
    }
}
