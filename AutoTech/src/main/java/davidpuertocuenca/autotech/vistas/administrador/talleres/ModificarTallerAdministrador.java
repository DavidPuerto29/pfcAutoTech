/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador.talleres;

import davidpuertocuenca.autotech.clases.Talleres;
import davidpuertocuenca.autotech.controladores.AdministradorControlador;
import static davidpuertocuenca.autotech.dao.TalleresDAO.actualizarTallerSql;
import davidpuertocuenca.autotech.vistas.usuario.Vehiculos.AnadirVehiculoPaso1;
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
        setExtendedState(AnadirVehiculoPaso1.MAXIMIZED_BOTH);
        mostrarDatos();
        reiniciarEtiquetas();
    }
    
    public ModificarTallerAdministrador(Talleres taller) {
        initComponents();
        setExtendedState(AnadirVehiculoPaso1.MAXIMIZED_BOTH);
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

    }
    
    private void reiniciarEtiquetas(){
        textoErrorNombre.setVisible(false);
        textoErrorTelefono.setVisible(false);
        textoErrorDireccion.setVisible(false);
        textoErrorLocalidad.setVisible(false);
        textoErrorCodigoPostal.setVisible(false);
        this.revalidate(); 
        this.repaint(); 
    }
    
    private void mostrarDatos(){
        fieldNombre.setText(taller.getNombre());
        fieldDireccion.setText(taller.getDireccion());
        fieldCodigoPostal.setText(taller.getCodigoPostal());
        fieldTelefono.setText(taller.getTelefono());
        fieldLocalidad.setText(taller.getLocalidad());
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
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
        labelAnadirTaller = new javax.swing.JLabel();
        fondoCabecera = new javax.swing.JLabel();
        fondoLogin = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Taller");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("AÑADIR CIF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 117;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 840, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 1000, 0, 0);
        getContentPane().add(botonCancelar, gridBagConstraints);

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 60, 0, 0);
        getContentPane().add(botonModificar, gridBagConstraints);

        textoErrorLocalidad.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorLocalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorLocalidad.setText("Debe introducir una localidad.");
        textoErrorLocalidad.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 990, 0, 0);
        getContentPane().add(textoErrorLocalidad, gridBagConstraints);

        fieldLocalidad.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 990, 0, 0);
        getContentPane().add(fieldLocalidad, gridBagConstraints);

        labelLocalidad.setForeground(new java.awt.Color(255, 255, 255));
        labelLocalidad.setText("Localidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 990, 0, 0);
        getContentPane().add(labelLocalidad, gridBagConstraints);

        textoErrorTelefono.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorTelefono.setText("Debe introducir un teléfono.");
        textoErrorTelefono.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 990, 0, 0);
        getContentPane().add(textoErrorTelefono, gridBagConstraints);

        fieldTelefono.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 990, 0, 0);
        getContentPane().add(fieldTelefono, gridBagConstraints);

        labelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        labelTelefono.setText("Teléfono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 990, 0, 0);
        getContentPane().add(labelTelefono, gridBagConstraints);

        textoErrorCodigoPostal.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCodigoPostal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorCodigoPostal.setText("Debe introducir un código postal.");
        textoErrorCodigoPostal.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 990, 0, 0);
        getContentPane().add(textoErrorCodigoPostal, gridBagConstraints);

        fieldCodigoPostal.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 990, 0, 0);
        getContentPane().add(fieldCodigoPostal, gridBagConstraints);

        labelCodigoPostal.setForeground(new java.awt.Color(255, 255, 255));
        labelCodigoPostal.setText("Código Postal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 990, 0, 0);
        getContentPane().add(labelCodigoPostal, gridBagConstraints);

        textoErrorDireccion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorDireccion.setText("Debe introducir una dirección");
        textoErrorDireccion.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 990, 0, 0);
        getContentPane().add(textoErrorDireccion, gridBagConstraints);

        fieldDireccion.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 990, 0, 0);
        getContentPane().add(fieldDireccion, gridBagConstraints);

        labelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        labelDireccion.setText("Dirección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 990, 0, 0);
        getContentPane().add(labelDireccion, gridBagConstraints);

        textoErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorNombre.setText("Debe introducir un nombre.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 990, 0, 0);
        getContentPane().add(textoErrorNombre, gridBagConstraints);

        fieldNombre.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 990, 0, 0);
        getContentPane().add(fieldNombre, gridBagConstraints);

        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Nombre Del Taller");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 990, 0, 0);
        getContentPane().add(labelNombre, gridBagConstraints);

        labelAnadirTaller.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelAnadirTaller.setForeground(new java.awt.Color(255, 255, 255));
        labelAnadirTaller.setText("Modificar Taller");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(170, 1000, 0, 0);
        getContentPane().add(labelAnadirTaller, gridBagConstraints);

        fondoCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cabecera_prov.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -1536;
        gridBagConstraints.ipady = -82;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(170, 990, 0, 0);
        getContentPane().add(fondoCabecera, gridBagConstraints);

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_login_prov .jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.gridheight = 21;
        gridBagConstraints.ipadx = -2414;
        gridBagConstraints.ipady = -3222;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 790, 0, 0);
        getContentPane().add(fondoLogin, gridBagConstraints);

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_prov.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 22;
        gridBagConstraints.ipadx = 220;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondoPantalla, gridBagConstraints);

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
    private javax.swing.JTextField fieldCodigoPostal;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldLocalidad;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JLabel fondoCabecera;
    private javax.swing.JLabel fondoLogin;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAnadirTaller;
    private javax.swing.JLabel labelCodigoPostal;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelLocalidad;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel textoErrorCodigoPostal;
    private javax.swing.JLabel textoErrorDireccion;
    private javax.swing.JLabel textoErrorLocalidad;
    private javax.swing.JLabel textoErrorNombre;
    private javax.swing.JLabel textoErrorTelefono;
    // End of variables declaration//GEN-END:variables
}
