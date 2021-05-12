/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author alang
 */
public class Paciente extends Persona {

    private String diagnostico;
    private Habitacion habitacion;
    private Medico medico;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;

    public Paciente(String id, String nombre, int edad, char genero, Medico medico, Habitacion habitacion, LocalDateTime fechaIngreso) {
        super(id, nombre, edad, genero);
        this.medico = medico;

        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        diagnostico = "";
    }

    public void agregarDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String obtenerDiagnostico() {
        return this.diagnostico;
    }

    public Habitacion obtenerHabitacion() {
        return this.habitacion;
    }

    public Medico obtenerMedico() {
        return this.medico;
    }

    public LocalDateTime obtenerFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setearFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime obtenerFechaSalida() {
        return this.fechaSalida;
    }

    public String[] obtenerDatosPaciente() {

        return new String[]{id, nombre, String.valueOf(edad), String.valueOf(genero), habitacion.obtenerCodigo(), String.valueOf(fechaIngreso), diagnostico};
    }

    public String obtenerDatosString() {
        return "ID:" + id + ";Nombre:" + nombre + ";Edad:" + edad + ";Género:" + genero + ";Habitación:" + habitacion.obtenerCodigo() + ";FechaIngreso:" + fechaIngreso + ";Diagnóstico:" + diagnostico + "\n";
    }

    public void setearNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setearEdad(int edad) {
        this.edad = edad;
    }

    public void setearGenero(char genero) {
        this.genero = genero;
    }

    public void borrarMedico() {
        medico = new Medico();
    }

    public void setearHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String obtenerInformacion() {
        return "ID:" + id + ";Nombre:" + nombre + ";Edad:" + edad
                + ";Género:" + genero + ";Habitación:" + habitacion.obtenerCodigo() + ";Médico:" + medico.obtenerId() + ";FechaIngreso:" + String.valueOf(fechaIngreso);
    }

    public void darFormato() {
        if (id.length() < 5) {
            for (int i = id.length(); i < 5; i++) {
                id += " ";
            }
        } else {
            id = id.substring(0, 5);
        }

        if (nombre.length() < 20) {
            for (int i = nombre.length(); i < 20; i++) {
                nombre += " ";
            }
        } else {
            nombre = nombre.substring(0, 20);
        }

        String aux = medico.obtenerId();
        if (medico.obtenerId().length() < 5) {
            for (int i = medico.obtenerId().length(); i < 5; i++) {
                aux += " ";
            }
            medico.setearID(aux);
        } else {
            medico.setearID(medico.obtenerId().substring(0, 5));
        }

        aux = habitacion.obtenerCodigo();
        if (habitacion.obtenerCodigo().length() < 5) {
            for (int i = habitacion.obtenerCodigo().length(); i < 5; i++) {
                aux += " ";
            }
            habitacion.setearCodigo(aux);
        } else {
            habitacion.setearCodigo(habitacion.obtenerCodigo().substring(0, 5));
        }
    }

    public void guardar() {
        String raiz = System.getProperty("user.dir");
        try {
            darFormato();
            File arch = new File(raiz + "\\PACIENTES.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");

            if (archivo.length() != 0) {
                archivo.seek(archivo.length());
            }
            archivo.writeUTF(id); //7 Bytes
            archivo.writeUTF(nombre); //22 Bytes
            archivo.writeInt(edad); //4 Bytes
            archivo.writeChar(genero); //2 Bytes
            archivo.writeUTF(habitacion.obtenerCodigo()); //7 Bytes
            archivo.writeUTF(medico.obtenerId()); //7 Bytes
            archivo.writeUTF(fechaIngreso.toString()); //25 Bytes

            if (fechaSalida != null) {
                archivo.writeUTF(fechaSalida.toString()); //25 Bytes
            } else {
                archivo.writeUTF("null                   ");
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("error en el ingreso");
        }
    }

}
