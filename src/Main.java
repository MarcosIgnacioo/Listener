import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public static void main(String[] args) {
        GatoJuego popo = new GatoJuego();
        popo.setVisible(true);
        Ventana v = new Ventana();
        v.add(popo);

    }
}