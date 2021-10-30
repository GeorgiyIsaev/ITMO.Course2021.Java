package labs.lab08.ex01BoxShape;

public class Pyramid implements IShape{
    protected double s;
    protected double h;
    protected double volume;

    public Pyramid(double volume, double s, double h) {
        this.volume = volume;
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

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public double getVolume() {
        return volume;
    }
}
