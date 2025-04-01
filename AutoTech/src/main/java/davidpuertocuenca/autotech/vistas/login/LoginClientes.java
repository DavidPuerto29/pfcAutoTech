/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.login;

import davidpuertocuenca.autotech.clases.Cliente;
import static davidpuertocuenca.autotech.clases.Cliente.comprobacionAutenticacionUsuario;
import static davidpuertocuenca.autotech.dao.ClienteDAO.obtenerClientePorUsuarioSql;
import davidpuertocuenca.autotech.vistas.cliente.VistaGeneralCliente;
import davidpuertocuenca.autotech.vistas.registro.RegistroClientes;
import javax.swing.JOptionPane;


/**
 *
 * @author David Puerto Cuenca
 */
public class LoginClientes extends javax.swing.JFrame {
    /**
     * Creates new form TestLogin
     */
    public LoginClientes() {
        initComponents();
        setExtendedState(this.MAXIMIZED_BOTH);
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

        textUsuario = new javax.swing.JTextField();
        botonIniciarSesion = new javax.swing.JToggleButton();
        inicioSesionAdministrador = new javax.swing.JToggleButton();
        botonRegistrar = new javax.swing.JButton();
        textContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        getContentPane().add(textUsuario, gridBagConstraints);

        botonIniciarSesion.setText("Login");
        botonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarSesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        getContentPane().add(botonIniciarSesion, gridBagConstraints);

        inicioSesionAdministrador.setText("admin");
        inicioSesionAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioSesionAdministradorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        getContentPane().add(inicioSesionAdministrador, gridBagConstraints);

        botonRegistrar.setText("Registro");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        getContentPane().add(botonRegistrar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        getContentPane().add(textContrasena, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarSesionActionPerformed
        Cliente cliente = obtenerClientePorUsuarioSql(textUsuario.getText());
        char[] contasenaChar = textContrasena.getPassword();
        
        if(comprobacionAutenticacionUsuario(cliente, String.valueOf(contasenaChar))){
            //Se limpia el array para aumentar la seguridad.
            java.util.Arrays.fill(contasenaChar, '\0');
                VistaGeneralCliente g = new VistaGeneralCliente(cliente);
                    g.setVisible(true);
                        this.dispose();
        }else{
            //Se limpia el array para aumentar la seguridad.
            java.util.Arrays.fill(contasenaChar, '\0');
                JOptionPane.showMessageDialog(this, "El usuario no ha sido encontrado, por favor compruebe los datos y vuelva a intentarlo.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonIniciarSesionActionPerformed

    private void inicioSesionAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioSesionAdministradorActionPerformed
        LoginAdministradores loginAdministrador = new LoginAdministradores();
            loginAdministrador.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_inicioSesionAdministradorActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        RegistroClientes r = new RegistroClientes();
            r.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_botonRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(LoginClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonIniciarSesion;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JToggleButton inicioSesionAdministrador;
    private javax.swing.JPasswordField textContrasena;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}
