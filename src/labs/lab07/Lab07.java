package labs.lab07;

import labs.lab07.Ex01Car.Car;
import labs.lab07.Ex01Car.Truck;
import labs.lab07.Ex02BoxShape.Ball;
import labs.lab07.Ex02BoxShape.Box;
import labs.lab07.Ex02BoxShape.Cylinder;
import labs.lab07.Ex02BoxShape.Pyramid;

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

        Box box = new Box(200);
        System.out.println(box);
        box.add(new Pyramid(45,12,5));
        box.add(new Ball(12,9));
        box.add(new Cylinder(62,9,12));
        box.add(new Pyramid(45,12,5));
        box.add(new Ball(12,9));
        box.add(new Cylinder(62,9,12));
        System.out.println(box);

    }
}
