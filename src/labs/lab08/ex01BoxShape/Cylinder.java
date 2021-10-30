package labs.lab08.ex01BoxShape;

public class Cylinder extends SolidOfRevolution implements  IShape {
    protected double height;

    public Cylinder(double volume, double radius, double height) {
        super(volume, radius);
        this.height = height;
    }

    @Override
    public String toString() {
        return "Цилиндр{" +
                "height=" + height +
                ", radius=" + radius +
                ", объем=" + volume +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
