package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import vista.PanelNivel3;
import vista.PanelNivel2;
import vista.PanelNivel1;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("Simulador de la Jerarquia de Chomsky");

        setSize(900,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

       PanelNivel3 nivel3 = new PanelNivel3();

        PanelNivel2 nivel2 = new PanelNivel2();

       PanelNivel1 nivel1 = new PanelNivel1();

        JPanel nivel0 = new JPanel();
        nivel0.add(new JLabel("Nivel 0 - Maquina de Turing"));

        tabs.addTab("Nivel 3", nivel3);
        tabs.addTab("Nivel 2", nivel2);
        tabs.addTab("Nivel 1", nivel1);
        tabs.addTab("Nivel 0", nivel0);

        add(tabs, BorderLayout.CENTER);
    }
}