/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author alang
 */
public class Administrativo extends Persona {

    private String contrasena;

    public Administrativo(String id, String nombre, int edad, char genero, String contrasena) {
        super(id, nombre, edad, genero);
        this.contrasena = contrasena;
    }
    public Administrativo(){
        
    }

    public String obtenerContrasena() {
        return this.contrasena;
    }

    public void actualizarContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String obtenerInformacion() {
        return "ID:" + _id + ";Nombre:" + _nombre + ";Edad:" + _edad
                + ";Género:" + _genero + ";Contraseña:" + contrasena;
    }
    
    public void guardar() {
        String raiz = System.getProperty("user.dir");
        try {
            File arch = new File(raiz + "\\ADMINISTRATIVO.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");
            darFormato();

            if (archivo.length() != 0) {
                archivo.seek(archivo.length());
                archivo.writeUTF(_id);
                archivo.writeUTF(_nombre);
                archivo.writeInt(_edad);
                archivo.writeChar(_genero);
                archivo.writeUTF(contrasena);
                archivo.close();
            } else {
                archivo.writeUTF(_id);
                archivo.writeUTF(_nombre);
                archivo.writeInt(_edad);
                archivo.writeChar(_genero);
                archivo.writeUTF(contrasena);
                archivo.close();
            }
        } catch (IOException e) {
            System.out.println("Error en el ingreso");
        }

    }
    
    public void darFormato(){
        if(_id.length() < 5){
           for(int i = _id.length(); i < 5; i++){
                _id +=" ";
            }
        }
        else {
            _id = _id.substring(0,5);
        }
        
        if(_nombre.length() < 25){
           for(int i = _nombre.length(); i < 25; i++){
                _nombre +=" ";
            }
        }
        else {
            _nombre = _nombre.substring(0,25);
        }
        
        if(contrasena.length() < 10){
           for(int i = contrasena.length(); i < 10; i++){
                contrasena +=" ";
            }
        }
        else {
            contrasena = contrasena.substring(0,10);
        }
    }
}
