/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package davidpuertocuenca.autotech;

import davidpuertocuenca.autotech.dao.HibernateUtil;
import davidpuertocuenca.autotech.vistas.login.LoginClientes;
import javax.swing.JOptionPane;

/**
 *
 * @author David Puerto Cuenca
 */
public class AutoTech {
    public static void main(String[] args) {
        if(HibernateUtil.getSessionFactory() != null){ 
            LoginClientes test = new LoginClientes();
                test.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No se ha podido establecer conexión con el servidor.", "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
}
