package memoramagame;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.Timer;

public class MemoramaGame extends JFrame implements ActionListener, MouseListener {

    private Accion anterior = new Accion();
    private Accion[][] botones = new Accion[6][6];

    private final JButton jugar;
    private final JLabel puntaje;
    private final JLabel numMovs;
    private final JLabel titulo;
    private final JLabel tiempo;
    private final ImageIcon iconoOculto;
    private final ImageIcon imagenL;
    private ImageIcon imagenT;
    private final JComboBox dificultad;
    private Timer timer;
    private int posicion, tiempoRestante;
    private int puntos = 0, movimientos = 0, restantes = 18;
    private int[] verificador = new int[18];
    private boolean pulsado = false;
    private boolean fallo = false;

    public MemoramaGame() {
        setLayout(null);

        setTitle("Memorama");

        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/oculto.png"))).getImage());

        Image oculto = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/oculto.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        iconoOculto = new ImageIcon(oculto);

        Image i1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/1.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono1 = new ImageIcon(i1);

        Image I2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/2.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono2 = new ImageIcon(I2);

        Image I3 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/3.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono3 = new ImageIcon(I3);

        Image I4 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/4.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono4 = new ImageIcon(I4);

        Image I5 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/5.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono5 = new ImageIcon(I5);

        Image I6 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/6.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono6 = new ImageIcon(I6);

        Image I7 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/7.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono7 = new ImageIcon(I7);

        Image I8 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/8.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono8 = new ImageIcon(I8);

        Image I9 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/9.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono9 = new ImageIcon(I9);

        Image I10 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/10.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono10 = new ImageIcon(I10);

        Image I11 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/11.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono11 = new ImageIcon(I11);

        Image I12 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/12.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono12 = new ImageIcon(I12);

        Image I13 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/13.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono13 = new ImageIcon(I13);

        Image I14 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/14.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono14 = new ImageIcon(I14);

        Image I15 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/15.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono15 = new ImageIcon(I15);

        Image I16 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/16.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono16 = new ImageIcon(I16);

        Image I17 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/17.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono17 = new ImageIcon(I17);

        Image I18 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/18.png"))).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon icono18 = new ImageIcon(I18);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                boolean correcto = false;
                while (!correcto) {
                    posicion = (int) Math.floor(Math.random() * (18 - 1 + 1) + 1);

                    if (verificador[posicion - 1] < 2) {
                        verificador[posicion - 1]++;
                        correcto = true;

                        botones[i][j] = new Accion(iconoOculto);
                        botones[i][j].setBackground(new Color(0, 0, 0));
                        botones[i][j].setSize(120, 120);
                        botones[i][j].addActionListener(this);
                        botones[i][j].addMouseListener(this);
                        botones[i][j].setID(posicion);
                        botones[i][j].setEnabled(false);

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

        /* Panel de componentes */
        JPanel panel = new JPanel();
        panel.setBounds(800, 250, 325, 535);
        panel.setBackground(new Color(0, 0, 0));
        panel.setLayout(null);
        add(panel);

        JLabel puntuacion = new JLabel("Puntuación:");
        puntuacion.setBounds(58, 430, 166, 43);
        Font auxFont = puntuacion.getFont();
        puntuacion.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        puntuacion.setForeground(Color.WHITE);
        panel.add(puntuacion);

        JLabel movs = new JLabel("Movimientos:");
        movs.setBounds(45, 468, 191, 43);
        auxFont = movs.getFont();
        movs.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        movs.setForeground(Color.WHITE);
        panel.add(movs);

        jugar = new JButton("Comenzar");
        jugar.setBounds(66, 320, 180, 78);
        auxFont = jugar.getFont();
        jugar.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        jugar.setForeground(Color.WHITE);
        jugar.setBackground(new Color(102, 94, 128));
        jugar.addActionListener(this);
        panel.add(jugar);

        puntaje = new JLabel("0");
        puntaje.setBounds(175, 430, 35, 43);
        auxFont = puntaje.getFont();
        puntaje.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        puntaje.setForeground(Color.WHITE);
        panel.add(puntaje);

        numMovs = new JLabel("0");
        numMovs.setBounds(175, 449, 305, 80);
        auxFont = numMovs.getFont();
        numMovs.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        numMovs.setForeground(Color.WHITE);
        panel.add(numMovs);

        JLabel logo = new JLabel();
        imagenL = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/logo.png")));
        logo.setIcon(imagenL);
        logo.setBounds(907, 1, 180, 180);
        add(logo);

        titulo = new JLabel();
        imagenT = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/titulomemo.png")));
        titulo.setIcon(imagenT);
        titulo.setBounds(813, 143, 300, 100);
        add(titulo);

        JLabel reloj = new JLabel();
        ImageIcon imagenR = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/mask.png")));
        reloj.setIcon(imagenR);
        reloj.setBounds(64, 185, 83, 83);
        panel.add(reloj);

        JLabel seleccionarLabel = new JLabel("Selecciona la dificultad");
        seleccionarLabel.setBounds(50, 30, 500, 43);
        auxFont = seleccionarLabel.getFont();
        seleccionarLabel.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        seleccionarLabel.setForeground(Color.WHITE);
        panel.add(seleccionarLabel);

        dificultad = new JComboBox();
        dificultad.setBounds(65, 70, 185, 30);
        for (String s : Arrays.asList("", "Fácil: 120 seg.", "Normal: 90 seg.", "Dificil: 60 seg.", "Alma de acero: 30 seg.")) {
            dificultad.addItem(s);
        }
        dificultad.addActionListener(this);
        panel.add(dificultad);

        JLabel tiempoRestanteLabel = new JLabel("Tiempo restante:");
        tiempoRestanteLabel.setBounds(80, 130, 500, 43);
        auxFont = tiempoRestanteLabel.getFont();
        tiempoRestanteLabel.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
        tiempoRestanteLabel.setForeground(Color.WHITE);
        panel.add(tiempoRestanteLabel);

        tiempo = new JLabel("000");
        tiempo.setBounds(160, 180, 100, 100);
        auxFont = tiempo.getFont();
        tiempo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
        tiempo.setForeground(Color.WHITE);
        panel.add(tiempo);

    }

    /* Ventana del juego */
    public void ventana() {
        MemoramaGame ventana = new MemoramaGame();
        ventana.setSize(1160, 840);
        ventana.getContentPane().setBackground(new Color(26, 26, 26));
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        musica();
    }

    /* Manda el tiempo del combo al label que lo muestra */
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

    /* Temporizador */
    private void temporizador() {
        // Configurar el Timer para actualizar el JLabel cada segundo
        timer = new Timer(1000, e -> {
            tiempoRestante--;
            tiempo.setText(String.valueOf(tiempoRestante));
            if (tiempoRestante <= 0) {
                timer.stop();
                estado("/recursos/perder.png");
            }
        });
        timer.start();
    }

    /* Compara una casilla con la otra y manda los puntos y movimientos */
    public void comparar(Accion anterior, Accion actual) {
        if (anterior.getID() == actual.getID()) {
            puntos += 5;
            movimientos++;
            restantes--;

            puntaje.setText(Integer.toString(puntos));
            numMovs.setText(Integer.toString(movimientos));

            anterior.setEnabled(false);
            actual.setEnabled(false);

            if (restantes == 0) {
                estado("/recursos/ganar.png");
            }

        } else {
            movimientos++;
            numMovs.setText(Integer.toString(movimientos));
            fallo = true;
        }

        pulsado = false;
    }

    /* Cambia los estados del boton de comenzar de acuerdo al estado del juego actual ✅ */
    private void cambiarEstado(String text) {
        switch (text) {
            case "Comenzar" -> {
                jugar.setText("Rendirse");
                accionAlComenzar();
            }
            case "Rendirse" -> {
                jugar.setText("Reintentar");
                accionDespuesDeComenzar();
            }
            case "Reintentar" -> {
                jugar.setText("Comenzar");
                accionAlPerder();
            }
        }
    }

    /* Comienza el juego */
    private void accionAlComenzar() {
        temporizador();
        estadoCasillas();
    }

    /* Termina el juego */
    private void accionDespuesDeComenzar() {
        estado("/recursos/perder.png");
    }

    /* Reinicia el juego */
    private void accionAlPerder() {
        dispose();
        ventana();
    }

    /* Bloquea o desbloquea las casillas segun se requiera */
    private void estadoCasillas() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                botones[i][j].setEnabled(true);
            }
        }
    }

    /* Devuelve al estado orignal en caso de fallar */
    public void devolver(Accion anterior, Accion actual) {
        anterior.setUsado(false);
        actual.setUsado(false);
        anterior.setIcon(iconoOculto);
        actual.setIcon(iconoOculto);
        fallo = false;
    }

    /* Detiene y cambia los elementos dependiendo de si gaste o perdiste ✅*/
    public void estado(String urlImage) {
        imagenT = new ImageIcon(Objects.requireNonNull(getClass().getResource(urlImage)));
        titulo.setIcon(imagenT);
        timer.stop();
        jugar.setText("Reintentar");
    }

    /* Reproduce la musica de fondo */
    public void musica() {
        String ruta = "/recursos/Hollow Knight.wav";
        Clip clip;
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResource(ruta))));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /*Mensaje*/
    public void mensaje() {
        JLabel label = new JLabel("Selecciona una dificultad", JLabel.CENTER);
        label.setForeground(new Color(255, 255, 255));
        UIManager.put("OptionPane.background", new Color(26, 26, 26));
        UIManager.put("Button.background", new Color(102, 94, 128));
        UIManager.put("Panel.background", new Color(26, 26, 26));
        UIManager.put("Button.foreground", new Color(255, 255, 255));
        JOptionPane.showMessageDialog(null, label, "Memorama Mensaje", JOptionPane.PLAIN_MESSAGE);
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
            if (Objects.equals(dificultad.getSelectedItem(), "")) {
                mensaje();
            } else {
                cambiarEstado(jugar.getText());
            }
        }

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
