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
        this.setLocationRelativeTo(null);
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
        this.setLocationRelativeTo(null);
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
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boxHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una hora." }));
        boxHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxHorarioActionPerformed(evt);
            }
        });
        getContentPane().add(boxHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 220, 40));

        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText("Fecha");
        getContentPane().add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 119, -1));

        labelMotivo.setForeground(new java.awt.Color(255, 255, 255));
        labelMotivo.setText("Breve descripción");
        labelMotivo.setToolTipText("");
        getContentPane().add(labelMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 121, -1));

        labelHorario.setForeground(new java.awt.Color(255, 255, 255));
        labelHorario.setText("Horario");
        getContentPane().add(labelHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 121, -1));

        textoErrorHora.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorHora.setText("Debe seleccionar una hora.");
        getContentPane().add(textoErrorHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 181, -1));

        textoErrorTaller.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorTaller.setText("Debe seleccionar un taller.");
        getContentPane().add(textoErrorTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 182, -1));

        textoErrorMotivo.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorMotivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorMotivo.setText("Debe describir el motivo.");
        textoErrorMotivo.setToolTipText("");
        getContentPane().add(textoErrorMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 580, 183, -1));

        labelTaller.setForeground(new java.awt.Color(255, 255, 255));
        labelTaller.setText("Taller");
        getContentPane().add(labelTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 121, -1));
        getContentPane().add(textDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, 220, 40));
        getContentPane().add(calendarioDiasCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 191, 143));

        getContentPane().add(boxTalleres, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 220, 40));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 620, 100, -1));

        botonPedir.setText("Pedir");
        botonPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedirActionPerformed(evt);
            }
        });
        getContentPane().add(botonPedir, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 620, -1, -1));

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelIniciarSesion.setText("Pedir Cita");
        getContentPane().add(labelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 150, 40));

        fondoCabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cabecera_prov.png"))); // NOI18N
        getContentPane().add(fondoCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 180, 50));

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_login_prov .jpg"))); // NOI18N
        getContentPane().add(fondoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 560, 650));

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_prov.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 690));

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
