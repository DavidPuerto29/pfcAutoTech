/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador.citas;

import davidpuertocuenca.autotech.clases.Citas;
import davidpuertocuenca.autotech.clases.Vehiculos;
import davidpuertocuenca.autotech.controladores.AdministradorControlador;
import static davidpuertocuenca.autotech.dao.CitasDAO.actualizarCitaSql;
import static davidpuertocuenca.autotech.dao.TalleresDAO.obtenerTallerPorNombreSql;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloBoton;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloComboBox;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloJCalendar;
import static davidpuertocuenca.autotech.util.Estilos.aplicarEstiloTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author David  Puerto Cuenca
 */
public class ModificarCitaAdministrador extends javax.swing.JFrame {
    private AdministradorControlador controlador = new AdministradorControlador();
    private Citas cita;
    private Vehiculos vehiculo;
    /**
     * Creates new form ModificarCita
     */
    
    public ModificarCitaAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonModificar);
        aplicarEstiloTextField(textDescripcion);
        aplicarEstiloComboBox(boxTalleres);
        aplicarEstiloComboBox(boxHorario);
        aplicarEstiloJCalendar(calendarioDiasCita);
        
        reiniciarEtiquetas();
        rellenarCampos();
    }
    
    public ModificarCitaAdministrador(Vehiculos vehiculo, Citas cita) {
        initComponents();
        this.setLocationRelativeTo(null);
        //Estilos FrontEnd
        aplicarEstiloBoton(botonCancelar);
        aplicarEstiloBoton(botonModificar);
        aplicarEstiloTextField(textDescripcion);
        aplicarEstiloComboBox(boxTalleres);
        aplicarEstiloComboBox(boxHorario);
        aplicarEstiloJCalendar(calendarioDiasCita);
        
        this.vehiculo = vehiculo;
        this.cita = cita;
        reiniciarEtiquetas();
        rellenarCampos();
        
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
                finalizarModificarCita();
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
        
        public void rellenarCampos(){
            controlador.cargarTalleresSeleccionadoComboBox(boxTalleres, cita);
            controlador.cargarHorariosCitasSeleccionadoJComboBox(calendarioDiasCita, boxHorario, obtenerTallerPorNombreSql((String) boxTalleres.getSelectedItem()), cita);
            calendarioDiasCita.setDate(cita.getFecha());
            textDescripcion.setText(cita.getDescripcion());
        }
        
        public boolean modificarCita(){
        reiniciarEtiquetas();
        boolean formatoCorrecto = true;
        
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
                    cita.setFecha(fechaFinal);
                    cita.setVehiculo(vehiculo);
                    cita.setTaller(obtenerTallerPorNombreSql((String) boxTalleres.getSelectedItem()));
                    cita.setDescripcion(textDescripcion.getText());
                        return true;
            }
            return false;
        }catch (DateTimeParseException e){
            controlador.cargarHorariosCitasJComboBox(calendarioDiasCita, boxHorario, obtenerTallerPorNombreSql((String) boxTalleres.getSelectedItem()));
        }
        return false;
    }
        
        private void finalizarModificarCita(){
            if(modificarCita()){
                actualizarCitaSql(cita);
                    controlador.vistaCitas(this);
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

        formularioCita = new javax.swing.JPanel();
        textoErrorHora = new javax.swing.JLabel();
        calendarioDiasCita = new com.toedter.calendar.JCalendar();
        labelIniciarSesion = new javax.swing.JLabel();
        textoErrorMotivo = new javax.swing.JLabel();
        labelHorario = new javax.swing.JLabel();
        textDescripcion = new javax.swing.JTextField();
        labelFecha = new javax.swing.JLabel();
        botonModificar = new javax.swing.JButton();
        boxHorario = new javax.swing.JComboBox();
        textoErrorTaller = new javax.swing.JLabel();
        labelTaller = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        boxTalleres = new javax.swing.JComboBox<>();
        labelMotivo = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoTech - Administrador");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formularioCita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoErrorHora.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorHora.setText("Debe seleccionar una hora.");
        formularioCita.add(textoErrorHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 250, -1));
        formularioCita.add(calendarioDiasCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 250, 143));

        labelIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labelIniciarSesion.setText("AutoTech – Modificar Cita");
        formularioCita.add(labelIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 290, 40));

        textoErrorMotivo.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorMotivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorMotivo.setText("Debe describir el motivo.");
        textoErrorMotivo.setToolTipText("");
        formularioCita.add(textoErrorMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 250, -1));

        labelHorario.setForeground(new java.awt.Color(255, 255, 255));
        labelHorario.setText("Horario");
        formularioCita.add(labelHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 250, -1));
        formularioCita.add(textDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 250, 40));

        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText("Fecha");
        formularioCita.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 120, -1));

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        formularioCita.add(botonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 100, 30));

        boxHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una hora." }));
        boxHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxHorarioActionPerformed(evt);
            }
        });
        formularioCita.add(boxHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 250, 40));

        textoErrorTaller.setForeground(new java.awt.Color(255, 0, 0));
        textoErrorTaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error_prov.png"))); // NOI18N
        textoErrorTaller.setText("Debe seleccionar un taller.");
        formularioCita.add(textoErrorTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 250, -1));

        labelTaller.setForeground(new java.awt.Color(255, 255, 255));
        labelTaller.setText("Taller");
        formularioCita.add(labelTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 250, -1));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        formularioCita.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 100, 30));

        formularioCita.add(boxTalleres, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 250, 40));

        labelMotivo.setForeground(new java.awt.Color(255, 255, 255));
        labelMotivo.setText("Breve descripción");
        labelMotivo.setToolTipText("");
        formularioCita.add(labelMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 120, -1));

        getContentPane().add(formularioCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 520, 620));
        formularioCita.setBackground(new java.awt.Color(0, 0, 0, 120));

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_formularios.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxHorarioActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        controlador.vistaCitas(this);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        finalizarModificarCita();
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
            java.util.logging.Logger.getLogger(ModificarCitaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarCitaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarCitaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarCitaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarCitaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JComboBox boxHorario;
    private javax.swing.JComboBox<String> boxTalleres;
    private com.toedter.calendar.JCalendar calendarioDiasCita;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JPanel formularioCita;
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
