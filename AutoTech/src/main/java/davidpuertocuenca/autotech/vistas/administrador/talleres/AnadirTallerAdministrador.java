/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador.talleres;

import davidpuertocuenca.autotech.clases.Talleres;
import davidpuertocuenca.autotech.controladores.AdministradorControlador;
import static davidpuertocuenca.autotech.dao.TalleresDAO.crearTallerSql;
import static davidpuertocuenca.autotech.dao.TalleresDAO.obtenerTallerPorCifSql;
import davidpuertocuenca.autotech.vistas.usuario.Vehiculos.AnadirVehiculoPaso1;

/**
 *
 * @author David
 */
public class AnadirTallerAdministrador extends javax.swing.JFrame {
    private AdministradorControlador controlador = new AdministradorControlador();
    /**
     * Creates new form AnadirTallerAdministrador
     */
    public AnadirTallerAdministrador() {
        initComponents();
        setExtendedState(AnadirVehiculoPaso1.MAXIMIZED_BOTH);
        reiniciarEtiquetas();
    }
    
    private void reiniciarEtiquetas(){
        textoErrorNombre.setVisible(false);
        textoErrorTelefono.setVisible(false);
        textoErrorDireccion.setVisible(false);
        textoErrorLocalidad.setVisible(false);
        textoErrorCodigoPostal.setVisible(false);
        textoErrorCitasMaximas.setVisible(false);
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
        if (!fieldCitasMaximas.getText().matches("^[A-HJNP-SUVW][0-9]{7}[0-9A-J]$")) {
            formatoCorrecto = false;
                textoErrorCitasMaximas.setVisible(true);
                    textoErrorCitasMaximas.setText("Debe introducir un CIF válido.");
        }
        
        //Comprobación de que el CIF no este registrado.
        if(obtenerTallerPorCifSql(fieldCitasMaximas.getText()) != null){
           formatoCorrecto = false;
                textoErrorCitasMaximas.setText("Este CIF ya esta registrado.");
                    textoErrorCitasMaximas.setVisible(true);    
        }
        
        
        //Comprobación de que el CIF no este vacia.
        if(fieldCitasMaximas.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorCitasMaximas.setVisible(true);
                    textoErrorCitasMaximas.setText("Debe introducir un CIF.");
        }
        
        if(formatoCorrecto){
            crearTallerSql(new Talleres(fieldNombre.getText(), fieldDireccion.getText(), fieldCodigoPostal.getText(), fieldTelefono.getText(), fieldCitasMaximas.getText().toUpperCase(), fieldLocalidad.getText(), Integer.valueOf(fieldCitasMaximas.getText())));
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
        fondoCabecera = new javax.swing.JLabel();
        fondoLogin = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();
        fieldIdentidicacionFiscal1 = new javax.swing.JTextField();
        labelIdentidicacionFiscal1 = new javax.swing.JLabel();
        textoErrorIdentidicacionFiscal1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir Taller");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        getContentPane().setLayout(null);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar);
        botonCancelar.setBounds(1000, 910, 76, 23);

        botonAnadir.setText("Añadir");
        botonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirActionPerformed(evt);
            }
        });
        getContentPane().add(botonAnadir);
        botonAnadir.setBounds(1160, 910, 83, 23);

        fieldCitasMaximas.setToolTipText("");
        getContentPane().add(fieldCitasMaximas);
        fieldCitasMaximas.setBounds(990, 770, 250, 40);

        textoErrorCitasMaximas.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCitasMaximas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorCitasMaximas.setText("Debe introducir un número.");
        textoErrorCitasMaximas.setToolTipText("");
        getContentPane().add(textoErrorCitasMaximas);
        textoErrorCitasMaximas.setBounds(990, 820, 210, 20);

        labelCitasMaximas.setForeground(new java.awt.Color(255, 255, 255));
        labelCitasMaximas.setText("Citas Maximas");
        getContentPane().add(labelCitasMaximas);
        labelCitasMaximas.setBounds(990, 750, 110, 16);

        textoErrorLocalidad.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorLocalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorLocalidad.setText("Debe introducir una localidad.");
        textoErrorLocalidad.setToolTipText("");
        getContentPane().add(textoErrorLocalidad);
        textoErrorLocalidad.setBounds(990, 720, 212, 20);

        fieldLocalidad.setToolTipText("");
        getContentPane().add(fieldLocalidad);
        fieldLocalidad.setBounds(990, 670, 250, 40);

        labelLocalidad.setForeground(new java.awt.Color(255, 255, 255));
        labelLocalidad.setText("Localidad");
        getContentPane().add(labelLocalidad);
        labelLocalidad.setBounds(990, 650, 111, 16);

        textoErrorTelefono.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorTelefono.setText("Debe introducir un teléfono.");
        textoErrorTelefono.setToolTipText("");
        getContentPane().add(textoErrorTelefono);
        textoErrorTelefono.setBounds(990, 620, 211, 20);

        fieldTelefono.setToolTipText("");
        getContentPane().add(fieldTelefono);
        fieldTelefono.setBounds(990, 570, 250, 40);

        labelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        labelTelefono.setText("Teléfono");
        getContentPane().add(labelTelefono);
        labelTelefono.setBounds(990, 550, 110, 16);

        textoErrorCodigoPostal.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCodigoPostal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorCodigoPostal.setText("Debe introducir un código postal.");
        textoErrorCodigoPostal.setToolTipText("");
        getContentPane().add(textoErrorCodigoPostal);
        textoErrorCodigoPostal.setBounds(990, 520, 211, 20);

        fieldCodigoPostal.setToolTipText("");
        getContentPane().add(fieldCodigoPostal);
        fieldCodigoPostal.setBounds(990, 470, 250, 40);

        labelCodigoPostal.setForeground(new java.awt.Color(255, 255, 255));
        labelCodigoPostal.setText("Código Postal");
        getContentPane().add(labelCodigoPostal);
        labelCodigoPostal.setBounds(990, 450, 110, 16);

        textoErrorDireccion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorDireccion.setText("Debe introducir una dirección");
        textoErrorDireccion.setToolTipText("");
        getContentPane().add(textoErrorDireccion);
        textoErrorDireccion.setBounds(990, 420, 191, 20);

        fieldDireccion.setToolTipText("");
        getContentPane().add(fieldDireccion);
        fieldDireccion.setBounds(990, 370, 250, 40);

        labelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        labelDireccion.setText("Dirección");
        getContentPane().add(labelDireccion);
        labelDireccion.setBounds(990, 350, 110, 16);

        textoErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorNombre.setText("Debe introducir un nombre.");
        getContentPane().add(textoErrorNombre);
        textoErrorNombre.setBounds(990, 320, 189, 20);

        fieldNombre.setToolTipText("");
        getContentPane().add(fieldNombre);
        fieldNombre.setBounds(990, 270, 250, 40);

        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Nombre Del Taller");
        getContentPane().add(labelNombre);
        labelNombre.setBounds(990, 250, 112, 16);

        labelAnadirTaller.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelAnadirTaller.setForeground(new java.awt.Color(255, 255, 255));
        labelAnadirTaller.setText("Añadir Taller");
        getContentPane().add(labelAnadirTaller);
        labelAnadirTaller.setBounds(1000, 170, 218, 40);

        fondoCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cabecera_prov.png"))); // NOI18N
        getContentPane().add(fondoCabecera);
        fondoCabecera.setBounds(990, 170, 210, 50);

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_login_prov .jpg"))); // NOI18N
        getContentPane().add(fondoLogin);
        fondoLogin.setBounds(790, 90, 610, 870);

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_prov.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla);
        fondoPantalla.setBounds(0, 0, 2140, 1080);

        fieldIdentidicacionFiscal1.setToolTipText("");
        getContentPane().add(fieldIdentidicacionFiscal1);
        fieldIdentidicacionFiscal1.setBounds(990, 770, 250, 40);

        labelIdentidicacionFiscal1.setForeground(new java.awt.Color(255, 255, 255));
        labelIdentidicacionFiscal1.setText("Identificación Fiscal");
        getContentPane().add(labelIdentidicacionFiscal1);
        labelIdentidicacionFiscal1.setBounds(990, 750, 110, 16);

        textoErrorIdentidicacionFiscal1.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorIdentidicacionFiscal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorIdentidicacionFiscal1.setText("Debe introducir un cif.");
        textoErrorIdentidicacionFiscal1.setToolTipText("");
        getContentPane().add(textoErrorIdentidicacionFiscal1);
        textoErrorIdentidicacionFiscal1.setBounds(990, 820, 210, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaTalleres(this);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirActionPerformed
        if(registrarTaller()){
            controlador.vistaTalleres(this);
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
    private javax.swing.JTextField fieldIdentidicacionFiscal1;
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
    private javax.swing.JLabel textoErrorIdentidicacionFiscal1;
    private javax.swing.JLabel textoErrorLocalidad;
    private javax.swing.JLabel textoErrorNombre;
    private javax.swing.JLabel textoErrorTelefono;
    // End of variables declaration//GEN-END:variables
}
