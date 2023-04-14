import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(450,400));
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
