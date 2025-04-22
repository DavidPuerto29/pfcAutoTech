/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.controladores;

import davidpuertocuenca.autotech.clases.Cliente;
import static davidpuertocuenca.autotech.dao.ClienteDAO.actualizarClienteSql;
import static davidpuertocuenca.autotech.dao.ClienteDAO.eliminarClienteSql;
import static davidpuertocuenca.autotech.dao.ClienteDAO.obtenerClienteSql;
import static davidpuertocuenca.autotech.dao.ClienteDAO.obtenerTodosClientesSql;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author David
 */
public class AdministradorControlador {
    
    //Tambien usado para actualizar la tabla
    public void crearTabla(JTable tablaClientes) { 
        Object[] cabecera = new Object[]{"Usuario","Dni","Nombre","Apellidos", "Correo Electrónico", "Número De Teléfono","Dirección","Es Administrador"}; 
        DefaultTableModel miModelo = new DefaultTableModel(cabecera, 0){
            //Edicion de celdas deshabilida.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  
            }
        };
        tablaClientes.setModel(miModelo);
        tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaClientes.getTableHeader().setReorderingAllowed(false);


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
            tablaClientes.setRowHeight(40);
            TableColumn columnaFecha = tablaClientes.getColumn("Usuario");
            columnaFecha.setMinWidth(100);
            columnaFecha.setMaxWidth(600);
            columnaFecha.setPreferredWidth(300); 
            
            TableColumn columnaCliente = tablaClientes.getColumn("Dni");
            columnaCliente.setMinWidth(100);
            columnaCliente.setMaxWidth(600);
            columnaCliente.setPreferredWidth(300); 
            
            TableColumn columnaEnvios = tablaClientes.getColumn("Nombre");
            columnaEnvios.setMinWidth(100);
            columnaEnvios.setMaxWidth(600);
            columnaEnvios.setPreferredWidth(300); 
            
            TableColumn columnaCiudad = tablaClientes.getColumn("Apellidos");
            columnaCiudad.setMinWidth(100);
            columnaCiudad.setMaxWidth(600);
            columnaCiudad.setPreferredWidth(300); 
            
            TableColumn columnaCorreo = tablaClientes.getColumn("Correo Electrónico");
            columnaCorreo.setMinWidth(100);
            columnaCorreo.setMaxWidth(600);
            columnaCorreo.setPreferredWidth(300); 
            
            TableColumn columnaTelefono = tablaClientes.getColumn("Número De Teléfono");
            columnaTelefono.setMinWidth(100);
            columnaTelefono.setMaxWidth(600);
            columnaTelefono.setPreferredWidth(300); 
            
            TableColumn columnaDireccion = tablaClientes.getColumn("Dirección");
            columnaDireccion.setMinWidth(100);
            columnaDireccion.setMaxWidth(600);
            columnaDireccion.setPreferredWidth(300); 
            
            TableColumn columnaAdministrador = tablaClientes.getColumn("Es Administrador");
            columnaAdministrador.setMinWidth(100);
            columnaAdministrador.setMaxWidth(600);
            columnaAdministrador.setPreferredWidth(300); 
            
           
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tablaClientes.getTableHeader().setResizingAllowed(false);
            //Usado para centrar el texto de las celdas.
            for (int i = 0; i < tablaClientes.getColumnCount(); i++) {
                tablaClientes.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                    tablaClientes.getColumnModel().getColumn(i).setResizable(false);
            }
    }
    
    public void eliminarCliente(JTable tablaClientes, JFrame vista){
        try{
            Cliente cliente = obtenerClienteSql((String) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
            if(cliente == null){
                JOptionPane.showMessageDialog(vista, "El usuario no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
            }
            if(JOptionPane.showOptionDialog(vista, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                eliminarClienteSql(cliente);        
            }else{
                JOptionPane.showMessageDialog(vista, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE); 
            }
         }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
        //Siempre al finalizar actualiza la tabla.
        crearTabla(tablaClientes);
    }
    
    public void quitarAdministrador(JTable tablaClientes, JFrame vista){
        try{
             Cliente cliente = obtenerClienteSql((String) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
             if(cliente.isAdministrador()){
                  if(JOptionPane.showOptionDialog(vista, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                     if(cliente == null){
                         JOptionPane.showMessageDialog(vista, "El usuario no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
                     }
                     cliente.setAdministrador(false);
                          if(actualizarClienteSql(cliente)){
                              JOptionPane.showMessageDialog(vista, "El usuario ha sido actualizado correctamente.", "Usuario actualizado", JOptionPane.INFORMATION_MESSAGE);  //ALOMEJOR ES DEMASIADO DIALOG
                          }else{
                             JOptionPane.showMessageDialog(vista, "Ha ocurrido un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);  //REVISARRRR
                          }
                  }else{
                       JOptionPane.showMessageDialog(vista, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE); 
                  }
             }else{
                  JOptionPane.showMessageDialog(vista, "Este usuario no es administrador.", "Información", JOptionPane.INFORMATION_MESSAGE);
             }
             //Siempre al finalizar actualiza la tabla.
            crearTabla(tablaClientes);
         }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
    }
    
    public void hacerAdministrador(JTable tablaClientes, JFrame vista){
        try{
             Cliente cliente = obtenerClienteSql((String) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
             if(cliente == null){
                         JOptionPane.showMessageDialog(vista, "El usuario no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
             }
             
             if(!cliente.isAdministrador()){
                 if(JOptionPane.showOptionDialog(vista, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                     cliente.setAdministrador(true);
                         if(actualizarClienteSql(cliente)){
                             JOptionPane.showMessageDialog(vista, "El usuario ha sido actualizado correctamente.", "Usuario actualizado", JOptionPane.INFORMATION_MESSAGE);   //ALOMEJOR ES DEMASIADO DIALOG
                         }else{
                             JOptionPane.showMessageDialog(vista, "Ha ocurrido un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);  //REVISARRRR
                         }
                 }else{
                     JOptionPane.showMessageDialog(vista, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE); 
                 }
             }else{
                 JOptionPane.showMessageDialog(vista, "Este usuario ya es administrador.", "Información", JOptionPane.INFORMATION_MESSAGE);
             }
             //Siempre al finalizar actualiza la tabla.
             crearTabla(tablaClientes);
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void cerrarSesion(JFrame vista){
        if(JOptionPane.showOptionDialog(vista, "¿Desea cerrar sesíon?", "Cerrar Sesíon", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
            LoginClientes login = new LoginClientes();
                login.setVisible(true);
                    vista.dispose();
        }
    }
}
