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
public class Administrativo extends Persona {

    private String contrasena;

    public Administrativo(String id, String nombre, int edad, char genero, String contrasena) {
        super(id, nombre, edad, genero);
        this.contrasena = contrasena;
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
}
