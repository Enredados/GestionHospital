/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author alang
 * Comentario de prueba
 */
public class Medico extends Persona {

    private String especialidad;
    private ArrayList<Paciente> pacientes;
    private String contrasena;

    public Medico(String id, String nombre, int edad, char genero, String especialidad, String contrasena) {
        super(id, nombre, edad, genero);
        this.especialidad = especialidad;
        pacientes = new ArrayList<Paciente>();
        this.contrasena = contrasena;
    }

    public Medico() {

    }

    public String obtenerEspecialidad() {
        return this.especialidad;
    }

    public ArrayList<Paciente> obtenerPacientes() {
        return this.pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public String obtenerContrasena() {
        return this.contrasena;
    }

    public void actualizarContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String obtenerInformacion() {
        return "ID:" + id + ";Nombre:" + nombre + ";Edad:" + edad
                + ";Género:" + genero + ";Especialidad:" + especialidad
                + ";Contraseña:" + contrasena;
    }

    public void darFormato() {
        if (id.length() < 5) {
            for (int i = id.length() - 1; i < 5; i++) {
                id += "";
            }
        } else {
            id = id.substring(0, 5);
        }

        if (nombre.length() < 20) {
            for (int i = nombre.length() - 1; i < 20; i++) {
                nombre += "";
            }
        } else {
            nombre = nombre.substring(0, 20);
        }

        if (especialidad.length() < 20) {
            for (int i = especialidad.length() - 1; i < 20; i++) {
                especialidad += "";
            }
        } else {
            especialidad = especialidad.substring(0, 20);
        }

        if (contrasena.length() < 10) {
            for (int i = contrasena.length() - 1; i < 10; i++) {
                contrasena += "";
            }
        } else {
            contrasena = contrasena.substring(0, 10);
        }
    }

    public void guardar() {
        String raiz = System.getProperty("user.dir");
        try {
            darFormato();
            File arch = new File(raiz + "\\MEDICOS.dat");
            System.out.println(raiz);
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");

            if (archivo.length() != 0) {
                archivo.seek(archivo.length());
                archivo.writeUTF(id);
                archivo.writeUTF(nombre);
                archivo.writeInt(edad);
                archivo.writeChar(edad);
                archivo.writeUTF(especialidad);
                archivo.writeUTF(contrasena);
                archivo.close();
            } else {
                archivo.writeUTF(id);
                archivo.writeUTF(nombre);
                archivo.writeInt(edad);
                archivo.writeChar(edad);
                archivo.writeUTF(especialidad);
                archivo.writeUTF(contrasena);
                archivo.close();
            }
        } catch (IOException e) {
            System.out.println("error en el ingreso");
        }
    }

}
