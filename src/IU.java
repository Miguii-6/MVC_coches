
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Entorno gráfico - Interfaz de Usuario
 */
public class IU {
    private JPanel panel;
    private JTextField tfModelo;
    private JTextField tfMatricula;
    private JLabel lbModelo;
    private JLabel lbMatricula;
    private JButton btCrear;
    private JButton btBajar;
    private JButton btAumentar;
    /**
     * Constructor del entorno gráfico
     * tendrá los listener de la interfaz gráfica
     */

    public IU() {
        btCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.crearCoche(tfModelo.getText(), tfMatricula.getText());
            }
        });
        btBajar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.bajarVelocidad(tfMatricula.getText());
            }
        });
        btAumentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.aumentarVelocidad(tfMatricula.getText());
            }
        });
    }
    /**
     * Inicializa la Interfaz del Usuario
     * Lo llamaremos en el constructor de la vista
     */

    public static void crearVentana() {
        JFrame fr = new JFrame("Ventana para coches");
        fr.setContentPane(new IU().panel);
        fr.setDefaultCloseOperation(3);
        fr.pack();
        fr.setVisible(true);
    }
}
