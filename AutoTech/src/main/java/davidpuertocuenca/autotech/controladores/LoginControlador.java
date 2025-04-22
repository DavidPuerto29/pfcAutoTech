/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.controladores;

import davidpuertocuenca.autotech.clases.Usuarios;
import static davidpuertocuenca.autotech.clases.Usuarios.comprobacionAutenticacionUsuario;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.obtenerUsuarioPorUsuarioSql;
import davidpuertocuenca.autotech.vistas.administrador.VistaUsuariosAdministrador;
import davidpuertocuenca.autotech.vistas.login.LoginAdministradores;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import davidpuertocuenca.autotech.vistas.registro.RegistroClientesView1;
import davidpuertocuenca.autotech.vistas.usuario.VistaVehiculosUsuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class LoginControlador {
    
    public void iniciarSesionAdministradores(String usuario, char[] contrasena, JFrame vista){
        Usuarios cliente = obtenerUsuarioPorUsuarioSql(usuario);
        char[] contasenaChar = contrasena;
        
         if(comprobacionAutenticacionUsuario(cliente, String.valueOf(contasenaChar))){
            //Se limpia el array para aumentar la seguridad.
            java.util.Arrays.fill(contasenaChar, '\0');
                if(cliente.isAdministrador()){
                    vistaAdministrador(vista);
                }else{
                   JOptionPane.showMessageDialog(vista, "No eres administrador, en caso erróneo contacte con el servicio técnico.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                }
        }else{
            JOptionPane.showMessageDialog(vista, "El usuario no ha sido encontrado, por favor compruebe los datos y vuelva a intentarlo.", "Error de búsqueda", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void iniciarSesionUsuarios(String usuario, char[] contrasena, JFrame vista){
        Usuarios usuarios = obtenerUsuarioPorUsuarioSql(usuario);
        
        if(comprobacionAutenticacionUsuario(usuarios, String.valueOf(contrasena))){
            //Se limpia el array para aumentar la seguridad.
            java.util.Arrays.fill(contrasena, '\0');
               vistaVehiculosUsuario(usuarios, vista);
        }else{
            //Se limpia el array para aumentar la seguridad.
            java.util.Arrays.fill(contrasena, '\0');
                JOptionPane.showMessageDialog(vista, "El usuario no ha sido encontrado, por favor compruebe los datos y vuelva a intentarlo.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void vistaVehiculosUsuario(Usuarios usuario, JFrame vista){
        VistaVehiculosUsuario g = new VistaVehiculosUsuario(usuario);
               g.setVisible(true);
                     vista.dispose();
    }
    
    public void vistaAdministrador(JFrame vista){
        VistaUsuariosAdministrador vga = new VistaUsuariosAdministrador();
               vga.setVisible(true);
                    vista.dispose();
    }
    
    public void vistaClientes(JFrame vista){
        LoginClientes lgc = new LoginClientes();
            lgc.setVisible(true);
                vista.dispose();
    }
    
    public void vistaLoginAdministradores(JFrame vista){
        LoginAdministradores loginAdministrador = new LoginAdministradores();
                    loginAdministrador.setVisible(true);
                        vista.dispose();
    }
    
    public void vistaRegistroUsuarios(JFrame vista){
        RegistroClientesView1 rg = new RegistroClientesView1();
            rg.setVisible(true);
                vista.dispose();
    }
   
}
