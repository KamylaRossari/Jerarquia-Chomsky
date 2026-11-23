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

public class PanelNivel0 extends JPanel {

    private JTextField txtCadena;
    private JTextArea txtPasos;
    private JTextArea txtCinta;
    private JButton btnProcesar;

    public PanelNivel0() {

        setLayout(new BorderLayout());

        JPanel superior = new JPanel(new FlowLayout());

        superior.add(new JLabel("Cadena:"));

        txtCadena = new JTextField(15);
        superior.add(txtCadena);

        btnProcesar = new JButton("Ejecutar");
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

        btnProcesar.addActionListener(e -> ejecutar());
    }

    private void ejecutar() {

        txtPasos.setText("");
        txtCinta.setText("");

        String entrada = txtCadena.getText().trim();

        if (entrada.isEmpty()) {

            txtPasos.setText("Ingrese una cadena.");
            return;
        }

        char[] cinta =
                ("□" + entrada + "□").toCharArray();

        int paso = 1;

        for (int i = 1; i < cinta.length - 1; i++) {

            char leido = cinta[i];

            String estado;

            char escrito;

            if (leido == 'a') {

                estado = "q0";
                escrito = 'X';

            } else if (leido == 'b') {

                estado = "q1";
                escrito = 'Y';

            } else {

                continue;
            }

            txtPasos.append(
                    "PASO " + paso + "\n");

            txtPasos.append(
                    "Estado activo: " + estado + "\n");

            txtPasos.append(
                    "Leer: " + leido + "\n");

            txtPasos.append(
                    "Escribir: " + escrito + "\n");

            txtPasos.append(
                    "Movimiento: Derecha\n\n");

            cinta[i] = escrito;

            mostrarCinta(cinta, i);

            paso++;
        }

        txtPasos.append(
                "Estado final: qAceptacion\n");

        txtPasos.append(
                " Cadena aceptada");
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
                "----------------------------------------\n");
    }
}