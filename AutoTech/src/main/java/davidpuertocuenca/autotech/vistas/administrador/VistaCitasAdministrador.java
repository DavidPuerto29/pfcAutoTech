/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador;

import davidpuertocuenca.autotech.clases.Citas;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerTodasCitasSql;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author David
 */
public class VistaCitasAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form VitaCitasAdministrador
     */
    public VistaCitasAdministrador() {
        initComponents();
        crearTabla();
        setExtendedState(VistaVehiculosAdministrador.MAXIMIZED_BOTH);
        
        //Requerido para que la opción de cerrar sesión aparezca a la derecha de la pantalla.     
        jMenuBar1.remove(jMenu5);
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu5);
    }
    
    private void crearTabla() {
        Object[] cabecera = new Object[]{"Numero De Cita","Fecha","Nombre Del Taller","Matrícula","Cliente"}; 
        DefaultTableModel miModelo = new DefaultTableModel(cabecera, 0){
            //Edicion de celdas deshabilida.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  
            }
        };
        tablaCitas.setModel(miModelo);
        tablaCitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaCitas.getTableHeader().setReorderingAllowed(false);
                
            List<Citas> citas = new ArrayList(obtenerTodasCitasSql());
           
            for(Citas cita : citas){
                Object[] fila = new Object[5];
                fila[0] = cita.getNumeroCita();
                fila[1] = cita.getFecha();
                fila[2] = cita.getTaller().getNombre();
                fila[3] = cita.getVehiculo().getMatricula();
                fila[4] = cita.getVehiculo().getCliente().getNombre();
                    miModelo.addRow(fila);
            }
         
            //Dimensiones de la tabla.
            tablaCitas.setRowHeight(40);
            TableColumn columnaNumeroCita = tablaCitas.getColumn("Numero De Cita");
            columnaNumeroCita.setMinWidth(100);
            columnaNumeroCita.setMaxWidth(600);
            columnaNumeroCita.setPreferredWidth(300); 
            
            TableColumn columnaFecha = tablaCitas.getColumn("Fecha");
            columnaFecha.setMinWidth(100);
            columnaFecha.setMaxWidth(600);
            columnaFecha.setPreferredWidth(300); 
            
            TableColumn columnaTaller = tablaCitas.getColumn("Nombre Del Taller");
            columnaTaller.setMinWidth(100);
            columnaTaller.setMaxWidth(600);
            columnaTaller.setPreferredWidth(300); 
            
            TableColumn columnaMatricula = tablaCitas.getColumn("Matrícula");
            columnaMatricula.setMinWidth(100);
            columnaMatricula.setMaxWidth(600);
            columnaMatricula.setPreferredWidth(300);
            
            TableColumn columnaCliente = tablaCitas.getColumn("Cliente");
            columnaCliente.setMinWidth(100);
            columnaCliente.setMaxWidth(600);
            columnaCliente.setPreferredWidth(300);
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tablaCitas.getTableHeader().setResizingAllowed(false);
            //Usado para centrar el texto de las celdas.
            for (int i = 0; i < tablaCitas.getColumnCount(); i++) {
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                    tablaCitas.getColumnModel().getColumn(i).setResizable(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        labelGestionarCitas = new javax.swing.JLabel();
        CabeceraVehiculos = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuVehiculos2 = new javax.swing.JMenu();
        JMenuItemModificarCita = new javax.swing.JMenuItem();
        JMenuItemEliminarCita = new javax.swing.JMenuItem();
        jMenuClientes = new javax.swing.JMenu();
        JMenuItemClientes = new javax.swing.JMenuItem();
        jMenuVehiculos = new javax.swing.JMenu();
        JMenuItemVehiculos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemTalleres = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Citas Adminsitrador");
        getContentPane().setLayout(null);

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero De Cita", "Fecha", "Taller", "Vehiculo", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaCitas.setToolTipText("");
        jScrollPane1.setViewportView(tablaCitas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 1880, 890);

        labelGestionarCitas.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        labelGestionarCitas.setForeground(new java.awt.Color(255, 255, 255));
        labelGestionarCitas.setText("Gestión De Citas");
        labelGestionarCitas.setToolTipText("");
        getContentPane().add(labelGestionarCitas);
        labelGestionarCitas.setBounds(30, 20, 510, 80);

        CabeceraVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cliente/cabecera_vehiculos_prov.jpg"))); // NOI18N
        getContentPane().add(CabeceraVehiculos);
        CabeceraVehiculos.setBounds(20, 30, 1910, 66);

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_vistaGeneral_prov.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla);
        fondoPantalla.setBounds(0, 0, 2000, 1231);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(90, 32768));
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setOpaque(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(50, 50));

        jMenuVehiculos2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuVehiculos2.setText("Citas");
        jMenuVehiculos2.setToolTipText("");
        jMenuVehiculos2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuVehiculos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuVehiculos2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuVehiculos2.setMinimumSize(new java.awt.Dimension(50, 22));
        jMenuVehiculos2.setPreferredSize(new java.awt.Dimension(100, 40));

        JMenuItemModificarCita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemModificarCita.setText("Modificar");
        JMenuItemModificarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemModificarCitaActionPerformed(evt);
            }
        });
        jMenuVehiculos2.add(JMenuItemModificarCita);

        JMenuItemEliminarCita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemEliminarCita.setText("Eliminar");
        JMenuItemEliminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemEliminarCitaActionPerformed(evt);
            }
        });
        jMenuVehiculos2.add(JMenuItemEliminarCita);

        jMenuBar1.add(jMenuVehiculos2);

        jMenuClientes.setForeground(new java.awt.Color(255, 255, 255));
        jMenuClientes.setText("Clientes");
        jMenuClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuClientes.setPreferredSize(new java.awt.Dimension(100, 40));

        JMenuItemClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemClientes.setText("Menu De Clientes");
        JMenuItemClientes.setToolTipText("");
        JMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemClientesActionPerformed(evt);
            }
        });
        jMenuClientes.add(JMenuItemClientes);

        jMenuBar1.add(jMenuClientes);

        jMenuVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        jMenuVehiculos.setText("Vehículos");
        jMenuVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuVehiculos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuVehiculos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuVehiculos.setPreferredSize(new java.awt.Dimension(100, 40));

        JMenuItemVehiculos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemVehiculos.setText("Menu De Vehículos");
        JMenuItemVehiculos.setToolTipText("");
        JMenuItemVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemVehiculosActionPerformed(evt);
            }
        });
        jMenuVehiculos.add(JMenuItemVehiculos);

        jMenuBar1.add(jMenuVehiculos);

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

    private void JMenuItemModificarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemModificarCitaActionPerformed
        
    }//GEN-LAST:event_JMenuItemModificarCitaActionPerformed

    private void JMenuItemEliminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemEliminarCitaActionPerformed

    }//GEN-LAST:event_JMenuItemEliminarCitaActionPerformed

    private void JMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemClientesActionPerformed
        VistaClientesAdministrador vga = new VistaClientesAdministrador();
            vga.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_JMenuItemClientesActionPerformed

    private void jMenuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarSesionActionPerformed
        if(JOptionPane.showOptionDialog(this, "¿Desea cerrar sesíon?", "Cerrar Sesíon", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
            LoginClientes login = new LoginClientes();
                login.setVisible(true);
                    this.dispose();
        }
    }//GEN-LAST:event_jMenuItemCerrarSesionActionPerformed

    private void JMenuItemVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemVehiculosActionPerformed
        VistaVehiculosAdministrador vha = new VistaVehiculosAdministrador();
            vha.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_JMenuItemVehiculosActionPerformed

    private void jMenuItemTalleresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTalleresActionPerformed
        VistaTalleresAdministrador vta = new VistaTalleresAdministrador();
            vta.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_jMenuItemTalleresActionPerformed

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
            java.util.logging.Logger.getLogger(VistaCitasAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCitasAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCitasAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCitasAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCitasAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CabeceraVehiculos;
    private javax.swing.JMenuItem JMenuItemClientes;
    private javax.swing.JMenuItem JMenuItemEliminarCita;
    private javax.swing.JMenuItem JMenuItemModificarCita;
    private javax.swing.JMenuItem JMenuItemVehiculos;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenuItem jMenuItemCerrarSesion;
    private javax.swing.JMenuItem jMenuItemTalleres;
    private javax.swing.JMenu jMenuVehiculos;
    private javax.swing.JMenu jMenuVehiculos2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGestionarCitas;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}
