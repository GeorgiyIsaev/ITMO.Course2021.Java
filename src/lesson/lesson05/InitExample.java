package lesson.lesson05;

public class InitExample {
    private  int field;
    private int[] array;
    {
        System.out.println("Before constructor");
        array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }
    }

    public void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    {
        field = 40;
    }

}
