/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador;

import davidpuertocuenca.autotech.clases.Vehiculos;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.eliminarVehiculoSql;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerTodosVehiculosSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoMatriculaSql;
import davidpuertocuenca.autotech.vistas.administrador.vehiculo.ModificarVehiculo;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author David
 */
public class VistaVehiculosAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form VistaVehiculosAdministrador
     */
    public VistaVehiculosAdministrador() {
        initComponents();
        crearTabla();
        setExtendedState(VistaVehiculosAdministrador.MAXIMIZED_BOTH);
        //Requerido para que la opción de cerrar sesión aparezca a la derecha de la pantalla.     
        jMenuBar1.remove(jMenu5);
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu5);
    }

    private void crearTabla() {
        Object[] cabecera = new Object[]{"Matrícula", "Marca", "Modelo", "Año De Matriculación", "Color", "Citas Reservadas", "Número De Bastidor"}; 
        DefaultTableModel miModelo = new DefaultTableModel(cabecera, 0){
            //Edicion de celdas deshabilida.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  
            }
        };
        tablaVehiculos.setModel(miModelo);
        tablaVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaVehiculos.getTableHeader().setReorderingAllowed(false);
                
            List<Vehiculos> vehiculos = new ArrayList(obtenerTodosVehiculosSql());
           
            for(Vehiculos Vehiculo : vehiculos){
                Object[] fila = new Object[7];
                fila[0] = Vehiculo.getMatricula();
                fila[1] = Vehiculo.getMarca();
                fila[2] = Vehiculo.getModelo();
                fila[3] = Vehiculo.getAnoMatriculacion();
                fila[4] = Vehiculo.getColor();
                fila[5] = Vehiculo.getCitas().size();
                fila[6] = Vehiculo.getNumeroBastidor();
                    miModelo.addRow(fila);
            }
         
            //Dimensiones de la tabla.
            tablaVehiculos.setRowHeight(40);
            TableColumn columnaMatricula = tablaVehiculos.getColumn("Matrícula");
            columnaMatricula.setMinWidth(100);
            columnaMatricula.setMaxWidth(600);
            columnaMatricula.setPreferredWidth(300); 
            
            TableColumn columnaMarca = tablaVehiculos.getColumn("Marca");
            columnaMarca.setMinWidth(100);
            columnaMarca.setMaxWidth(600);
            columnaMarca.setPreferredWidth(300); 
            
            TableColumn columnaModelo = tablaVehiculos.getColumn("Modelo");
            columnaModelo.setMinWidth(100);
            columnaModelo.setMaxWidth(600);
            columnaModelo.setPreferredWidth(300); 
            
            TableColumn columnaAnoMatriculacion = tablaVehiculos.getColumn("Año De Matriculación");
            columnaAnoMatriculacion.setMinWidth(100);
            columnaAnoMatriculacion.setMaxWidth(600);
            columnaAnoMatriculacion.setPreferredWidth(300); 
            
            TableColumn columnaColor = tablaVehiculos.getColumn("Color");
            columnaColor.setMinWidth(100);
            columnaColor.setMaxWidth(600);
            columnaColor.setPreferredWidth(300); 
            
            TableColumn columnaCitas = tablaVehiculos.getColumn("Citas Reservadas");
            columnaCitas.setMinWidth(100);
            columnaCitas.setMaxWidth(600);
            columnaCitas.setPreferredWidth(300);
            
            TableColumn columnaBastidor = tablaVehiculos.getColumn("Número De Bastidor");
            columnaBastidor.setMinWidth(100);
            columnaBastidor.setMaxWidth(600);
            columnaBastidor.setPreferredWidth(300); 
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tablaVehiculos.getTableHeader().setResizingAllowed(false);
            //Usado para centrar el texto de las celdas.
            for (int i = 0; i < tablaVehiculos.getColumnCount(); i++) {
                tablaVehiculos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                     tablaVehiculos.getColumnModel().getColumn(i).setResizable(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        labelGestionarVehiculos = new javax.swing.JLabel();
        CabeceraVehiculos = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuVehiculos = new javax.swing.JMenu();
        JMenuItemModificarVehiculo = new javax.swing.JMenuItem();
        JMenuItemEliminarVehiculo = new javax.swing.JMenuItem();
        jMenuClientes = new javax.swing.JMenu();
        JMenuItemClientes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JMenuItemCitas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemTalleres = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vehículos Administrador");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1864;
        gridBagConstraints.ipady = 870;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        labelGestionarVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        labelGestionarVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        labelGestionarVehiculos.setText("Gestión De Vehículos");
        labelGestionarVehiculos.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 30, 0, 0);
        getContentPane().add(labelGestionarVehiculos, gridBagConstraints);

        CabeceraVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cliente/cabecera_vehiculos_prov.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = -66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 20, 0, 0);
        getContentPane().add(CabeceraVehiculos, gridBagConstraints);

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_vistaGeneral_prov.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(fondoPantalla, gridBagConstraints);

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
        ModificarVehiculo mv = new ModificarVehiculo(obtenerVehiculoMatriculaSql((String) tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0)));
            mv.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_JMenuItemModificarVehiculoActionPerformed

    private void JMenuItemEliminarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemEliminarVehiculoActionPerformed
       try{
            Vehiculos vehiculo = obtenerVehiculoMatriculaSql((String) tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0));
                if(vehiculo == null){
                    JOptionPane.showMessageDialog(this, "El vehículo no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
                }
                if(JOptionPane.showOptionDialog(this, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                    eliminarVehiculoSql(vehiculo);        
                }else{
                    JOptionPane.showMessageDialog(this, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE); 
                }
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(this, "Debe seleccionar un vehículo de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
        //Siempre al finalizar actualiza la tabla.
        crearTabla();
    }//GEN-LAST:event_JMenuItemEliminarVehiculoActionPerformed

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

    private void JMenuItemCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemCitasActionPerformed
        VistaCitasAdministrador vca = new VistaCitasAdministrador();
            vca.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_JMenuItemCitasActionPerformed

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
    private javax.swing.JMenuItem JMenuItemCitas;
    private javax.swing.JMenuItem JMenuItemClientes;
    private javax.swing.JMenuItem JMenuItemEliminarVehiculo;
    private javax.swing.JMenuItem JMenuItemModificarVehiculo;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenuItem jMenuItemCerrarSesion;
    private javax.swing.JMenuItem jMenuItemTalleres;
    private javax.swing.JMenu jMenuVehiculos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelGestionarVehiculos;
    private javax.swing.JTable tablaVehiculos;
    // End of variables declaration//GEN-END:variables
}
