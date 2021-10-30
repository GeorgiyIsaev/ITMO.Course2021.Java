package labs.lab08.Ex01BoxShape;

public class Box implements IShape {

    private IShape[] shapes;

    public Box(double maxVolume) {
        super(maxVolume);
        shapes = new IShape[0];
    }

    private boolean isCanAdd(IShape shape){
        double newCurFilling = getCurrFilling() + shape.getVolume();
        if(newCurFilling < this.getVolume())
            return true;
        else return false;
    }
    private double getCurrFilling(){
        double currVolume = 0;
        for (int i = 0; i < shapes.length; i++)
            currVolume += shapes[i].getVolume();
        return currVolume;
    }

    public boolean add(IShape shape){
        if(isCanAdd( shape)){
            IShape[] newShapes = new Shape[shapes.length +1];
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
                "Заполнение " +getCurrFilling() + " из " + this.getVolume();
        for (int i = 0; i < shapes.length; i++) {
            str += "\n\t"+ i + ")";
            str += shapes[i];
        }
        return str;
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
