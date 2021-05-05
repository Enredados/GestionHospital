/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

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
                + ";Género:" + genero + ";Habitación:" + habitacion.obtenerCodigo()+ ";Médico:"+medico.obtenerId()+ ";FechaIngreso:" + String.valueOf(fechaIngreso);
    }

}
