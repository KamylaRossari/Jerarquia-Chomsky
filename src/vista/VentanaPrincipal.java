package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("Simulador de la Jerarquia de Chomsky");

        setSize(900,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        JPanel nivel3 = new JPanel();
        nivel3.add(new JLabel("Nivel 3 - Lenguajes Regulares"));

        JPanel nivel2 = new JPanel();
        nivel2.add(new JLabel("Nivel 2 - Automata de Pila"));

        JPanel nivel1 = new JPanel();
        nivel1.add(new JLabel("Nivel 1 - LBA"));

        JPanel nivel0 = new JPanel();
        nivel0.add(new JLabel("Nivel 0 - Maquina de Turing"));

        tabs.addTab("Nivel 3", nivel3);
        tabs.addTab("Nivel 2", nivel2);
        tabs.addTab("Nivel 1", nivel1);
        tabs.addTab("Nivel 0", nivel0);

        add(tabs, BorderLayout.CENTER);
    }
}