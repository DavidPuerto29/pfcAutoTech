/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador.talleres;

import davidpuertocuenca.autotech.clases.Talleres;
import davidpuertocuenca.autotech.controladores.AdministradorControlador;
import static davidpuertocuenca.autotech.dao.TalleresDAO.actualizarTallerSql;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloBoton;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloComboBox;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Puerto Cuenca
 */
public class ModificarTallerAdministrador extends javax.swing.JFrame {
    private AdministradorControlador controlador = new AdministradorControlador();
    private Talleres taller;
    /**
     * Creates new form AnadirTallerAdministrador
     */
    public ModificarTallerAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonModificar);
        aplicarEstiloTextField(fieldNombre);
        aplicarEstiloTextField(fieldDireccion);
        aplicarEstiloTextField(fieldCodigoPostal);
        aplicarEstiloTextField(fieldTelefono);
        aplicarEstiloTextField(fieldLocalidad);
        aplicarEstiloTextField(fieldCitasMaximas);
        
        mostrarDatos();
        reiniciarEtiquetas();
    }
    
    public ModificarTallerAdministrador(Talleres taller) {
        initComponents();
        this.setLocationRelativeTo(null);
        //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonModificar);
        aplicarEstiloTextField(fieldNombre);
        aplicarEstiloTextField(fieldDireccion);
        aplicarEstiloTextField(fieldCodigoPostal);
        aplicarEstiloTextField(fieldTelefono);
        aplicarEstiloTextField(fieldLocalidad);
        aplicarEstiloTextField(fieldCitasMaximas);
        
        this.taller = taller;
        mostrarDatos();
        reiniciarEtiquetas();
        
        //Listener para poder pasar al siguiente paso pulsando enter desde los textFields.
         ActionListener finalizarRegistroListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarModificarTaller();
            }
         };

        fieldNombre.addActionListener(finalizarRegistroListener);
        fieldDireccion.addActionListener(finalizarRegistroListener);
        fieldCodigoPostal.addActionListener(finalizarRegistroListener);
        fieldTelefono.addActionListener(finalizarRegistroListener);
        fieldLocalidad.addActionListener(finalizarRegistroListener);
        fieldCitasMaximas.addActionListener(finalizarRegistroListener);

    }
    
    private void reiniciarEtiquetas(){
        textoErrorNombre.setVisible(false);
        textoErrorTelefono.setVisible(false);
        textoErrorDireccion.setVisible(false);
        textoErrorLocalidad.setVisible(false);
        textoErrorCodigoPostal.setVisible(false);
        textoErrorCitasMaximas.setVisible(false);
        this.revalidate(); 
        this.repaint(); 
    }
    
    private void mostrarDatos(){
        fieldNombre.setText(taller.getNombre());
        fieldDireccion.setText(taller.getDireccion());
        fieldCodigoPostal.setText(taller.getCodigoPostal());
        fieldTelefono.setText(taller.getTelefono());
        fieldLocalidad.setText(taller.getLocalidad());
        fieldCitasMaximas.setText(String.valueOf(taller.getCitasMaximas()));
    }

        private boolean registrarTaller(){
        reiniciarEtiquetas();
        boolean formatoCorrecto = true;
        
        //Comprobación de que el nombre no este vacio.
        if(fieldNombre.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorNombre.setVisible(true);
                    textoErrorNombre.setText("Debe introducir un nombre.");
        }
        
        //Comprobación de que la localidad no este vacia.
        if(fieldLocalidad.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorLocalidad.setVisible(true);
                    textoErrorLocalidad.setText("Debe introducir una localidad.");
        }
  
        //Comprobación de que el teléfono sean números y no letras.
        try {
            Integer.parseInt(fieldTelefono.getText()); 
        }catch (NumberFormatException e) {
            formatoCorrecto = false;
                textoErrorTelefono.setVisible(true);
                    textoErrorTelefono.setText("El teléfono no puede contener letras.");
        } 
          
        //Comprobación de que el teléfono tenga el formato correcto. (123546789)
        if (!fieldTelefono.getText().trim().matches("\\d{9}") && !fieldTelefono.getText().trim().isEmpty()) {
            formatoCorrecto = false;
                textoErrorTelefono.setVisible(true);
                    textoErrorTelefono.setText("El formato no es el correcto.");         
        }
        
        //Comprobación de que el teléfono no este vacio.
        if(fieldTelefono.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorTelefono.setVisible(true);
                    textoErrorTelefono.setText("Debe introducir un teléfono.");
        }
        
        //Comprobación de que la dirección no este vacia.
        if(fieldDireccion.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorDireccion.setVisible(true);
                    textoErrorDireccion.setText("Debe introducir una dirección.");
        }
        
        //Comprobación de que el numero maximo de citas sea un número y no letras, tampoco que sea menor o igual a 0.
        try {
            if(Integer.parseInt(fieldCitasMaximas.getText()) == 0 || Integer.parseInt(fieldCitasMaximas.getText()) < 0){
                formatoCorrecto = false;
                    textoErrorCitasMaximas.setVisible(true);
                        textoErrorCitasMaximas.setText("Debe introducir un número válido.");
            }
        }catch (NumberFormatException e) {
            formatoCorrecto = false;
                textoErrorCitasMaximas.setVisible(true);
                    textoErrorCitasMaximas.setText("El campo debe ser un numero.");
        } 
        
        //Comprobación de que el numero maximo de citas no este vacio.
        if(fieldCitasMaximas.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorCitasMaximas.setVisible(true);
                    textoErrorCitasMaximas.setText("Debe introducir un número.");
        }
        
        
        // Comprobación de que el código postal tenga el formato correcto.
        if (!fieldCodigoPostal.getText().matches("^[0-9]{5}$")) {
            formatoCorrecto = false;
                textoErrorCodigoPostal.setVisible(true);
                    textoErrorCodigoPostal.setText("Debe introducir un código postal válido.");
        }

        //Comprobación de que la dirección no este vacia.
        if(fieldCodigoPostal.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorCodigoPostal.setVisible(true);
                    textoErrorCodigoPostal.setText("Debe introducir un código postal.");
        }
        
        if(formatoCorrecto){
                taller.setNombre(fieldNombre.getText());
                    taller.setDireccion(fieldDireccion.getText());
                        taller.setCodigoPostal(fieldCodigoPostal.getText());
                            taller.setTelefono(fieldTelefono.getText());
                                taller.setCitasMaximas(Integer.valueOf(fieldCitasMaximas.getText()));
                                    taller.setLocalidad(fieldLocalidad.getText());
                                        actualizarTallerSql(taller);
                                            return true;
        }else{
            return false;
        }
    }
        
        private void finalizarModificarTaller(){
            if(registrarTaller()){
                controlador.vistaTalleres(this);
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

        formularioTaller = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        textoErrorLocalidad = new javax.swing.JLabel();
        fieldLocalidad = new javax.swing.JTextField();
        labelLocalidad = new javax.swing.JLabel();
        textoErrorTelefono = new javax.swing.JLabel();
        fieldTelefono = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        textoErrorCodigoPostal = new javax.swing.JLabel();
        fieldCodigoPostal = new javax.swing.JTextField();
        labelCodigoPostal = new javax.swing.JLabel();
        textoErrorDireccion = new javax.swing.JLabel();
        fieldDireccion = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        textoErrorNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        fieldCitasMaximas = new javax.swing.JTextField();
        textoErrorCitasMaximas = new javax.swing.JLabel();
        labelCitasMaximas = new javax.swing.JLabel();
        labelAnadirTaller = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoTech - Administrador");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formularioTaller.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        formularioTaller.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 100, 30));

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        formularioTaller.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 100, 30));

        textoErrorLocalidad.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorLocalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorLocalidad.setText("Debe introducir una localidad.");
        textoErrorLocalidad.setToolTipText("");
        formularioTaller.add(textoErrorLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 250, -1));

        fieldLocalidad.setToolTipText("");
        formularioTaller.add(fieldLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 250, 40));

        labelLocalidad.setForeground(new java.awt.Color(255, 255, 255));
        labelLocalidad.setText("Localidad");
        formularioTaller.add(labelLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 250, -1));

        textoErrorTelefono.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorTelefono.setText("Debe introducir un teléfono.");
        textoErrorTelefono.setToolTipText("");
        formularioTaller.add(textoErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 250, -1));

        fieldTelefono.setToolTipText("");
        formularioTaller.add(fieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 250, 40));

        labelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        labelTelefono.setText("Teléfono");
        formularioTaller.add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 250, -1));

        textoErrorCodigoPostal.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCodigoPostal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorCodigoPostal.setText("Debe introducir un código postal.");
        textoErrorCodigoPostal.setToolTipText("");
        formularioTaller.add(textoErrorCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 250, -1));

        fieldCodigoPostal.setToolTipText("");
        formularioTaller.add(fieldCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 250, 40));

        labelCodigoPostal.setForeground(new java.awt.Color(255, 255, 255));
        labelCodigoPostal.setText("Código Postal");
        formularioTaller.add(labelCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 250, -1));

        textoErrorDireccion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorDireccion.setText("Debe introducir una dirección");
        textoErrorDireccion.setToolTipText("");
        formularioTaller.add(textoErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 250, -1));

        fieldDireccion.setToolTipText("");
        formularioTaller.add(fieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 250, 40));

        labelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        labelDireccion.setText("Dirección");
        formularioTaller.add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 250, -1));

        textoErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorNombre.setText("Debe introducir un nombre.");
        formularioTaller.add(textoErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, -1));

        fieldNombre.setToolTipText("");
        formularioTaller.add(fieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 250, 40));

        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Nombre Del Taller");
        formularioTaller.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 250, -1));

        fieldCitasMaximas.setToolTipText("");
        formularioTaller.add(fieldCitasMaximas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 250, 40));

        textoErrorCitasMaximas.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCitasMaximas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorCitasMaximas.setText("Debe introducir un número.");
        textoErrorCitasMaximas.setToolTipText("");
        formularioTaller.add(textoErrorCitasMaximas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 250, -1));

        labelCitasMaximas.setForeground(new java.awt.Color(255, 255, 255));
        labelCitasMaximas.setText("Citas Maximas");
        formularioTaller.add(labelCitasMaximas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 250, -1));

        labelAnadirTaller.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelAnadirTaller.setForeground(new java.awt.Color(255, 255, 255));
        labelAnadirTaller.setText("AutoTech – Modificar Taller");
        formularioTaller.add(labelAnadirTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 310, 40));

        getContentPane().add(formularioTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 840, 420));
        formularioTaller.setBackground(new java.awt.Color(0, 0, 0, 120));

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_formularios.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaTalleres(this);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        finalizarModificarTaller();
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
            java.util.logging.Logger.getLogger(ModificarTallerAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarTallerAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarTallerAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarTallerAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarTallerAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JTextField fieldCitasMaximas;
    private javax.swing.JTextField fieldCodigoPostal;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldLocalidad;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JPanel formularioTaller;
    private javax.swing.JLabel labelAnadirTaller;
    private javax.swing.JLabel labelCitasMaximas;
    private javax.swing.JLabel labelCodigoPostal;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelLocalidad;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel textoErrorCitasMaximas;
    private javax.swing.JLabel textoErrorCodigoPostal;
    private javax.swing.JLabel textoErrorDireccion;
    private javax.swing.JLabel textoErrorLocalidad;
    private javax.swing.JLabel textoErrorNombre;
    private javax.swing.JLabel textoErrorTelefono;
    // End of variables declaration//GEN-END:variables
}
