/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.cliente;

import davidpuertocuenca.autotech.clases.Citas;
import davidpuertocuenca.autotech.clases.Cliente;
import davidpuertocuenca.autotech.clases.Vehiculos;
import static davidpuertocuenca.autotech.dao.CitasDAO.eliminarCitaSql;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerCitaPorNumeroSql;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerTodasCitasMatriculaSql;
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
public class VistaCitasCliente extends javax.swing.JFrame {
    private Vehiculos vehiculo;
    //Usado para no perder los datos del cliente cuando se vuelve a la vista general.
    private Cliente cliente;
    /**
     * Creates new form VistaCitasCliente
     */
    public VistaCitasCliente() {
        initComponents();
        setExtendedState(VistaCitasCliente.MAXIMIZED_BOTH);
        crearTabla();
        //Requerido para que la opción de cerrar sesión aparezca a la derecha de la pantalla.     
        jMenuBar1.remove(jMenu5);
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu5);
    }
    
    public VistaCitasCliente(Vehiculos vehiculo, Cliente cliente) {
        initComponents();
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        setExtendedState(VistaCitasCliente.MAXIMIZED_BOTH);
        crearTabla();
        //Requerido para que la opción de cerrar sesión aparezca a la derecha de la pantalla.     
        jMenuBar1.remove(jMenu5);
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu5);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitasVehiculo = new javax.swing.JTable();
        labelCitasDelVehiculo = new javax.swing.JLabel();
        CabeceraVehiculos = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuClientes = new javax.swing.JMenu();
        JMenuItemPedirCita = new javax.swing.JMenuItem();
        JMenuItemModificarCita = new javax.swing.JMenuItem();
        JMenuItemCancelarCita = new javax.swing.JMenuItem();
        Vehículos = new javax.swing.JMenu();
        JMenuItemVehículos = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Citas Del Vehículo");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tablaCitasVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero De Cita", "Fecha", "Taller", "Matricula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCitasVehiculo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1864;
        gridBagConstraints.ipady = 900;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        labelCitasDelVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        labelCitasDelVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        labelCitasDelVehiculo.setText("Citas Del Vehículo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 128;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        getContentPane().add(labelCitasDelVehiculo, gridBagConstraints);

        CabeceraVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cliente/cabecera_vehiculos_prov.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = -66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        getContentPane().add(CabeceraVehiculos, gridBagConstraints);

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_vistaGeneral_prov.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipady = 509;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondoPantalla, gridBagConstraints);

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

        JMenuItemPedirCita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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

        JMenuItemCancelarCita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        JMenuItemCancelarCita.setText("Cancelar");
        JMenuItemCancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemCancelarCitaActionPerformed(evt);
            }
        });
        jMenuClientes.add(JMenuItemCancelarCita);

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
     
    }//GEN-LAST:event_JMenuItemPedirCitaActionPerformed

    private void JMenuItemModificarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemModificarCitaActionPerformed
        
    }//GEN-LAST:event_JMenuItemModificarCitaActionPerformed

    private void JMenuItemCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemCancelarCitaActionPerformed
        try{
            Citas cita = obtenerCitaPorNumeroSql((Long) tablaCitasVehiculo.getValueAt(tablaCitasVehiculo.getSelectedRow(), 0));
                if(vehiculo == null){
                    JOptionPane.showMessageDialog(this, "La cita no ha sido encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if(JOptionPane.showOptionDialog(this, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                    eliminarCitaSql(cita);
                }else{
                    JOptionPane.showMessageDialog(this, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
        }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una cita de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        //Siempre al finalizar actualiza la tabla.
        crearTabla();
    }//GEN-LAST:event_JMenuItemCancelarCitaActionPerformed

    private void JMenuItemVehículosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemVehículosActionPerformed
        VistaVehiculosCliente vvc = new VistaVehiculosCliente(cliente);
            vvc.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_JMenuItemVehículosActionPerformed

    private void jMenuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarSesionActionPerformed
        if(JOptionPane.showOptionDialog(this, "¿Desea cerrar sesíon?", "Cerrar Sesíon", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
            LoginClientes login = new LoginClientes();
                login.setVisible(true);
                    this.dispose();
        }
    }//GEN-LAST:event_jMenuItemCerrarSesionActionPerformed

    private void crearTabla() {
        Object[] cabecera = new Object[]{"Número de cita","Fecha","Vehiculo","Taller"}; 
        DefaultTableModel miModelo = new DefaultTableModel(cabecera, 0){
            //Edicion de celdas deshabilida.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  
            }
        };
        tablaCitasVehiculo.setModel(miModelo);
        tablaCitasVehiculo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaCitasVehiculo.getTableHeader().setReorderingAllowed(false);

            List<Citas> citas = new ArrayList(obtenerTodasCitasMatriculaSql(vehiculo));
           
            for(Citas Cita : citas){
                Object[] fila = new Object[4];
                fila[0] = Cita.getNumeroCita();
                fila[1] = Cita.getFecha();
                fila[2] = Cita.getVehiculo().getMatricula();
                fila[3] = Cita.getTaller();
                    miModelo.addRow(fila);
            } 
            
            //Dimensiones de la tabla.
            tablaCitasVehiculo.setRowHeight(40);
            TableColumn columnaNumeroCita = tablaCitasVehiculo.getColumn("Número de cita");
            columnaNumeroCita.setMinWidth(100);
            columnaNumeroCita.setMaxWidth(600);
            columnaNumeroCita.setPreferredWidth(300); 
            
            TableColumn columnaFecha = tablaCitasVehiculo.getColumn("Fecha");
            columnaFecha.setMinWidth(100);
            columnaFecha.setMaxWidth(600);
            columnaFecha.setPreferredWidth(300); 
            
            TableColumn columnaAnoVehiculo = tablaCitasVehiculo.getColumn("Vehiculo");
            columnaAnoVehiculo.setMinWidth(100);
            columnaAnoVehiculo.setMaxWidth(600);
            columnaAnoVehiculo.setPreferredWidth(300); 
            
            TableColumn columnaTaller = tablaCitasVehiculo.getColumn("Taller");
            columnaTaller.setMinWidth(100);
            columnaTaller.setMaxWidth(600);
            columnaTaller.setPreferredWidth(300); 
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tablaCitasVehiculo.getTableHeader().setResizingAllowed(false);
            //Usado para centrar el texto de las celdas.
            for (int i = 0; i < tablaCitasVehiculo.getColumnCount(); i++) {
                tablaCitasVehiculo.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                    tablaCitasVehiculo.getColumnModel().getColumn(i).setResizable(false);
            }
    }
    
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
            java.util.logging.Logger.getLogger(VistaCitasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCitasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCitasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCitasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCitasCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CabeceraVehiculos;
    private javax.swing.JMenuItem JMenuItemCancelarCita;
    private javax.swing.JMenuItem JMenuItemModificarCita;
    private javax.swing.JMenuItem JMenuItemPedirCita;
    private javax.swing.JMenuItem JMenuItemVehículos;
    private javax.swing.JMenu Vehículos;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenuItem jMenuItemCerrarSesion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCitasDelVehiculo;
    private javax.swing.JTable tablaCitasVehiculo;
    // End of variables declaration//GEN-END:variables
}
