/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador.talleres;

import davidpuertocuenca.autotech.clases.Talleres;
import davidpuertocuenca.autotech.controladores.AdministradorControlador;
import static davidpuertocuenca.autotech.dao.TalleresDAO.crearTallerSql;
import static davidpuertocuenca.autotech.dao.TalleresDAO.obtenerTallerPorCifSql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Puerto Cuenca
 */
public class AnadirTallerAdministrador extends javax.swing.JFrame {
    private AdministradorControlador controlador = new AdministradorControlador();
    /**
     * Creates new form AnadirTallerAdministrador
     */
    public AnadirTallerAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        reiniciarEtiquetas();
        
        //Listener para poder pasar al siguiente paso pulsando enter desde los textFields.
         ActionListener finalizarRegistroListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarRegistroTaller();
            }
         };

        fieldNombre.addActionListener(finalizarRegistroListener);
        fieldDireccion.addActionListener(finalizarRegistroListener);
        fieldCodigoPostal.addActionListener(finalizarRegistroListener);
        fieldTelefono.addActionListener(finalizarRegistroListener);
        fieldIdentidicacionFiscal.addActionListener(finalizarRegistroListener);
        fieldLocalidad.addActionListener(finalizarRegistroListener);
        fieldCitasMaximas.addActionListener(finalizarRegistroListener);
        
    }
    
    private void reiniciarEtiquetas(){
        textoErrorNombre.setVisible(false);
        textoErrorTelefono.setVisible(false);
        textoErrorDireccion.setVisible(false);
        textoErrorLocalidad.setVisible(false);
        textoErrorIdentidicacionFiscal.setVisible(false);
        textoErrorCodigoPostal.setVisible(false);
        textoErrorCitasMaximas.setVisible(false);
        this.revalidate(); 
        this.repaint(); 
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
        if(fieldTelefono.getText().length() != 9 && !fieldTelefono.getText().isEmpty()){
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
        
        //Comprobación de que el numero maximo de citas sea un número y no letras.
        try {
            Integer.parseInt(fieldCitasMaximas.getText()); 
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
        
        // Comprobación de que el CIF tenga el formato correcto.
        if (!fieldIdentidicacionFiscal.getText().matches("^[A-HJNP-SUVW][0-9]{7}[0-9A-J]$")) {
            formatoCorrecto = false;
                textoErrorIdentidicacionFiscal.setVisible(true);
                    textoErrorIdentidicacionFiscal.setText("Debe introducir un CIF válido.");
        }
        
        //Comprobación de que el CIF no este registrado.
        if(obtenerTallerPorCifSql(fieldIdentidicacionFiscal.getText()) != null){
           formatoCorrecto = false;
                textoErrorIdentidicacionFiscal.setText("Este CIF ya esta registrado.");
                    textoErrorIdentidicacionFiscal.setVisible(true);    
        }
        
        
        //Comprobación de que el CIF no este vacia.
        if(fieldIdentidicacionFiscal.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorIdentidicacionFiscal.setVisible(true);
                    textoErrorIdentidicacionFiscal.setText("Debe introducir un CIF.");
        }
        
        if(formatoCorrecto){
            crearTallerSql(new Talleres(fieldNombre.getText(), fieldDireccion.getText(), fieldCodigoPostal.getText(), fieldTelefono.getText(), fieldIdentidicacionFiscal.getText().toUpperCase(), fieldLocalidad.getText(), Integer.valueOf(fieldCitasMaximas.getText())));
                return true;
        }else{
            return false;
        }
    }
        
        private void finalizarRegistroTaller(){
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

        botonCancelar = new javax.swing.JButton();
        botonAnadir = new javax.swing.JButton();
        fieldCitasMaximas = new javax.swing.JTextField();
        textoErrorCitasMaximas = new javax.swing.JLabel();
        labelCitasMaximas = new javax.swing.JLabel();
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
        labelAnadirTaller = new javax.swing.JLabel();
        fieldIdentidicacionFiscal = new javax.swing.JTextField();
        labelIdentidicacionFiscal1 = new javax.swing.JLabel();
        textoErrorIdentidicacionFiscal = new javax.swing.JLabel();
        fondoCabecera = new javax.swing.JLabel();
        fondoLogin = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir Taller");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, -1, -1));

        botonAnadir.setText("Añadir");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });
        getContentPane().add(botonAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 83, -1));

        fieldCitasMaximas.setToolTipText("");
        getContentPane().add(fieldCitasMaximas, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 250, 40));

        textoErrorCitasMaximas.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCitasMaximas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorCitasMaximas.setText("Debe introducir un número.");
        textoErrorCitasMaximas.setToolTipText("");
        getContentPane().add(textoErrorCitasMaximas, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 250, -1));

        labelCitasMaximas.setForeground(new java.awt.Color(255, 255, 255));
        labelCitasMaximas.setText("Citas Maximas");
        getContentPane().add(labelCitasMaximas, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 250, -1));

        textoErrorLocalidad.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorLocalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorLocalidad.setText("Debe introducir una localidad.");
        textoErrorLocalidad.setToolTipText("");
        getContentPane().add(textoErrorLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 250, -1));

        fieldLocalidad.setToolTipText("");
        getContentPane().add(fieldLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 250, 40));

        labelLocalidad.setForeground(new java.awt.Color(255, 255, 255));
        labelLocalidad.setText("Localidad");
        getContentPane().add(labelLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 250, -1));

        textoErrorTelefono.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorTelefono.setText("Debe introducir un teléfono.");
        textoErrorTelefono.setToolTipText("");
        getContentPane().add(textoErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 250, -1));

        fieldTelefono.setToolTipText("");
        getContentPane().add(fieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 250, 40));

        labelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        labelTelefono.setText("Teléfono");
        getContentPane().add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 250, -1));

        textoErrorCodigoPostal.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCodigoPostal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorCodigoPostal.setText("Debe introducir un código postal.");
        textoErrorCodigoPostal.setToolTipText("");
        getContentPane().add(textoErrorCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 250, -1));

        fieldCodigoPostal.setToolTipText("");
        getContentPane().add(fieldCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 250, 40));

        labelCodigoPostal.setForeground(new java.awt.Color(255, 255, 255));
        labelCodigoPostal.setText("Código Postal");
        getContentPane().add(labelCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 250, -1));

        textoErrorDireccion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorDireccion.setText("Debe introducir una dirección");
        textoErrorDireccion.setToolTipText("");
        getContentPane().add(textoErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 250, -1));

        fieldDireccion.setToolTipText("");
        getContentPane().add(fieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 250, 40));

        labelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        labelDireccion.setText("Dirección");
        getContentPane().add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 250, -1));

        textoErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorNombre.setText("Debe introducir un nombre.");
        getContentPane().add(textoErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 250, -1));

        fieldNombre.setToolTipText("");
        getContentPane().add(fieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 250, 40));

        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Nombre Del Taller");
        getContentPane().add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 250, -1));

        labelAnadirTaller.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelAnadirTaller.setForeground(new java.awt.Color(255, 255, 255));
        labelAnadirTaller.setText("Añadir Taller");
        getContentPane().add(labelAnadirTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 160, 40));

        fieldIdentidicacionFiscal.setToolTipText("");
        getContentPane().add(fieldIdentidicacionFiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 250, 40));

        labelIdentidicacionFiscal1.setForeground(new java.awt.Color(255, 255, 255));
        labelIdentidicacionFiscal1.setText("Identificación Fiscal");
        getContentPane().add(labelIdentidicacionFiscal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 250, -1));

        textoErrorIdentidicacionFiscal.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorIdentidicacionFiscal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorIdentidicacionFiscal.setText("Debe introducir un cif.");
        textoErrorIdentidicacionFiscal.setToolTipText("");
        getContentPane().add(textoErrorIdentidicacionFiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 250, -1));

        fondoCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cabecera_prov.png"))); // NOI18N
        getContentPane().add(fondoCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 210, 50));

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_login_prov .jpg"))); // NOI18N
        getContentPane().add(fondoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 920, 490));

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_prov.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaTalleres(this);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        finalizarRegistroTaller();
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
            java.util.logging.Logger.getLogger(AnadirTallerAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirTallerAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirTallerAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirTallerAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirTallerAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnadir;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField fieldCitasMaximas;
    private javax.swing.JTextField fieldCodigoPostal;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldIdentidicacionFiscal;
    private javax.swing.JTextField fieldLocalidad;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JLabel fondoCabecera;
    private javax.swing.JLabel fondoLogin;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JLabel labelAnadirTaller;
    private javax.swing.JLabel labelCitasMaximas;
    private javax.swing.JLabel labelCodigoPostal;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelIdentidicacionFiscal1;
    private javax.swing.JLabel labelLocalidad;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel textoErrorCitasMaximas;
    private javax.swing.JLabel textoErrorCodigoPostal;
    private javax.swing.JLabel textoErrorDireccion;
    private javax.swing.JLabel textoErrorIdentidicacionFiscal;
    private javax.swing.JLabel textoErrorLocalidad;
    private javax.swing.JLabel textoErrorNombre;
    private javax.swing.JLabel textoErrorTelefono;
    // End of variables declaration//GEN-END:variables
}
