/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class Hospital {

    private static ArrayList<Paciente> pacientes;
    private static ArrayList<Medico> medicos;
    private static ArrayList<Administrativo> admins;
    private static ArrayList<Habitacion> habitaciones;

    /**
     * @param args the command line arguments
     */
    public ArrayList<Paciente> cargarClientes() {

        return null;
    }

    public static void main(String[] args) {
        Login aux = new Login();
        aux.setLocationRelativeTo(null);
        aux.setSize(700,800);
        aux.setVisible(true);
        
    }

    //Función para guardar en archivos
}
