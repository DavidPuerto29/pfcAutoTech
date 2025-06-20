/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package davidpuertocuenca.autotech.util;

import com.toedter.calendar.JCalendar;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
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
     
         public static void aplicarEstiloBoton(JButton boton) {
                // Ajustes estándar de AutoTech
                int ancho = 180;
                int alto = 40;
                int radio = 20;
                Color colorFondo = new Color(33, 150, 243); // Azul AutoTech
                Font fuente = new Font("Segoe UI", Font.BOLD, 14);

                // Aplicar estilo
                boton.setPreferredSize(new Dimension(ancho, alto));
                boton.setFont(fuente);
                boton.setForeground(Color.WHITE);
                boton.setBackground(colorFondo);
                boton.setFocusPainted(false);
                boton.setBorderPainted(false);
                boton.setContentAreaFilled(false);
                boton.setOpaque(false);
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

                // Redondeado con UI personalizada
                boton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
                    @Override
                    public void paint(Graphics g, JComponent c) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2.setColor(boton.getBackground());
                        g2.fillRoundRect(0, 0, boton.getWidth(), boton.getHeight(), radio, radio);
                        g2.dispose();
                        super.paint(g, c);
                    }
                });
    }
         
        public static void aplicarEstiloTextField(JTextField campo) {
                int radio = 20;
                int alto = 40;
                Font fuente = new Font("Segoe UI", Font.PLAIN, 14);
                Color colorFondo = Color.WHITE;
                Color colorBorde = new Color(33, 150, 243); // Azul AutoTech

                campo.setPreferredSize(new Dimension(180, alto));
                campo.setFont(fuente);
                campo.setForeground(Color.BLACK);
                campo.setBackground(colorFondo);
                campo.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
                campo.setOpaque(false); // para personalizar el fondo redondeado

                // UI personalizada para redondear y dibujar borde
                campo.setUI(new javax.swing.plaf.basic.BasicTextFieldUI() {
                    @Override
                    protected void paintSafely(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g.create();

                        // Antialias para bordes suaves
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        // Fondo blanco redondeado
                        g2.setColor(colorFondo);
                        g2.fillRoundRect(0, 0, campo.getWidth(), campo.getHeight(), radio, radio);

                        // Borde azul redondeado
                        g2.setColor(colorBorde);
                        g2.setStroke(new BasicStroke(2));
                        g2.drawRoundRect(1, 1, campo.getWidth()-3, campo.getHeight()-3, radio, radio);

                        g2.dispose();

                        super.paintSafely(g);
                    }
                });
    }
        
        public static void aplicarEstiloPasswordField(JPasswordField campo) {
                int radio = 20;
                int alto = 40;
                Font fuente = new Font("Segoe UI", Font.PLAIN, 14);
                Color colorFondo = Color.WHITE;
                Color colorBorde = new Color(33, 150, 243); // Azul AutoTech

                campo.setPreferredSize(new Dimension(180, alto));
                campo.setFont(fuente);
                campo.setForeground(Color.BLACK);
                campo.setBackground(colorFondo);
                campo.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
                campo.setOpaque(false); // para personalizar el fondo redondeado

                // UI personalizada para redondear y dibujar borde
                campo.setUI(new BasicPasswordFieldUI() {
                    @Override
                    protected void paintSafely(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g.create();

                        // Antialias para bordes suaves
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        // Fondo blanco redondeado
                        g2.setColor(colorFondo);
                        g2.fillRoundRect(0, 0, campo.getWidth(), campo.getHeight(), radio, radio);

                        // Borde azul redondeado
                        g2.setColor(colorBorde);
                        g2.setStroke(new BasicStroke(2));
                        g2.drawRoundRect(1, 1, campo.getWidth() - 3, campo.getHeight() - 3, radio, radio);

                        g2.dispose();

                        super.paintSafely(g);
                    }
                });
    }
     
            public static void aplicarEstiloComboBox(JComboBox<?> comboBox) {
                int radio = 20;
                int alto = 40;
                Font fuente = new Font("Segoe UI", Font.PLAIN, 14);
                Color colorFondo = Color.WHITE;
                Color colorBorde = new Color(33, 150, 243); // Azul AutoTech

                comboBox.setPreferredSize(new Dimension(180, alto));
                comboBox.setFont(fuente);
                comboBox.setForeground(Color.BLACK);
                comboBox.setBackground(colorFondo);
                comboBox.setOpaque(false);
                comboBox.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

                // UI personalizada para pintar borde redondeado
                comboBox.setUI(new BasicComboBoxUI() {
                    @Override
                    public void paint(Graphics g, JComponent c) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        // Fondo
                        g2.setColor(colorFondo);
                        g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), radio, radio);

                        // Borde
                        g2.setColor(colorBorde);
                        g2.setStroke(new BasicStroke(2));
                        g2.drawRoundRect(1, 1, c.getWidth() - 3, c.getHeight() - 3, radio, radio);

                        g2.dispose();
                        super.paint(g, c);
                    }
                });

                // Editor (si es editable)
                if (comboBox.isEditable()) {
                    Component editor = comboBox.getEditor().getEditorComponent();
                    if (editor instanceof JTextField) {
                        JTextField textField = (JTextField) editor;
                        textField.setFont(fuente);
                        textField.setBackground(colorFondo);
                        textField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    }
                }
            }
    
    public static void aplicarEstiloJCalendar(JCalendar calendar) {
            int radio = 20;
            Font fuente = new Font("Segoe UI", Font.PLAIN, 14);
            Color colorFondo = Color.WHITE;
            Color colorBorde = new Color(33, 150, 243); // Azul AutoTech

            calendar.setBackground(colorFondo);
            calendar.setForeground(Color.BLACK);
            calendar.setFont(fuente);
            calendar.setDecorationBackgroundColor(new Color(240, 240, 240)); // color para cabecera de mes y semana

            // Acceder a los componentes internos
            JPanel panel = (JPanel) calendar.getComponent(0);

            for (Component comp : panel.getComponents()) {
                if (comp instanceof JComboBox) {
                    JComboBox<?> comboBox = (JComboBox<?>) comp;
                    comboBox.setPreferredSize(new Dimension(100, 30));
                    comboBox.setFont(fuente);
                    comboBox.setForeground(Color.BLACK);
                    comboBox.setBackground(colorFondo);
                    comboBox.setOpaque(false);
                    comboBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    comboBox.setUI(new BasicComboBoxUI() {
                        @Override
                        public void paint(Graphics g, JComponent c) {
                            Graphics2D g2 = (Graphics2D) g.create();
                            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                            g2.setColor(colorFondo);
                            g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), radio, radio);

                            g2.setColor(colorBorde);
                            g2.setStroke(new BasicStroke(2));
                            g2.drawRoundRect(1, 1, c.getWidth() - 3, c.getHeight() - 3, radio, radio);

                            g2.dispose();
                            super.paint(g, c);
                        }
                    });
                } else if (comp instanceof JTable) {
                    JTable table = (JTable) comp;
                    table.setFont(fuente);
                    table.setRowHeight(30);
                    table.setGridColor(colorBorde);
                    table.setForeground(Color.BLACK);
                    table.setBackground(colorFondo);

                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                    table.setDefaultRenderer(Object.class, centerRenderer);

                    JTableHeader header = table.getTableHeader();
                    header.setFont(fuente.deriveFont(Font.BOLD));
                    header.setBackground(new Color(220, 220, 220));
                    header.setForeground(Color.BLACK);
                }
            }

            // Panel de decoración (parte superior)
            calendar.getDayChooser().getDayPanel().setBackground(colorFondo);
        }

}
