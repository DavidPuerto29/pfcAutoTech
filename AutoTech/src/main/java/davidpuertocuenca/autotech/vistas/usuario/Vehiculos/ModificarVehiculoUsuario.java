/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.usuario.Vehiculos;

import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.clases.Vehiculos;
import davidpuertocuenca.autotech.controladores.UsuarioControlador;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.actualizarVehiculoSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoMatriculaSql;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloBoton;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Puerto Cuenca
 */
public class ModificarVehiculoUsuario extends javax.swing.JFrame {
    private Vehiculos vehiculo;
    private Usuarios cliente;
    private UsuarioControlador controlador = new UsuarioControlador();
    /**
     * Creates new form ModificarVehiculo
     */
    public ModificarVehiculoUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonModificar);
        aplicarEstiloTextField(fieldMarca);
        aplicarEstiloTextField(fieldModelo);
        aplicarEstiloTextField(fieldColor);
        aplicarEstiloTextField(fieldAnoMatriculacion);
        aplicarEstiloTextField(fieldMatricula);
        
        reiniciarEtiquetas();
    }
    
     public ModificarVehiculoUsuario(Vehiculos vehiculo, Usuarios cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
         //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonModificar);
        aplicarEstiloTextField(fieldMarca);
        aplicarEstiloTextField(fieldModelo);
        aplicarEstiloTextField(fieldColor);
        aplicarEstiloTextField(fieldAnoMatriculacion);
        aplicarEstiloTextField(fieldMatricula);
        
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        reiniciarEtiquetas();
        mostrarDatos();
        
        //Listener para poder pasar al siguiente paso pulsando enter desde los textFields.
         ActionListener ModificarVehiculoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarVehiculoFinalizar();
            }
         };

        fieldMatricula.addActionListener(ModificarVehiculoListener);
        fieldMarca.addActionListener(ModificarVehiculoListener);
        fieldModelo.addActionListener(ModificarVehiculoListener);
        fieldAnoMatriculacion.addActionListener(ModificarVehiculoListener);
        fieldColor.addActionListener(ModificarVehiculoListener);
        
    }

    private void reiniciarEtiquetas(){ 
        textoErrorAnoMatriculacion.setVisible(false);
        textoErrorModelo.setVisible(false);
        labelErrorMatricula.setVisible(false);
        textoErrorMarca.setVisible(false);
        textoErrorColor.setVisible(false);
        this.revalidate(); 
        this.repaint(); 
    }
    
    private void mostrarDatos(){ 
        fieldMatricula.setText(vehiculo.getMatricula());
        fieldMarca.setText(vehiculo.getMarca());
        fieldModelo.setText(vehiculo.getModelo());
        fieldAnoMatriculacion.setText(vehiculo.getAnoMatriculacion());
        fieldModelo.setText(vehiculo.getModelo());
        fieldColor.setText(vehiculo.getColor());
    }
    
    private boolean modificarVehiculo(){
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
        if(obtenerVehiculoMatriculaSql(fieldMatricula.getText()) != null && !vehiculo.getMatricula().equals(fieldMatricula.getText())){
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
            //Comprobacion de que el año no sea superior al actual ( > 2025)
            if(Integer.parseInt(fieldAnoMatriculacion.getText()) > 2025){
                formatoCorrecto = false;
                    textoErrorAnoMatriculacion.setVisible(true);
                        textoErrorAnoMatriculacion.setText("El año de matrículacion no puede ser mayor que el año actual.");
            }
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
        
        if(formatoCorrecto){
            vehiculo.setMatricula(fieldMatricula.getText().trim().toUpperCase().replaceAll("[\\s\\-]", ""));
                vehiculo.setMarca(fieldMarca.getText().trim().toUpperCase().replaceAll("[\\s\\-]", ""));
                    vehiculo.setModelo(fieldModelo.getText().trim().toUpperCase().replaceAll("[\\s\\-]", "")); 
                        vehiculo.setAnoMatriculacion(fieldAnoMatriculacion.getText());
                            vehiculo.setColor(fieldColor.getText().trim().toUpperCase().replaceAll("[\\s\\-]", ""));
                                return true;
        }else{
            return false;
        }
    }
    
    private void modificarVehiculoFinalizar(){
        if(modificarVehiculo()){
            actualizarVehiculoSql(vehiculo);
                controlador.vistaVehiculos(this, cliente);
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
        botonModificar = new javax.swing.JButton();
        fieldMatricula = new javax.swing.JTextField();
        labelMatricula = new javax.swing.JLabel();
        labelErrorMatricula = new javax.swing.JLabel();
        textoErrorMarca = new javax.swing.JLabel();
        fieldMarca = new javax.swing.JTextField();
        labelMarca = new javax.swing.JLabel();
        fieldColor = new javax.swing.JTextField();
        textoErrorColor = new javax.swing.JLabel();
        labelColor = new javax.swing.JLabel();
        labelIniciarSesion = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Vehículo");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formularioVehiculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelAnoMatriculacion.setForeground(new java.awt.Color(255, 255, 255));
        labelAnoMatriculacion.setText("Año De Matriculación");
        formularioVehiculo.add(labelAnoMatriculacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 250, -1));

        fieldAnoMatriculacion.setToolTipText("");
        formularioVehiculo.add(fieldAnoMatriculacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 250, 40));

        textoErrorAnoMatriculacion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorAnoMatriculacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorAnoMatriculacion.setText("Debe introducir un año.");
        formularioVehiculo.add(textoErrorAnoMatriculacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 250, -1));

        labelModelo.setForeground(new java.awt.Color(255, 255, 255));
        labelModelo.setText("Modelo");
        formularioVehiculo.add(labelModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 250, -1));

        fieldModelo.setToolTipText("");
        formularioVehiculo.add(fieldModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 250, 40));

        textoErrorModelo.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorModelo.setText("Debe introducir un modelo.");
        formularioVehiculo.add(textoErrorModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 250, -1));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        formularioVehiculo.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 100, 30));

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        formularioVehiculo.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 100, 30));

        fieldMatricula.setToolTipText("");
        formularioVehiculo.add(fieldMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 250, 40));

        labelMatricula.setForeground(new java.awt.Color(255, 255, 255));
        labelMatricula.setText("Matrícula");
        formularioVehiculo.add(labelMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 250, -1));

        labelErrorMatricula.setForeground(new java.awt.Color(255, 0, 0));
        labelErrorMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        labelErrorMatricula.setText("Matrícula ya registrada.");
        formularioVehiculo.add(labelErrorMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 250, -1));

        textoErrorMarca.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorMarca.setText("Debe introducir una marca.");
        formularioVehiculo.add(textoErrorMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 250, -1));

        fieldMarca.setToolTipText("");
        formularioVehiculo.add(fieldMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 250, 40));

        labelMarca.setForeground(new java.awt.Color(255, 255, 255));
        labelMarca.setText("Marca");
        formularioVehiculo.add(labelMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 250, -1));

        fieldColor.setToolTipText("");
        formularioVehiculo.add(fieldColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 250, 40));

        textoErrorColor.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorColor.setText("Debe introducir un color,");
        formularioVehiculo.add(textoErrorColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 250, -1));

        labelColor.setForeground(new java.awt.Color(255, 255, 255));
        labelColor.setText("Color");
        formularioVehiculo.add(labelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 250, -1));

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelIniciarSesion.setText("AutoTech – Edita Tu Vehículo");
        formularioVehiculo.add(labelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 350, 40));

        getContentPane().add(formularioVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 520, 620));
        formularioVehiculo.setBackground(new java.awt.Color(0, 0, 0, 120));

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_formularios.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaVehiculos(this, cliente);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        if(modificarVehiculo()){
            actualizarVehiculoSql(vehiculo);
                controlador.vistaVehiculos(this, cliente);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarVehiculoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarVehiculoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarVehiculoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarVehiculoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarVehiculoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JTextField fieldAnoMatriculacion;
    private javax.swing.JTextField fieldColor;
    private javax.swing.JTextField fieldMarca;
    private javax.swing.JTextField fieldMatricula;
    private javax.swing.JTextField fieldModelo;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JPanel formularioVehiculo;
    private javax.swing.JLabel labelAnoMatriculacion;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelErrorMatricula;
    private javax.swing.JLabel labelIniciarSesion;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel textoErrorAnoMatriculacion;
    private javax.swing.JLabel textoErrorColor;
    private javax.swing.JLabel textoErrorMarca;
    private javax.swing.JLabel textoErrorModelo;
    // End of variables declaration//GEN-END:variables
}
