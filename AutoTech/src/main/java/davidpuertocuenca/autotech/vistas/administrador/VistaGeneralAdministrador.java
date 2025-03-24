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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vista General Administrador");

        botonLogout.setText("salir");
        botonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLogoutActionPerformed(evt);
            }
        });

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

        botonRefrescar.setText("Refrescar");
        botonRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRefrescarActionPerformed(evt);
            }
        });

        botonHacerAdministrador.setText("Hacer administrador");
        botonHacerAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHacerAdministradorActionPerformed(evt);
            }
        });

        botonQuitarAdministrador.setText("Quitar administrador");
        botonQuitarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarAdministradorActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonVehiculos.setText("Vehiculos");
        botonVehiculos.setToolTipText("");
        botonVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVehiculosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(botonRefrescar)
                .addGap(18, 18, 18)
                .addComponent(botonVehiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(botonLogout)
                .addGap(77, 77, 77)
                .addComponent(botonEliminar)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonQuitarAdministrador)
                    .addComponent(botonHacerAdministrador))
                .addGap(220, 220, 220))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonLogout)
                    .addComponent(botonRefrescar)
                    .addComponent(botonHacerAdministrador)
                    .addComponent(botonEliminar)
                    .addComponent(botonVehiculos))
                .addGap(18, 18, 18)
                .addComponent(botonQuitarAdministrador)
                .addGap(23, 23, 23))
        );

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
