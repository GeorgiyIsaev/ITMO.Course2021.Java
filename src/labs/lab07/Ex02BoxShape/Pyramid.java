package labs.lab07.Ex02BoxShape;

public class Pyramid extends Shape{
    protected double s;
    protected double h;

    public Pyramid(double volume, double s, double h) {
        super(volume);
        this.s = s;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Пирамида{" +
                "s=" + s +
                ", h=" + h +
                ", объем=" + volume +
                '}';
    }
}
