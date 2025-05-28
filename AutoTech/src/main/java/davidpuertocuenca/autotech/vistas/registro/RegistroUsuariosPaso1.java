/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.registro;

import static davidpuertocuenca.autotech.cartografia.CifradoSHA256.cifrarContraseña;
import static davidpuertocuenca.autotech.cartografia.CifradoSHA256.generarRandomizador;
import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.controladores.RegistroControlador;
import java.util.Arrays;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.obtenerUsuarioPorUsuarioSql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Puerto Cuenca
 */
public class RegistroUsuariosPaso1 extends javax.swing.JFrame {
    private Usuarios usuario;
    private boolean aceptacionTerminos = false;
    private RegistroControlador controlador = new RegistroControlador();
    /**
     * Creates new form RegistroClientesView1
     */
    public RegistroUsuariosPaso1() {
        initComponents();
        this.setLocationRelativeTo(null);
        reiniciarEtiquetas();
        
        //Listener para poder pasar al siguiente paso pulsando enter desde los textFields.
         ActionListener finalizarRegistroListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarRegistro();
            }
         };

        fieldUsuario.addActionListener(finalizarRegistroListener);
        fieldCorreo.addActionListener(finalizarRegistroListener);
        fieldContrasena.addActionListener(finalizarRegistroListener);
        fieldContrasenaVerificar.addActionListener(finalizarRegistroListener);
        
    }

     private void reiniciarEtiquetas(){
        textoErrorUsuario.setVisible(false);
        textoErrorContrasena.setVisible(false);
        textoErrorContrasena1.setVisible(false);
        textoErrorCorreoElectronico.setVisible(false);
        textoErrorTerminos.setVisible(false);
        this.revalidate(); 
        this.repaint(); 
    }
    
    private boolean registrarCliente(){
        reiniciarEtiquetas();
        boolean formatoCorrecto = true;
        
        //Comprobación de que el usuario no esta ya en uso.
        if(obtenerUsuarioPorUsuarioSql(fieldUsuario.getText()) != null){
            formatoCorrecto = false;
                textoErrorUsuario.setText("Usuario ya en uso.");
                    textoErrorUsuario.setVisible(true);            
        }
        
        //Comprobación de que el campo usuario no esta vacio.
        if(fieldUsuario.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorUsuario.setText("Debe introducir un usuario.");
                    textoErrorUsuario.setVisible(true);
        }
        
        //Comprobación de que las dos contraseñas coincidan
        if(!Arrays.equals(fieldContrasena.getPassword(), fieldContrasenaVerificar.getPassword())){
           formatoCorrecto = false;
               textoErrorContrasena.setText("Las contraseñas no coinciden.");
                    textoErrorContrasena.setVisible(true);
                        textoErrorContrasena1.setText("Las contraseñas no coinciden.");
                            textoErrorContrasena1.setVisible(true);
                    
        }
        
        //Comprobación de que las dos contraseñas no esten vacias.
        if(String.valueOf(fieldContrasena.getPassword()).isEmpty() && String.valueOf(fieldContrasenaVerificar.getPassword()).isEmpty()){
           formatoCorrecto = false;
               textoErrorContrasena.setText("Debe introducir una contraseña.");
                    textoErrorContrasena.setVisible(true); 
                        textoErrorContrasena1.setText("Debe introducir una contraseña.");
                            textoErrorContrasena1.setVisible(true); 
        }
        
        //Comprobación de que el correo electronico tenga el formato requerido.
        if (!fieldCorreo.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            formatoCorrecto = false;
                textoErrorCorreoElectronico.setVisible(true);
                    textoErrorCorreoElectronico.setText("Introduzca un correo electrónico valido.");
        }
        
        //Comprobación de que el correo electronico no este vacio.
        if(fieldCorreo.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorCorreoElectronico.setVisible(true);
                    textoErrorCorreoElectronico.setText("Debe introducir un correo electrónico.");
        }
        
        //Comprobación de que el usuario haya aceptado los terminos.
        if(aceptacionTerminos == false){
            textoErrorTerminos.setVisible(true);
        }
        
        if(formatoCorrecto){
            String randormizador = generarRandomizador();
            char[] contasenaChar = fieldContrasena.getPassword();
                //Se guardan los datos obtenidos en la variable global.
                usuario = new Usuarios(fieldUsuario.getText(),cifrarContraseña(String.valueOf(contasenaChar), randormizador),randormizador,null, null, null, fieldCorreo.getText(), null, null, false);
                    //Se limpia el array para aumentar la seguridad.
                    java.util.Arrays.fill(contasenaChar, '\0');    
                        return true;
        }else{
            return false;
        }
    }
    
    private void finalizarRegistro(){
        if(registrarCliente() && aceptacionTerminos == true){
            controlador.vistaRegistroPasoDos(this, usuario);
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

        fieldUsuario = new javax.swing.JTextField();
        textoErrorUsuario = new javax.swing.JLabel();
        fieldContrasena = new javax.swing.JPasswordField();
        fieldContrasenaVerificar = new javax.swing.JPasswordField();
        textoErrorContrasena = new javax.swing.JLabel();
        fieldCorreo = new javax.swing.JTextField();
        textoErrorCorreoElectronico = new javax.swing.JLabel();
        labelUsuario1 = new javax.swing.JLabel();
        labelContrasena = new javax.swing.JLabel();
        labelCorreoElectronico = new javax.swing.JLabel();
        textoErrorContrasena1 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        botonContinuar = new javax.swing.JButton();
        checkTerminosYCondiciones = new javax.swing.JCheckBox();
        textoErrorTerminos = new javax.swing.JLabel();
        labelContrasena2 = new javax.swing.JLabel();
        labelIniciarSesion = new javax.swing.JLabel();
        fondoCabecera = new javax.swing.JLabel();
        fondoLogin = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Usuario Paso 1");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldUsuario.setToolTipText("");
        getContentPane().add(fieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 250, 40));

        textoErrorUsuario.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorUsuario.setText("Usuario ya en uso.");
        getContentPane().add(textoErrorUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 250, -1));
        getContentPane().add(fieldContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 250, 40));
        getContentPane().add(fieldContrasenaVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 250, 40));

        textoErrorContrasena.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorContrasena.setText("Las contraseñas no coinciden.");
        getContentPane().add(textoErrorContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 250, -1));

        fieldCorreo.setToolTipText("");
        getContentPane().add(fieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 250, 40));

        textoErrorCorreoElectronico.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCorreoElectronico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorCorreoElectronico.setText("Debe introducir un correo electrónico.");
        getContentPane().add(textoErrorCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 250, -1));

        labelUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario1.setText("Usuario");
        getContentPane().add(labelUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        labelContrasena.setForeground(new java.awt.Color(255, 255, 255));
        labelContrasena.setText("Contraseña");
        getContentPane().add(labelContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 80, -1));

        labelCorreoElectronico.setForeground(new java.awt.Color(255, 255, 255));
        labelCorreoElectronico.setText("Correo Electronico");
        getContentPane().add(labelCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 120, -1));

        textoErrorContrasena1.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorContrasena1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorContrasena1.setText("Las contraseñas no coinciden.");
        getContentPane().add(textoErrorContrasena1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 250, -1));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 90, -1));

        botonContinuar.setText("Continuar");
        botonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(botonContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 530, 100, -1));

        checkTerminosYCondiciones.setBackground(new java.awt.Color(0, 0, 0));
        checkTerminosYCondiciones.setForeground(new java.awt.Color(255, 255, 255));
        checkTerminosYCondiciones.setText("Términos y condiciones de uso");
        checkTerminosYCondiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTerminosYCondicionesActionPerformed(evt);
            }
        });
        getContentPane().add(checkTerminosYCondiciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 210, -1));

        textoErrorTerminos.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTerminos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorTerminos.setText("Debe aceptar los términos.");
        getContentPane().add(textoErrorTerminos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 210, -1));

        labelContrasena2.setForeground(new java.awt.Color(255, 255, 255));
        labelContrasena2.setText("Contraseña");
        getContentPane().add(labelContrasena2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 90, -1));

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelIniciarSesion.setText("[●○] Paso 1: Crear cuenta(Con mas estilo)");
        getContentPane().add(labelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 520, 40));

        fondoCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cabecera_prov.png"))); // NOI18N
        getContentPane().add(fondoCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 470, 50));

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_login_prov .jpg"))); // NOI18N
        getContentPane().add(fondoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 540, 620));

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_prov.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaLoginClientes(this);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContinuarActionPerformed
        finalizarRegistro();
    }//GEN-LAST:event_botonContinuarActionPerformed

    private void checkTerminosYCondicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTerminosYCondicionesActionPerformed
        if(controlador.vistaTerminosCondiciones(this)){
            checkTerminosYCondiciones.setSelected(true);
                aceptacionTerminos = true;
                    textoErrorTerminos.setVisible(false);
        }else{
            checkTerminosYCondiciones.setSelected(false);
                aceptacionTerminos = false;
        }
    }//GEN-LAST:event_checkTerminosYCondicionesActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroUsuariosPaso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuariosPaso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuariosPaso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuariosPaso1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuariosPaso1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonContinuar;
    private javax.swing.JCheckBox checkTerminosYCondiciones;
    private javax.swing.JPasswordField fieldContrasena;
    private javax.swing.JPasswordField fieldContrasenaVerificar;
    private javax.swing.JTextField fieldCorreo;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JLabel fondoCabecera;
    private javax.swing.JLabel fondoLogin;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JLabel labelContrasena;
    private javax.swing.JLabel labelContrasena2;
    private javax.swing.JLabel labelCorreoElectronico;
    private javax.swing.JLabel labelIniciarSesion;
    private javax.swing.JLabel labelUsuario1;
    private javax.swing.JLabel textoErrorContrasena;
    private javax.swing.JLabel textoErrorContrasena1;
    private javax.swing.JLabel textoErrorCorreoElectronico;
    private javax.swing.JLabel textoErrorTerminos;
    private javax.swing.JLabel textoErrorUsuario;
    // End of variables declaration//GEN-END:variables
}
