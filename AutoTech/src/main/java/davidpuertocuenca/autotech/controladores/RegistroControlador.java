/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.controladores;

import static davidpuertocuenca.autotech.cartografia.CifradoSHA256.cifrarContraseña;
import static davidpuertocuenca.autotech.cartografia.CifradoSHA256.generarRandomizador;
import davidpuertocuenca.autotech.clases.Usuarios;
import static davidpuertocuenca.autotech.dao.UsuariosDAO.obtenerUsuarioPorUsuarioSql;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import davidpuertocuenca.autotech.vistas.registro.RegistroUsuariosPaso2;
import davidpuertocuenca.autotech.vistas.registro.legal.TerminosYCondiciones;
import java.util.Arrays;
import javax.swing.JFrame;

/**
 *
 * @author David Puerto Cuenca
 */
public class RegistroControlador {
    /* Echarle un pensamiento
    public void registroClientePaso1(String usuario, Char[] contrasena){
        boolean formatoCorrecto = true;
        
        //Comprobación de que el usuario no esta ya en uso.
        if(obtenerUsuarioPorUsuarioSql(fieldUsuario.getText()) != null){
            formatoCorrecto = false;
                textoErrorUsuario.setText("Usuario ya en uso.");
                    textoErrorUsuario.setVisible(true);            
        }
        
        //Comprobación de que el campo usuario no esta vacio.
        if(fieldUsuario.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorUsuario.setText("Debe introducir un usuario.");
                    textoErrorUsuario.setVisible(true);
        }
        
        //Comprobación de que las dos contraseñas coincidan
        if(!Arrays.equals(fieldContrasena.getPassword(), fieldContrasenaVerificar.getPassword())){
           formatoCorrecto = false;
               textoErrorContrasena.setText("Las contraseñas no coinciden.");
                    textoErrorContrasena.setVisible(true);
                        textoErrorContrasena1.setText("Las contraseñas no coinciden.");
                            textoErrorContrasena1.setVisible(true);
                    
        }
        
        //Comprobación de que las dos contraseñas no esten vacias.
        if(String.valueOf(fieldContrasena.getPassword()).isEmpty() && String.valueOf(fieldContrasenaVerificar.getPassword()).isEmpty()){
           formatoCorrecto = false;
               textoErrorContrasena.setText("Debe introducir una contraseña.");
                    textoErrorContrasena.setVisible(true); 
                        textoErrorContrasena1.setText("Debe introducir una contraseña.");
                            textoErrorContrasena1.setVisible(true); 
        }
        
        //Comprobación de que el correo electronico tenga el formato requerido.
        if (!fieldCorreo.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            formatoCorrecto = false;
                textoErrorCorreoElectronico.setVisible(true);
                    textoErrorCorreoElectronico.setText("Introduzca un correo electrónico valido.");
        }
        
        //Comprobación de que el correo electronico no este vacio.
        if(fieldCorreo.getText().isEmpty()){
            formatoCorrecto = false;
                textoErrorCorreoElectronico.setVisible(true);
                    textoErrorCorreoElectronico.setText("Debe introducir un correo electrónico.");
        }
        
        //Comprobación de que el usuario haya aceptado los terminos.
        if(aceptacionTerminos == false){
            textoErrorTerminos.setVisible(true);
        }
        
        if(formatoCorrecto){
            String randormizador = generarRandomizador();
            char[] contasenaChar = fieldContrasena.getPassword();
                //Se guardan los datos obtenidos en la variable global.
                cliente = new Usuarios(fieldUsuario.getText(),cifrarContraseña(String.valueOf(contasenaChar), randormizador),randormizador,null, null, null, fieldCorreo.getText(), null, null, false);
                    //Se limpia el array para aumentar la seguridad.
                    java.util.Arrays.fill(contasenaChar, '\0');    
                        return true;
        }else{
            return false;
        }
    }
    */
    
    public void vistaLoginClientes(JFrame vista){
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
