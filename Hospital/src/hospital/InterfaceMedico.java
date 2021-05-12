/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author bryan
 */
public class InterfaceMedico extends javax.swing.JFrame {

    ArrayList<Paciente> pacientesMedico = new ArrayList<Paciente>();
    ArrayList<Medico> medicos;
    ArrayList<Administrativo> administrativos;
    ArrayList<Paciente> pacientes;
    ArrayList<Habitacion> habitaciones;

    String idUsuario;

    /**
     * Creates new form InterfaceMedico
     */
    public InterfaceMedico() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public InterfaceMedico(ArrayList<Medico> medicos, ArrayList<Administrativo> administrativos, ArrayList<Paciente> pacientes, ArrayList<Habitacion> habitaciones, String usuario) {
        initComponents();

        this.medicos = medicos;
        this.administrativos = administrativos;
        this.habitaciones = habitaciones;
        this.idUsuario = usuario;
        this.pacientes = pacientes;
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bt_estadistica_medico = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        JID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextDiagnostico = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Ver Pacientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Paciente", "Edad", "Género", "Habitación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        bt_estadistica_medico.setText("Ver estadísticas");
        bt_estadistica_medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_estadistica_medicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(28, 28, 28)
                .addComponent(bt_estadistica_medico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(bt_estadistica_medico))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        jTabbedPane1.addTab("Pacientes", jPanel2);

        JID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JIDActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Paciente");

        jButton3.setText("buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Diagnostico");

        jTextDiagnostico.setColumns(20);
        jTextDiagnostico.setRows(5);
        jScrollPane2.setViewportView(jTextDiagnostico);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Edad", "Genero", "Habitacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Dar de alta");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(JID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jButton1)
                        .addGap(123, 123, 123)
                        .addComponent(jButton5)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Editar Paciente", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar() {
        int cont = 0;
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
        }

        try {
            for (Paciente paciente : pacientes) {

                if (JID.getText().equals(paciente._id) && paciente.obtenerMedico().obtenerId().equals(idUsuario)) {
                    String[] elementos = paciente.obtenerDatosPaciente();
                    model.insertRow(model.getRowCount(), new Object[]{elementos[1], elementos[2], elementos[3], elementos[4]});
                    jTextDiagnostico.setText(paciente.obtenerDiagnostico());
                    cont++;
                }

            }
            if (cont == 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se ha encontrado paciente");
        }

    }

    private String[] obtenerDatos() {

        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\alang\\Documents\\NetBeansProjects\\PROYECTO HOSPITAL\\Hospital\\Pacientes.txt"))) {

            String lineas[];
            String aux = "";

            // read line by line
            String linea;
            while ((linea = br.readLine()) != null) {
                aux += linea + "\n";
            }
            lineas = aux.split("\n");
            br.close();
            return lineas;

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return null;
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Login aux = new Login(medicos, administrativos, pacientes, habitaciones);
        aux.setSize(700, 800);
        aux.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    //NOTA: ARREGLAR LA FORMA DE ELIMINAR ELEMENTOS DE LAS TABLAS
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Habitacion aux;
        String id = JID.getText();
        for (Paciente paciente : pacientes) {
            if (paciente.obtenerId().equals(id) && paciente.obtenerMedico().obtenerId().equals(idUsuario)) {
                aux = paciente.obtenerHabitacion();
                paciente.setearHabitacion(new Habitacion());
                paciente.borrarMedico();
                aux.eliminarPaciente();
                jTextDiagnostico.append("\n DADO DE ALTA: " + LocalDateTime.now());
                JID.setText("");
                buscar();
            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (Paciente paciente : pacientes) {
            if (JID.getText().equals(paciente._id) && paciente.obtenerMedico().obtenerId().equals(idUsuario)) {
                paciente.agregarDiagnostico(jTextDiagnostico.getText());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        buscar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JIDActionPerformed

    private void bt_estadistica_medicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_estadistica_medicoActionPerformed
        try {
            String raiz = System.getProperty("user.dir");
            File arch = new File(raiz + "\\PACIENTES.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "r");

            // Lectura de los registros en el archivo .dat
            int[] edades = new int[10];
            final int REGISTRO_LENGTH = 99;
            long cantidadRegistros = archivo.length() / REGISTRO_LENGTH;
            int posEdad = 29;
            System.out.println(archivo.length());
            archivo.seek(posEdad);
            for (int i = 0; i < cantidadRegistros; i++) {
                System.out.println(archivo.length());
                edades[(int) archivo.readInt() / 10]++;
                posEdad += 4;       // los 4 bytes que lee de la _edad
                posEdad += 95;     // los 99 - 4 bytes para leer la _edad del siguiente registro
                archivo.seek(posEdad);
            }

            // crear chart e ingresar datos
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(int i = 0; i < edades.length; i++){
                dataset.setValue(edades[i], "No. Pacientes", String.valueOf(i*10) + " - " + String.valueOf(i*10+10));
            }

            JFreeChart chart = ChartFactory.createBarChart("Pacientes ingresados por rango de edades", "Rango de edades", "No. pacientes ingresados", dataset);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Diagrama de barras", chart);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setSize(800, pacientes.size()*60);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfaceMedico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_estadistica_medicoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String raiz = System.getProperty("user.dir");
        try {
            String id;
            String nombre;
            int edad;
            char genero;
            String habCodigo;
            String medID;
            String fechaIngreso;
            String fechaSalida;
            long tamRegistro = 99;
            long cregistros = 0;
            File arch = new File(raiz + "\\PACIENTES.dat");
            RandomAccessFile archivo = new RandomAccessFile(arch, "rw");
            cregistros = archivo.length() / tamRegistro;

            for (int r = 0; r < cregistros; r++) {
                id = archivo.readUTF();
                nombre = archivo.readUTF();
                edad = archivo.readInt();
                genero = archivo.readChar();
                habCodigo = archivo.readUTF();
                medID = archivo.readUTF();
                fechaIngreso = archivo.readUTF();
                fechaSalida = archivo.readUTF();
                model.insertRow(model.getRowCount(), new Object[]{id, nombre, edad, genero, habCodigo, medID, fechaIngreso, fechaSalida});

                System.out.println();
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JID;
    private javax.swing.JButton bt_estadistica_medico;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextDiagnostico;
    // End of variables declaration//GEN-END:variables
}
