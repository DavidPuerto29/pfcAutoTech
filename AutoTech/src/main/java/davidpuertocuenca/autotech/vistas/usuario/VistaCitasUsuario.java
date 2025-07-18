/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.usuario;

import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.clases.Vehiculos;
import davidpuertocuenca.autotech.controladores.UsuarioControlador;

/**
 *
 * @author David Puerto Cuenca
 */
public class VistaCitasUsuario extends javax.swing.JFrame {
    private Vehiculos vehiculo;
    //Usado para no perder los datos del cliente cuando se vuelve a la vista general.
    private Usuarios usuario;
    private UsuarioControlador controlador = new UsuarioControlador();
    /**
     * Creates new form VistaCitasCliente
     */
    public VistaCitasUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
         controlador.crearTablaCitas(tablaCitasVehiculo, vehiculo);
        controlador.colocarCerrarSesion(jMenuBar1, jMenu5); 
    }
    
    public VistaCitasUsuario(Vehiculos vehiculo, Usuarios usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        controlador.crearTablaCitas(tablaCitasVehiculo, vehiculo);
        controlador.colocarCerrarSesion(jMenuBar1, jMenu5); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        organizadorVista = new javax.swing.JPanel();
        labelCitasDelVehiculo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitasVehiculo = new javax.swing.JTable();
        CabeceraVehiculos = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuClientes = new javax.swing.JMenu();
        JMenuItemPedirCita = new javax.swing.JMenuItem();
        JMenuItemModificarCita = new javax.swing.JMenuItem();
        Vehículos = new javax.swing.JMenu();
        JMenuItemVehículos = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoTech - Usuario");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizadorVista.setBackground(new java.awt.Color(255, 255, 255));
        organizadorVista.setLayout(null);

        labelCitasDelVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        labelCitasDelVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        labelCitasDelVehiculo.setText("Citas Del Vehículo");
        organizadorVista.add(labelCitasDelVehiculo);
        labelCitasDelVehiculo.setBounds(20, 10, 510, 70);

        tablaCitasVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero De Cita", "Fecha", "Taller", "Matricula", "Estado De La Cita"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCitasVehiculo);

        organizadorVista.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 1250, 530);

        CabeceraVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cliente/cabecera_vehiculos_prov.jpg"))); // NOI18N
        organizadorVista.add(CabeceraVehiculos);
        CabeceraVehiculos.setBounds(10, 10, 1250, 66);

        getContentPane().add(organizadorVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 670));

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(90, 32768));
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setOpaque(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(50, 50));

        jMenuClientes.setForeground(new java.awt.Color(255, 255, 255));
        jMenuClientes.setText("Citas");
        jMenuClientes.setToolTipText("");
        jMenuClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuClientes.setMinimumSize(new java.awt.Dimension(50, 22));
        jMenuClientes.setPreferredSize(new java.awt.Dimension(100, 40));

        JMenuItemPedirCita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemPedirCita.setText("Pedir Cita");
        JMenuItemPedirCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemPedirCitaActionPerformed(evt);
            }
        });
        jMenuClientes.add(JMenuItemPedirCita);

        JMenuItemModificarCita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemModificarCita.setText("Modificar");
        JMenuItemModificarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemModificarCitaActionPerformed(evt);
            }
        });
        jMenuClientes.add(JMenuItemModificarCita);

        jMenuBar1.add(jMenuClientes);

        Vehículos.setForeground(new java.awt.Color(255, 255, 255));
        Vehículos.setText("Vehículos");
        Vehículos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Vehículos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Vehículos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Vehículos.setPreferredSize(new java.awt.Dimension(100, 40));

        JMenuItemVehículos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemVehículos.setText("Mis Vehículos");
        JMenuItemVehículos.setToolTipText("");
        JMenuItemVehículos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemVehículosActionPerformed(evt);
            }
        });
        Vehículos.add(JMenuItemVehículos);

        jMenuBar1.add(Vehículos);

        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setText("Cerrar Sesión");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setPreferredSize(new java.awt.Dimension(100, 40));

        jMenuItemCerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemCerrarSesion.setText("Cerrar Sesión");
        jMenuItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarSesionActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemCerrarSesion);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMenuItemPedirCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemPedirCitaActionPerformed
        controlador.vistaPedirCita(usuario, vehiculo, this);
    }//GEN-LAST:event_JMenuItemPedirCitaActionPerformed

    private void JMenuItemModificarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemModificarCitaActionPerformed
        controlador.vistaModificarCita(tablaCitasVehiculo, usuario, vehiculo, this);
    }//GEN-LAST:event_JMenuItemModificarCitaActionPerformed

    private void JMenuItemVehículosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemVehículosActionPerformed
        controlador.vistaVehiculos(this, usuario);
    }//GEN-LAST:event_JMenuItemVehículosActionPerformed

    private void jMenuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarSesionActionPerformed
        controlador.cerrarSesion(this);
    }//GEN-LAST:event_jMenuItemCerrarSesionActionPerformed

    
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
            java.util.logging.Logger.getLogger(VistaCitasUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCitasUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCitasUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCitasUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCitasUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CabeceraVehiculos;
    private javax.swing.JMenuItem JMenuItemModificarCita;
    private javax.swing.JMenuItem JMenuItemPedirCita;
    private javax.swing.JMenuItem JMenuItemVehículos;
    private javax.swing.JMenu Vehículos;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenuItem jMenuItemCerrarSesion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCitasDelVehiculo;
    private javax.swing.JPanel organizadorVista;
    private javax.swing.JTable tablaCitasVehiculo;
    // End of variables declaration//GEN-END:variables
}
