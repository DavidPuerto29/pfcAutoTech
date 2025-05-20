/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.controladores;

import com.toedter.calendar.JCalendar;
import davidpuertocuenca.autotech.clases.Citas;
import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.clases.Talleres;
import davidpuertocuenca.autotech.clases.UsuariosTalleres;
import davidpuertocuenca.autotech.clases.Vehiculos;
import static davidpuertocuenca.autotech.dao.CitasDAO.eliminarCitaSql;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerCitaPorNumeroSql;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerNumeroCitasSql;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerTodasCitasMatriculaSql;
import static davidpuertocuenca.autotech.dao.CitasDAO.obtenerTodasCitasSql;
import static davidpuertocuenca.autotech.dao.TalleresDAO.eliminarTallerSql;
import static davidpuertocuenca.autotech.dao.TalleresDAO.obtenerTallerPorNombreSql;
import static davidpuertocuenca.autotech.dao.TalleresDAO.obtenerTallerPorNumeroSql;
import static davidpuertocuenca.autotech.dao.TalleresDAO.obtenerTodosTalleresSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.eliminarVehiculoSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerTodosVehiculosSql;
import davidpuertocuenca.autotech.vistas.administrador.VistaCitasAdministrador;
import davidpuertocuenca.autotech.vistas.administrador.VistaUsuariosAdministrador;
import davidpuertocuenca.autotech.vistas.administrador.VistaTalleresAdministrador;
import davidpuertocuenca.autotech.vistas.administrador.VistaVehiculosAdministrador;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
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
import static davidpuertocuenca.autotech.dao.VehiculosDAO.actualizarVehiculoSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoMatriculaSql;
import davidpuertocuenca.autotech.vistas.administrador.usuarios.ModificarUsuarios;
import davidpuertocuenca.autotech.vistas.administrador.vehiculo.ModificarVehiculo;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.actualizarUsuarioSql;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.eliminarUsuarioSql;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.obtenerTodosUsuariosSql;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.obtenerUsuarioSql;
import static davidpuertocuenca.autotech.dao.UsuariosTalleresDAO.actualizarUsuarioTallerSql;
import static davidpuertocuenca.autotech.dao.UsuariosTalleresDAO.obtenerTodosUsuariosTalleresSql;
import static davidpuertocuenca.autotech.dao.UsuariosTalleresDAO.obtenerUsuarioTallerPorDniSql;
import davidpuertocuenca.autotech.vistas.administrador.citas.ModificarCitaAdministrador;
import davidpuertocuenca.autotech.vistas.administrador.talleres.AnadirTallerAdministrador;
import davidpuertocuenca.autotech.vistas.administrador.talleres.ModificarTallerAdministrador;
import davidpuertocuenca.autotech.vistas.administrador.VistaEmpleadosTallerAdministrador;
import davidpuertocuenca.autotech.vistas.administrador.empleados.DialogAsignarTallerEmpleado;
import davidpuertocuenca.autotech.vistas.administrador.vehiculo.AñadirVehiculoAdministrador;
import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JDialog;

/**
 *
 * @author David Puerto Cuenca
 */
public class AdministradorControlador {
       
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
    
    public void crearTablaClientes(JTable tablaClientes) { 
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


            List<Usuarios> clientes = new ArrayList(obtenerTodosUsuariosSql());
          
            for(Usuarios cliente : clientes){
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
            
                        tablaClientes.setShowGrid(true); // Muestra las líneas entre celdas
tablaClientes.setGridColor(Color.LIGHT_GRAY); // Color de las líneas de la tabla
tablaClientes.setRowHeight(24); // Altura de cada fila
tablaClientes.setIntercellSpacing(new Dimension(1, 1)); // Espacio entre celdas
    }
    
    public void crearTablaEmpleados(JTable tablaEmpleados) { 
        Object[] cabecera = new Object[]{"Dni", "Usuario", "Nombre", "Apellidos", "Taller Asignado"}; 
        DefaultTableModel miModelo = new DefaultTableModel(cabecera, 0){
            //Edicion de celdas deshabilida.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  
            }
        };
        tablaEmpleados.setModel(miModelo);
        tablaEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaEmpleados.getTableHeader().setReorderingAllowed(false);


            List<UsuariosTalleres> usuarioTalleres = new ArrayList(obtenerTodosUsuariosTalleresSql());
          
            for(UsuariosTalleres usuarioTaller : usuarioTalleres){
                Object[] fila = new Object[5];
                fila[0] = usuarioTaller.getDni();
                fila[1] = usuarioTaller.getUsuario();
                fila[2] = usuarioTaller.getNombre();
                fila[3] = usuarioTaller.getApellidos();
                if(usuarioTaller.getTaller() == null){
                    fila[4] = "No Asignado";
                }else{
                    fila[4] = usuarioTaller.getTaller().getNombre();
                }
                    miModelo.addRow(fila);
            }
         
            //Dimensiones de la tabla.
            tablaEmpleados.setRowHeight(40);
            TableColumn columnaDni = tablaEmpleados.getColumn("Dni");
            columnaDni.setMinWidth(100);
            columnaDni.setMaxWidth(600);
            columnaDni.setPreferredWidth(300); 
            
            TableColumn columnaUsuario = tablaEmpleados.getColumn("Usuario");
            columnaUsuario.setMinWidth(100);
            columnaUsuario.setMaxWidth(600);
            columnaUsuario.setPreferredWidth(300); 
            
            TableColumn columnaNombre = tablaEmpleados.getColumn("Nombre");
            columnaNombre.setMinWidth(100);
            columnaNombre.setMaxWidth(600);
            columnaNombre.setPreferredWidth(300); 
            
            TableColumn columnaApellidos= tablaEmpleados.getColumn("Apellidos");
            columnaApellidos.setMinWidth(100);
            columnaApellidos.setMaxWidth(600);
            columnaApellidos.setPreferredWidth(300); 
            
            TableColumn columnaTallerAsignado = tablaEmpleados.getColumn("Taller Asignado");
            columnaTallerAsignado.setMinWidth(100);
            columnaTallerAsignado.setMaxWidth(600);
            columnaTallerAsignado.setPreferredWidth(300);             
           
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tablaEmpleados.getTableHeader().setResizingAllowed(false);
            //Usado para centrar el texto de las celdas.
            for (int i = 0; i < tablaEmpleados.getColumnCount(); i++) {
                tablaEmpleados.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                    tablaEmpleados.getColumnModel().getColumn(i).setResizable(false);
            }
    }
    
    public void crearTablaCitas(JTable tablaCitas, JFrame vista){
        Object[] cabecera = new Object[]{"Numero De Cita", "Fecha", "Nombre Del Taller", "Descripción", "Matrícula", "Cliente", "Estado"}; 
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
                Object[] fila = new Object[7];
                fila[0] = cita.getNumeroCita();
                fila[1] = cita.getFecha();
                fila[2] = cita.getTaller().getNombre();
                fila[3] = cita.getDescripcion();
                fila[4] = cita.getVehiculo().getMatricula();
                fila[5] = cita.getVehiculo().getCliente().getNombre();
                switch(cita.getEstadoCita()){
                    case 1 -> fila[6] = "Pendiente ";
                    case 2 -> fila[6] = "En proceso ";
                    case 3 -> fila[6] = "Listo para recoger ";
                    case 4 -> fila[6] = "Finalizada  ";
                        default -> fila[6] = "Error";
                }
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
            
            TableColumn columnaDescripcionr = tablaCitas.getColumn("Descripción");
            columnaDescripcionr.setMinWidth(100);
            columnaDescripcionr.setMaxWidth(600);
            columnaDescripcionr.setPreferredWidth(300); 
            
            TableColumn columnaMatricula = tablaCitas.getColumn("Matrícula");
            columnaMatricula.setMinWidth(100);
            columnaMatricula.setMaxWidth(600);
            columnaMatricula.setPreferredWidth(300);
            
            TableColumn columnaCliente = tablaCitas.getColumn("Cliente");
            columnaCliente.setMinWidth(100);
            columnaCliente.setMaxWidth(600);
            columnaCliente.setPreferredWidth(300);
            
            TableColumn columnaEstado = tablaCitas.getColumn("Estado");
            columnaEstado.setMinWidth(100);
            columnaEstado.setMaxWidth(600);
            columnaEstado.setPreferredWidth(300);
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tablaCitas.getTableHeader().setResizingAllowed(false);
            //Usado para centrar el texto de las celdas.
            for (int i = 0; i < tablaCitas.getColumnCount(); i++) {
                tablaCitas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                    tablaCitas.getColumnModel().getColumn(i).setResizable(false);
            }
    }
    
    public void crearTablaTalleres(JTable tablaTalleres, JFrame vista){
        Object[] cabecera = new Object[]{"Número De Taller","Nombre","Dirección", "Código Postal", "Teléfono", "Localidad", "Identificación Fiscal"}; 
        DefaultTableModel miModelo = new DefaultTableModel(cabecera, 0){
            //Edicion de celdas deshabilida.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  
            }
        };
        
        tablaTalleres.setModel(miModelo);
        tablaTalleres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaTalleres.getTableHeader().setReorderingAllowed(false);

            List<Talleres> talleres = new ArrayList(obtenerTodosTalleresSql());
          
            for(Talleres taller : talleres){
                Object[] fila = new Object[7];
                fila[0] = taller.getNumeroTaller();
                fila[1] = taller.getNombre();
                fila[2] = taller.getDireccion();
                fila[3] = taller.getCodigoPostal();
                fila[4] = taller.getTelefono();
                fila[5] = taller.getLocalidad();
                fila[6] = taller.getCif();
                    miModelo.addRow(fila);
            }
         
            //Dimensiones de la tabla.
            tablaTalleres.setRowHeight(40);
            
            TableColumn columnaNumeroTaller = tablaTalleres.getColumn("Número De Taller");
            columnaNumeroTaller.setMinWidth(100);
            columnaNumeroTaller.setMaxWidth(600);
            columnaNumeroTaller.setPreferredWidth(300); 
            
            TableColumn columnaNombre = tablaTalleres.getColumn("Nombre");
            columnaNombre.setMinWidth(100);
            columnaNombre.setMaxWidth(600);
            columnaNombre.setPreferredWidth(300); 
            
            TableColumn columnaDireccion = tablaTalleres.getColumn("Dirección");
            columnaDireccion.setMinWidth(100);
            columnaDireccion.setMaxWidth(600);
            columnaDireccion.setPreferredWidth(300); 
            
            TableColumn columnaCodigoPostal = tablaTalleres.getColumn("Código Postal");
            columnaCodigoPostal.setMinWidth(100);
            columnaCodigoPostal.setMaxWidth(600);
            columnaCodigoPostal.setPreferredWidth(300); 
            
            TableColumn columnaTelefono = tablaTalleres.getColumn("Teléfono");
            columnaTelefono.setMinWidth(100);
            columnaTelefono.setMaxWidth(600);
            columnaTelefono.setPreferredWidth(300); 
            
            TableColumn columnaLocalidad = tablaTalleres.getColumn("Localidad");
            columnaLocalidad.setMinWidth(100);
            columnaLocalidad.setMaxWidth(600);
            columnaLocalidad.setPreferredWidth(300); 
            
            TableColumn columnaIdentificaciónFiscal = tablaTalleres.getColumn("Identificación Fiscal");
            columnaIdentificaciónFiscal.setMinWidth(100);
            columnaIdentificaciónFiscal.setMaxWidth(600);
            columnaIdentificaciónFiscal.setPreferredWidth(300); 
            
           
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tablaTalleres.getTableHeader().setResizingAllowed(false);
            //Usado para centrar el texto de las celdas.
            for (int i = 0; i < tablaTalleres.getColumnCount(); i++) {
                tablaTalleres.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                    tablaTalleres.getColumnModel().getColumn(i).setResizable(false);
            }
    }
    
    public void crearTablaVehiculos(JTable tablaVehiculos, JFrame vista){
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
    
        public void cargarClientesSeleccionadoComboBox(JComboBox comboBoxUsuarios, Vehiculos vehiculo){
            comboBoxUsuarios.removeAllItems(); 

            for (Usuarios usuario : obtenerTodosUsuariosSql()) {
                comboBoxUsuarios.addItem(usuario.getUsuario()); 
                    if (usuario.getUsuario().equals(vehiculo.getCliente().getUsuario())) {
                        comboBoxUsuarios.setSelectedItem(usuario.getUsuario());
                    }
            }
        }

        public void cargarClientesComboBox(JComboBox comboBoxUsuarios){
            comboBoxUsuarios.removeAllItems(); 
                for (Usuarios usuario : obtenerTodosUsuariosSql()) {
                    comboBoxUsuarios.addItem(usuario.getUsuario()); 
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

                      //Primero se convierte la hora de la cita al formato requerido.
                      Calendar cal = Calendar.getInstance();
                      cal.setTime(cita.getFecha());
                      String horaCita = String.format("%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));

                       for (String hora : horas) {
                           if(obtenerNumeroCitasSql(taller, LocalDateTime.of(calendarioDiasCita.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalTime.parse(hora))) != taller.getCitasMaximas()){
                               boxHorario.addItem(hora);
                                    if (hora.equals(horaCita)) {
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
    
         public void cargarTalleresSeleccionadoComboBox(JComboBox boxTalleres, Citas cita){
            boxTalleres.removeAllItems(); 

            for (Talleres taller : obtenerTodosTalleresSql()) {
                boxTalleres.addItem(taller.getNombre()); 
                    if (taller.getNombre().equals(cita.getTaller().getNombre())) {
                        boxTalleres.setSelectedItem(taller.getNombre());
                    }
            }
         }
         
         public void cargarTalleresUsuarioTallerComboBox(JComboBox boxTalleres, UsuariosTalleres usuarioTaller){
            boxTalleres.removeAllItems(); 

            boxTalleres.addItem("Seleccione un taller:");
                for (Talleres taller : obtenerTodosTalleresSql()) {
                    boxTalleres.addItem(taller.getNombre()); 
                    if(usuarioTaller.getTaller() != null){
                        if(usuarioTaller.getTaller().getNombre().equals(taller.getNombre())){
                            boxTalleres.setSelectedItem(taller.getNombre());
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
    
    public void eliminarCliente(JTable tablaClientes, JFrame vista){
        try{
            Usuarios cliente = obtenerUsuarioSql((String) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
            if(cliente == null){
                JOptionPane.showMessageDialog(vista, "El usuario no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
            }
                if(JOptionPane.showOptionDialog(vista, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                    eliminarUsuarioSql(cliente);        
                }else{
                    JOptionPane.showMessageDialog(vista, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE); 
                }
         }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
        //Siempre al finalizar actualiza la tabla.
        crearTablaClientes(tablaClientes);
    }
    
    public void eliminarCita(JTable tablaCitas, JFrame vista){
        try{
            Citas cita = obtenerCitaPorNumeroSql((Long) tablaCitas.getValueAt(tablaCitas.getSelectedRow(), 0));
            if(cita == null){
                JOptionPane.showMessageDialog(vista, "La cita seleccionada no ha sido encontrada.", "Error", JOptionPane.ERROR_MESSAGE); 
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
        crearTablaCitas(tablaCitas, vista);
    }
    
    public void modificarTallerEmpleado(UsuariosTalleres usuarioTaller, JComboBox comboBoxTalleres, JDialog vista){
        usuarioTaller.setTaller(obtenerTallerPorNombreSql((String)comboBoxTalleres.getSelectedItem()));
            actualizarUsuarioTallerSql(usuarioTaller);
                vista.dispose();
    }
    
    public void eliminarTaller(JTable tablaTalleres, JFrame vista){
        try{
            Talleres taller = obtenerTallerPorNumeroSql((Long) tablaTalleres.getValueAt(tablaTalleres.getSelectedRow(), 0));
            if(taller == null){
                JOptionPane.showMessageDialog(vista, "El taller seleccionado no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
            }
                if(JOptionPane.showOptionDialog(vista, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                    eliminarTallerSql(taller);        
                }else{
                    JOptionPane.showMessageDialog(vista, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE); 
                }
         }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un taller de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
        //Siempre al finalizar actualiza la tabla.
        crearTablaTalleres(tablaTalleres, vista);
    }
    
    public void eliminarVehiculo(JTable tablaVehiculos, JFrame vista){
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
        crearTablaVehiculos(tablaVehiculos, vista);
    }
    
    public void modificarVehiculo(JFrame vista, Vehiculos vehiculo){
        actualizarVehiculoSql(vehiculo);
            vistaVehiculos(vista);
    }
    
    public void quitarAdministrador(JTable tablaClientes, JFrame vista){
        try{
             Usuarios cliente = obtenerUsuarioSql((String) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
             if(cliente.isAdministrador()){
                  if(JOptionPane.showOptionDialog(vista, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                     if(cliente == null){
                         JOptionPane.showMessageDialog(vista, "El usuario no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
                     }
                     cliente.setAdministrador(false);
                          if(actualizarUsuarioSql(cliente)){
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
            crearTablaClientes(tablaClientes);
         }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
    }
    
    public void hacerAdministrador(JTable tablaClientes, JFrame vista){
        try{
             Usuarios cliente = obtenerUsuarioSql((String) tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0));
             if(cliente == null){
                         JOptionPane.showMessageDialog(vista, "El usuario no ha sido encontrado.", "Error", JOptionPane.ERROR_MESSAGE); 
             }
             
             if(!cliente.isAdministrador()){
                 if(JOptionPane.showOptionDialog(vista, "¿Esta seguro de realizar esta opción?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No"},"No") == JOptionPane.YES_OPTION){
                     cliente.setAdministrador(true);
                         if(actualizarUsuarioSql(cliente)){
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
             crearTablaClientes(tablaClientes);
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void vistaUsuarios(JFrame vista){
        VistaUsuariosAdministrador vga = new VistaUsuariosAdministrador();
            vga.setVisible(true);
                vista.dispose();
    }
    
    public void vistaCitas(JFrame vista){
        VistaCitasAdministrador vca = new VistaCitasAdministrador();
            vca.setVisible(true);
                vista.dispose();
    }
    
    public void vistaTalleres(JFrame vista){
        VistaTalleresAdministrador vta = new VistaTalleresAdministrador();
            vta.setVisible(true);
                vista.dispose();
    }
    
    public void vistaEmpleados(JFrame vista){
        VistaEmpleadosTallerAdministrador veta = new VistaEmpleadosTallerAdministrador();
            veta.setVisible(true);
                vista.dispose();
    }
    
    public void vistaAnadirTaller(JFrame vista){
        AnadirTallerAdministrador ata = new AnadirTallerAdministrador();
            ata.setVisible(true);
                vista.dispose();
    }
    
    public void vistaAnadirVehiculo(JFrame vista){
        AñadirVehiculoAdministrador ava = new AñadirVehiculoAdministrador();
            ava.setVisible(true);
                vista.dispose();
    }
   
    public void vistaVehiculos(JFrame vista){
        VistaVehiculosAdministrador vha = new VistaVehiculosAdministrador();
            vha.setVisible(true);
                vista.dispose();
    }
    
    public void vistaModificarVehiculo(JTable tablaVehiculos, JFrame vista){
        try{
            ModificarVehiculo mv = new ModificarVehiculo(obtenerVehiculoMatriculaSql((String) tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0)));
                mv.setVisible(true);
                    vista.dispose();
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un vehículo de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void vistaModificarCita(JTable tablaCitas,  Vehiculos vehiculo, JFrame vista){
            ModificarCitaAdministrador mca = new ModificarCitaAdministrador(vehiculo, obtenerCitaPorNumeroSql((Long) tablaCitas.getValueAt(tablaCitas.getSelectedRow(), 0)));
                mca.setVisible(true);
                    vista.dispose();
    }
    
     public void vistaModificarTaller(JTable tablaTalleres, JFrame vista){
        try{
            ModificarTallerAdministrador mta = new ModificarTallerAdministrador(obtenerTallerPorNumeroSql((Long) tablaTalleres.getValueAt(tablaTalleres.getSelectedRow(), 0)));
                mta.setVisible(true);
                    vista.dispose();
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un taller de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
     
     public void vistaAsignarTallerAEmpleado(JTable tablaEmpleados, JFrame vista){
        try{
            DialogAsignarTallerEmpleado vate = new DialogAsignarTallerEmpleado(vista, true, obtenerUsuarioTallerPorDniSql((String) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0)));
                vate.setVisible(true);
                    //Al finalizar se actualiza la tabla.
                    crearTablaEmpleados(tablaEmpleados);
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un empleado de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
     
    public void vistaModificarUsuario(JTable tablaUsuarios, JFrame vista){
        try{
            ModificarUsuarios mu = new ModificarUsuarios(obtenerUsuarioSql((String) tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0)));
                mu.setVisible(true);
                    vista.dispose();
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
}
