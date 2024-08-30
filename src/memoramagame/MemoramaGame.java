package memoramagame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class MemoramaGame extends JFrame implements ActionListener, MouseListener {

    private Accion[][] botones = new Accion[6][6];
    private JButton jugar;
    private JLabel puntaje, numMovs, titulo, logo, reloj, tiempo, puntuacion, movs, seleccionarLabel;
    private Image I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, oculto;
    private ImageIcon iconoOculto, icono1, icono2, icono3, icono4, icono5, icono6, icono7, icono8, icono9, icono10, icono11, icono12, icono13, icono14, icono15, icono16, icono17, icono18;
    private Color fondo = new Color(0, 0, 0);
    private int[] verificador = new int[18];
    private int posicion;
    private boolean correcto = false, pulsado = false, fallo = false;
    private Accion anterior = new Accion();
    private JFrame resultados;
    private JPanel panel;
    private Font auxFont;
    private ImageIcon imagenT, imagenL, imagenR;
    private JComboBox dificultad;

    private int puntos = 0, movimientos = 0, restantes = 18;
    private int estado;
    private Timer timer;
    private int tiempoRestante;


    public MemoramaGame() {
        setLayout(null);

        setTitle("Memorama");

        setIconImage(new ImageIcon("src/recursos/intriga.png").getImage());

        oculto = new ImageIcon("src/recursos/intriga.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        iconoOculto = new ImageIcon(oculto);

        I1 = new ImageIcon("src/recursos/1.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono1 = new ImageIcon(I1);

        I2 = new ImageIcon("src/recursos/2.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono2 = new ImageIcon(I2);

        I3 = new ImageIcon("src/recursos/3.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono3 = new ImageIcon(I3);

        I4 = new ImageIcon("src/recursos/4.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono4 = new ImageIcon(I4);

        I5 = new ImageIcon("src/recursos/5.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono5 = new ImageIcon(I5);

        I6 = new ImageIcon("src/recursos/6.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono6 = new ImageIcon(I6);

        I7 = new ImageIcon("src/recursos/7.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono7 = new ImageIcon(I7);

        I8 = new ImageIcon("src/recursos/8.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono8 = new ImageIcon(I8);

        I9 = new ImageIcon("src/recursos/9.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono9 = new ImageIcon(I9);

        I10 = new ImageIcon("src/recursos/10.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono10 = new ImageIcon(I10);

        I11 = new ImageIcon("src/recursos/11.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono11 = new ImageIcon(I11);

        I12 = new ImageIcon("src/recursos/12.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono12 = new ImageIcon(I12);

        I13 = new ImageIcon("src/recursos/13.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono13 = new ImageIcon(I13);

        I14 = new ImageIcon("src/recursos/14.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono14 = new ImageIcon(I14);

        I15 = new ImageIcon("src/recursos/15.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono15 = new ImageIcon(I15);

        I16 = new ImageIcon("src/recursos/16.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono16 = new ImageIcon(I16);

        I17 = new ImageIcon("src/recursos/17.jpg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono17 = new ImageIcon(I17);

        I18 = new ImageIcon("src/recursos/18.jpeg").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        icono18 = new ImageIcon(I18);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                correcto = false;
                while (!correcto) {
                    posicion = (int) Math.floor(Math.random() * (18 - 1 + 1) + 1);

                    if (verificador[posicion - 1] < 2) {
                        verificador[posicion - 1]++;
                        correcto = true;

                        botones[i][j] = new Accion(iconoOculto);
                        botones[i][j].setBackground(fondo);
                        botones[i][j].setSize(120, 120);
                        botones[i][j].addActionListener(this);
                        botones[i][j].addMouseListener(this);
                        botones[i][j].setID(posicion);

                        switch (posicion) {
                            case 1:
                                botones[i][j].setFoto(icono1);
                                break;

                            case 2:
                                botones[i][j].setFoto(icono2);
                                break;

                            case 3:
                                botones[i][j].setFoto(icono3);
                                break;

                            case 4:
                                botones[i][j].setFoto(icono4);
                                break;

                            case 5:
                                botones[i][j].setFoto(icono5);
                                break;

                            case 6:
                                botones[i][j].setFoto(icono6);
                                break;

                            case 7:
                                botones[i][j].setFoto(icono7);
                                break;

                            case 8:
                                botones[i][j].setFoto(icono8);
                                break;

                            case 9:
                                botones[i][j].setFoto(icono9);
                                break;

                            case 10:
                                botones[i][j].setFoto(icono10);
                                break;

                            case 11:
                                botones[i][j].setFoto(icono11);
                                break;

                            case 12:
                                botones[i][j].setFoto(icono12);
                                break;

                            case 13:
                                botones[i][j].setFoto(icono13);
                                break;

                            case 14:
                                botones[i][j].setFoto(icono14);
                                break;

                            case 15:
                                botones[i][j].setFoto(icono15);
                                break;

                            case 16:
                                botones[i][j].setFoto(icono16);
                                break;

                            case 17:
                                botones[i][j].setFoto(icono17);
                                break;

                            case 18:
                                botones[i][j].setFoto(icono18);
                                break;

                        }
                    }
                }
            }
        }

        //Primera Fila
        botones[0][0].setLocation(15, 15);
        add(botones[0][0]);

        botones[0][1].setLocation(145, 15);
        add(botones[0][1]);

        botones[0][2].setLocation(275, 15);
        add(botones[0][2]);

        botones[0][3].setLocation(405, 15);
        add(botones[0][3]);

        botones[0][4].setLocation(535, 15);
        add(botones[0][4]);

        botones[0][5].setLocation(665, 15);
        add(botones[0][5]);

        //Segunda Fila
        botones[1][0].setLocation(15, 145);
        add(botones[1][0]);

        botones[1][1].setLocation(145, 145);
        add(botones[1][1]);

        botones[1][2].setLocation(275, 145);
        add(botones[1][2]);

        botones[1][3].setLocation(405, 145);
        add(botones[1][3]);

        botones[1][4].setLocation(535, 145);
        add(botones[1][4]);

        botones[1][5].setLocation(665, 145);
        add(botones[1][5]);

        //Tercera Fila
        botones[2][0].setLocation(15, 275);
        add(botones[2][0]);

        botones[2][1].setLocation(145, 275);
        add(botones[2][1]);

        botones[2][2].setLocation(275, 275);
        add(botones[2][2]);

        botones[2][3].setLocation(405, 275);
        add(botones[2][3]);

        botones[2][4].setLocation(535, 275);
        add(botones[2][4]);

        botones[2][5].setLocation(665, 275);
        add(botones[2][5]);

        //Cuarta Fila
        botones[3][0].setLocation(15, 405);
        add(botones[3][0]);

        botones[3][1].setLocation(145, 405);
        add(botones[3][1]);

        botones[3][2].setLocation(275, 405);
        add(botones[3][2]);

        botones[3][3].setLocation(405, 405);
        add(botones[3][3]);

        botones[3][4].setLocation(535, 405);
        add(botones[3][4]);

        botones[3][5].setLocation(665, 405);
        add(botones[3][5]);

        //Quinta Fila
        botones[4][0].setLocation(15, 535);
        add(botones[4][0]);

        botones[4][1].setLocation(145, 535);
        add(botones[4][1]);

        botones[4][2].setLocation(275, 535);
        add(botones[4][2]);

        botones[4][3].setLocation(405, 535);
        add(botones[4][3]);

        botones[4][4].setLocation(535, 535);
        add(botones[4][4]);

        botones[4][5].setLocation(665, 535);
        add(botones[4][5]);

        //Sexta Fila
        botones[5][0].setLocation(15, 665);
        add(botones[5][0]);

        botones[5][1].setLocation(145, 665);
        add(botones[5][1]);

        botones[5][2].setLocation(275, 665);
        add(botones[5][2]);

        botones[5][3].setLocation(405, 665);
        add(botones[5][3]);

        botones[5][4].setLocation(535, 665);
        add(botones[5][4]);

        botones[5][5].setLocation(665, 665);
        add(botones[5][5]);

        panel = new JPanel();
        panel.setBounds(800, 250, 325, 535);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        add(panel);

        puntuacion = new JLabel("Puntuación:");
        puntuacion.setBounds(58, 430, 166, 43);
        auxFont = puntuacion.getFont();
        puntuacion.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        puntuacion.setForeground(Color.BLACK);
        panel.add(puntuacion);

        movs = new JLabel("Movimientos:");
        movs.setBounds(45, 468, 191, 43);
        auxFont = movs.getFont();
        movs.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        movs.setForeground(Color.BLACK);
        panel.add(movs);

        jugar = new JButton("Comenzar");
        jugar.setBounds(66, 320, 180, 78);
        auxFont = jugar.getFont();
        jugar.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        jugar.setForeground(Color.WHITE);
        jugar.setBackground(new Color(200, 172, 255));
        jugar.addActionListener(this);
        panel.add(jugar);

        puntaje = new JLabel("0");
        puntaje.setBounds(175, 430, 35, 43);
        auxFont = puntaje.getFont();
        puntaje.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        puntaje.setForeground(Color.BLACK);
        panel.add(puntaje);

        numMovs = new JLabel("0");
        numMovs.setBounds(175, 449, 305, 80);
        auxFont = numMovs.getFont();
        numMovs.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        numMovs.setForeground(Color.BLACK);
        panel.add(numMovs);

        titulo = new JLabel();
        imagenT = new ImageIcon(Objects.requireNonNull(getClass().getResource("../recursos/titulo.png")));
        titulo.setIcon(imagenT);
        titulo.setBounds(813, 163, 300, 80);
        add(titulo);

        logo = new JLabel();
        imagenL = new ImageIcon(Objects.requireNonNull(getClass().getResource("../recursos/imagenlogo.png")));
        logo.setIcon(imagenL);
        logo.setBounds(910, 20, 180, 180);
        add(logo);

        reloj = new JLabel();
        imagenR = new ImageIcon(Objects.requireNonNull(getClass().getResource("../recursos/reloj.png")));
        reloj.setIcon(imagenR);
        reloj.setBounds(64, 185, 83, 83);
        panel.add(reloj);

        seleccionarLabel = new JLabel("Selecciona la dificultad");
        seleccionarLabel.setBounds(50, 30, 500, 43);
        auxFont = seleccionarLabel.getFont();
        seleccionarLabel.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        seleccionarLabel.setForeground(Color.BLACK);
        panel.add(seleccionarLabel);

        dificultad = new JComboBox();
        dificultad.setBounds(65, 70, 185, 30);
        for (String s : Arrays.asList("", "Fácil: 120 seg.", "Normal: 60 seg.", "Dificil: 30 seg.")) {
            dificultad.addItem(s);
        }
        dificultad.addActionListener(this);
        panel.add(dificultad);

        tiempo = new JLabel("000");
        tiempo.setBounds(160, 180, 100, 100);
        auxFont = tiempo.getFont();
        tiempo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
        tiempo.setForeground(Color.BLACK);
        panel.add(tiempo);

    }

    public void ventana() {
        MemoramaGame ventana = new MemoramaGame();
        ventana.setSize(1160, 840);
        ventana.getContentPane().setBackground(new Color(255, 248, 156));
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
    }

    public void mandarTiempo() {
        String seleccion = (String) dificultad.getSelectedItem();

        if (seleccion != null && !seleccion.isEmpty()) {
            String[] partes = seleccion.split(": ");
            if (partes.length > 1) {
                String numero = partes[1].replace(" seg.", "").trim();
                tiempo.setText(numero);
                tiempoRestante = Integer.parseInt(numero);
            }
        }

    }

    private void temporizador() {
        // Configurar el Timer para actualizar el JLabel cada segundo
        timer = new Timer(1000, e -> {
            tiempoRestante--;
            tiempo.setText(String.valueOf(tiempoRestante));
            if (tiempoRestante <= 0) {
                timer.stop();
            }
        });
        timer.start();
    }

    public void comparar(Accion anterior, Accion actual) {
        if (anterior.getID() == actual.getID()) {
            puntos = puntos + 5;
            movimientos++;
            restantes--;

            puntaje.setText(Integer.toString(puntos));
            numMovs.setText(Integer.toString(movimientos));

            anterior.setEnabled(false);
            actual.setEnabled(false);

            if (restantes == 0) {
                estado("../recursos/ganar.png", true);
            }

        } else {
            puntos--;
            movimientos++;
            puntaje.setText(Integer.toString(puntos));
            numMovs.setText(Integer.toString(movimientos));
            fallo = true;
        }

        pulsado = false;
    }

    private void cambiarEstado() {
        this.estado = (this.estado + 1) % 3;
        switch (estado) {
            case 0 -> {
                jugar.setText("Comenzar");
                accionEstado1();
            }
            case 1 -> {
                jugar.setText("Rendirse");
                accionEstado2();
            }
            case 2 -> {
                jugar.setText("Reintentar");
                accionEstado3();
            }
        }
    }

    private void accionEstado1() {
        dispose();
        ventana();
        System.out.println("Se reinicio");
    }

    private void accionEstado2() {
        temporizador();
        System.out.println("Comenzo el juego");
    }

    private void accionEstado3() {
        estado("../recursos/perder.png", false);
        System.out.println("Termino el juego");
    }

    public void devolver(Accion anterior, Accion actual) {
        anterior.setUsado(false);
        actual.setUsado(false);
        anterior.setIcon(iconoOculto);
        actual.setIcon(iconoOculto);
        fallo = false;
    }

    public void estado(String urlImage, boolean partida) {
        imagenT = new ImageIcon(Objects.requireNonNull(getClass().getResource(urlImage)));
        if (partida) {
            titulo.setIcon(imagenT);
            System.out.println("Ganador");
            timer.stop();
            this.estado = 1;
        } else {
            titulo.setIcon(imagenT);
            System.out.println("Perdiste");
            timer.stop();
            this.estado = 2;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

        //Primera fila
        if (e.getSource() == botones[0][0] && fallo) {
            devolver(anterior, botones[0][0]);
        }

        if (e.getSource() == botones[0][1] && fallo) {
            devolver(anterior, botones[0][1]);
        }

        if (e.getSource() == botones[0][2] && fallo) {
            devolver(anterior, botones[0][2]);
        }

        if (e.getSource() == botones[0][3] && fallo) {
            devolver(anterior, botones[0][3]);
        }

        if (e.getSource() == botones[0][4] && fallo) {
            devolver(anterior, botones[0][4]);
        }

        if (e.getSource() == botones[0][5] && fallo) {
            devolver(anterior, botones[0][5]);
        }

        //Segunda fila
        if (e.getSource() == botones[1][0] && fallo) {
            devolver(anterior, botones[1][0]);
        }

        if (e.getSource() == botones[1][1] && fallo) {
            devolver(anterior, botones[1][1]);
        }

        if (e.getSource() == botones[1][2] && fallo) {
            devolver(anterior, botones[1][2]);
        }

        if (e.getSource() == botones[1][3] && fallo) {
            devolver(anterior, botones[1][3]);
        }

        if (e.getSource() == botones[1][4] && fallo) {
            devolver(anterior, botones[1][4]);
        }

        if (e.getSource() == botones[1][5] && fallo) {
            devolver(anterior, botones[1][5]);
        }

        //Tercera fila
        if (e.getSource() == botones[2][0] && fallo) {
            devolver(anterior, botones[2][0]);
        }

        if (e.getSource() == botones[2][1] && fallo) {
            devolver(anterior, botones[2][1]);
        }

        if (e.getSource() == botones[2][2] && fallo) {
            devolver(anterior, botones[2][2]);
        }

        if (e.getSource() == botones[2][3] && fallo) {
            devolver(anterior, botones[2][3]);
        }

        if (e.getSource() == botones[2][4] && fallo) {
            devolver(anterior, botones[2][4]);
        }

        if (e.getSource() == botones[2][5] && fallo) {
            devolver(anterior, botones[2][5]);
        }

        //Cuarta fila
        if (e.getSource() == botones[3][0] && fallo) {
            devolver(anterior, botones[3][0]);
        }

        if (e.getSource() == botones[3][1] && fallo) {
            devolver(anterior, botones[3][1]);
        }

        if (e.getSource() == botones[3][2] && fallo) {
            devolver(anterior, botones[3][2]);
        }

        if (e.getSource() == botones[3][3] && fallo) {
            devolver(anterior, botones[3][3]);
        }

        if (e.getSource() == botones[3][4] && fallo) {
            devolver(anterior, botones[3][4]);
        }

        if (e.getSource() == botones[3][5] && fallo) {
            devolver(anterior, botones[3][5]);
        }

        //Quinta fila
        if (e.getSource() == botones[4][0] && fallo) {
            devolver(anterior, botones[4][0]);
        }

        if (e.getSource() == botones[4][1] && fallo) {
            devolver(anterior, botones[4][1]);
        }

        if (e.getSource() == botones[4][2] && fallo) {
            devolver(anterior, botones[4][2]);
        }

        if (e.getSource() == botones[4][3] && fallo) {
            devolver(anterior, botones[4][3]);
        }

        if (e.getSource() == botones[4][4] && fallo) {
            devolver(anterior, botones[4][4]);
        }

        if (e.getSource() == botones[4][5] && fallo) {
            devolver(anterior, botones[4][5]);
        }

        //Sexta fila
        if (e.getSource() == botones[5][0] && fallo) {
            devolver(anterior, botones[5][0]);
        }

        if (e.getSource() == botones[5][1] && fallo) {
            devolver(anterior, botones[5][1]);
        }

        if (e.getSource() == botones[5][2] && fallo) {
            devolver(anterior, botones[5][2]);
        }

        if (e.getSource() == botones[5][3] && fallo) {
            devolver(anterior, botones[5][3]);
        }

        if (e.getSource() == botones[5][4] && fallo) {
            devolver(anterior, botones[5][4]);
        }

        if (e.getSource() == botones[5][5] && fallo) {
            devolver(anterior, botones[5][5]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jugar) {

            cambiarEstado();
        }

       /* if (e.getSource() == reintentar) {

        }*/

        if (e.getSource() == dificultad) {
            mandarTiempo();
        }

        //Primera fila
        if (e.getSource() == botones[0][0] && !botones[0][0].isUsado()) {
            botones[0][0].setIcon(botones[0][0].getFoto());
            botones[0][0].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[0][0]);
            } else {
                pulsado = true;
                anterior = botones[0][0];
            }
        }

        if (e.getSource() == botones[0][1] && !botones[0][1].isUsado()) {
            botones[0][1].setIcon(botones[0][1].getFoto());
            botones[0][1].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[0][1]);
            } else {
                pulsado = true;
                anterior = botones[0][1];
            }
        }

        if (e.getSource() == botones[0][2] && !botones[0][2].isUsado()) {
            botones[0][2].setIcon(botones[0][2].getFoto());
            botones[0][2].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[0][2]);
            } else {
                pulsado = true;
                anterior = botones[0][2];
            }
        }

        if (e.getSource() == botones[0][3] && !botones[0][3].isUsado()) {
            botones[0][3].setIcon(botones[0][3].getFoto());
            botones[0][3].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[0][3]);
            } else {
                pulsado = true;
                anterior = botones[0][3];
            }
        }

        if (e.getSource() == botones[0][4] && !botones[0][4].isUsado()) {
            botones[0][4].setIcon(botones[0][4].getFoto());
            botones[0][4].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[0][4]);
            } else {
                pulsado = true;
                anterior = botones[0][4];
            }
        }

        if (e.getSource() == botones[0][5] && !botones[0][5].isUsado()) {
            botones[0][5].setIcon(botones[0][5].getFoto());
            botones[0][5].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[0][5]);
            } else {
                pulsado = true;
                anterior = botones[0][5];
            }
        }

        //Segunda fila
        if (e.getSource() == botones[1][0] && !botones[1][0].isUsado()) {
            botones[1][0].setIcon(botones[1][0].getFoto());
            botones[1][0].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[1][0]);
            } else {
                pulsado = true;
                anterior = botones[1][0];
            }
        }

        if (e.getSource() == botones[1][1] && !botones[1][1].isUsado()) {
            botones[1][1].setIcon(botones[1][1].getFoto());
            botones[1][1].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[1][1]);
            } else {
                pulsado = true;
                anterior = botones[1][1];
            }
        }

        if (e.getSource() == botones[1][2] && !botones[1][2].isUsado()) {
            botones[1][2].setIcon(botones[1][2].getFoto());
            botones[1][2].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[1][2]);
            } else {
                pulsado = true;
                anterior = botones[1][2];
            }
        }

        if (e.getSource() == botones[1][3] && !botones[1][3].isUsado()) {
            botones[1][3].setIcon(botones[1][3].getFoto());
            botones[1][3].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[1][3]);
            } else {
                pulsado = true;
                anterior = botones[1][3];
            }
        }

        if (e.getSource() == botones[1][4] && !botones[1][4].isUsado()) {
            botones[1][4].setIcon(botones[1][4].getFoto());
            botones[1][4].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[1][4]);
            } else {
                pulsado = true;
                anterior = botones[1][4];
            }
        }

        if (e.getSource() == botones[1][5] && !botones[1][5].isUsado()) {
            botones[1][5].setIcon(botones[1][5].getFoto());
            botones[1][5].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[1][5]);
            } else {
                pulsado = true;
                anterior = botones[1][5];
            }
        }

        //Tercera fila
        if (e.getSource() == botones[2][0] && !botones[2][0].isUsado()) {
            botones[2][0].setIcon(botones[2][0].getFoto());
            botones[2][0].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[2][0]);
            } else {
                pulsado = true;
                anterior = botones[2][0];
            }
        }

        if (e.getSource() == botones[2][1] && !botones[2][1].isUsado()) {
            botones[2][1].setIcon(botones[2][1].getFoto());
            botones[2][1].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[2][1]);
            } else {
                pulsado = true;
                anterior = botones[2][1];
            }
        }

        if (e.getSource() == botones[2][2] && !botones[2][2].isUsado()) {
            botones[2][2].setIcon(botones[2][2].getFoto());
            botones[2][2].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[2][2]);
            } else {
                pulsado = true;
                anterior = botones[2][2];
            }
        }

        if (e.getSource() == botones[2][3] && !botones[2][3].isUsado()) {
            botones[2][3].setIcon(botones[2][3].getFoto());
            botones[2][3].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[2][3]);
            } else {
                pulsado = true;
                anterior = botones[2][3];
            }
        }

        if (e.getSource() == botones[2][4] && !botones[2][4].isUsado()) {
            botones[2][4].setIcon(botones[2][4].getFoto());
            botones[2][4].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[2][4]);
            } else {
                pulsado = true;
                anterior = botones[2][4];
            }
        }

        if (e.getSource() == botones[2][5] && !botones[2][5].isUsado()) {
            botones[2][5].setIcon(botones[2][5].getFoto());
            botones[2][5].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[2][5]);
            } else {
                pulsado = true;
                anterior = botones[2][5];
            }
        }

        //Cuarta fila
        if (e.getSource() == botones[3][0] && !botones[3][0].isUsado()) {
            botones[3][0].setIcon(botones[3][0].getFoto());
            botones[3][0].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[3][0]);
            } else {
                pulsado = true;
                anterior = botones[3][0];
            }
        }

        if (e.getSource() == botones[3][1] && !botones[3][1].isUsado()) {
            botones[3][1].setIcon(botones[3][1].getFoto());
            botones[3][1].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[3][1]);
            } else {
                pulsado = true;
                anterior = botones[3][1];
            }
        }

        if (e.getSource() == botones[3][2] && !botones[3][2].isUsado()) {
            botones[3][2].setIcon(botones[3][2].getFoto());
            botones[3][2].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[3][2]);
            } else {
                pulsado = true;
                anterior = botones[3][2];
            }
        }

        if (e.getSource() == botones[3][3] && !botones[3][3].isUsado()) {
            botones[3][3].setIcon(botones[3][3].getFoto());
            botones[3][3].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[3][3]);
            } else {
                pulsado = true;
                anterior = botones[3][3];
            }
        }

        if (e.getSource() == botones[3][4] && !botones[3][4].isUsado()) {
            botones[3][4].setIcon(botones[3][4].getFoto());
            botones[3][4].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[3][4]);
            } else {
                pulsado = true;
                anterior = botones[3][4];
            }
        }

        if (e.getSource() == botones[3][5] && !botones[3][5].isUsado()) {
            botones[3][5].setIcon(botones[3][5].getFoto());
            botones[3][5].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[3][5]);
            } else {
                pulsado = true;
                anterior = botones[3][5];
            }
        }

        //Quinta fila
        if (e.getSource() == botones[4][0] && !botones[4][0].isUsado()) {
            botones[4][0].setIcon(botones[4][0].getFoto());
            botones[4][0].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[4][0]);
            } else {
                pulsado = true;
                anterior = botones[4][0];
            }
        }

        if (e.getSource() == botones[4][1] && !botones[4][1].isUsado()) {
            botones[4][1].setIcon(botones[4][1].getFoto());
            botones[4][1].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[4][1]);
            } else {
                pulsado = true;
                anterior = botones[4][1];
            }
        }

        if (e.getSource() == botones[4][2] && !botones[4][2].isUsado()) {
            botones[4][2].setIcon(botones[4][2].getFoto());
            botones[4][2].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[4][2]);
            } else {
                pulsado = true;
                anterior = botones[4][2];
            }
        }

        if (e.getSource() == botones[4][3] && !botones[4][3].isUsado()) {
            botones[4][3].setIcon(botones[4][3].getFoto());
            botones[4][3].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[4][3]);
            } else {
                pulsado = true;
                anterior = botones[4][3];
            }
        }

        if (e.getSource() == botones[4][4] && !botones[4][4].isUsado()) {
            botones[4][4].setIcon(botones[4][4].getFoto());
            botones[4][4].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[4][4]);
            } else {
                pulsado = true;
                anterior = botones[4][4];
            }
        }

        if (e.getSource() == botones[4][5] && !botones[4][5].isUsado()) {
            botones[4][5].setIcon(botones[4][5].getFoto());
            botones[4][5].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[4][5]);
            } else {
                pulsado = true;
                anterior = botones[4][5];
            }
        }

        //Sexta fila
        if (e.getSource() == botones[5][0] && !botones[5][0].isUsado()) {
            botones[5][0].setIcon(botones[5][0].getFoto());
            botones[5][0].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[5][0]);
            } else {
                pulsado = true;
                anterior = botones[5][0];
            }
        }

        if (e.getSource() == botones[5][1] && !botones[5][1].isUsado()) {
            botones[5][1].setIcon(botones[5][1].getFoto());
            botones[5][1].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[5][1]);
            } else {
                pulsado = true;
                anterior = botones[5][1];
            }
        }

        if (e.getSource() == botones[5][2] && !botones[5][2].isUsado()) {
            botones[5][2].setIcon(botones[5][2].getFoto());
            botones[5][2].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[5][2]);
            } else {
                pulsado = true;
                anterior = botones[5][2];
            }
        }

        if (e.getSource() == botones[5][3] && !botones[5][3].isUsado()) {
            botones[5][3].setIcon(botones[5][3].getFoto());
            botones[5][3].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[5][3]);
            } else {
                pulsado = true;
                anterior = botones[5][3];
            }
        }

        if (e.getSource() == botones[5][4] && !botones[5][4].isUsado()) {
            botones[5][4].setIcon(botones[5][4].getFoto());
            botones[5][4].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[5][4]);
            } else {
                pulsado = true;
                anterior = botones[5][4];
            }
        }

        if (e.getSource() == botones[5][5] && !botones[5][5].isUsado()) {
            botones[5][5].setIcon(botones[5][5].getFoto());
            botones[5][5].setUsado(true);

            if (pulsado) {
                comparar(anterior, botones[5][5]);
            } else {
                pulsado = true;
                anterior = botones[5][5];
            }
        }

    }

}
