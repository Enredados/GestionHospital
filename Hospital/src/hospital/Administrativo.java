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
        return "ID:" + id + ";Nombre:" + nombre + ";Edad:" + edad
                + ";Género:" + genero + ";Contraseña:" + contrasena;
    }
    
    public void guardar() {
        String raiz = System.getProperty("user.dir");
        try {
            File arch = new File(raiz + "\\ADMINISTRATIVO.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");
            darFormato();

            if (archivo.length() != 0) {
                archivo.seek(archivo.length());
                archivo.writeUTF(id);
                archivo.writeUTF(nombre);
                archivo.writeInt(edad);
                archivo.writeChar(genero);
                archivo.writeUTF(contrasena);
                archivo.close();
            } else {
                archivo.writeUTF(id);
                archivo.writeUTF(nombre);
                archivo.writeInt(edad);
                archivo.writeChar(genero);
                archivo.writeUTF(contrasena);
                archivo.close();
            }
        } catch (IOException e) {
            System.out.println("Error en el ingreso");
        }

    }
    
    public void darFormato(){
        if(id.length() < 5){
           for(int i = id.length(); i < 5; i++){
                id +=" ";
            }
        }
        else {
            id = id.substring(0,5);
        }
        
        if(nombre.length() < 25){
           for(int i = nombre.length(); i < 25; i++){
                nombre +=" ";
            }
        }
        else {
            nombre = nombre.substring(0,25);
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
