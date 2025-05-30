/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.usuario.Vehiculos;

import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.clases.Vehiculos;
import davidpuertocuenca.autotech.controladores.UsuarioControlador;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoMatriculaSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoNumeroBastidorSql;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloBoton;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author David Puerto Cuenca
 */
public class AnadirVehiculoPaso1 extends javax.swing.JFrame {
    private Vehiculos vehiculo;
    private Usuarios cliente;
    private UsuarioControlador controlador = new UsuarioControlador();
    /**
     * Creates new form AnadirVehiculo
     */
    public AnadirVehiculoPaso1() {
        initComponents();
        this.setLocationRelativeTo(null);
        //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonContinuar);
        aplicarEstiloTextField(fieldMatricula);
        aplicarEstiloTextField(fieldAnoMatriculacion);
        aplicarEstiloTextField(fieldNumeroBastidor);
        
        reiniciarEtiquetas();
    }
    
    public AnadirVehiculoPaso1(Usuarios cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
         //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonContinuar);
        aplicarEstiloTextField(fieldMatricula);
        aplicarEstiloTextField(fieldAnoMatriculacion);
        aplicarEstiloTextField(fieldNumeroBastidor);
        this.cliente = cliente;
        reiniciarEtiquetas();
        
        //Listener para poder pasar al siguiente paso pulsando enter desde los textFields.
         ActionListener RegistroVehiculoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registroVehiculo();
            }
         };

        fieldMatricula.addActionListener(RegistroVehiculoListener);
        fieldAnoMatriculacion.addActionListener(RegistroVehiculoListener);
        fieldNumeroBastidor.addActionListener(RegistroVehiculoListener);
    }

    private void reiniciarEtiquetas(){
        labelErrorMatricula.setVisible(false);
        textoErrorAnoMatriculacion.setVisible(false);
        textoErrorNumeroBastidor.setVisible(false);
        this.revalidate(); 
        this.repaint(); 
    }
       
    private boolean registrarVehiculo(){
        reiniciarEtiquetas();
        boolean formatoCorrecto = true;

        //Comprobación de que la matrícula cumpla el formato actual y el antiguo (España).
        if (!fieldMatricula.getText().trim().toUpperCase().replaceAll("[\\s\\-]", "").matches("^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$") && !fieldMatricula.getText().trim().toUpperCase().replaceAll("[\\s\\-]", "").matches("^[A-Z]{1,2}[0-9]{4}[A-Z]{0,2}$")) {      
            formatoCorrecto = false;
                labelErrorMatricula.setText("Debe introducir una matrícula valida.");
                    labelErrorMatricula.setVisible(true);
        }
        
        //Comprobación de que la matrícula no este vacía.
        if(fieldMatricula.getText().isEmpty()){
            formatoCorrecto = false;
                labelErrorMatricula.setText("Debe introducir una matrícula.");
                    labelErrorMatricula.setVisible(true);   
        }
        
        //Comprobación de que la matrícula no este registrada.
        if(obtenerVehiculoMatriculaSql(fieldMatricula.getText()) != null){
           formatoCorrecto = false;
                labelErrorMatricula.setText("Esta matrícula ya esta registrada.");
                    labelErrorMatricula.setVisible(true);    
        }
        
        //Comprobación de que el año de matrículacion tenga el formato correcto. (0000)
        if(fieldAnoMatriculacion.getText().length() != 4 && !fieldAnoMatriculacion.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorAnoMatriculacion.setVisible(true);
                    textoErrorAnoMatriculacion.setText("El formato no es el correcto.");         
        }
        
        //Comprobación de que el año de matrículacion sean números y no letras.
        try {
            //Comprobacion de que el año no sea superior al actual  ni menor a 1950
            if(Integer.parseInt(fieldAnoMatriculacion.getText()) > LocalDate.now().getYear() || Integer.parseInt(fieldAnoMatriculacion.getText()) < 1950){
                formatoCorrecto = false;
                    textoErrorAnoMatriculacion.setVisible(true);
                        textoErrorAnoMatriculacion.setText("Año de matriculación inválido.");
        }
        }catch (NumberFormatException e) {
            formatoCorrecto = false;
                textoErrorAnoMatriculacion.setVisible(true);
                    textoErrorAnoMatriculacion.setText("Año de matriculación inválido.");
        } 
        
        //Comprobación de que el año de matrículacion no este vacío.
        if(fieldAnoMatriculacion.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorAnoMatriculacion.setText("Debe introducir un año.");
                    textoErrorAnoMatriculacion.setVisible(true);   
        }
        
        //Comprobación de que el número de bastidor tenga el formato correcto (acepta mayúsculas y minúsculas).
        if (!fieldNumeroBastidor.getText().matches("^[A-HJ-NPR-Za-hj-npr-z0-9]{17}$")) {
            formatoCorrecto = false;
                textoErrorNumeroBastidor.setText("Número de bastidor inválido.");
                    textoErrorNumeroBastidor.setVisible(true);
        }

        //Comprobación de que el numero de bastidor no este registrado.
        if(obtenerVehiculoNumeroBastidorSql(fieldNumeroBastidor.getText()) != null){
           formatoCorrecto = false;
                textoErrorNumeroBastidor.setText("Número de bastidor ya registrado.");
                    textoErrorNumeroBastidor.setVisible(true);   
        }
        
        //Comprobación de que el campo numero de bastidor no este vacío.
        if(fieldNumeroBastidor.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorNumeroBastidor.setText("Debe introducir un bastidor.");
                    textoErrorNumeroBastidor.setVisible(true);   
        }
        
        if(formatoCorrecto){
            vehiculo = new Vehiculos(fieldMatricula.getText().trim().toUpperCase().replaceAll("[\\s\\-]", ""), null, null, null, fieldAnoMatriculacion.getText(),fieldNumeroBastidor.getText().trim().toUpperCase().replaceAll("[\\s\\-]", ""), cliente, new ArrayList());
                return true;
        }else{
            return false;
        }
    }
    
    private void registroVehiculo(){
        if(registrarVehiculo()){
            controlador.vistaAnadirVehiculoPaso2(this, cliente, vehiculo);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formularioVehiculo = new javax.swing.JPanel();
        labelMatricula = new javax.swing.JLabel();
        fieldMatricula = new javax.swing.JTextField();
        labelErrorMatricula = new javax.swing.JLabel();
        labelAnoMatriculacion = new javax.swing.JLabel();
        fieldAnoMatriculacion = new javax.swing.JTextField();
        textoErrorAnoMatriculacion = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        botonContinuar = new javax.swing.JButton();
        fieldNumeroBastidor = new javax.swing.JTextField();
        textoErrorNumeroBastidor = new javax.swing.JLabel();
        labelNumeroBastidor = new javax.swing.JLabel();
        labelIniciarSesion = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir Vehículo Paso 1");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formularioVehiculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMatricula.setForeground(new java.awt.Color(255, 255, 255));
        labelMatricula.setText("Matrícula");
        formularioVehiculo.add(labelMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 250, -1));

        fieldMatricula.setToolTipText("");
        formularioVehiculo.add(fieldMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 250, 40));

        labelErrorMatricula.setForeground(new java.awt.Color(255, 0, 0));
        labelErrorMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        labelErrorMatricula.setText("Matrícula ya registrada.");
        formularioVehiculo.add(labelErrorMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 250, -1));

        labelAnoMatriculacion.setForeground(new java.awt.Color(255, 255, 255));
        labelAnoMatriculacion.setText("Año De Matriculación");
        formularioVehiculo.add(labelAnoMatriculacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 250, -1));

        fieldAnoMatriculacion.setToolTipText("");
        formularioVehiculo.add(fieldAnoMatriculacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 250, 40));

        textoErrorAnoMatriculacion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorAnoMatriculacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorAnoMatriculacion.setText("Debe introducir un año.");
        formularioVehiculo.add(textoErrorAnoMatriculacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 250, -1));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        formularioVehiculo.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 100, 30));

        botonContinuar.setText("Continuar");
        botonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContinuarActionPerformed(evt);
            }
        });
        formularioVehiculo.add(botonContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 100, 30));

        fieldNumeroBastidor.setToolTipText("");
        formularioVehiculo.add(fieldNumeroBastidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 250, 40));

        textoErrorNumeroBastidor.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorNumeroBastidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorNumeroBastidor.setText("Debe introducir un bastidor.");
        formularioVehiculo.add(textoErrorNumeroBastidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 250, -1));

        labelNumeroBastidor.setForeground(new java.awt.Color(255, 255, 255));
        labelNumeroBastidor.setText("Número De Bastidor");
        formularioVehiculo.add(labelNumeroBastidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 250, -1));

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelIniciarSesion.setText("AutoTech - Paso 1 de 2: Añadir Vehículo");
        formularioVehiculo.add(labelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 470, 40));

        getContentPane().add(formularioVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 520, 440));
        formularioVehiculo.setBackground(new java.awt.Color(0, 0, 0, 120));

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_formularios.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaVehiculos(this, cliente);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContinuarActionPerformed
        registroVehiculo();
    }//GEN-LAST:event_botonContinuarActionPerformed

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
            java.util.logging.Logger.getLogger(AnadirVehiculoPaso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirVehiculoPaso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirVehiculoPaso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirVehiculoPaso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirVehiculoPaso1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonContinuar;
    private javax.swing.JTextField fieldAnoMatriculacion;
    private javax.swing.JTextField fieldMatricula;
    private javax.swing.JTextField fieldNumeroBastidor;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JPanel formularioVehiculo;
    private javax.swing.JLabel labelAnoMatriculacion;
    private javax.swing.JLabel labelErrorMatricula;
    private javax.swing.JLabel labelIniciarSesion;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelNumeroBastidor;
    private javax.swing.JLabel textoErrorAnoMatriculacion;
    private javax.swing.JLabel textoErrorNumeroBastidor;
    // End of variables declaration//GEN-END:variables
}
