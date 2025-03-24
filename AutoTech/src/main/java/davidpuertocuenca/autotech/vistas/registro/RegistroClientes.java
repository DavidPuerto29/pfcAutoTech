/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.registro;

import static davidpuertocuenca.autotech.cartografia.CifradoSHA256.cifrarContraseña;
import static davidpuertocuenca.autotech.cartografia.CifradoSHA256.generarRandomizador;
import davidpuertocuenca.autotech.clases.Cliente;
import static davidpuertocuenca.autotech.dao.ClienteDAO.obtenerClientePorUsuarioSql;
import static davidpuertocuenca.autotech.dao.ClienteDAO.crearClienteSql;
import static davidpuertocuenca.autotech.dao.ClienteDAO.obtenerClientePorDniSql;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import java.util.Arrays;

/**
 *
 * @author David Puerto Cuenca
 */
public class RegistroClientes extends javax.swing.JFrame {

    /**
     * Creates new form RegistroClietnes
     */
    public RegistroClientes() {
        initComponents();
        reiniciarEtiquetas();
        setExtendedState(RegistroClientes.MAXIMIZED_BOTH);
    }

    private void reiniciarEtiquetas(){
        textoErrorUsuario.setVisible(false);
        textoErrorContrasena.setVisible(false);
        textoErrorDni.setVisible(false);
        textoErrorNombre.setVisible(false);
        textoErrorApellidos.setVisible(false);
        textoErrorCorreoElectronico.setVisible(false);
        textoErrorTelefono.setVisible(false);
        textoErrorDireccion.setVisible(false);
    }
    private boolean registrarCliente(){
        reiniciarEtiquetas();
        boolean formatoCorrecto = true;
        
        //Comprobación de que el usuario no esta ya en uso.
        if(obtenerClientePorUsuarioSql(fieldUsuario.getText()) != null){
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
                    
        }
        
        //Comprobación de que las dos contraseñas no esten vacias.
        if(String.valueOf(fieldContrasena.getPassword()).isEmpty() && String.valueOf(fieldContrasenaVerificar.getPassword()).isEmpty()){
           formatoCorrecto = false;
               textoErrorContrasena.setText("Debe introducir una contraseña.");
                    textoErrorContrasena.setVisible(true); 
        }
        
        //Comprobación de que el dni no este vacio.
        if(fieldDni.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorDni.setVisible(true);
                    textoErrorDni.setText("Debe introducir un dni.");
        }
        
        //Comprobación de que el dni no esta ya en uso.
        if(obtenerClientePorDniSql(fieldDni.getText()) != null){
            formatoCorrecto = false;
                textoErrorDni.setText("Dni ya en uso.");
                    textoErrorDni.setVisible(true);            
        }
        
        //TODO FORMATO DNI
        
        //Comprobación de que el nombre no este vacio.
        if(fieldNombre.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorNombre.setVisible(true);
                    textoErrorNombre.setText("Debe introducir un nombre.");
        }
        
        //Comprobación de que los apellidos no esten vacios.
        if(fieldApellidos.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorApellidos.setVisible(true);
                    textoErrorApellidos.setText("Debe introducir los apellidos.");
        }
        
        //Comprobación de que el correo electronico no este vacio.
        if(fieldCorreo.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorCorreoElectronico.setVisible(true);
                    textoErrorCorreoElectronico.setText("Debe introducir un correo electrónico.");
        }
        
        //TODO FORMATO CORREO ELECTRONICO.
        
        //Comprobación de que el teléfono no este vacio.
        if(fieldTelefono.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorTelefono.setVisible(true);
                    textoErrorTelefono.setText("Debe introducir un teléfono.");
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
        
        //Comprobación de que la dirección no este vacio.
        if(fieldDireccion.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorDireccion.setVisible(true);
                    textoErrorDireccion.setText("Debe introducir una dirección.");
        }
        
        if(formatoCorrecto){
            String randormizador = generarRandomizador();
            char[] contasenaChar = fieldContrasena.getPassword();
                Cliente cliente = new Cliente(fieldUsuario.getText(),cifrarContraseña(String.valueOf(contasenaChar), randormizador),randormizador,fieldDni.getText(),fieldNombre.getText(),fieldApellidos.getText(),fieldCorreo.getText(),fieldTelefono.getText(),fieldDireccion.getText(),false);
                    //Se limpia el array para aumentar la seguridad.
                    java.util.Arrays.fill(contasenaChar, '\0');    
                        crearClienteSql(cliente);
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

        fieldUsuario = new javax.swing.JTextField();
        fieldDni = new javax.swing.JTextField();
        fieldCorreo = new javax.swing.JTextField();
        fieldApellidos = new javax.swing.JTextField();
        fieldDireccion = new javax.swing.JTextField();
        fieldTelefono = new javax.swing.JTextField();
        fieldContrasenaVerificar = new javax.swing.JPasswordField();
        fieldContrasena = new javax.swing.JPasswordField();
        botonCancelar = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        fieldNombre = new javax.swing.JTextField();
        textoErrorUsuario = new javax.swing.JLabel();
        textoErrorContrasena = new javax.swing.JLabel();
        textoErrorDni = new javax.swing.JLabel();
        textoErrorNombre = new javax.swing.JLabel();
        textoErrorApellidos = new javax.swing.JLabel();
        textoErrorCorreoElectronico = new javax.swing.JLabel();
        textoErrorTelefono = new javax.swing.JLabel();
        textoErrorDireccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar");

        fieldUsuario.setText("Usuario");

        fieldDni.setText("Dni");
        fieldDni.setToolTipText("");

        fieldCorreo.setText("Correo Electronico");
        fieldCorreo.setToolTipText("");

        fieldApellidos.setText("Apellidos");
        fieldApellidos.setToolTipText("");

        fieldDireccion.setText("Direccion");
        fieldDireccion.setToolTipText("");

        fieldTelefono.setText("Numero Telefono");
        fieldTelefono.setToolTipText("");

        fieldContrasenaVerificar.setText("Contraseña2");

        fieldContrasena.setText("Contraseña1");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonRegistrar.setText("Registrar");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        fieldNombre.setText("Nombre");
        fieldNombre.setToolTipText("");

        textoErrorUsuario.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorUsuario.setText("Usuario ya en uso.");

        textoErrorContrasena.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorContrasena.setText("Las contraseñas no coinciden.");

        textoErrorDni.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorDni.setText("El formato no es correcto.");

        textoErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorNombre.setText("Debe introducir un nombre.");

        textoErrorApellidos.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorApellidos.setText("Debe introducir un apellido.");

        textoErrorCorreoElectronico.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCorreoElectronico.setText("Debe introducir un correo electrónico.");

        textoErrorTelefono.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTelefono.setText("Debe introducir un teléfono.");

        textoErrorDireccion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorDireccion.setText("Debe introducir una dirección.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(botonCancelar)
                        .addGap(162, 162, 162)
                        .addComponent(botonRegistrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoErrorUsuario))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoErrorContrasena)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fieldContrasenaVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoErrorDni)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoErrorNombre))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(fieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoErrorApellidos)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoErrorCorreoElectronico)
                            .addComponent(fieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoErrorTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoErrorDireccion)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContrasenaVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoErrorUsuario)
                    .addComponent(textoErrorContrasena)
                    .addComponent(textoErrorDni))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoErrorCorreoElectronico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoErrorNombre)
                        .addComponent(textoErrorApellidos)
                        .addComponent(textoErrorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textoErrorDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonRegistrar))
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        LoginClientes l = new LoginClientes();
            l.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
         if(registrarCliente()){
            LoginClientes lgc = new LoginClientes();
                lgc.setVisible(true);
                    this.dispose(); 
        }
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
            java.util.logging.Logger.getLogger(RegistroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JTextField fieldApellidos;
    private javax.swing.JPasswordField fieldContrasena;
    private javax.swing.JPasswordField fieldContrasenaVerificar;
    private javax.swing.JTextField fieldCorreo;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldDni;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JLabel textoErrorApellidos;
    private javax.swing.JLabel textoErrorContrasena;
    private javax.swing.JLabel textoErrorCorreoElectronico;
    private javax.swing.JLabel textoErrorDireccion;
    private javax.swing.JLabel textoErrorDni;
    private javax.swing.JLabel textoErrorNombre;
    private javax.swing.JLabel textoErrorTelefono;
    private javax.swing.JLabel textoErrorUsuario;
    // End of variables declaration//GEN-END:variables
}
