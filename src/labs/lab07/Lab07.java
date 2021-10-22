package labs.lab07;

import labs.lab07.Ex01Car.Car;
import labs.lab07.Ex01Car.Truck;

public class Lab07 {
    public static void main(String[] args) {
        //Здание 01: Класс грузовик, наследуется от класса Car
        Car car = new Car(3, "Жигули",'a', 90);
        car.outPut();
        Truck truck = new Truck(22,"Камаз", 'b', 70,
                6, 34);
        truck.outPut();
        System.out.println(truck);
        truck.newWheels(8);
        System.out.println(truck);

        //Задание 02: Реализовать иерархию классов в соответствии со схемой

    }
}
