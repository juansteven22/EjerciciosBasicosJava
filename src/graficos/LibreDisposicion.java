package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LibreDisposicion {

    public static void main(String[] args) {
        // Iniciar la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            MarcoLibre marco = new MarcoLibre();
            marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}

/* ---------- Ventana principal ---------- */
class MarcoLibre extends JFrame {

    public MarcoLibre() {
        setTitle("Componentes en círculo");
        setBounds(450, 350, 600, 600);      // tamaño algo más cuadrado
        LaminaLibre lamina = new LaminaLibre();
        add(lamina);
        setVisible(true);
    }
}

/* ---------- Panel que contiene los controles ---------- */
class LaminaLibre extends JPanel {

    public LaminaLibre() {
        setLayout(new EnCirculo());          // <<--- aquí usamos el nuevo layout

        JLabel  nombre    = new JLabel("Nombre:");
        JTextField cNombre = new JTextField(10);

        JLabel  apellido    = new JLabel("Apellido:");
        JTextField cApellido = new JTextField(10);

        JLabel  edad    = new JLabel("Edad:");
        JTextField cEdad = new JTextField(5);

        JLabel  telefono    = new JLabel("Teléfono:");
        JTextField cTelefono = new JTextField(10);
        
        JLabel  prueba1    = new JLabel("Teléfono:");
        JLabel  prueba2   = new JLabel("Teléfono:");
        JLabel  prueba3    = new JLabel("Teléfono:");
        JLabel  prueba4    = new JLabel("Teléfono:");
        JLabel  prueba5    = new JLabel("Teléfono:");

        add(nombre);   add(cNombre);
        add(apellido); add(cApellido);
        add(edad);     add(cEdad);
        add(telefono); add(cTelefono);
        
        add(prueba1);
        add(prueba2);
        add(prueba3);
        add(prueba4);
        add(prueba5);
        
    }
}

/* ---------- Nuevo LayoutManager que coloca los componentes en un círculo ---------- */
class EnCirculo implements LayoutManager {

    /* No necesitamos hacer nada especial al añadir/quitar componentes */
    @Override public void addLayoutComponent(String name, Component comp) {}
    @Override public void removeLayoutComponent(Component comp) {}

    /* Un tamaño por defecto razonable */
    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return new Dimension(400, 400);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension(200, 200);
    }

    @Override
    public void layoutContainer(Container parent) {
        int n = parent.getComponentCount();
        if (n == 0) return;

        int w = parent.getWidth();
        int h = parent.getHeight();

        int cx = w / 2;                       // centro X
        int cy = h / 2;                       // centro Y

        int radius = Math.min(w, h) / 2 - 40; // margen para que no choquen los bordes

        /* Angulo inicial arriba (-π/2) y recorrido horario */
        for (int i = 0; i < n; i++) {
            Component c = parent.getComponent(i);

            Dimension pref = c.getPreferredSize();
            int cw = pref.width;
            int ch = pref.height;

            double angle = 2 * Math.PI * i / n - Math.PI / 2;

            int x = cx + (int) (radius * Math.cos(angle)) - cw / 2;
            int y = cy + (int) (radius * Math.sin(angle)) - ch / 2;

            c.setBounds(x, y, cw, ch);
        }
    }
}
