/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador;

import davidpuertocuenca.autotech.controladores.AdministradorControlador;


/**
 *
 * @author David Puerto Cuenca
 */
public class VistaVehiculosAdministrador extends javax.swing.JFrame {
    private AdministradorControlador controlador = new AdministradorControlador();
    /**
     * Creates new form VistaVehiculosAdministrador
     */
    public VistaVehiculosAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        controlador.crearTablaVehiculos(tablaVehiculos, this);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        labelGestionarVehiculos = new javax.swing.JLabel();
        CabeceraVehiculos = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuVehiculos = new javax.swing.JMenu();
        JMenuItemAnadirVehiculo = new javax.swing.JMenuItem();
        JMenuItemModificarVehiculo = new javax.swing.JMenuItem();
        JMenuItemEliminarVehiculo = new javax.swing.JMenuItem();
        jMenuUsuarios = new javax.swing.JMenu();
        JMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JMenuItemCitas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemTalleres = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoTech - Administrador");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizadorVista.setBackground(new java.awt.Color(255, 255, 255));
        organizadorVista.setLayout(null);

        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Matrícula", "Marca", "Modelo", "Año De Matriculación", "Color", "Citas Reservadas", "Número De Bastidor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaVehiculos.setToolTipText("");
        jScrollPane1.setViewportView(tablaVehiculos);

        organizadorVista.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 1250, 530);

        labelGestionarVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        labelGestionarVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        labelGestionarVehiculos.setText("Gestión De Vehículos");
        labelGestionarVehiculos.setToolTipText("");
        organizadorVista.add(labelGestionarVehiculos);
        labelGestionarVehiculos.setBounds(20, 10, 620, 70);

        CabeceraVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cliente/cabecera_vehiculos_prov.jpg"))); // NOI18N
        organizadorVista.add(CabeceraVehiculos);
        CabeceraVehiculos.setBounds(10, 10, 1250, 66);

        getContentPane().add(organizadorVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 670));

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(90, 32768));
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setOpaque(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(50, 50));

        jMenuVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        jMenuVehiculos.setText("Vehículos");
        jMenuVehiculos.setToolTipText("");
        jMenuVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuVehiculos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuVehiculos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuVehiculos.setMinimumSize(new java.awt.Dimension(50, 22));
        jMenuVehiculos.setPreferredSize(new java.awt.Dimension(100, 40));

        JMenuItemAnadirVehiculo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemAnadirVehiculo.setText("Añadir");
        JMenuItemAnadirVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemAnadirVehiculoActionPerformed(evt);
            }
        });
        jMenuVehiculos.add(JMenuItemAnadirVehiculo);

        JMenuItemModificarVehiculo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemModificarVehiculo.setText("Modificar");
        JMenuItemModificarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemModificarVehiculoActionPerformed(evt);
            }
        });
        jMenuVehiculos.add(JMenuItemModificarVehiculo);

        JMenuItemEliminarVehiculo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemEliminarVehiculo.setText("Eliminar");
        JMenuItemEliminarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemEliminarVehiculoActionPerformed(evt);
            }
        });
        jMenuVehiculos.add(JMenuItemEliminarVehiculo);

        jMenuBar1.add(jMenuVehiculos);

        jMenuUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jMenuUsuarios.setText("Usuarios");
        jMenuUsuarios.setToolTipText("");
        jMenuUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuUsuarios.setPreferredSize(new java.awt.Dimension(100, 40));

        JMenuItemUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemUsuarios.setText("Menu De Usuarios");
        JMenuItemUsuarios.setToolTipText("");
        JMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(JMenuItemUsuarios);

        jMenuBar1.add(jMenuUsuarios);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Citas");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.setPreferredSize(new java.awt.Dimension(100, 40));

        JMenuItemCitas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemCitas.setText("Menu De Citas");
        JMenuItemCitas.setToolTipText("");
        JMenuItemCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemCitasActionPerformed(evt);
            }
        });
        jMenu3.add(JMenuItemCitas);

        jMenuBar1.add(jMenu3);

        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("Talleres");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu4.setPreferredSize(new java.awt.Dimension(100, 40));

        jMenuItemTalleres.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemTalleres.setText("Menu De Talleres");
        jMenuItemTalleres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTalleresActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemTalleres);

        jMenuBar1.add(jMenu4);

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

    private void JMenuItemModificarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemModificarVehiculoActionPerformed
        controlador.vistaModificarVehiculo(tablaVehiculos, this);
    }//GEN-LAST:event_JMenuItemModificarVehiculoActionPerformed

    private void JMenuItemEliminarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemEliminarVehiculoActionPerformed
        controlador.eliminarVehiculo(tablaVehiculos, this);
    }//GEN-LAST:event_JMenuItemEliminarVehiculoActionPerformed

    private void JMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemUsuariosActionPerformed
        controlador.vistaUsuarios(this);
    }//GEN-LAST:event_JMenuItemUsuariosActionPerformed

    private void jMenuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarSesionActionPerformed
        controlador.cerrarSesion(this);
    }//GEN-LAST:event_jMenuItemCerrarSesionActionPerformed

    private void JMenuItemCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemCitasActionPerformed
        controlador.vistaCitas(this);
    }//GEN-LAST:event_JMenuItemCitasActionPerformed

    private void jMenuItemTalleresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTalleresActionPerformed
       controlador.vistaTalleres(this);
    }//GEN-LAST:event_jMenuItemTalleresActionPerformed

    private void JMenuItemAnadirVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemAnadirVehiculoActionPerformed
        controlador.vistaAnadirVehiculo(this);
    }//GEN-LAST:event_JMenuItemAnadirVehiculoActionPerformed

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
            java.util.logging.Logger.getLogger(VistaVehiculosAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaVehiculosAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaVehiculosAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaVehiculosAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaVehiculosAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CabeceraVehiculos;
    private javax.swing.JMenuItem JMenuItemAnadirVehiculo;
    private javax.swing.JMenuItem JMenuItemCitas;
    private javax.swing.JMenuItem JMenuItemEliminarVehiculo;
    private javax.swing.JMenuItem JMenuItemModificarVehiculo;
    private javax.swing.JMenuItem JMenuItemUsuarios;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCerrarSesion;
    private javax.swing.JMenuItem jMenuItemTalleres;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JMenu jMenuVehiculos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGestionarVehiculos;
    private javax.swing.JPanel organizadorVista;
    private javax.swing.JTable tablaVehiculos;
    // End of variables declaration//GEN-END:variables
}
