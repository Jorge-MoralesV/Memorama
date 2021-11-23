package memoramagame;

import javax.swing.*;

public class Accion extends JButton {

    private ImageIcon foto;
    private int ID;
    private boolean usado = false;

    public Accion() {
        super();
    }

    public Accion(String nombre) {
        super(nombre);
    }

    public Accion(ImageIcon icono) {
        super(icono);
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

}
