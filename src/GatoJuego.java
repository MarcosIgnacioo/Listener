import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GatoJuego extends JPanel {
    static String turno = "X";

    static JButton botonesArreglo[] = new JButton[9];

    static int puntajeO;
    static int puntajeX;
    static JLabel puntosO = new JLabel("Puntos O: ");
    static JLabel puntosX = new JLabel("Puntos X: ");
    static JLabel turnoActualLabel = new JLabel(turno,JLabel.CENTER);
    /**
     * Create the panel.
     */
    public GatoJuego() {


        JPanel panelSuperior = new JPanel();
        panelSuperior.setVisible(true);
        panelSuperior.setPreferredSize(new Dimension(450,70));
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.setBackground(Color.orange);
            panelSuperior.add(puntosO, BorderLayout.EAST);
            panelSuperior.add(puntosX, BorderLayout.WEST);
            panelSuperior.add(turnoActualLabel,BorderLayout.CENTER);
        this.add(panelSuperior, BorderLayout.NORTH);



        JPanel panelCentral = new JPanel();
        panelCentral.setVisible(true);
        panelCentral.setPreferredSize(new Dimension(450,250));
        panelCentral.setBackground(Color.PINK);
        panelCentral.setLayout(new GridLayout(3,3));
        this.add(panelCentral, BorderLayout.CENTER);

            for (int i = 0; i<botonesArreglo.length; i++){
                botonesArreglo[i] = new JButton();
                botonesArreglo[i].setOpaque(true);
                int tmp = i;
                botonesArreglo[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            botonesArreglo[tmp].setText(turno);
                            botonesArreglo[tmp].setEnabled(false);
                            switch (tmp){
                                case 0:
                                    verificadorPuntos(botonesArreglo[1],botonesArreglo[2]);
                                    verificadorPuntos(botonesArreglo[3],botonesArreglo[6]);
                                    verificadorPuntos(botonesArreglo[4],botonesArreglo[8]);
                                    break;
                                case 1:
                                    verificadorPuntos(botonesArreglo[0],botonesArreglo[2]);
                                    verificadorPuntos(botonesArreglo[4],botonesArreglo[7]);
                                    break;
                                case 2:
                                    verificadorPuntos(botonesArreglo[0],botonesArreglo[1]);
                                    verificadorPuntos(botonesArreglo[5],botonesArreglo[8]);
                                    verificadorPuntos(botonesArreglo[4],botonesArreglo[6]);
                                    break;
                                case 3:
                                    verificadorPuntos(botonesArreglo[4],botonesArreglo[5]);
                                    verificadorPuntos(botonesArreglo[0],botonesArreglo[6]);
                                    break;
                                case 4:
                                    verificadorPuntos(botonesArreglo[3],botonesArreglo[5]);
                                    verificadorPuntos(botonesArreglo[0],botonesArreglo[8]);
                                    verificadorPuntos(botonesArreglo[6],botonesArreglo[2]);
                                    verificadorPuntos(botonesArreglo[1],botonesArreglo[7]);
                                    break;
                                case 5:
                                    verificadorPuntos(botonesArreglo[4],botonesArreglo[3]);
                                    verificadorPuntos(botonesArreglo[2],botonesArreglo[8]);
                                    break;
                                case 6:
                                    verificadorPuntos(botonesArreglo[7],botonesArreglo[8]);
                                    verificadorPuntos(botonesArreglo[0],botonesArreglo[3]);
                                    verificadorPuntos(botonesArreglo[4],botonesArreglo[2]);
                                    break;
                                case 7:
                                    verificadorPuntos(botonesArreglo[6],botonesArreglo[8]);
                                    verificadorPuntos(botonesArreglo[1],botonesArreglo[4]);
                                    break;
                                case 8:
                                    verificadorPuntos(botonesArreglo[7],botonesArreglo[6]);
                                    verificadorPuntos(botonesArreglo[2],botonesArreglo[5]);
                                    verificadorPuntos(botonesArreglo[0],botonesArreglo[4]);
                                    break;
                            }
                            cambioTurno();
                        }
                });
                panelCentral.add(botonesArreglo[i]);
            }

        JPanel panelInferior = new JPanel();
        panelInferior.setVisible(true);
        panelInferior.setPreferredSize(new Dimension(450,70));
        panelInferior.setBackground(Color.orange);
        panelInferior.setLayout(new BorderLayout());
        this.add(panelInferior, BorderLayout.SOUTH);
            JButton botonReiniciar = new JButton("Reiniciar");
            botonReiniciar.setVisible(true);
            botonReiniciar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    reiniciarBotones();
                }
            });
            panelInferior.add(botonReiniciar, BorderLayout.NORTH);
        repaint();
        revalidate();
    }
    public static void cambioTurno(){
        if (turno == "O"){
            turno = "X";
            turnoActualLabel.setText(turno);
        }
        else {
            turno = "O";
            turnoActualLabel.setText(turno);
        }
    }
    public static void reiniciarBotones(){
        for (int i = 0; i<botonesArreglo.length; i++){
            botonesArreglo[i].setText("");
            botonesArreglo[i].setEnabled(true);
        }
        turno = "X";
        turnoActualLabel.setText(turno);
    }
    public static boolean verificadorPuntos(JButton b1, JButton b2){
        if (b1.getText().equals(turno) && b2.getText().equals(turno)){
            if (b1.getText() == "O"){
                JOptionPane.showMessageDialog(null,"Gano: "+turno, "Partida terminada", JOptionPane.INFORMATION_MESSAGE);
                puntajeO += 1;
                puntosO.setText("Puntos O: " + puntajeO);
            }
            else{
                JOptionPane.showMessageDialog(null,"Gano: "+turno, "Partida terminada", JOptionPane.INFORMATION_MESSAGE);
                puntajeX += 1;
                puntosX.setText("Puntos X: " + puntajeX);
            }
            reiniciarBotones();
            return true;
        }
        else{
            return false;
        }
    }


}
