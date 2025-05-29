/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.controladores;

import davidpuertocuenca.autotech.clases.Usuarios;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import davidpuertocuenca.autotech.vistas.registro.RegistroUsuariosPaso2;
import davidpuertocuenca.autotech.vistas.registro.legal.TerminosYCondiciones;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author David Puerto Cuenca
 */
public class RegistroControlador {
    
    public void vistaLoginClientes(JFrame vista){
       LoginClientes lgc = new LoginClientes();
            lgc.setVisible(true);
                vista.dispose(); 
    }
    
    public void vistaLoginClientesFinalizarRegistro(JFrame vista){
        JOptionPane.showMessageDialog(vista, "Su cuenta ha sido creada correctamente. ¡Bienvenido a AutoTech!", "Bienvenido a AutoTech", JOptionPane.INFORMATION_MESSAGE);
            LoginClientes lgc = new LoginClientes();
                 lgc.setVisible(true);
                     vista.dispose(); 
    }
    
    public void vistaRegistroPasoDos(JFrame vista, Usuarios usuario){
        RegistroUsuariosPaso2 rgc = new RegistroUsuariosPaso2(usuario);
                rgc.setVisible(true);
                    vista.dispose(); 
    }
    
    //Devuelve si los terminos han sido aceptados o no
    public boolean vistaTerminosCondiciones(JFrame vista){
        TerminosYCondiciones tyc = new TerminosYCondiciones(vista, true);
                tyc.setVisible(true);
                    return tyc.isAceptado();
    }
}
