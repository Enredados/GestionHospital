/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String pacienteID;

    // constantes
    private final int LONG_CODIGO = 5;
    private final int LONG_TIPO = 10;
    private final int LONG_PACIENTE = 5;

    public Habitacion(String codigo, int piso, String tipo, Paciente paciente) {
        this.codigo = codigo;
        this.piso = piso;
        this.tipo = tipo;
        this.paciente = paciente;
        pacienteID = "";
    }

    public Habitacion() {
        pacienteID = "";
    }

    public void setearCodigo(String codigo) {
        this.codigo = codigo;
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

    public void setearDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean obtenerDisponibilidad() {
        return this.disponibilidad;
    }

    public void setearPiso(int piso) {
        this.piso = piso;
    }

    public int obtenerPiso() {
        return this.piso;
    }

    public void setearTipo(String tipo) {
        this.tipo = tipo;
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
        return "Código:" + codigo + ";Piso:" + piso + ";Tipo:" + tipo + ";Paciente:" + paciente;
    }

    public static void mostrarFichero() {
        String n;
        try {
            String raiz = System.getProperty("user.dir");
            File ficherof = new File(raiz + "\\habitaciones.dat");
            RandomAccessFile fichero = new RandomAccessFile(ficherof, "rw");
            fichero.seek(0); //nos situamos al principio
            while (true) {
                n = fichero.readUTF() + fichero.readInt() + fichero.readUTF() + fichero.readUTF() + fichero.readBoolean();  //se lee  un entero del fichero  
                System.out.println(n);  //se muestra en pantalla
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void guardar() {
        String raiz = System.getProperty("user.dir");

        try {
            File arch = new File(raiz + "\\HABITACIONES.dat");
            RandomAccessFile rand = new RandomAccessFile(arch, "rw");
            darFormato();

            if (rand.length() != 0) {
                rand.seek(rand.length());
            }
            rand.writeUTF(codigo); //7 Bytes
            rand.writeInt(piso); //4 Bytes
            rand.writeUTF(tipo); //7 Bytes
            rand.writeUTF(pacienteID); //7 Bytes
            rand.writeBoolean(disponibilidad); //1 Byte
            rand.close();
            
            mostrarFichero();
            
        } catch (Exception e) {
            Logger.getLogger(Habitacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void darFormato() {
        // codigo con formato char de 5 (7 bytes)
        if (codigo.length() > LONG_CODIGO) {
            codigo = codigo.substring(0, LONG_CODIGO);
        } else {
            for (int i = codigo.length(); i < LONG_CODIGO; i++) {
                codigo += " ";
            }
        }
        // tipo con formato char de 5 (7 bytes)
        if (tipo.length() > LONG_TIPO) {
            tipo = tipo.substring(0, LONG_TIPO);
        } else {
            for (int i = tipo.length(); i < LONG_TIPO; i++) {
                tipo += " ";
            }
        }
        // pacienteID con formato char de 5 (7 bytes)
        if (pacienteID.length() > LONG_PACIENTE) {
            pacienteID = pacienteID.substring(0, LONG_PACIENTE);
        } else {
            for (int i = pacienteID.length(); i < LONG_PACIENTE; i++) {
                pacienteID += " ";
            }
        }
    }
}
