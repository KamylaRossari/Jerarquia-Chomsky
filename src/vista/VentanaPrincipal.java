package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("Simulador de la Jerarquia de Chomsky");

        setSize(1100, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel encabezado = new JPanel();

        encabezado.setLayout(new BorderLayout());

        encabezado.setBackground(
                new Color(44, 62, 80));

        JLabel titulo = new JLabel(
                "SIMULADOR DE LA JERARQUIA DE CHOMSKY",
                SwingConstants.CENTER);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24));

        JLabel autor = new JLabel(
                "Kamyla Gabriela Rosario Cano",
                SwingConstants.CENTER);

        autor.setForeground(
                new Color(220, 220, 220));

        autor.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14));

        encabezado.add(
                titulo,
                BorderLayout.CENTER);

        encabezado.add(
                autor,
                BorderLayout.SOUTH);

        add(encabezado,
                BorderLayout.NORTH);

        JTabbedPane tabs =
                new JTabbedPane();

        tabs.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14));

        PanelNivel3 nivel3 =
                new PanelNivel3();

        PanelNivel2 nivel2 =
                new PanelNivel2();

        PanelNivel1 nivel1 =
                new PanelNivel1();

        PanelNivel0 nivel0 =
                new PanelNivel0();

        JPanel guia =
                new JPanel(
                        new BorderLayout());

        JTextArea informacion =
                new JTextArea();

        informacion.setEditable(false);

        informacion.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15));

        informacion.setBackground(
                new Color(245, 245, 245));

        informacion.setText(

                "BIENVENIDO AL SIMULADOR DE LA JERARQUIA DE CHOMSKY\n\n"

                + "Seleccione un nivel para comenzar.\n\n"

                + "NIVEL 3 - LENGUAJES REGULARES\n"
                + "Lenguaje: ab*\n"
                + "Ejemplos: a, ab, abb, abbb\n\n"

                + "NIVEL 2 - AUTOMATA CON PILA\n"
                + "Lenguaje: aⁿbⁿ\n"
                + "Ejemplos: ab, aabb, aaabbb\n\n"

                + "NIVEL 1 - AUTOMATA LINEALMENTE ACOTADO\n"
                + "Lenguaje: aⁿbⁿcⁿ\n"
                + "Ejemplos: abc, aabbcc, aaabbbccc\n\n"

                + "NIVEL 0 - MAQUINA DE TURING\n"
                + "Lenguaje: aⁿbⁿ\n"
                + "Ejemplos: ab, aabb, aaabbb\n\n"

                + "ALFABETO DE LA CINTA\n"
                + "{ a, b, X, Y, □ }\n\n"

                + "Esta aplicacion permite visualizar el "
                + "funcionamiento de los cuatro niveles de la "
                + "Jerarquia de Chomsky mediante simulaciones "
                + "graficas e interactivas."
        );

        guia.add(
                new JScrollPane(informacion),
                BorderLayout.CENTER);

        tabs.addTab(
                "Guia",
                guia);

        tabs.addTab(
                "Nivel 3",
                nivel3);

        tabs.addTab(
                "Nivel 2",
                nivel2);

        tabs.addTab(
                "Nivel 1",
                nivel1);

        tabs.addTab(
                "Nivel 0",
                nivel0);

        add(
                tabs,
                BorderLayout.CENTER);
    }
}