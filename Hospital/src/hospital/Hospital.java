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

        String raiz = System.getProperty("user.dir");

        File archivoPacientes = new File(raiz + "\\PACIENTES.txt");
        File archivoMedicos = new File(raiz + "\\MEDICOS.txt");
        File archivoAdmins = new File(raiz + "\\ADMINISTRATIVOS.txt");
        File archivoHabitaciones = new File(raiz + "\\HABITACIONES.txt");

        String[] espacios;
        String[] pcomas;
        String[] datos;
        String temp = "";

        pacientes = new ArrayList<>();
        medicos = new ArrayList<Medico>();
        admins = new ArrayList<Administrativo>();
        habitaciones = new ArrayList<Habitacion>();

        // LEER ARCHIVO MEDICOS
        try {
            Scanner myReader = new Scanner(archivoMedicos);
            int i = 0;
            while (myReader.hasNextLine()) {
                temp = myReader.nextLine();
                pcomas = temp.split(";");

                medicos.add(new Medico(
                        pcomas[0].split(":")[1],
                        pcomas[1].split(":")[1],
                        Integer.parseInt(pcomas[2].split(":")[1]),
                        pcomas[3].split(":")[1].charAt(0),
                        pcomas[4].split(":")[1],
                        pcomas[5].split(":")[1]));
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("ADMINS:");
        // LEER ARCHIVO ADMINISTRATIVOS
        try {
            Scanner myReader = new Scanner(archivoAdmins);
            int i = 0;
            while (myReader.hasNextLine()) {
                temp = myReader.nextLine();
                pcomas = temp.split(";");

                admins.add(new Administrativo(
                        pcomas[0].split(":")[1],
                        pcomas[1].split(":")[1],
                        Integer.parseInt(pcomas[2].split(":")[1]),
                        pcomas[3].split(":")[1].charAt(0),
                        pcomas[4].split(":")[1]));
                i++;
            }

            for (Administrativo admin : admins) {
                admin.obtenerInformacion();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // LEER ARCHIVO HABITACIONES
        try {
            Scanner myReader = new Scanner(archivoHabitaciones);
            int i = 0;
            datos = null;
            while (myReader.hasNextLine()) {
                temp = myReader.nextLine();
                pcomas = temp.split(";");

                Paciente pacAux = null;
                for (Paciente pac : pacientes) {
                    if (!pcomas[3].split(":")[1].equals("null") && pcomas[3].split(":")[1].equals(pac.obtenerId())) {
                        pacAux = pac;
                    }
                }

                habitaciones.add(new Habitacion(
                        pcomas[0].split(":")[1],
                        Integer.parseInt(pcomas[1].split(":")[1]),
                        pcomas[2].split(":")[1],
                        pacAux));
                i++;
            }

            for (Habitacion hab : habitaciones) {
                hab.obtenerInformacion();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("PACIENTES:");
        // LEER ARCHIVO PACIENTES
        try {
            Scanner myReader = new Scanner(archivoPacientes);
            int i = 0;
            while (myReader.hasNextLine()) {
                temp = myReader.nextLine();
                pcomas = temp.split(";");
                datos = pcomas[i].split(":");
                Medico medAux = null;
                for (Medico med : medicos) {
                    System.out.println("med acutal: " + med.obtenerId());
                    System.out.println("pac acutal: " + pcomas[5].split(":")[1]);
                    if (pcomas[5].split(":")[1].equals(med.obtenerId())) {
                        System.out.println("encontrado: " + med.obtenerId() + "\n");
                        medAux = med;
                        break;
                    }
                }
                Habitacion habAux = null;
                for (Habitacion hab : habitaciones) {
                    String strHab = pcomas[4].split(":")[1];
                    if (strHab.equals(hab.obtenerCodigo())) {
                        habAux = hab;
                    }
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String[] fecha = pcomas[6].split(":");
                String str = fecha[1].replace('T', ' ') + ":" + fecha[2];
                LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

                // Crear objeto paciente y agregarlo al arraylist pacientes
                pacientes.add(new Paciente(
                        pcomas[0].split(":")[1],
                        pcomas[1].split(":")[1],
                        Integer.parseInt(pcomas[2].split(":")[1]),
                        pcomas[3].split(":")[1].charAt(0),
                        medAux,
                        habAux,
                        dateTime));
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Login login = new Login(medicos, admins, pacientes, habitaciones);
        login.setSize(700, 800);
        login.setVisible(true);
        //login.setExtendedState(login.MAXIMIZED_BOTH);

    }

    //Función para guardar en archivos
    public static void guardarEnArchivos() {
        String raiz = System.getProperty("user.dir");

        try {
            String temp = "";
            FileWriter archivoMedicos = new FileWriter(raiz + "\\MEDICOS.txt");
            FileWriter archivoPacientes = new FileWriter(raiz + "\\Pacientes.txt");
            FileWriter archivoAdmins = new FileWriter(raiz + "\\ADMINISTRATIVOS.txt");
            FileWriter archivoHabs = new FileWriter(raiz + "\\HABITACIONES.txt");

            // GUARDAR MEDICOS
            for (Medico med : medicos) {
                temp += med.obtenerInformacion() + "\n";
            }
            archivoMedicos.write(temp);
            archivoMedicos.flush();
            archivoMedicos.close();

            temp = "";
            // GUARDAR PACIENTES
            for (Paciente pac : pacientes) {
                temp += pac.obtenerInformacion() + "\n";
            }
            archivoPacientes.write(temp);
            archivoPacientes.flush();
            archivoPacientes.close();

            temp = "";           
            // GUARDAR ADMINISTRATIVOS
            for (Administrativo admin : admins) {
                temp += admin.obtenerInformacion() + "\n";
            }
            archivoAdmins.write(temp);
            archivoAdmins.flush();
            archivoAdmins.close();
        
            temp = "";  
            // GUARDAR HABITACIONES
            for (Habitacion hab : habitaciones) {
                temp += hab.obtenerInformacion() + "\n";
            }
            archivoHabs.write(temp);
            archivoHabs.flush();
            archivoHabs.close();

        } catch (IOException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
