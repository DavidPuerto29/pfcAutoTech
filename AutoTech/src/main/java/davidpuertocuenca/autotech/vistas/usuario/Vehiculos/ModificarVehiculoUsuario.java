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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author David Puerto Cuenca
 */
public class ModificarVehiculoUsuario extends javax.swing.JFrame {
    private ImageIcon iconoError = new ImageIcon(getClass().getResource("/icons/error_prov.png"));
    private Vehiculos vehiculo;
    private Usuarios cliente;
    private UsuarioControlador controlador = new UsuarioControlador();
    /**
     * Creates new form ModificarVehiculo
     */
    public ModificarVehiculoUsuario() {
        initComponents();
        reiniciarEtiquetas();
        setExtendedState(ModificarVehiculoUsuario.MAXIMIZED_BOTH);
    }
    
     public ModificarVehiculoUsuario(Vehiculos vehiculo, Usuarios cliente) {
        initComponents();
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        reiniciarEtiquetas();
        mostrarDatos();
        setExtendedState(ModificarVehiculoUsuario.MAXIMIZED_BOTH);
        
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
        textoErrorAnoMatriculacion.setText(" ");
        textoErrorAnoMatriculacion.setIcon(null);
        textoErrorModelo.setText(" ");
        textoErrorModelo.setIcon(null);
        labelErrorMatricula.setText(" ");
        labelErrorMatricula.setIcon(null);
        textoErrorMarca.setText(" ");
        textoErrorMarca.setIcon(null);
        textoErrorColor.setText(" ");
        textoErrorColor.setIcon(null);
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
                    labelErrorMatricula.setIcon(iconoError); 
        }
        
        //Comprobación de que la matrícula no este vacía.
        if(fieldMatricula.getText().isEmpty()){
            formatoCorrecto = false;
                labelErrorMatricula.setText("Debe introducir una matrícula.");
                    labelErrorMatricula.setIcon(iconoError); 
        }
        
        //Comprobación de que la matrícula no este registrada.
        if(obtenerVehiculoMatriculaSql(fieldMatricula.getText()) != null && !vehiculo.getMatricula().equals(fieldMatricula.getText())){
           formatoCorrecto = false;
                labelErrorMatricula.setText("Esta matrícula ya esta registrada.");
                    labelErrorMatricula.setIcon(iconoError); 
        }
        
       //Comprobación de que el año de matrículacion tenga el formato correcto. (0000)
        if(fieldAnoMatriculacion.getText().length() != 4 && !fieldAnoMatriculacion.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorAnoMatriculacion.setIcon(iconoError); 
                    textoErrorAnoMatriculacion.setText("El formato no es el correcto.");         
        }
        
        //Comprobación de que el año de matrículacion sean números y no letras.
        try {
            //Comprobacion de que el año no sea superior al actual ( > 2025)
            if(Integer.parseInt(fieldAnoMatriculacion.getText()) > 2025){
                formatoCorrecto = false;
                    textoErrorAnoMatriculacion.setIcon(iconoError); 
                        textoErrorAnoMatriculacion.setText("El año de matrículacion no puede ser mayor que el año actual.");
            }
        }catch (NumberFormatException e) {
            formatoCorrecto = false;
                textoErrorAnoMatriculacion.setIcon(iconoError); 
                    textoErrorAnoMatriculacion.setText("El año de matrículacion no puede contener letras.");
        } 
        
        //Comprobación de que el año de matrículacion no este vacío.
        if(fieldAnoMatriculacion.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorAnoMatriculacion.setText("Debe introducir un año.");
                    textoErrorAnoMatriculacion.setIcon(iconoError); 
        }
        
        //Comprobación de que el modelo no este vacío.
        if(fieldModelo.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorModelo.setText("Debe introducir un modelo.");
                    textoErrorModelo.setIcon(iconoError); 
        }
        
        //Comprobación de que el campo marca no este vacío.
        if(fieldMarca.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorMarca.setText("Debe introducir una marca.");
                    textoErrorMarca.setIcon(iconoError); 
        }
        
        //Comprobación de que el campo color no este vacío.
        if(fieldColor.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorColor.setText("Debe introducir un color.");
                    textoErrorColor.setIcon(iconoError); 
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
        java.awt.GridBagConstraints gridBagConstraints;

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
        fondoCabecera = new javax.swing.JLabel();
        fondoLogin = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Vehículo");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        labelAnoMatriculacion.setForeground(new java.awt.Color(255, 255, 255));
        labelAnoMatriculacion.setText("Año De Matriculación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 920, 0, 0);
        getContentPane().add(labelAnoMatriculacion, gridBagConstraints);

        fieldAnoMatriculacion.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 920, 0, 0);
        getContentPane().add(fieldAnoMatriculacion, gridBagConstraints);

        textoErrorAnoMatriculacion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorAnoMatriculacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorAnoMatriculacion.setText("Debe introducir un año.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 920, 0, 0);
        getContentPane().add(textoErrorAnoMatriculacion, gridBagConstraints);

        labelModelo.setForeground(new java.awt.Color(255, 255, 255));
        labelModelo.setText("Modelo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 920, 0, 0);
        getContentPane().add(labelModelo, gridBagConstraints);

        fieldModelo.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 920, 0, 0);
        getContentPane().add(fieldModelo, gridBagConstraints);

        textoErrorModelo.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorModelo.setText("Debe introducir un modelo.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 920, 0, 0);
        getContentPane().add(textoErrorModelo, gridBagConstraints);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 930, 0, 0);
        getContentPane().add(botonCancelar, gridBagConstraints);

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        getContentPane().add(botonModificar, gridBagConstraints);

        fieldMatricula.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 920, 0, 0);
        getContentPane().add(fieldMatricula, gridBagConstraints);

        labelMatricula.setForeground(new java.awt.Color(255, 255, 255));
        labelMatricula.setText("Matrícula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 920, 0, 0);
        getContentPane().add(labelMatricula, gridBagConstraints);

        labelErrorMatricula.setForeground(new java.awt.Color(255, 0, 0));
        labelErrorMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        labelErrorMatricula.setText("Matrícula ya registrada.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 920, 0, 0);
        getContentPane().add(labelErrorMatricula, gridBagConstraints);

        textoErrorMarca.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorMarca.setText("Debe introducir una marca.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 920, 0, 0);
        getContentPane().add(textoErrorMarca, gridBagConstraints);

        fieldMarca.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 920, 0, 0);
        getContentPane().add(fieldMarca, gridBagConstraints);

        labelMarca.setForeground(new java.awt.Color(255, 255, 255));
        labelMarca.setText("Marca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 87;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 920, 0, 0);
        getContentPane().add(labelMarca, gridBagConstraints);

        fieldColor.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 920, 0, 0);
        getContentPane().add(fieldColor, gridBagConstraints);

        textoErrorColor.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorColor.setText("Debe introducir un color,");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 920, 0, 0);
        getContentPane().add(textoErrorColor, gridBagConstraints);

        labelColor.setForeground(new java.awt.Color(255, 255, 255));
        labelColor.setText("Color");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 920, 0, 0);
        getContentPane().add(labelColor, gridBagConstraints);

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelIniciarSesion.setText("Modificar Vehículo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(160, 940, 0, 0);
        getContentPane().add(labelIniciarSesion, gridBagConstraints);

        fondoCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cabecera_prov.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.ipadx = -1256;
        gridBagConstraints.ipady = -82;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(150, 830, 0, 0);
        getContentPane().add(fondoCabecera, gridBagConstraints);

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_login_prov .jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = 18;
        gridBagConstraints.ipadx = -2464;
        gridBagConstraints.ipady = -3232;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(110, 780, 0, 0);
        getContentPane().add(fondoLogin, gridBagConstraints);

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_prov.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 26;
        gridBagConstraints.gridheight = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondoPantalla, gridBagConstraints);

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
    private javax.swing.JLabel fondoCabecera;
    private javax.swing.JLabel fondoLogin;
    private javax.swing.JLabel fondoPantalla;
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
