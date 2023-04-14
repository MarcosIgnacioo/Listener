import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Eventos extends JFrame {

    public Eventos(){
        this.setVisible(true);
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.ORANGE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(900,700);
        //panel.setBackground(Color.pink);
        this.add(panel);

        JButton boton = new JButton("Picame");
        boton.setSize(200,200);
        boton.setLocation(0,0);
        boton.setOpaque(true);
        boton.setBackground(Color.BLUE);
        panel.add(boton);
        Random rndGenerator = new Random();
        int i = 0;
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = rndGenerator.nextInt(999999);
                String cod= String.valueOf(num);
                System.out.println(cod);
                int x = rndGenerator.nextInt(500);
                int y = rndGenerator.nextInt(500);
                boton.setBackground(Color.decode(cod));
                boton.setLocation(x,y);
                x = rndGenerator.nextInt(500);
                y = rndGenerator.nextInt(500);
                num = rndGenerator.nextInt(999999);
                JButton pops = new JButton(cod);
                pops.setOpaque(true);
                pops.setBackground(Color.decode(cod));
                pops.setLocation(x,y);
                pops.setSize(x/2,y/2);
                panel.add(pops);
                pops.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(pops,cod,"Este es el mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
                repaint();
                revalidate();
            }
        });

        this.repaint();
        this.revalidate();
    }
}
