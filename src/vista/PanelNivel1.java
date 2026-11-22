package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelNivel1 extends JPanel {

    private JTextField txtCadena;
    private JTextArea txtPasos;
    private JTextArea txtCinta;
    private JButton btnProcesar;

    public PanelNivel1() {

        setLayout(new BorderLayout());

        JPanel superior = new JPanel(new FlowLayout());

        superior.add(new JLabel("Cadena:"));

        txtCadena = new JTextField(15);
        superior.add(txtCadena);

        btnProcesar = new JButton("Procesar");
        superior.add(btnProcesar);

        add(superior, BorderLayout.NORTH);

        txtPasos = new JTextArea();
        txtPasos.setEditable(false);

        txtCinta = new JTextArea();
        txtCinta.setEditable(false);

        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(txtPasos),
                new JScrollPane(txtCinta));

        split.setDividerLocation(350);

        add(split, BorderLayout.CENTER);

        btnProcesar.addActionListener(e -> procesar());
    }

    private void procesar() {

        txtPasos.setText("");
        txtCinta.setText("");

        String entrada = txtCadena.getText().trim();

        if (entrada.isEmpty()) {

            txtPasos.setText("Ingrese una cadena.");
            return;
        }

        if (!entrada.matches("a+b+c+")) {

            txtPasos.setText("Cadena rechazada.");
            return;
        }

        int cantidadA = 0;
        int cantidadB = 0;
        int cantidadC = 0;

        for (char c : entrada.toCharArray()) {

            if (c == 'a') {
                cantidadA++;
            } else if (c == 'b') {
                cantidadB++;
            } else if (c == 'c') {
                cantidadC++;
            }
        }

        if (!(cantidadA == cantidadB &&
                cantidadB == cantidadC)) {

            txtPasos.setText(
                    "Cadena rechazada.\n"
                    + "No cumple aⁿbⁿcⁿ");
            return;
        }

        char[] cinta =
                ("#" + entrada + "#").toCharArray();

        int paso = 1;

        for (int i = 1; i < cinta.length - 1; i++) {

            char simboloOriginal = cinta[i];

            char marca;

            if (simboloOriginal == 'a') {

                marca = 'X';

            } else if (simboloOriginal == 'b') {

                marca = 'Y';

            } else {

                marca = 'Z';
            }

            txtPasos.append(
                    "PASO " + paso + "\n");

            txtPasos.append(
                    "Cabezal se mueve hacia la derecha\n");

            txtPasos.append(
                    "Se marca "
                    + simboloOriginal
                    + " -> "
                    + marca
                    + "\n\n");

            cinta[i] = marca;

            mostrarCinta(cinta, i);

            paso++;
        }

        for (int i = cinta.length - 2; i >= 1; i--) {

            txtPasos.append(
                    "PASO " + paso + "\n");

            txtPasos.append(
                    "Cabezal se mueve hacia la izquierda\n\n");

            mostrarCinta(cinta, i);

            paso++;
        }

        txtPasos.append(
                "\n Cadena aceptada");
    }

    private void mostrarCinta(
            char[] cinta,
            int posicionCabezal) {

        for (char c : cinta) {

            txtCinta.append(c + " ");
        }

        txtCinta.append("\n");

        for (int i = 0; i < posicionCabezal; i++) {

            txtCinta.append("  ");
        }

        txtCinta.append("^\n");

        txtCinta.append(
                "--------------------------------------\n");
    }
}