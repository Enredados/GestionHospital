/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author alang
 */
public class Persona {
    protected String id;
    protected String  nombre;
    protected int edad;
    protected char genero;
    
    public Persona(String id, String nombre, int edad, char genero){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }
    
    public Persona(){
        
    }
    
    public String obtenerId(){
        return this.id;
    }    
    
    public String obtenerNombre(){
        return this.nombre;
    }
    
    public int obtenerEdad(){
        return this.edad;
    }
    
    public char obtenerGenero(){
        return this.genero;
    }
}
