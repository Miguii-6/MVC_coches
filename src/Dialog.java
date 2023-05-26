import javax.swing.*;

public class Dialog extends JDialog{
    private JPanel panel;
    private JLabel lbVelocidad;

    public Dialog(){
        setContentPane(panel);
        setModal(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public static void msjDialog(String msj){
        Dialog dialog = new Dialog();
        dialog.pack();
        dialog.lbVelocidad.setText(msj);
        dialog.setVisible(true);
    }
}
