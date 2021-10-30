package labs.lab08.ex01BoxShape;

public class Box implements IShape {

    private IShape[] shapes;
    private double maxVolume;

    public double getMaxVolume() {
        return maxVolume;
    }

    public Box(double maxVolume) {
        this.maxVolume = maxVolume;
        shapes = new IShape[0];
    }

    private boolean isCanAdd(IShape shape){
        double newCurFilling = getVolume() + shape.getVolume();
        if(newCurFilling < this.getMaxVolume())
            return true;
        else return false;
    }
    public double getVolume(){
        double currVolume = 0;
        for (int i = 0; i < shapes.length; i++)
            currVolume += shapes[i].getVolume();
        return currVolume;
    }

    public boolean add(IShape shape){
        if(isCanAdd( shape)){
            IShape[] newShapes = new IShape[shapes.length +1];
            for (int i = 0; i < shapes.length; i++) {
                newShapes[i] = shapes[i];
            }
            newShapes[shapes.length] = shape;
            shapes = newShapes;
            return true;
        }
        else {
            System.out.println("Не достаточно места для Фигуры " + shape);
            return false;
        }
    }

    @Override
    public String toString() {
        String str = "Коробка с фигурами " +
                "Заполнение " + getVolume() + " из " + this.getMaxVolume();
        for (int i = 0; i < shapes.length; i++) {
            str += "\n\t"+ (i+1) + ")";
            str += shapes[i];
        }
        return str;
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
