package labs.lab07.Ex02BoxShape;

public class Cylinder extends SolidOfRevolution{
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
}
