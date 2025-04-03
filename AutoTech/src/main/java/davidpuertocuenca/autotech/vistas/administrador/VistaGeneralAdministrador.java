/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.administrador;

import davidpuertocuenca.autotech.clases.Cliente;
import static davidpuertocuenca.autotech.dao.ClienteDAO.actualizarClienteSql;
import static davidpuertocuenca.autotech.dao.ClienteDAO.eliminarClienteSql;
import static davidpuertocuenca.autotech.dao.ClienteDAO.obtenerClienteSql;
import static davidpuertocuenca.autotech.dao.ClienteDAO.obtenerTodosClientesSql;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * 
 * @author David Puerto Cuenca
 */
public class VistaGeneralAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form VistaGeneralAdministrador
     */
    public VistaGeneralAdministrador() {
        initComponents();
        setExtendedState(VistaGeneralAdministrador.MAXIMIZED_BOTH);
            crearTabla();
    }

    //Tambien usado para actualizar la tabla
    private void crearTabla() { 
        Object[] cabecera = new Object[]{"Usuario","Dni","Nombre","Apellidos", "Correo Electrónico", "Número De Teléfono","Dirección","Es Administrador"}; 
        DefaultTableModel miModelo = new DefaultTableModel(cabecera, 0){
            //Edicion de celdas deshabilida.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  
            }
        };
        tablaClientes.setModel(miModelo);

            List<Cliente> clientes = new ArrayList(obtenerTodosClientesSql());
          
            for(Cliente cliente : clientes){
                Object[] fila = new Object[8];
                fila[0] = cliente.getUsuario();
                fila[1] = cliente.getDni();
                fila[2] = cliente.getNombre();
                fila[3] = cliente.getApellidos();
                fila[4] = cliente.getCorreoElectronico();
                fila[5] = cliente.getNumeroTelefono();
                fila[6] = cliente.getDireccion();
                if(cliente.isAdministrador()){
                    fila[7] = "Si";
                }else{
                    fila[7] = "No";
                }
                    miModelo.addRow(fila);
            }
         
            //Dimensiones de la tabla.
            tablaClientes.setRowHeight(20);
            TableColumn columnaFecha = tablaClientes.getColumn("Usuario");
            columnaFecha.setMinWidth(100);
            columnaFecha.setMaxWidth(400);
            columnaFecha.setPreferredWidth(150); 
            
            TableColumn columnaCliente = tablaClientes.getColumn("Dni");
            columnaCliente.setMinWidth(100);
            columnaCliente.setMaxWidth(400);
            columnaCliente.setPreferredWidth(200); 
            
            TableColumn columnaEnvios = tablaClientes.getColumn("Nombre");
            columnaEnvios.setMinWidth(100);
            columnaEnvios.setMaxWidth(400);
            columnaEnvios.setPreferredWidth(200); 
            
            TableColumn columnaCiudad = tablaClientes.getColumn("Apellidos");
            columnaCiudad.setMinWidth(100);
            columnaCiudad.setMaxWidth(400);
            columnaCiudad.setPreferredWidth(200); 
            
            TableColumn columnaCorreo = tablaClientes.getColumn("Correo Electrónico");
            columnaCorreo.setMinWidth(100);
            columnaCorreo.setMaxWidth(400);
            columnaCorreo.setPreferredWidth(200); 
            
            TableColumn columnaTelefono = tablaClientes.getColumn("Número De Teléfono");
            columnaTelefono.setMinWidth(100);
            columnaTelefono.setMaxWidth(400);
            columnaTelefono.setPreferredWidth(200); 
            
            TableColumn columnaDireccion = tablaClientes.getColumn("Dirección");
            columnaDireccion.setMinWidth(100);
            columnaDireccion.setMaxWidth(400);
            columnaDireccion.setPreferredWidth(200); 
            
            TableColumn columnaAdministrador = tablaClientes.getColumn("Es Administrador");
            columnaAdministrador.setMinWidth(100);
            columnaAdministrador.setMaxWidth(400);
            columnaAdministrador.setPreferredWidth(200); 
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonLogout = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        botonRefrescar = new javax.swing.JButton();
        botonHacerAdministrador = new javax.swing.JButton();
        botonQuitarAdministrador = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonVehiculos = new javax.swing.JButton();
        fondoPantalla = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vista General Administrador");
        getContentPane().setLayout(null);

        botonLogout.setText("salir");
        botonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(botonLogout);
        botonLogout.setBounds(440, 740, 51, 23);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Dni", "Nombre", "Apellidos", "Correo Electrónico", "Número De Teléfono", "Dirección", "Es Administrador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tablaClientes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 1020, 581);

        botonRefrescar.setText("Refrescar");
        botonRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRefrescarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRefrescar);
        botonRefrescar.setBounds(170, 740, 78, 23);

        botonHacerAdministrador.setText("Hacer administrador");
        botonHacerAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHacerAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(botonHacerAdministrador);
        botonHacerAdministrador.setBounds(670, 740, 138, 23);

        botonQuitarAdministrador.setText("Quitar administrador");
        botonQuitarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(botonQuitarAdministrador);
        botonQuitarAdministrador.setBounds(670, 790, 140, 23);

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminar);
        botonEliminar.setBounds(570, 740, 73, 23);

        botonVehiculos.setText("Vehiculos");
        botonVehiculos.setToolTipText("");
        botonVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVehiculosActionPerformed(evt);
            }
        });
        getContentPane().add(botonVehiculos);
        botonVehiculos.setBounds(260, 740, 81, 23);

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_vistaGeneral_prov.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla);
        fondoPantalla.setBounds(0, 0, 2000, 1231);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(90, 32768));
        jMenuBar1.setName(""); // NOI18N
        jMenuBar1.setOpaque(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(40, 40));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("File");
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu1.setMinimumSize(new java.awt.Dimension(50, 22));
        jMenu1.setPreferredSize(new java.awt.Dimension(60, 22));
        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLogoutActionPerformed
        LoginClientes login = new LoginClientes();
            login.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_botonLogoutActionPerformed

    private void botonRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRefrescarActionPerformed
       crearTabla();
    }//GEN-LAST:event_botonRefrescarActionPerformed

    private void botonHacerAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHacerAdministradorActionPerformed
        try{
             Cliente cliente = obtenerClienteSql((String) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
             if(cliente == null){
                         JOptionPane.showMessageDialog(this, "El usuario no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
             }
             
             if(!cliente.isAdministrador()){
                 if(JOptionPane.showOptionDialog(this, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                     cliente.setAdministrador(true);
                         if(actualizarClienteSql(cliente)){
                             JOptionPane.showMessageDialog(this, "El usuario ha sido actualizado correctamente.", "Usuario actualizado", JOptionPane.INFORMATION_MESSAGE);   //ALOMEJOR ES DEMASIADO DIALOG
                         }else{
                             JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);  //REVISARRRR
                         }
                 }else{
                     JOptionPane.showMessageDialog(this, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE); 
                 }
             }else{
                 JOptionPane.showMessageDialog(this, "Este usuario ya es administrador.", "Información", JOptionPane.INFORMATION_MESSAGE);
             }
             //Siempre al finalizar actualiza la tabla.
             crearTabla();
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonHacerAdministradorActionPerformed

    private void botonQuitarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarAdministradorActionPerformed
        try{
             Cliente cliente = obtenerClienteSql((String) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
             if(cliente.isAdministrador()){
                 if(JOptionPane.showOptionDialog(this, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                     if(cliente == null){
                         JOptionPane.showMessageDialog(this, "El usuario no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
                     }
                     cliente.setAdministrador(false);
                         if(actualizarClienteSql(cliente)){
                             JOptionPane.showMessageDialog(this, "El usuario ha sido actualizado correctamente.", "Usuario actualizado", JOptionPane.INFORMATION_MESSAGE);  //ALOMEJOR ES DEMASIADO DIALOG
                         }else{
                             JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);  //REVISARRRR
                         }
                 }else{
                     JOptionPane.showMessageDialog(this, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE); 
                 }
             }else{
                 JOptionPane.showMessageDialog(this, "Este usuario no es administrador.", "Información", JOptionPane.INFORMATION_MESSAGE);
             }
             //Siempre al finalizar actualiza la tabla.
             crearTabla();
         }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
    }//GEN-LAST:event_botonQuitarAdministradorActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        try{
            Cliente cliente = obtenerClienteSql((String) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
            if(cliente == null){
                JOptionPane.showMessageDialog(this, "El usuario no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
            }
            if(JOptionPane.showOptionDialog(this, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                eliminarClienteSql(cliente);        
            }else{
                JOptionPane.showMessageDialog(this, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE); 
            }
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
        //Siempre al finalizar actualiza la tabla.
        crearTabla();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVehiculosActionPerformed
        // TODO add your handling code here:
        VistaVehiculosAdministrador vha = new VistaVehiculosAdministrador();
            vha.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_botonVehiculosActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGeneralAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGeneralAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGeneralAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGeneralAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGeneralAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonHacerAdministrador;
    private javax.swing.JToggleButton botonLogout;
    private javax.swing.JButton botonQuitarAdministrador;
    private javax.swing.JButton botonRefrescar;
    private javax.swing.JButton botonVehiculos;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
