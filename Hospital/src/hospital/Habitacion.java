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
public class Habitacion {

    private String codigo;
    private Paciente paciente;
    private boolean disponibilidad = true;
    private int piso;
    private String tipo;

    public Habitacion(String codigo, int piso, String tipo, Paciente paciente) {
        this.codigo = codigo;
        this.piso = piso;
        this.tipo = tipo;
        this.paciente = paciente;
    }

    public Habitacion() {

    }

    public String obtenerCodigo() {
        return this.codigo;
    }

    public void setearPaciente(Paciente paciente) {
        this.paciente = paciente;
        disponibilidad = false;
    }

    public Paciente obtenerPaciente() {
        return this.paciente;
    }

    public boolean obtenerDisponibilidad() {
        return this.disponibilidad;
    }

    public int obtenerPiso() {
        return this.piso;
    }

    public String obtenerTipo() {
        return this.tipo;
    }

    public void eliminarPaciente() {
        paciente = null;
        disponibilidad = true;
    }

    public String[] obtenerDatos() {
        String disp = disponibilidad == true ? "Habitación disponible" : "Habitación ocupada";
        return new String[]{codigo, disp, String.valueOf(piso), tipo};
    }

    public String obtenerInformacion() {
        return "Código:" + codigo + ";Piso:" + piso + ";Tipo:" + tipo+ ";Paciente:"+paciente;
    }
}
