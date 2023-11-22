package be.intecbrussel.sellers;

public class Stock {

    private int iceRockets;
    private int cones;
    private int balls;
    private int magni;

    public Stock(){
        iceRockets = 3;
        cones= 0;
        balls= 1;
        magni = 1;
    }

    public int getIceRockets() {
            return iceRockets;
    }

    public void setIceRockets(int iceRockets) {
            this.iceRockets = iceRockets;
    }

    public int getCones() {
        return cones;
    }

    public void setCones(int cones) {
        this.cones = cones;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getMagni() {
            return magni;
    }

    public void setMagni(int magni) {
        this.magni = magni;
    }
}
