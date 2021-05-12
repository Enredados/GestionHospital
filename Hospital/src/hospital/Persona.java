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
    protected String _id;
    protected String  _nombre;
    protected int _edad;
    protected char _genero;
    
    public Persona(String id, String nombre, int edad, char genero){
        this._id = id;
        this._nombre = nombre;
        this._edad = edad;
        this._genero = genero;
    }
    
    public Persona(){
        
    }
    
    public String obtenerId(){
        return _id;
    }    
    
    public String obtenerNombre(){
        return _nombre;
    }
    
    public void setearNombre(String nombre){
        this._nombre = nombre;
    }
    
    public int obtenerEdad(){
        return _edad;
    }
    
    public char obtenerGenero(){
        return _genero;
    }
}
