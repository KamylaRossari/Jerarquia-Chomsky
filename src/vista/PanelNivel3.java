package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelNivel3 extends JPanel {

    private JTextField txtCadena;
    private JTextArea txtResultado;
    private JButton btnProcesar;

    public PanelNivel3() {

        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new FlowLayout());

        panelSuperior.add(new JLabel("Cadena:"));

        txtCadena = new JTextField(15);
        panelSuperior.add(txtCadena);

        btnProcesar = new JButton("Procesar");
        panelSuperior.add(btnProcesar);

        add(panelSuperior, BorderLayout.NORTH);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);

        add(new JScrollPane(txtResultado), BorderLayout.CENTER);

        btnProcesar.addActionListener(e -> procesarCadena());
    }

    private void procesarCadena() {

        String cadena = txtCadena.getText();

        txtResultado.setText("");

        if (cadena.isEmpty()) {
            txtResultado.setText("Ingrese una cadena.");
            return;
        }

        String estado = "q0";

        for (int i = 0; i < cadena.length(); i++) {

            char simbolo = cadena.charAt(i);

            txtResultado.append(
                    "Estado actual: " + estado +
                    " | Símbolo leído: " + simbolo + "\n");

            if (estado.equals("q0")) {

                if (simbolo == 'a') {

                    estado = "q1";

                    txtResultado.append(
                            "Transición: q0 -> q1\n\n");

                } else {

                    txtResultado.append(
                            "\nCadena rechazada.\n");

                    return;
                }

            } else if (estado.equals("q1")) {

                if (simbolo == 'b') {

                    txtResultado.append(
                            "Transición: q1 -> q1\n\n");

                } else {

                    txtResultado.append(
                            "\nCadena rechazada.\n");

                    return;
                }
            }
        }

        if (estado.equals("q1")) {

            txtResultado.append(
                    "\n Cadena aceptada");

        } else {

            txtResultado.append(
                    "\n Cadena rechazada");
        }
    }
}