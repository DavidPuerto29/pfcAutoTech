/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author David Puerto Cuenca
 */
public class Estilos {
    
     public void aplicarEstiloTablas(JTable tabla) {
            // Configuración básica
            tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabla.setShowGrid(true);
            tabla.setGridColor(new Color(200, 200, 200)); 
            tabla.setIntercellSpacing(new Dimension(1, 1));
            tabla.setRowHeight(28);
            tabla.setFont(new Font("Segoe UI", Font.PLAIN, 14)); 

            // Cabecera 
            JTableHeader header = tabla.getTableHeader();
            header.setReorderingAllowed(false);
            header.setResizingAllowed(false);
            header.setBackground(new Color(235, 235, 235)); // Gris clarito
            header.setForeground(new Color(50, 50, 50)); // Gris oscuro
            header.setFont(new Font("Segoe UI", Font.BOLD, 14));
            header.setOpaque(true);

            // Centrar contenido de las celdas
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < tabla.getColumnCount(); i++) {
                TableColumn columna = tabla.getColumnModel().getColumn(i);
                columna.setCellRenderer(centerRenderer);
                columna.setResizable(false);
                columna.setMinWidth(120);
                columna.setPreferredWidth(200);
                columna.setMaxWidth(500);
            }

            // Fondo para filas.
            tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                private final Color EVEN_COLOR = new Color(245, 245, 245);
                private final Color ODD_COLOR = Color.WHITE;
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    if (!isSelected) {
                        c.setBackground(row % 2 == 0 ? EVEN_COLOR : ODD_COLOR);
                    } else {
                        c.setBackground(new Color(184, 207, 229)); // Color de selección
                    }
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return c;
                }
            });
        }
     
}
