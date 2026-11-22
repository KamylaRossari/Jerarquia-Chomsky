package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelNivel2 extends JPanel {

    private JTextField txtCadena;
    private JTextArea txtOperaciones;
    private JTextArea txtPila;
    private JButton btnProcesar;

    public PanelNivel2() {

        setLayout(new BorderLayout());

        JPanel superior = new JPanel(new FlowLayout());

        superior.add(new JLabel("Cadena:"));

        txtCadena = new JTextField(15);
        superior.add(txtCadena);

        btnProcesar = new JButton("Procesar");
        superior.add(btnProcesar);

        add(superior, BorderLayout.NORTH);

        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT);

        txtOperaciones = new JTextArea();
        txtOperaciones.setEditable(false);

        txtPila = new JTextArea();
        txtPila.setEditable(false);

        split.setLeftComponent(
                new JScrollPane(txtOperaciones));

        split.setRightComponent(
                new JScrollPane(txtPila));

        add(split, BorderLayout.CENTER);

        btnProcesar.addActionListener(e -> procesar());
    }

    private void procesar() {

        txtOperaciones.setText("");
        txtPila.setText("");

        String cadena = txtCadena.getText().trim();

        Stack<Character> pila = new Stack<>();

        boolean leyendoBs = false;
        int paso = 1;

        for (int i = 0; i < cadena.length(); i++) {

            char simbolo = cadena.charAt(i);

            if (simbolo == 'a' && !leyendoBs) {

                pila.push('a');

                txtOperaciones.append(
                        "Paso " + paso
                        + ": Lectura de 'a' -> Push(a)\n");

                actualizarPila(
                        pila,
                        simbolo,
                        "Push(a)",
                        paso);

                paso++;

            } else if (simbolo == 'b') {

                leyendoBs = true;

                if (pila.isEmpty()) {

                    txtOperaciones.append(
                            "\nCadena rechazada");

                    return;
                }

                pila.pop();

                txtOperaciones.append(
                        "Paso " + paso
                        + ": Lectura de 'b' -> Pop(a)\n");

                actualizarPila(
                        pila,
                        simbolo,
                        "Pop(a)",
                        paso);

                paso++;

            } else {

                txtOperaciones.append(
                        "\nCadena rechazada");

                return;
            }
        }

        if (pila.isEmpty()) {

            txtOperaciones.append(
                    "\n\n Cadena aceptada");

        } else {

            txtOperaciones.append(
                    "\n\n Cadena rechazada");
        }
    }

    private void actualizarPila(
            Stack<Character> pila,
            char simbolo,
            String accion,
            int paso) {

        txtPila.append(
                "PASO " + paso + "\n\n");

        txtPila.append(
                "Simbolo leido: "
                + simbolo + "\n");

        txtPila.append(
                "Accion: "
                + accion + "\n\n");

        if (pila.isEmpty()) {

            txtPila.append(
                    "PILA VACIA\n");

        } else {

            txtPila.append(
                    "TOPE\n");

            for (int i = pila.size() - 1;
                    i >= 0;
                    i--) {

                txtPila.append(
                        "[ "
                        + pila.get(i)
                        + " ]\n");
            }
        }

        txtPila.append(
                "\n----------------------------------\n\n");
    }
}