package labs.lab07.Ex01Car;

public class Truck extends Car{
    int countWheels;
    int maxWeight;

    public void newWheels(int countWheels){
        this.countWheels = countWheels;
    }

    public Truck(int w, String m, char c, float s,
                 int countWheels, int maxWeight) {
        super(w, m, c, s);
        this.countWheels = countWheels;
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "Грузовик: Модель " + model +
                ", Цвет " + color +
                ", Колес " + countWheels + " шт" +
                ", Вес " + weight + "\\" + maxWeight +
                ", Скорость " + speed;
    }
}

