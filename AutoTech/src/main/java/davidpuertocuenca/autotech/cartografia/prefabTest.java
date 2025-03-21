/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.cartografia;

import static davidpuertocuenca.autotech.cartografia.CifradoSHA256.cifrarContraseña;
import static davidpuertocuenca.autotech.cartografia.CifradoSHA256.generarRandomizador;
import davidpuertocuenca.autotech.clases.Cliente;
import static davidpuertocuenca.autotech.clases.Cliente.comprobacionAutenticacionUsuario;
import static davidpuertocuenca.autotech.dao.ClienteDAO.crearClienteSql;

/**
 *
 * @author David
 */
public class prefabTest {
    public static void main(String[] args) {
         String contrasena = "normal";
    String randormizador = generarRandomizador();
    
    String hash = cifrarContraseña(contrasena, randormizador);
    
    Cliente c = new Cliente("normal",hash,randormizador,"4215698547A","David","Puerto Cuenca","david@hotmail.com",123456789,"Calle falsa 123",true); //TEST
    //crearClienteSql(c);
    
    System.out.println(comprobacionAutenticacionUsuario(c,"normal"));
    
    }
}
