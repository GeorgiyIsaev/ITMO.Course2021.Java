package labs.lab06;

import java.io.OutputStream;

public class Plane {
    private Wing wing;
    private String name;

    public Plane(String name, double weightWing) {
        Wing wing = new Wing(weightWing);
        this.wing = wing;
        this.name = name;
    }
    public void print(){
        System.out.println("Информация о самолете " + name + ":");
        wing.printWing();
    }

    private class Wing{
        double weight;
        public Wing(double weight) {
            this.weight = weight;
        }
        void printWing(){
            System.out.println("● Вес крыла самолета: " + weight + " тонны");
        }

    }
}
