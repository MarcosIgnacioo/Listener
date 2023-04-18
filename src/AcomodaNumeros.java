import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

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

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;

        for (int i = 0; i< 4; i++){
            for (int j = 0; j<4; j++){
                botonesOriginales[i][j] = new JButton(String.valueOf(tablero[i][j]));
                botonesOriginales[i][j].setVisible(true);
                botonesOriginales[i][j].setFont(new Font("Arial", Font.BOLD,24));

                repaint();
                revalidate();
            }
        }
        desordenarTablero(botonesOriginales);

        int finalX = 0;
        int finalY = 0;
        for (int i = 0; i< 4; i++){
            finalX = i;
            for (int j = 0; j<4; j++){
                gbc.gridx = j;
                gbc.gridy = i;
                finalY = j;
                panel.add(botonesOriginales[i][j], gbc);
                repaint();
                revalidate();
                int finalI = i;
                int finalJ = j;
                if (botonesOriginales[i][j].getText().equals("15")){
                    botonesOriginales[i][j].setText("");
                    posInvisibleX = j;
                    posInvisibleY = i;
                }
                int finalX1 = finalX;
                int finalY1 = finalY;
                botonesOriginales[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String coordsInv[] = leerMatriz(botonesOriginales);
                        String botonSeleccionado = botonesOriginales[finalX1][finalY1].getText();
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
                            botonesOriginales[finalX1][finalY1].setText("");
                            botonesOriginales[posInvisibleY][posInvisibleX].setText(coordsInv[indice]);
                            posInvisibleY = finalX1;
                            posInvisibleX = finalY1;
                            repaint();
                            revalidate();
                        }
                        System.out.println("X: " + coordsInv[0] + " Y: " + coordsInv[1]);
                    }
                });
            }
        }
    }
    public static void desordenarPiezas(int array[]){
            Random r = new Random();
            int tmp = 0;
            for (int i = 0; i< array.length; i++){
                int rnd = r.nextInt(15);
                tmp = array[i];
                array[i] = array[rnd];
                array[rnd] = tmp;
            }
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
    public static int distanciaEntreBotones(int x1, int y1, int x2, int y2){
        return (int) (Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2)));
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
}
