package labs.lab07.Ex02BoxShape;

public class SolidOfRevolution extends Shape {
    protected double radius;

    public double getRadius() {
        return radius;
    }

    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }
}
