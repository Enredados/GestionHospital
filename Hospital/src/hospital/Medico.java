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
 * @author alang Comentario de prueba
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
        return "ID:" + _id + ";Nombre:" + _nombre + ";Edad:" + _edad
                + ";Género:" + _genero + ";Especialidad:" + especialidad
                + ";Contraseña:" + contrasena;
    }

    public void setearID(String id) {
        this._id = id;
    }

    public void darFormato() {
        if (_id.length() < 5) {
            for (int i = _id.length(); i < 5; i++) {
                _id += " ";
            }
        } else {
            _id = _id.substring(0, 5);
        }

        if (_nombre.length() < 20) {
            for (int i = _nombre.length(); i < 20; i++) {
                _nombre += " ";
            }
        } else {
            _nombre = _nombre.substring(0, 20);
        }

        if (especialidad.length() < 20) {
            for (int i = especialidad.length(); i < 20; i++) {
                especialidad += " ";
            }
        } else {
            especialidad = especialidad.substring(0, 20);
        }

        if (contrasena.length() < 10) {
            for (int i = contrasena.length(); i < 10; i++) {
                contrasena += " ";
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
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");

            if (archivo.length() != 0) {
                archivo.seek(archivo.length());
            }                                       // TAMAÑO EN BYTES (incluido los 2 del writeUtf)
            archivo.writeUTF(_id);                  // 7
            archivo.writeUTF(_nombre);              // 22
            archivo.writeInt(_edad);                // 4
            archivo.writeChar(_genero);             // 1    2
            archivo.writeUTF(especialidad);         // 23
            archivo.writeUTF(contrasena);           // 12
            archivo.close();                        // TOTAL: 70 por registro

        } catch (IOException e) {
            System.out.println("error en el ingreso");
        }
    }

}
