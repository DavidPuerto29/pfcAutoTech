/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador.vehiculo;

import davidpuertocuenca.autotech.clases.Vehiculos;
import davidpuertocuenca.autotech.controladores.AdministradorControlador;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.obtenerUsuarioPorUsuarioSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.crearVehiculoSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoMatriculaSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoNumeroBastidorSql;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloBoton;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloComboBox;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author David Puerto Cuenca
 */
public class AñadirVehiculoAdministrador extends javax.swing.JFrame {
    private AdministradorControlador controlador = new AdministradorControlador();
    /**
     * Creates new form AñadirVehiculoAdministrador
     */
    public AñadirVehiculoAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
         //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonAnadir);
        aplicarEstiloTextField(fieldMarca);
        aplicarEstiloTextField(fieldModelo);
        aplicarEstiloTextField(fieldColor);
        aplicarEstiloTextField(fieldAnoMatriculacion);
        aplicarEstiloTextField(fieldMatricula);
        aplicarEstiloTextField(fieldNumeroBastidor);
        aplicarEstiloComboBox(comboBoxClientes);
        
        reiniciarEtiquetas();
        controlador.cargarClientesComboBox(comboBoxClientes);
        
         //Listener para poder pasar al siguiente paso pulsando enter desde los textFields.
         ActionListener RegistroVehiculoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVehiculo();
            }
         };

        fieldMatricula.addActionListener(RegistroVehiculoListener);
        fieldAnoMatriculacion.addActionListener(RegistroVehiculoListener);
        fieldNumeroBastidor.addActionListener(RegistroVehiculoListener);
        fieldMarca.addActionListener(RegistroVehiculoListener);
        fieldModelo.addActionListener(RegistroVehiculoListener);
        fieldColor.addActionListener(RegistroVehiculoListener);
    }
    
    private void reiniciarEtiquetas(){
        textoErrorAnoMatriculacion.setVisible(false);
        textoErrorModelo.setVisible(false);
        labelErrorMatricula.setVisible(false);
        textoErrorMarca.setVisible(false);
        textoErrorColor.setVisible(false);
        textoErrorNumeroBastidor.setVisible(false);
        this.revalidate(); 
        this.repaint(); 
    }
    
    private boolean anadirVehiculo(){
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
        
        //Comprobación de que el modelo no este vacío.
        if(fieldModelo.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorModelo.setText("Debe introducir un modelo.");
                    textoErrorModelo.setVisible(true);   
        }
        
        //Comprobación de que el campo marca no este vacío.
        if(fieldMarca.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorMarca.setText("Debe introducir una marca.");
                    textoErrorMarca.setVisible(true);   
        }
        
        //Comprobación de que el campo color no este vacío.
        if(fieldColor.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorColor.setText("Debe introducir un color.");
                    textoErrorColor.setVisible(true);   
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
                textoErrorNumeroBastidor.setText("Numero de bastidor ya registrado.");
                    textoErrorNumeroBastidor.setVisible(true);   
        }
        
        //Comprobación de que el campo numero de bastidor no este vacío.
        if(fieldNumeroBastidor.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorNumeroBastidor.setText("Debe introducir un bastidor.");
                    textoErrorNumeroBastidor.setVisible(true);   
        }
        
        if(formatoCorrecto){
            crearVehiculoSql(new Vehiculos(fieldMatricula.getText().trim().toUpperCase().replaceAll("[\\s\\-]", ""), fieldMarca.getText().trim().toUpperCase().replaceAll("[\\s\\-]", ""), fieldModelo.getText().trim().toUpperCase().replaceAll("[\\s\\-]", ""), fieldColor.getText().trim().toUpperCase().replaceAll("[\\s\\-]", "") , fieldAnoMatriculacion.getText(), fieldNumeroBastidor.getText().trim().toUpperCase().replaceAll("[\\s\\-]", ""), obtenerUsuarioPorUsuarioSql((String) comboBoxClientes.getSelectedItem()), new ArrayList()));
                  return true;
        }else{
            return false;
        }
    }
    
    private void registrarVehiculo(){
         if(anadirVehiculo()){    
            controlador.vistaVehiculos(this);
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
        labelAnoMatriculacion = new javax.swing.JLabel();
        fieldAnoMatriculacion = new javax.swing.JTextField();
        textoErrorAnoMatriculacion = new javax.swing.JLabel();
        labelModelo = new javax.swing.JLabel();
        fieldModelo = new javax.swing.JTextField();
        textoErrorModelo = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        botonAnadir = new javax.swing.JButton();
        comboBoxClientes = new javax.swing.JComboBox<>();
        labelCliente = new javax.swing.JLabel();
        fieldMatricula = new javax.swing.JTextField();
        labelMatricula = new javax.swing.JLabel();
        labelErrorMatricula = new javax.swing.JLabel();
        labelMarca = new javax.swing.JLabel();
        fieldMarca = new javax.swing.JTextField();
        textoErrorMarca = new javax.swing.JLabel();
        labelColor = new javax.swing.JLabel();
        fieldColor = new javax.swing.JTextField();
        textoErrorColor = new javax.swing.JLabel();
        labelIniciarSesion = new javax.swing.JLabel();
        fieldNumeroBastidor = new javax.swing.JTextField();
        labelNumeroBastidor = new javax.swing.JLabel();
        textoErrorNumeroBastidor = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir Vehículo");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formularioVehiculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAnoMatriculacion.setForeground(new java.awt.Color(255, 255, 255));
        labelAnoMatriculacion.setText("Año De Matriculación");
        formularioVehiculo.add(labelAnoMatriculacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 250, -1));

        fieldAnoMatriculacion.setToolTipText("");
        formularioVehiculo.add(fieldAnoMatriculacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 250, 40));

        textoErrorAnoMatriculacion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorAnoMatriculacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorAnoMatriculacion.setText("Debe introducir un año.");
        formularioVehiculo.add(textoErrorAnoMatriculacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 250, -1));

        labelModelo.setForeground(new java.awt.Color(255, 255, 255));
        labelModelo.setText("Modelo");
        formularioVehiculo.add(labelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 250, -1));

        fieldModelo.setToolTipText("");
        formularioVehiculo.add(fieldModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 250, 40));

        textoErrorModelo.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorModelo.setText("Debe introducir un modelo.");
        formularioVehiculo.add(textoErrorModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 250, -1));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        formularioVehiculo.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 100, 30));

        botonAnadir.setLabel("Añadir");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });
        formularioVehiculo.add(botonAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 100, 30));

        comboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxClientesActionPerformed(evt);
            }
        });
        formularioVehiculo.add(comboBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 250, 40));

        labelCliente.setForeground(new java.awt.Color(255, 255, 255));
        labelCliente.setText("Cliente");
        formularioVehiculo.add(labelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        fieldMatricula.setToolTipText("");
        formularioVehiculo.add(fieldMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 250, 40));

        labelMatricula.setForeground(new java.awt.Color(255, 255, 255));
        labelMatricula.setText("Matrícula");
        formularioVehiculo.add(labelMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 250, -1));

        labelErrorMatricula.setForeground(new java.awt.Color(255, 0, 0));
        labelErrorMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        labelErrorMatricula.setText("Matrícula ya registrada.");
        formularioVehiculo.add(labelErrorMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, -1));

        labelMarca.setForeground(new java.awt.Color(255, 255, 255));
        labelMarca.setText("Marca");
        formularioVehiculo.add(labelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 250, -1));

        fieldMarca.setToolTipText("");
        formularioVehiculo.add(fieldMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 250, 40));

        textoErrorMarca.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorMarca.setText("Debe introducir una marca.");
        formularioVehiculo.add(textoErrorMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 250, -1));

        labelColor.setForeground(new java.awt.Color(255, 255, 255));
        labelColor.setText("Color");
        formularioVehiculo.add(labelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 250, -1));

        fieldColor.setToolTipText("");
        formularioVehiculo.add(fieldColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 250, 40));

        textoErrorColor.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorColor.setText("Debe introducir un color,");
        formularioVehiculo.add(textoErrorColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 250, -1));

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelIniciarSesion.setText("AutoTech – Añadir Vehículo");
        formularioVehiculo.add(labelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 340, 40));

        fieldNumeroBastidor.setToolTipText("");
        formularioVehiculo.add(fieldNumeroBastidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 250, 40));

        labelNumeroBastidor.setForeground(new java.awt.Color(255, 255, 255));
        labelNumeroBastidor.setText("Número De Bastidor");
        formularioVehiculo.add(labelNumeroBastidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 250, -1));

        textoErrorNumeroBastidor.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorNumeroBastidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorNumeroBastidor.setText("Debe introducir un bastidor.");
        formularioVehiculo.add(textoErrorNumeroBastidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 250, -1));

        getContentPane().add(formularioVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 840, 420));
        formularioVehiculo.setBackground(new java.awt.Color(0, 0, 0, 120));

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_formularios.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaVehiculos(this);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        registrarVehiculo();
    }//GEN-LAST:event_botonAnadirActionPerformed

    private void comboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxClientesActionPerformed

    }//GEN-LAST:event_comboBoxClientesActionPerformed

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
            java.util.logging.Logger.getLogger(AñadirVehiculoAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirVehiculoAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirVehiculoAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirVehiculoAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirVehiculoAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JComboBox<String> comboBoxClientes;
    private javax.swing.JTextField fieldAnoMatriculacion;
    private javax.swing.JTextField fieldColor;
    private javax.swing.JTextField fieldMarca;
    private javax.swing.JTextField fieldMatricula;
    private javax.swing.JTextField fieldModelo;
    private javax.swing.JTextField fieldNumeroBastidor;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JPanel formularioVehiculo;
    private javax.swing.JLabel labelAnoMatriculacion;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelErrorMatricula;
    private javax.swing.JLabel labelIniciarSesion;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelNumeroBastidor;
    private javax.swing.JLabel textoErrorAnoMatriculacion;
    private javax.swing.JLabel textoErrorColor;
    private javax.swing.JLabel textoErrorMarca;
    private javax.swing.JLabel textoErrorModelo;
    private javax.swing.JLabel textoErrorNumeroBastidor;
    // End of variables declaration//GEN-END:variables
}
