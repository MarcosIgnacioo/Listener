import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AcomodaNumeros extends JFrame {
    JButton botonesOriginales[][] = new JButton[4][4];
    int posiciones[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    int tablero[][] = {{0,1,2,3},
                       {4  ,5,6  ,7},
                       {8  ,9,10,11},
                       {12,13,14,15}};
    int posInvisibleX, posInvisibleY;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AcomodaNumeros frame = new AcomodaNumeros();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AcomodaNumeros() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 900);

        contentPane = new JPanel();
            contentPane.setBorder(new LineBorder(new Color(70, 45, 34), 40));
            contentPane.setOpaque(true);
            setContentPane(contentPane);
            contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
            contentPane.add(panel, BorderLayout.CENTER);
            panel.setLayout(new GridLayout(4,4,0,0));

            acomodarAlAzar(botonesOriginales, panel);

            JButton reiniciar = new JButton("Reiniciar");
            reiniciar.setOpaque(true);
            reiniciar.setVisible(true);
            reiniciar.setBackground(new Color(70, 45, 34));
            reiniciar.setFont(new Font("Arial", Font.BOLD, 24));
            reiniciar.setForeground(new Color(194, 120, 93));
            reiniciar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removerBotones(botonesOriginales,panel);
                    acomodarAlAzar(botonesOriginales, panel);
                }
            });
            contentPane.add(reiniciar, BorderLayout.SOUTH);
            repaint();
            revalidate();
    }
    public static void desordenarTablero(JButton matriz[][]){
        Random r = new Random();
        JButton tmp;
        for (int i = 0; i< 4; i++){
            for (int j = 0; j<4; j++){
                int rnd = r.nextInt(4);
                int rnd2 = r.nextInt(4);
                tmp = matriz[i][j];
                matriz[i][j] =  matriz[rnd2][rnd];
                matriz[rnd2][rnd] = tmp;
                System.out.print("["+matriz[i][j].getText()+"] ");
            }
            System.out.println();
        }
    }
    public static String[] leerMatriz(JButton matriz[][]){
        int coordsBtnInv [] = new int[2];
        for (int i = 0; i< 4; i++){
            for (int j = 0; j<4; j++){
                System.out.print("["+matriz[i][j].getText()+"] ");
                if (matriz[i][j].getText().equals("")){
                    coordsBtnInv[0] = i;
                    coordsBtnInv[1] = j;
                }
            }
            System.out.println();
        }
        String botonesTexto[] = {null,null,null,null};
        if (coordsBtnInv[1] > 0) {
            botonesTexto[0] = matriz[coordsBtnInv[0]][coordsBtnInv[1] - 1].getText();
        }
        if (coordsBtnInv[1] < 3) {
            botonesTexto[1] = matriz[coordsBtnInv[0]][coordsBtnInv[1] + 1].getText();
        }
        if (coordsBtnInv[0] < 3) {
            botonesTexto[2] = matriz[coordsBtnInv[0] + 1][coordsBtnInv[1]].getText();
        }
        if (coordsBtnInv[0] > 0) {
            botonesTexto[3] = matriz[coordsBtnInv[0] - 1][coordsBtnInv[1]].getText();
        }
        return botonesTexto;
    }
    public void acomodarAlAzar(JButton matrizBotones[][], JPanel panel){
        for (int i = 0; i< 4; i++){
            for (int j = 0; j<4; j++){
                matrizBotones[i][j] = new JButton(String.valueOf(tablero[i][j]+1));
                matrizBotones[i][j].setVisible(true);
                matrizBotones[i][j].setFont(new Font("Arial", Font.BOLD,48));
                matrizBotones[i][j].setOpaque(true);
                repaint();
                revalidate();
            }
        }
        desordenarTablero(matrizBotones);

        int finalX = 0;
        int finalY = 0;
        for (int i = 0; i< 4; i++){
            finalX = i;
            for (int j = 0; j<4; j++){
                finalY = j;
                panel.add(matrizBotones[i][j]);
                this.repaint();
                this.revalidate();
                int finalI = i;
                int finalJ = j;
                Color colorFondo;
                Color colorLetras;
                if (j%2 == 0){
                    colorFondo = new Color(194, 120, 93);
                    colorLetras = new Color(70, 45, 34);
                }
                else {
                    colorFondo = new Color(70, 45, 34);
                    colorLetras = new Color(194, 120, 93);
                }
                matrizBotones[i][j].setForeground(colorLetras);
                matrizBotones[i][j].setBackground(colorFondo);
                if (matrizBotones[i][j].getText().equals("16")){
                    matrizBotones[i][j].setText("");
                    posInvisibleX = i;
                    posInvisibleY = j;
                }
                int finalX1 = finalX;
                int finalY1 = finalY;
                matrizBotones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String coordsInv[] = leerMatriz(matrizBotones);
                        String botonSeleccionado = matrizBotones[finalX1][finalY1].getText();
                        System.out.println(finalX1);
                        System.out.println(finalY1);
                        System.out.println("--------------");
                        System.out.println(coordsInv[0]);
                        System.out.println(coordsInv[1]);
                        System.out.println(coordsInv[2]);
                        System.out.println(coordsInv[3]);
                        System.out.println("--------------");
                        int indice = 0;
                        boolean sePuedeMover = false;
                        for (int k = 0; k<coordsInv.length; k++){
                            if (botonSeleccionado.equals(coordsInv[k])){
                                indice = k;
                                sePuedeMover = true;
                            }
                        }
                        if (sePuedeMover){
                            matrizBotones[finalX1][finalY1].setText("");
                            matrizBotones[posInvisibleX][posInvisibleY].setText(coordsInv[indice]);
                            posInvisibleX = finalX1;
                            posInvisibleY = finalY1;
                            repaint();
                            revalidate();
                            int victoriaRoyal = ganaste(botonesOriginales, panel);
                            if (victoriaRoyal == 16){
                                JOptionPane.showMessageDialog(null, "Ganaste", "Victory royal", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        System.out.println("X: " + coordsInv[0] + " Y: " + coordsInv[1]);
                    }
                });
            }
    }
    }
    public void removerBotones(JButton matrizBotones[][], JPanel panel){
        for (int i = 0; i< 4; i++){
            for (int j = 0; j<4; j++){
                panel.remove(matrizBotones[i][j]);
                repaint();
                revalidate();
            }
        }
    }
    public int ganaste(JButton matrizBotones[][], JPanel panel){
        String tableroGanador[][] = {
                {"1",  "2", "3", "4"},
                {"5",  "6", "7", "8"},
                {"9",  "10","11","12"},
                {"13", "14","15",""}};
        int puntos = 0;
        for (int i = 0; i< 4; i++){
            for (int j = 0; j<4; j++){
                if (matrizBotones[i][j].getText().equals(tableroGanador[i][j])){
                    puntos++;
                    System.out.println("p: "+ puntos);
                }
            }
        }
        return puntos;
    }
}
