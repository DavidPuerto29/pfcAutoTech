/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package davidpuertocuenca.autotech.vistas.cliente;

import davidpuertocuenca.autotech.clases.Cliente;
import davidpuertocuenca.autotech.clases.Vehiculos;
import davidpuertocuenca.autotech.vistas.login.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerTodosVehiculosClienteSql;
import static davidpuertocuenca.autotech.dao.VehiculosDAO.obtenerVehiculoMatriculaSql;
import davidpuertocuenca.autotech.vistas.Vehiculos.AnadirVehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author David Puerto Cuenca
 */
public class VistaGeneralCliente extends javax.swing.JFrame {
    private Cliente cliente;
    /**
     * Creates new form VistaGeneralCliente
     */
    public VistaGeneralCliente() {
        initComponents();
        setExtendedState(VistaGeneralCliente.MAXIMIZED_BOTH);
            crearTabla();
    }
    
    public VistaGeneralCliente(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        setExtendedState(VistaGeneralCliente.MAXIMIZED_BOTH);
            crearTabla();
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
        tablaVehiculos = new javax.swing.JTable();
        botonCitas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        labelVehiculos = new javax.swing.JLabel();
        CabeceraVehiculos = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vista General Cliente");
        getContentPane().setLayout(null);

        botonLogout.setText("salir");
        botonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(botonLogout);
        botonLogout.setBounds(550, 640, 120, 60);

        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matrícula", "Modelo", "Año De Matriculación", "Citas Reservadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVehiculos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 130, 1870, 460);

        botonCitas.setText("Ver citas");
        botonCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCitasActionPerformed(evt);
            }
        });
        getContentPane().add(botonCitas);
        botonCitas.setBounds(1070, 630, 340, 80);

        jButton1.setText("Vehicu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(780, 640, 100, 40);

        labelVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        labelVehiculos.setForeground(new java.awt.Color(255, 255, 255));
        labelVehiculos.setText("Mis Vehículos");
        getContentPane().add(labelVehiculos);
        labelVehiculos.setBounds(30, 20, 510, 80);

        CabeceraVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/cliente/cabecera_vehiculos_prov.jpg"))); // NOI18N
        getContentPane().add(CabeceraVehiculos);
        CabeceraVehiculos.setBounds(20, 30, 1910, 66);

        fondoPantalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stiles/fondo_vistaGeneral_prov.jpg"))); // NOI18N
        getContentPane().add(fondoPantalla);
        fondoPantalla.setBounds(0, 0, 2000, 1231);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearTabla() {
        Object[] cabecera = new Object[]{"Matrícula","Modelo","Año De Matriculación","Citas Reservadas"}; 
        DefaultTableModel miModelo = new DefaultTableModel(cabecera, 0){
            //Edicion de celdas deshabilida.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  
            }
        };
        tablaVehiculos.setModel(miModelo);

            List<Vehiculos> vehiculos = new ArrayList(obtenerTodosVehiculosClienteSql(this.cliente));
           
            for(Vehiculos Vehiculo : vehiculos){
                Object[] fila = new Object[4];
                fila[0] = Vehiculo.getMatricula();
                fila[1] = Vehiculo.getModelo();
                fila[2] = Vehiculo.getAnoMatriculacion();
                fila[3] = Vehiculo.getCitas().size();
                    miModelo.addRow(fila);
            }
         
            //Dimensiones de la tabla.
            tablaVehiculos.setRowHeight(20);
            TableColumn columnaMatricula = tablaVehiculos.getColumn("Matrícula");
            columnaMatricula.setMinWidth(100);
            columnaMatricula.setMaxWidth(400);
            columnaMatricula.setPreferredWidth(150); 
            
            TableColumn columnaModelo = tablaVehiculos.getColumn("Modelo");
            columnaModelo.setMinWidth(100);
            columnaModelo.setMaxWidth(400);
            columnaModelo.setPreferredWidth(200); 
            
            TableColumn columnaAnoMatriculacion = tablaVehiculos.getColumn("Año De Matriculación");
            columnaAnoMatriculacion.setMinWidth(100);
            columnaAnoMatriculacion.setMaxWidth(400);
            columnaAnoMatriculacion.setPreferredWidth(200); 
            
            TableColumn columnaCitas = tablaVehiculos.getColumn("Citas Reservadas");
            columnaCitas.setMinWidth(100);
            columnaCitas.setMaxWidth(400);
            columnaCitas.setPreferredWidth(200);
    }
    
    private void botonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLogoutActionPerformed
        LoginClientes login = new LoginClientes();
            login.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_botonLogoutActionPerformed

    private void botonCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCitasActionPerformed
        try{
            Vehiculos vehiculo = obtenerVehiculoMatriculaSql((String) tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0));
                VistaCitasCliente vcc = new VistaCitasCliente(vehiculo, cliente);
                    vcc.setVisible(true);
                        this.dispose();
        }catch (ArrayIndexOutOfBoundsException e){
              JOptionPane.showMessageDialog(this, "Debe seleccionar un vehículo de la lista.", "Información", JOptionPane.INFORMATION_MESSAGE);
         }
    }//GEN-LAST:event_botonCitasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AnadirVehiculo av = new AnadirVehiculo(cliente);
            av.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGeneralCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGeneralCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGeneralCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGeneralCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGeneralCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CabeceraVehiculos;
    private javax.swing.JButton botonCitas;
    private javax.swing.JToggleButton botonLogout;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelVehiculos;
    private javax.swing.JTable tablaVehiculos;
    // End of variables declaration//GEN-END:variables
}
