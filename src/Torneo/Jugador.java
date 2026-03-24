package Torneo;

public class Jugador {
    private int rank;//0
    private String nombre;//2
    private String info;//7
    private boolean alojado;
    private boolean cv;
    private int posicion;
    private int eloFide;
    private double puntos;

    public int getRank() {

        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isAlojado() {
        return alojado;
    }

    public void setAlojado(boolean alojado) {
        this.alojado = alojado;
    }

    public boolean isCv() {
        return cv;
    }

    public void setCv(boolean cv) {
        this.cv = cv;
    }
    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public int getEloFide() {
        return eloFide;
    }
    public void setEloFide(int eloFide) {
        this.eloFide = eloFide;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    Jugador(int rank, String nombre, String info,int eloFide) {
        this.rank = rank;
        this.nombre = nombre;
        this.info=info;
        if (info.endsWith("CV")){
            this.cv = true;
        }else{
            this.cv = false;
        }
        if (info.contains("H")){
            this.alojado = true;
        }else{
            this.alojado = false;
        }
        this.eloFide = eloFide;
    }
}
