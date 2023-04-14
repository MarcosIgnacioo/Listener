import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.jar.JarFile;
// fuente listener padre
public class ListenerClaseDos extends JFrame implements ActionListener {// REPAINT NIIGGGGGGGGGGGGGGGGGG REVALIDATE
    public ListenerClaseDos(){
        this.setVisible(true);
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.ORANGE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(900,700);
        panel.setBackground(Color.pink);
        this.add(panel);
        Random rndGenerator = new Random();
        ArrayList<JButton> listaBotones = new ArrayList<JButton>();
        final int[] index = {0};

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // con el panel siempre se usa los metodos a partir de e !!!!!!!!!
                int num = rndGenerator.nextInt(999999);
                String cod= String.valueOf(num);
                listaBotones.add(new JButton(cod));
                listaBotones.get(index[0]).setOpaque(true);
                listaBotones.get(index[0]).setLocation(e.getX(),e.getY());
                listaBotones.get(index[0]).setBackground(Color.decode(cod));
                listaBotones.get(index[0]).setSize(rndGenerator.nextInt(200),rndGenerator.nextInt(200));
                panel.add(listaBotones.get(index[0]));
                System.out.println("Indice: "+index[0]);
                int id = index[0];
                listaBotones.get(index[0]).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i<listaBotones.size(); i++){
                            if (e.getSource().equals(listaBotones.get(i))){
                                panel.remove(listaBotones.get(i));
                                repaint();
                                revalidate();
                                break;
                            }
                        }
                        repaint();
                        revalidate();
                    }//actualizado
                });
                index[0]++;
                repaint();
                revalidate();
                /*
                JButton pops = new JButton(cod);
                pops.setOpaque(true);
                pops.setLocation(e.getX(),e.getY());
                pops.setBackground(Color.decode(cod));
                pops.setSize(rndGenerator.nextInt(200),rndGenerator.nextInt(200));*/

                /*pops.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.remove(pops);
                        repaint();
                        revalidate();
                    }//actualizado
                });
                panel.add(pops);
                repaint();
                revalidate();*/
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

                int num = rndGenerator.nextInt(999999);
                String cod= String.valueOf(num);
                panel.setBackground(Color.decode(cod));
            }
        });

        this.repaint();
        this.revalidate();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                // 38 arriba 40 abajo 37 izquierda 39 derecha
                // 65 a
                // 83 s
                // 68 d
                // 87w
                if (e.getKeyCode() == 8){
                    for (int i = 0; i<listaBotones.size(); i++){
                        panel.remove(listaBotones.get(i));
                        repaint();
                        revalidate();
                    }
                }
                if (e.getKeyCode() == 38 || e.getKeyCode() == 87){
                    System.out.println("Arrriba");
                    for (int i = 0; i<listaBotones.size(); i++){
                        listaBotones.get(i).setLocation(listaBotones.get(i).getX(), listaBotones.get(i).getY()-20);
                        repaint();
                        revalidate();
                    }
                }
                if(e.getKeyCode() == 40 || e.getKeyCode() == 83){
                    System.out.println("Abajo");
                    for (int i = 0; i<listaBotones.size(); i++){
                        listaBotones.get(i).setLocation(listaBotones.get(i).getX(), listaBotones.get(i).getY()+20);
                        repaint();
                        revalidate();
                    }
                }
                if (e.getKeyCode() == 37 || e.getKeyCode() == 65){
                    for (int i = 0; i<listaBotones.size(); i++){
                        listaBotones.get(i).setLocation(listaBotones.get(i).getX()-20, listaBotones.get(i).getY());
                        repaint();
                        revalidate();
                    }
                    System.out.println("Izquierda");
                }
                if (e.getKeyCode() == 39|| e.getKeyCode() == 68){
                    for (int i = 0; i<listaBotones.size(); i++){
                        listaBotones.get(i).setLocation(listaBotones.get(i).getX()+20, listaBotones.get(i).getY());
                        repaint();
                        revalidate();
                    }
                    System.out.println("Derecha");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.repaint();
        this.revalidate();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
