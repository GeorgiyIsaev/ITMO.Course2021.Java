package labs.lab07.Ex02BoxShape;

public class Box extends Shape{

    private Shape[] shapes;

    public Box(double maxVolume) {
        super(maxVolume);
        shapes = new Shape[0];
    }

    private boolean isCanAdd(Shape shape){
        double newVolume = 0;
        for (int i = 0; i < shapes.length; i++) {
            newVolume += shapes[i].getVolume();
        }
        if(newVolume<this.getVolume()) return true;
        else return false;
    }

    public boolean add(Shape shape){
        if(isCanAdd( shape)){
            Shape[] newShapes = new Shape[shapes.length +1];
            for (int i = 0; i < shapes.length; i++) {
                newShapes[i] = shapes[i];
            }
            newShapes[shapes.length] = shape;
            return true;
        }
        else return false;
    }
}
