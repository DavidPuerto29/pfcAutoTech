/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.cliente.Vehiculos;

import davidpuertocuenca.autotech.clases.Cliente;
import davidpuertocuenca.autotech.clases.Vehiculos;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.crearVehiculoSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoMatriculaSql;
import davidpuertocuenca.autotech.vistas.cliente.VistaVehiculosCliente;
import davidpuertocuenca.autotech.vistas.registro.RegistroClientes;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class AnadirVehiculo extends javax.swing.JFrame {
    private Vehiculos vehiculo;
    private Cliente cliente;
    
    /**
     * Creates new form AnadirVehiculo
     */
    public AnadirVehiculo() {
        initComponents();
        reiniciarEtiquetas();
        setExtendedState(RegistroClientes.MAXIMIZED_BOTH);
    }
    
    public AnadirVehiculo(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        reiniciarEtiquetas();
        setExtendedState(RegistroClientes.MAXIMIZED_BOTH);
    }

    private void reiniciarEtiquetas(){
        labelErrorMatricula.setVisible(false);
        textoErrorAnoMatriculacion.setVisible(false);
        textoErrorModelo.setVisible(false);
        textoErrorMarca.setVisible(false);
        textoErrorColor.setVisible(false);
        textoErrorNumeroBastidor.setVisible(false);
        this.revalidate(); 
        this.repaint(); 
    }
       
    private boolean registrarVehiculo(){
        reiniciarEtiquetas();
        boolean formatoCorrecto = true;
        
        //Comprobación de que la matrícula no este vacía.
        if(fieldMatricula.getText().isEmpty()){
            formatoCorrecto = false;
                labelErrorMatricula.setText("Debe introducir una matrícula.");
                    labelErrorMatricula.setVisible(true);   
        }

        //Comprobación de que la matrícula cumpla el formato. 0000-XXX (y formato antiguo tambien)
        
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
        
        //Comprobacion de que el año no sea superior al actual ( > 2025)
        
        //Comprobación de que el año de matrículacion sean números y no letras.
        try {
            Integer.parseInt(fieldAnoMatriculacion.getText()); 
        }catch (NumberFormatException e) {
            formatoCorrecto = false;
                textoErrorAnoMatriculacion.setVisible(true);
                    textoErrorAnoMatriculacion.setText("El año de matrículacion no puede contener letras.");
        } 
        
        //Comprobación de que el año de matrículacion no este vacío.
        if(fieldAnoMatriculacion.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorAnoMatriculacion.setText("Debe introducir un año.");
                    textoErrorAnoMatriculacion.setVisible(true);   
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
        
        //Comprobación de que el campo numero de bastidor no este vacío.
        if(fieldNumeroBastidor.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorNumeroBastidor.setText("Debe introducir un bastidor.");
                    textoErrorNumeroBastidor.setVisible(true);   
        }
        
        //Comprobación de que el modelo no este vacío.
        if(fieldModelo.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorModelo.setText("Debe introducir un modelo.");
                    textoErrorModelo.setVisible(true);   
        }
        
        if(formatoCorrecto){
            vehiculo = new Vehiculos(fieldMatricula.getText(),fieldMarca.getText(), fieldModelo.getText(), fieldColor.getText(), fieldAnoMatriculacion.getText(),fieldNumeroBastidor.getText(), cliente, new ArrayList());
                return true;
        }else{
            return false;
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

        labelMatricula = new javax.swing.JLabel();
        fieldMatricula = new javax.swing.JTextField();
        labelErrorMatricula = new javax.swing.JLabel();
        labelAnoMatriculacion = new javax.swing.JLabel();
        fieldAnoMatriculacion = new javax.swing.JTextField();
        textoErrorAnoMatriculacion = new javax.swing.JLabel();
        labelModelo = new javax.swing.JLabel();
        fieldModelo = new javax.swing.JTextField();
        textoErrorModelo = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        botonAnadir = new javax.swing.JButton();
        labelMarca = new javax.swing.JLabel();
        fieldMarca = new javax.swing.JTextField();
        textoErrorMarca = new javax.swing.JLabel();
        fieldColor = new javax.swing.JTextField();
        labelColor = new javax.swing.JLabel();
        textoErrorColor = new javax.swing.JLabel();
        fieldNumeroBastidor = new javax.swing.JTextField();
        textoErrorNumeroBastidor = new javax.swing.JLabel();
        labelNumeroBastidor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir Vehículo");

        labelMatricula.setForeground(new java.awt.Color(255, 255, 255));
        labelMatricula.setText("Matrícula");

        fieldMatricula.setToolTipText("");

        labelErrorMatricula.setForeground(new java.awt.Color(255, 0, 0));
        labelErrorMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        labelErrorMatricula.setText("Matrícula ya registrada.");

        labelAnoMatriculacion.setForeground(new java.awt.Color(255, 255, 255));
        labelAnoMatriculacion.setText("Año De Matriculación");

        fieldAnoMatriculacion.setToolTipText("");

        textoErrorAnoMatriculacion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorAnoMatriculacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorAnoMatriculacion.setText("Debe introducir un año.");

        labelModelo.setForeground(new java.awt.Color(255, 255, 255));
        labelModelo.setText("Modelo");

        fieldModelo.setToolTipText("");

        textoErrorModelo.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorModelo.setText("Debe introducir un modelo.");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAnadir.setText("Añadir");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });

        labelMarca.setForeground(new java.awt.Color(255, 255, 255));
        labelMarca.setText("Marca");

        fieldMarca.setToolTipText("");

        textoErrorMarca.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorMarca.setText("Debe introducir una marca");

        fieldColor.setToolTipText("");

        labelColor.setForeground(new java.awt.Color(255, 255, 255));
        labelColor.setText("Color");

        textoErrorColor.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorColor.setText("Debe introducir un color,");

        fieldNumeroBastidor.setToolTipText("");

        textoErrorNumeroBastidor.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorNumeroBastidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorNumeroBastidor.setText("Debe introducir un bastidor.");

        labelNumeroBastidor.setForeground(new java.awt.Color(255, 255, 255));
        labelNumeroBastidor.setText("Número De Bastidor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoErrorNumeroBastidor)
                    .addComponent(fieldNumeroBastidor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumeroBastidor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoErrorColor)
                    .addComponent(fieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoErrorMarca)
                    .addComponent(fieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoErrorModelo)
                    .addComponent(labelMatricula)
                    .addComponent(fieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelErrorMatricula)
                    .addComponent(labelAnoMatriculacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldAnoMatriculacion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoErrorAnoMatriculacion)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAnadir))
                        .addComponent(fieldModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(303, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(labelMatricula)
                .addGap(4, 4, 4)
                .addComponent(fieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(labelErrorMatricula)
                .addGap(24, 24, 24)
                .addComponent(labelAnoMatriculacion)
                .addGap(4, 4, 4)
                .addComponent(fieldAnoMatriculacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(textoErrorAnoMatriculacion)
                .addGap(18, 18, 18)
                .addComponent(labelMarca)
                .addGap(4, 4, 4)
                .addComponent(fieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(textoErrorMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelModelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(textoErrorModelo)
                .addGap(29, 29, 29)
                .addComponent(labelColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(textoErrorColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNumeroBastidor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNumeroBastidor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(textoErrorNumeroBastidor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonAnadir))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        VistaVehiculosCliente vgc = new VistaVehiculosCliente(cliente);
            vgc.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        if(registrarVehiculo()){
            crearVehiculoSql(vehiculo);
                VistaVehiculosCliente vgc = new VistaVehiculosCliente(cliente);
                    vgc.setVisible(true);
                        this.dispose();
        }
    }//GEN-LAST:event_botonAnadirActionPerformed

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
            java.util.logging.Logger.getLogger(AnadirVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField fieldAnoMatriculacion;
    private javax.swing.JTextField fieldColor;
    private javax.swing.JTextField fieldMarca;
    private javax.swing.JTextField fieldMatricula;
    private javax.swing.JTextField fieldModelo;
    private javax.swing.JTextField fieldNumeroBastidor;
    private javax.swing.JLabel labelAnoMatriculacion;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelErrorMatricula;
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
