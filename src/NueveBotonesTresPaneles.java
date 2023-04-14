import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class NueveBotonesTresPaneles extends JPanel {

    /**
     * Create the panel.
     */
    public NueveBotonesTresPaneles() {
        setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 450, 43);
        panel_1.setBackground(new Color(255, 183, 45));
        add(panel_1);

        JLabel lblNewLabel = new JLabel("ola");
        panel_1.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(0, 42, 450, 213);
        add(panel);
        panel.setLayout(new GridLayout(3, 3, 3, 3));

        JButton botones[] = new JButton[9];
        botones[0] = new JButton("New asdsad");
        botones[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botones[0].setOpaque(true);
                botones[0].setBackground(Color.CYAN);
            }
        });
        panel.add(botones[0]);

        botones[1] = new JButton("New button");
        botones[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botones[1].setOpaque(true);
                botones[1].setBackground(Color.CYAN);
            }
        });
        panel.add(botones[1]);

        botones[2] = new JButton("New button");
        botones[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botones[2].setOpaque(true);
                botones[2].setBackground(Color.CYAN);
            }
        });
        panel.add(botones[2]);

        botones[3] = new JButton("New button");
        botones[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botones[3].setOpaque(true);
                botones[3].setBackground(Color.CYAN);
            }
        });
        panel.add(botones[3]);

        botones[4] = new JButton("New button");
        botones[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botones[4].setOpaque(true);
                botones[4].setBackground(Color.CYAN);
            }
        });
        panel.add(botones[4]);

        botones[5] = new JButton("New button");
        botones[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botones[5].setOpaque(true);
                botones[5].setBackground(Color.CYAN);
            }
        });
        panel.add(botones[5]);

        botones[6] = new JButton("New button");
        botones[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botones[6].setOpaque(true);
                botones[6].setBackground(Color.CYAN);
            }
        });
        panel.add(botones[6]);
        botones[7] = new JButton("New button");
        botones[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botones[7].setOpaque(true);
                botones[7].setBackground(Color.CYAN);
            }
        });
        panel.add(botones[7]);

        botones[8] = new JButton("New button");
        botones[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botones[8].setOpaque(true);
                botones[8].setBackground(Color.CYAN);
            }
        });
        panel.add(botones[8]);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 251, 450, 43);
        panel_2.setBackground(new Color(255, 183, 45));
        add(panel_2);

        JButton btnNewButton_9 = new JButton("Reiniciar");
        btnNewButton_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i<botones.length; i++){
                    botones[i].setBackground(Color.WHITE);
                }
            }
        });
        panel_2.add(btnNewButton_9);

    }



}
