package labs.lab07.Ex02BoxShape;

public class Pyramid extends Shape{
    protected double s;
    protected double h;

    public Pyramid(double volume, double s, double h) {
        super(volume);
        this.s = s;
        this.h = h;
    }
}
