/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador.usuarios;

import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.controladores.AdministradorControlador;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.actualizarUsuarioSql;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.obtenerUsuarioPorDniSql;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.obtenerUsuarioPorUsuarioSql;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloBoton;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloComboBox;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David Puerto Cuenca
 */
public class ModificarUsuarios extends javax.swing.JFrame {
    private Usuarios usuario;
    private AdministradorControlador controlador = new AdministradorControlador();
    /**
     * Creates new form ModificarCliente
     */
    public ModificarUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonModificar);
        aplicarEstiloTextField(fieldUsuario);
        aplicarEstiloTextField(fieldNombre);
        aplicarEstiloTextField(fieldApellidos);
        aplicarEstiloTextField(fieldCorreo);
        aplicarEstiloTextField(fieldDni);
        aplicarEstiloTextField(fieldTelefono);
        aplicarEstiloTextField(fieldDireccion);
                
        reiniciarEtiquetas();
        mostrarDatos();
    }
    
    public ModificarUsuarios(Usuarios usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonModificar);
        aplicarEstiloTextField(fieldUsuario);
        aplicarEstiloTextField(fieldNombre);
        aplicarEstiloTextField(fieldApellidos);
        aplicarEstiloTextField(fieldCorreo);
        aplicarEstiloTextField(fieldDni);
        aplicarEstiloTextField(fieldTelefono);
        aplicarEstiloTextField(fieldDireccion);
        
        this.usuario = usuario;
        reiniciarEtiquetas();
        mostrarDatos();
        
        //Listener para poder pasar al siguiente paso pulsando enter desde los textFields.
         ActionListener finalizarRegistroListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarModificarUsuario();
            }
         };

        fieldUsuario.addActionListener(finalizarRegistroListener);
        fieldNombre.addActionListener(finalizarRegistroListener);
        fieldApellidos.addActionListener(finalizarRegistroListener);
        fieldCorreo.addActionListener(finalizarRegistroListener);
        fieldDni.addActionListener(finalizarRegistroListener);
        fieldTelefono.addActionListener(finalizarRegistroListener);
        fieldDireccion.addActionListener(finalizarRegistroListener);
        
    }

    private void reiniciarEtiquetas(){
        textoErrorUsuario.setVisible(false);
        textoErrorCorreoElectronico.setVisible(false);
        textoErrorDni.setVisible(false);
        textoErrorNombre.setVisible(false);
        textoErrorApellidos.setVisible(false);
        textoErrorTelefono.setVisible(false);
        textoErrorDireccion.setVisible(false);
        this.revalidate(); 
        this.repaint(); 
    }
    
    private void mostrarDatos(){
        fieldUsuario.setText(usuario.getUsuario());
        fieldNombre.setText(usuario.getNombre());
        fieldApellidos.setText(usuario.getApellidos());
        fieldCorreo.setText(usuario.getCorreoElectronico());
        fieldDni.setText(usuario.getDni());
        fieldTelefono.setText(usuario.getNumeroTelefono());
        fieldDireccion.setText(usuario.getDireccion());
    }
    
        private boolean modificarUsuario(){
        reiniciarEtiquetas();
        boolean formatoCorrecto = true;
        
        //Comprobación de que el usuario no esta ya en uso.
        if(obtenerUsuarioPorUsuarioSql(fieldUsuario.getText()) != null && !usuario.getUsuario().equals(fieldUsuario.getText())){
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
        
                //Comprobación de que el dni no esta ya en uso.
        if(obtenerUsuarioPorDniSql(fieldDni.getText()) != null && !usuario.getDni().equals(fieldDni.getText())){
            formatoCorrecto = false;
                textoErrorDni.setText("Dni ya en uso.");
                    textoErrorDni.setVisible(true);            
        }
        
        //Comprobación de que el dni tenga el formato correcto.
        if (!fieldDni.getText().matches("^[0-9]{8}[A-Za-z]$")) {
            formatoCorrecto = false;
                textoErrorDni.setVisible(true);
                    textoErrorDni.setText("Debe introducir un dni valido.");
        }
        
        //Comprobación de que el dni no este vacio.
        if(fieldDni.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorDni.setVisible(true);
                    textoErrorDni.setText("Debe introducir un dni.");
        }
        
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
        
        //Comprobación de que la dirección no este vacio.
        if(fieldDireccion.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorDireccion.setVisible(true);
                    textoErrorDireccion.setText("Debe introducir una dirección.");
        }
        
        if(formatoCorrecto){
            usuario.setUsuario(fieldUsuario.getText());
            usuario.setNombre(fieldNombre.getText());
            usuario.setApellidos(fieldApellidos.getText());
            usuario.setCorreoElectronico(fieldCorreo.getText());
            usuario.setDni(fieldDni.getText().toUpperCase());
            usuario.setNumeroTelefono(fieldTelefono.getText());
            usuario.setDireccion(fieldDireccion.getText());
                        actualizarUsuarioSql(usuario);
                        return true;
        }else{
            return false;
        }
    }
        
        private void finalizarModificarUsuario(){
            if(modificarUsuario() == true){
                controlador.vistaUsuarios(this);
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

        formularioUsuario = new javax.swing.JPanel();
        fieldCorreo = new javax.swing.JTextField();
        labelCorreoElectronico = new javax.swing.JLabel();
        textoErrorCorreoElectronico = new javax.swing.JLabel();
        labelUsuario1 = new javax.swing.JLabel();
        fieldUsuario = new javax.swing.JTextField();
        textoErrorUsuario = new javax.swing.JLabel();
        labelIniciarSesion = new javax.swing.JLabel();
        textoErrorDireccion = new javax.swing.JLabel();
        fieldDireccion = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        textoErrorTelefono = new javax.swing.JLabel();
        fieldTelefono = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        textoErrorDni = new javax.swing.JLabel();
        fieldDni = new javax.swing.JTextField();
        labelDni = new javax.swing.JLabel();
        textoErrorApellidos = new javax.swing.JLabel();
        fieldApellidos = new javax.swing.JTextField();
        labelApellidos = new javax.swing.JLabel();
        textoErrorNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        botonModificar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Usuario");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formularioUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldCorreo.setToolTipText("");
        formularioUsuario.add(fieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 250, 40));

        labelCorreoElectronico.setForeground(new java.awt.Color(255, 255, 255));
        labelCorreoElectronico.setText("Correo Electrónico");
        formularioUsuario.add(labelCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 250, -1));

        textoErrorCorreoElectronico.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorCorreoElectronico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorCorreoElectronico.setText("Debe introducir un correo electrónico.");
        formularioUsuario.add(textoErrorCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 251, -1));

        labelUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario1.setText("Usuario");
        formularioUsuario.add(labelUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 250, -1));

        fieldUsuario.setToolTipText("");
        formularioUsuario.add(fieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 250, 40));

        textoErrorUsuario.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorUsuario.setText("Usuario ya en uso.");
        formularioUsuario.add(textoErrorUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, -1));

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelIniciarSesion.setText("AutoTech – Modificar Usuario");
        formularioUsuario.add(labelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 350, 40));

        textoErrorDireccion.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorDireccion.setText("Debe introducir una dirección.");
        formularioUsuario.add(textoErrorDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 250, -1));

        fieldDireccion.setToolTipText("");
        formularioUsuario.add(fieldDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 250, 40));

        labelDireccion.setForeground(new java.awt.Color(255, 255, 255));
        labelDireccion.setText("Dirección");
        formularioUsuario.add(labelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 250, -1));

        textoErrorTelefono.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorTelefono.setText("Debe introducir un teléfono.");
        formularioUsuario.add(textoErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 250, -1));

        fieldTelefono.setToolTipText("");
        formularioUsuario.add(fieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 250, 40));

        labelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        labelTelefono.setText("Teléfono");
        formularioUsuario.add(labelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 250, -1));

        textoErrorDni.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorDni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorDni.setText("El formato no es correcto.");
        formularioUsuario.add(textoErrorDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 250, -1));

        fieldDni.setToolTipText("");
        formularioUsuario.add(fieldDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 250, 40));

        labelDni.setForeground(new java.awt.Color(255, 255, 255));
        labelDni.setText("Dni");
        formularioUsuario.add(labelDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 250, -1));

        textoErrorApellidos.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorApellidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorApellidos.setText("Debe introducir un apellido.");
        formularioUsuario.add(textoErrorApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 250, -1));

        fieldApellidos.setToolTipText("");
        formularioUsuario.add(fieldApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 250, 40));

        labelApellidos.setForeground(new java.awt.Color(255, 255, 255));
        labelApellidos.setText("Apellidos");
        formularioUsuario.add(labelApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 250, -1));

        textoErrorNombre.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorNombre.setText("Debe introducir un nombre.");
        formularioUsuario.add(textoErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 250, -1));

        fieldNombre.setToolTipText("");
        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });
        formularioUsuario.add(fieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 250, 40));

        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Nombre");
        formularioUsuario.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 250, -1));

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        formularioUsuario.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 100, 30));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        formularioUsuario.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 100, 30));

        getContentPane().add(formularioUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 840, 420));
        formularioUsuario.setBackground(new java.awt.Color(0, 0, 0, 120));

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_formularios.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaUsuarios(this);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        finalizarModificarUsuario();
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
            java.util.logging.Logger.getLogger(ModificarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JTextField fieldApellidos;
    private javax.swing.JTextField fieldCorreo;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldDni;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JPanel formularioUsuario;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelCorreoElectronico;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelDni;
    private javax.swing.JLabel labelIniciarSesion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelUsuario1;
    private javax.swing.JLabel textoErrorApellidos;
    private javax.swing.JLabel textoErrorCorreoElectronico;
    private javax.swing.JLabel textoErrorDireccion;
    private javax.swing.JLabel textoErrorDni;
    private javax.swing.JLabel textoErrorNombre;
    private javax.swing.JLabel textoErrorTelefono;
    private javax.swing.JLabel textoErrorUsuario;
    // End of variables declaration//GEN-END:variables
}
