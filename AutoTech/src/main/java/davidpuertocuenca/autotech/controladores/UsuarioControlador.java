/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.controladores;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import davidpuertocuenca.autotech.clases.Citas;
import davidpuertocuenca.autotech.clases.Talleres;
import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.clases.Vehiculos;
import static davidpuertocuenca.autotech.dao.CitasDAO.eliminarCitaSql;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerCitaPorNumeroSql;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerNumeroCitasSql;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerTodasCitasMatriculaSql;
import static davidpuertocuenca.autotech.dao.TalleresDAO.obtenerTodosTalleresSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.eliminarVehiculoSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerTodosVehiculosClienteSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoMatriculaSql;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import davidpuertocuenca.autotech.vistas.usuario.Vehiculos.AnadirVehiculoPaso1;
import davidpuertocuenca.autotech.vistas.usuario.Vehiculos.AnadirVehiculoPaso2;
import davidpuertocuenca.autotech.vistas.usuario.Vehiculos.ModificarVehiculoUsuario;
import davidpuertocuenca.autotech.vistas.usuario.VistaCitasUsuario;
import davidpuertocuenca.autotech.vistas.usuario.VistaVehiculosUsuario;
import davidpuertocuenca.autotech.vistas.usuario.citas.PedirCita;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author David Puerto Cuenca
 */
public class UsuarioControlador {
    
    public void cerrarSesion(JFrame vista){
        if(JOptionPane.showOptionDialog(vista, "¿Desea cerrar sesíon?", "Cerrar Sesíon", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
            LoginClientes login = new LoginClientes();
                login.setVisible(true);
                    vista.dispose();
        }
    }
    
    //Requerido para que la opción de cerrar sesión aparezca a la derecha de la pantalla.    
    public void colocarCerrarSesion(JMenuBar jMenuBar1, JMenu jMenu5){
        jMenuBar1.remove(jMenu5);
        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu5);
    }
    
    public void crearTablaVehiculos(JTable tablaVehiculos, Usuarios usuario){
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

            List<Vehiculos> vehiculos = new ArrayList(obtenerTodosVehiculosClienteSql(usuario));
           
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
    
    public void crearTablaCitas(JTable tablaCitasVehiculo, Vehiculos vehiculo){
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
                fila[3] = Cita.getTaller().getNombre();
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
    
    public void cargarTalleresSeleccionadoComboBox(JComboBox boxTalleres, Citas cita){
        boxTalleres.removeAllItems(); 
          
        for (Talleres taller : obtenerTodosTalleresSql()) {
            boxTalleres.addItem(taller.getNombre()); 
                if (taller.getNombre().equals(cita.getTaller().getNombre())) {
                    boxTalleres.setSelectedItem(taller.getNombre());
                }
        }
    }
    
    public void cargarTalleresComboBox(JComboBox boxTalleres){
        boxTalleres.removeAllItems(); 
            boxTalleres.addItem("Seleccione un taller."); 
                for (Talleres taller : obtenerTodosTalleresSql()) {
                    boxTalleres.addItem(taller.getNombre()); 
                }
    }
    
    public void cargarHorariosCitasSeleccionadoJComboBox(JCalendar calendarioDiasCita, JComboBox<String> boxHorario, Talleres taller, Citas cita){
        //Para asegurar que no hay ningun dato guardado.
        boxHorario.removeAllItems();
        
        String[] horas = {
        "08:00", "08:30", "09:00", "09:30", "10:00", 
        "10:30", "11:00", "11:30", "12:00", "12:30", 
        "13:00", "13:30", "14:00", "14:30", "15:00", 
        "15:30", "16:00", "16:30", "17:00", "17:30", 
        "18:00", "18:30", "19:00", "19:30", "20:00",
        "20:30"
        };
         
        if(taller != null){
            if(taller.getCitasMaximas() != null){
               boxHorario.addItem("Seleccione una hora."); 
               
                   for (String hora : horas) {
                       if(obtenerNumeroCitasSql(taller, LocalDateTime.of(calendarioDiasCita.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalTime.parse(hora))) != taller.getCitasMaximas()){
                           boxHorario.addItem(hora);
                                if(hora.equals(cita.getFecha())){
                                    boxHorario.setSelectedItem(hora);
                                }
                       }
                   }
           }
        }
    }
    
    
    public void cargarHorariosCitasJComboBox(JCalendar calendarioDiasCita, JComboBox<String> boxHorario, Talleres taller){
        //Para asegurar que no hay ningun dato guardado.
        boxHorario.removeAllItems();
        
        String[] horas = {
        "08:00", "08:30", "09:00", "09:30", "10:00", 
        "10:30", "11:00", "11:30", "12:00", "12:30", 
        "13:00", "13:30", "14:00", "14:30", "15:00", 
        "15:30", "16:00", "16:30", "17:00", "17:30", 
        "18:00", "18:30", "19:00", "19:30", "20:00",
        "20:30"
        };
         
        if(taller != null){
            if(taller.getCitasMaximas() != null){
               boxHorario.addItem("Seleccione una hora."); 
                   for (String hora : horas) {
                       if(obtenerNumeroCitasSql(taller, LocalDateTime.of(calendarioDiasCita.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalTime.parse(hora))) != taller.getCitasMaximas()){
                           boxHorario.addItem(hora);
                       }
                   }
           }
        }
    }
    
    public boolean comprobarCitasIgualesVehiculo(Date fecha, Vehiculos vehiculo){
        List<Citas> citasVehiculo = obtenerTodasCitasMatriculaSql(vehiculo);
        
        for(Citas cita : citasVehiculo){
            //Para asegurarse de que la comprobación es correcta.
            if(Math.abs(cita.getFecha().getTime() - fecha.getTime()) < 1000){
                return false;
            }
        }
        return true;
    }
    
    public void vistaCitas(JTable tablaVehiculos, Usuarios usuario, JFrame vista){
       try{
            VistaCitasUsuario vcc = new VistaCitasUsuario(obtenerVehiculoMatriculaSql((String) tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0)), usuario);
                vcc.setVisible(true);
                    vista.dispose();
        }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un vehículo de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void vistaCitasConVehiculo(Vehiculos vehiculo, Usuarios usuario, JFrame vista){
            VistaCitasUsuario vcc = new VistaCitasUsuario(vehiculo, usuario);
                vcc.setVisible(true);
                    vista.dispose();
    }
    
    public void vistaPedirCita(Usuarios usuario, Vehiculos vehiculo, JFrame vista){
         PedirCita pc = new PedirCita(usuario,vehiculo);
             pc.setVisible(true);
                 vista.dispose();  
    }
    
    public void vistaModificarVehiculo(JTable tablaVehiculos, Usuarios usuario, JFrame vista){
        try{
            ModificarVehiculoUsuario mv = new ModificarVehiculoUsuario(obtenerVehiculoMatriculaSql((String) tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0)), usuario);
                mv.setVisible(true);
                    vista.dispose();
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un vehículo de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void eliminarVehiculo(JTable tablaVehiculos, Usuarios usuario, JFrame vista){
        try{
            Vehiculos vehiculo = obtenerVehiculoMatriculaSql((String) tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0));
                if(vehiculo == null){
                    JOptionPane.showMessageDialog(vista, "El vehículo no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                    if(JOptionPane.showOptionDialog(vista, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                        eliminarVehiculoSql(vehiculo);
                    }else{
                        JOptionPane.showMessageDialog(vista, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
        }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un vehículo de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        //Siempre al finalizar actualiza la tabla.
        crearTablaVehiculos(tablaVehiculos, usuario);
    }
    
    public void cancelarCitas(JTable tablaCitasVehiculo, Vehiculos vehiculo, JFrame vista){
         try{
            Citas cita = obtenerCitaPorNumeroSql((Long) tablaCitasVehiculo.getValueAt(tablaCitasVehiculo.getSelectedRow(), 0));
                if(vehiculo == null){
                    JOptionPane.showMessageDialog(vista, "La cita no ha sido encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if(JOptionPane.showOptionDialog(vista, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                    eliminarCitaSql(cita);
                }else{
                    JOptionPane.showMessageDialog(vista, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
         }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una cita de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
         //Siempre al finalizar actualiza la tabla.
         crearTablaCitas(tablaCitasVehiculo, vehiculo);
    }
    
    public void vistaAnadirVehiculo(JFrame vista, Usuarios usuario){
        AnadirVehiculoPaso1 av = new AnadirVehiculoPaso1(usuario);
            av.setVisible(true);
                vista.dispose();
    }
    
    public void vistaAnadirVehiculoPaso2(JFrame vista, Usuarios usuario, Vehiculos vehiculo){
        AnadirVehiculoPaso2 avp2 = new AnadirVehiculoPaso2(usuario, vehiculo);
            avp2.setVisible(true);
                vista.dispose();
    }
    
    public void vistaVehiculos(JFrame vista, Usuarios usuario){
        VistaVehiculosUsuario vvc = new VistaVehiculosUsuario(usuario);
            vvc.setVisible(true);
                vista.dispose();
    }
    
}
