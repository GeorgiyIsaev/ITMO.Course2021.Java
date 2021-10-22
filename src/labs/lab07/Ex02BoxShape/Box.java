package labs.lab07.Ex02BoxShape;

public class Box {
    private double maxVolume;
    private Shape[] shapes;

    public Box(double maxVolume) {
        this.maxVolume = maxVolume;
        shapes = new Shape[0];
    }
    private boolean isCanAdd(Shape shape){
        double newVolume = 0;
        for (int i = 0; i < shapes.length; i++) {
            newVolume += shapes[i].getVolume();
        }
        if(newVolume<maxVolume) return true;
        else return false;
    }

    public void add(Shape shape){


    }
}
