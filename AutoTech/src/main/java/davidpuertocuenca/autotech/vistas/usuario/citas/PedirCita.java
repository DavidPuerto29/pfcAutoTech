/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.usuario.citas;

import davidpuertocuenca.autotech.clases.Citas;
import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.clases.Vehiculos;
import davidpuertocuenca.autotech.controladores.UsuarioControlador;
import static davidpuertocuenca.autotech.dao.CitasDAO.crearCitaSql;
import static davidpuertocuenca.autotech.dao.TalleresDAO.obtenerTallerPorNombreSql;
import davidpuertocuenca.autotech.vistas.usuario.Vehiculos.AnadirVehiculoPaso1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author David Puerto Cuenca
 */
public class PedirCita extends javax.swing.JFrame {
    private UsuarioControlador controlador = new UsuarioControlador();
    private Citas cita;
    private Usuarios usuario;
    private Vehiculos vehiculo;
    /**
     * Creates new form PedirCita
     */
    public PedirCita() {
        initComponents();
        setExtendedState(PedirCita.MAXIMIZED_BOTH);
        reiniciarEtiquetas();
        controlador.cargarTalleresComboBox(boxTalleres);
       
        //Listener para que cuando se seleccione una fecha se carguen los horarios.
        calendarioDiasCita.addPropertyChangeListener(new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent evt) { 
                controlador.cargarHorariosCitasJComboBox(calendarioDiasCita, boxHorario, obtenerTallerPorNombreSql((String) boxTalleres.getSelectedItem()));
            }
         });
         
    }
    
    public PedirCita(Usuarios usuario, Vehiculos vehiculo) {
        initComponents();
        setExtendedState(PedirCita.MAXIMIZED_BOTH);
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        reiniciarEtiquetas();
        controlador.cargarTalleresComboBox(boxTalleres);
       
        //Listener para que cuando se seleccione una fecha se carguen los horarios.
        calendarioDiasCita.addPropertyChangeListener(new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent evt) { 
                controlador.cargarHorariosCitasJComboBox(calendarioDiasCita, boxHorario, obtenerTallerPorNombreSql((String) boxTalleres.getSelectedItem()));
            }
        });
        
        //Listener para poder pasar al siguiente paso pulsando enter desde los textFields.
         ActionListener ModificarVehiculoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearCita();
            }
         };
        
         textDescripcion.addActionListener(ModificarVehiculoListener);
        
    } 
    
    private void reiniciarEtiquetas(){
        textoErrorTaller.setVisible(false);
        textoErrorHora.setVisible(false);
        textoErrorMotivo.setVisible(false);   
        this.revalidate(); 
        this.repaint(); 
    }
    
    public boolean anadirCita(){
        reiniciarEtiquetas();
        boolean formatoCorrecto = true;
        
        //En caso de que el usuario no haya seleccionado un taller.
        if(boxTalleres.getSelectedIndex() == 0){
            formatoCorrecto = false;
                textoErrorTaller.setText("Debe seleccionar un taller.");
                    textoErrorTaller.setVisible(true);   
        }
        
        //En caso de que el usuario no haya seleccionado una hora.
        if(boxHorario.getSelectedIndex() == 0){
            formatoCorrecto = false;
                textoErrorHora.setText("Debe seleccionar una hora.");
                    textoErrorHora.setVisible(true);   
        }
        
        //En caso de que el usuario no haya introducido el motivo de la cita.
        if(textDescripcion.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorMotivo.setText("Debe describir el motivo.");
                    textoErrorMotivo.setVisible(true);   
        }
        
        try{
        Date fechaFinal = Date.from(LocalDateTime.of(calendarioDiasCita.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),LocalTime.parse((String) boxHorario.getSelectedItem())).atZone(ZoneId.systemDefault()).toInstant());
        
        //Comprobación de que un vehiculo no puede tener dos citas el mismo dia y a la misma hora.
        if(!controlador.comprobarCitasIgualesVehiculo(fechaFinal, vehiculo)){
            formatoCorrecto = false;
                JOptionPane.showMessageDialog(this, "Este vehículo ya tiene una cita programada para la fecha y hora indicadas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if(formatoCorrecto){
                cita = new Citas(fechaFinal, vehiculo, obtenerTallerPorNombreSql((String) boxTalleres.getSelectedItem()), textDescripcion.getText(), 1);
                    return true;
        }
        return false;
        //REVISAR
        }catch (java.time.format.DateTimeParseException e){
                controlador.cargarHorariosCitasJComboBox(calendarioDiasCita, boxHorario, obtenerTallerPorNombreSql((String) boxTalleres.getSelectedItem()));
        }
        return false;
    }
    
    private void crearCita(){
        if(anadirCita()){
            crearCitaSql(cita);
                controlador.vistaCitasConVehiculo(vehiculo, usuario, this);
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

        boxHorario = new javax.swing.JComboBox();
        labelFecha = new javax.swing.JLabel();
        labelMotivo = new javax.swing.JLabel();
        labelHorario = new javax.swing.JLabel();
        textoErrorHora = new javax.swing.JLabel();
        textoErrorTaller = new javax.swing.JLabel();
        textoErrorMotivo = new javax.swing.JLabel();
        labelTaller = new javax.swing.JLabel();
        textDescripcion = new javax.swing.JTextField();
        calendarioDiasCita = new com.toedter.calendar.JCalendar();
        boxTalleres = new javax.swing.JComboBox<>();
        botonCancelar = new javax.swing.JButton();
        botonPedir = new javax.swing.JButton();
        labelIniciarSesion = new javax.swing.JLabel();
        fondoCabecera = new javax.swing.JLabel();
        fondoLogin = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pedir Cita");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        boxHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una hora." }));
        boxHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxHorarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 960, 0, 0);
        getContentPane().add(boxHorario, gridBagConstraints);

        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText("Fecha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 89;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 960, 0, 0);
        getContentPane().add(labelFecha, gridBagConstraints);

        labelMotivo.setForeground(new java.awt.Color(255, 255, 255));
        labelMotivo.setText("Breve descripción");
        labelMotivo.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 960, 0, 0);
        getContentPane().add(labelMotivo, gridBagConstraints);

        labelHorario.setForeground(new java.awt.Color(255, 255, 255));
        labelHorario.setText("Horario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 960, 0, 0);
        getContentPane().add(labelHorario, gridBagConstraints);

        textoErrorHora.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorHora.setText("Debe seleccionar una hora.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 960, 0, 0);
        getContentPane().add(textoErrorHora, gridBagConstraints);

        textoErrorTaller.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorTaller.setText("Debe seleccionar un taller.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 960, 0, 0);
        getContentPane().add(textoErrorTaller, gridBagConstraints);

        textoErrorMotivo.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorMotivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorMotivo.setText("Debe describir el motivo.");
        textoErrorMotivo.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 960, 0, 0);
        getContentPane().add(textoErrorMotivo, gridBagConstraints);

        labelTaller.setForeground(new java.awt.Color(255, 255, 255));
        labelTaller.setText("Taller");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 960, 0, 0);
        getContentPane().add(labelTaller, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 960, 0, 0);
        getContentPane().add(textDescripcion, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 960, 0, 0);
        getContentPane().add(calendarioDiasCita, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 148;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 960, 0, 0);
        getContentPane().add(boxTalleres, gridBagConstraints);

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 980, 0, 0);
        getContentPane().add(botonCancelar, gridBagConstraints);

        botonPedir.setText("Pedir");
        botonPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 40, 0, 0);
        getContentPane().add(botonPedir, gridBagConstraints);

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelIniciarSesion.setText("Pedir Cita");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(200, 1000, 0, 0);
        getContentPane().add(labelIniciarSesion, gridBagConstraints);

        fondoCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cabecera_prov.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -1566;
        gridBagConstraints.ipady = -82;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(200, 960, 0, 0);
        getContentPane().add(fondoCabecera, gridBagConstraints);

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_login_prov .jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 15;
        gridBagConstraints.ipadx = -2464;
        gridBagConstraints.ipady = -3232;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 780, 0, 0);
        getContentPane().add(fondoLogin, gridBagConstraints);

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_prov.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 16;
        gridBagConstraints.ipadx = 220;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondoPantalla, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxHorarioActionPerformed

    private void botonPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedirActionPerformed
        crearCita();
    }//GEN-LAST:event_botonPedirActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaCitasConVehiculo(vehiculo, usuario, this);
    }//GEN-LAST:event_botonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(PedirCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedirCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedirCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedirCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedirCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonPedir;
    private javax.swing.JComboBox boxHorario;
    private javax.swing.JComboBox<String> boxTalleres;
    private com.toedter.calendar.JCalendar calendarioDiasCita;
    private javax.swing.JLabel fondoCabecera;
    private javax.swing.JLabel fondoLogin;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHorario;
    private javax.swing.JLabel labelIniciarSesion;
    private javax.swing.JLabel labelMotivo;
    private javax.swing.JLabel labelTaller;
    private javax.swing.JTextField textDescripcion;
    private javax.swing.JLabel textoErrorHora;
    private javax.swing.JLabel textoErrorMotivo;
    private javax.swing.JLabel textoErrorTaller;
    // End of variables declaration//GEN-END:variables
}
