

import javax.swing.*;
import java.awt.GridLayout;

public class NueveBotones extends JPanel {

    /**
     * Create the panel.
     */
    public NueveBotones() {
        setLayout(new GridLayout(3,3,3,3));

        JButton btnNewButton = new JButton("New button");
        add(btnNewButton);

        JButton btnNewButton_3 = new JButton("New button");
        add(btnNewButton_3);

        JButton btnNewButton_6 = new JButton("New button");
        add(btnNewButton_6);

        JButton btnNewButton_8 = new JButton("New button");
        add(btnNewButton_8);

        JButton btnNewButton_7 = new JButton("New button");
        add(btnNewButton_7);

        JButton btnNewButton_5 = new JButton("New button");
        add(btnNewButton_5);

        JButton btnNewButton_4 = new JButton("New button");
        add(btnNewButton_4);

        JButton btnNewButton_1 = new JButton("New button");
        add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("New button");
        add(btnNewButton_2);
        repaint();
        revalidate();
    }
}
