public class Ponto {
    private double x;
    private double y;
    private boolean dentro;

    public Ponto(boolean dentro, double x, double y) {
        this.dentro = dentro;
        this.x = x;
        this.y = y;
    }

    public boolean isDentro() {
        return dentro;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
