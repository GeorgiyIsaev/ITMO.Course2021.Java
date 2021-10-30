package labs.lab08;

import labs.lab07.Ex02BoxShape.Ball;
import labs.lab07.Ex02BoxShape.Box;
import labs.lab07.Ex02BoxShape.Cylinder;
import labs.lab07.Ex02BoxShape.Pyramid;

public class Lab08 {
    public static void main(String[] args) {
        //ЗАДАНИЕ 01: Изменить иерархию shapes (использовать абстрактные и
        // интерфейсы классы, где это возможно)
        shapeInterface();
        //ЗАДАНИЕ 02: (Из книги "Карьера программиста" стр 122, задача 7.2)
        // Имеется центр обработки звонков с тремя уровнями сотрудников: оператор,
        //менеджер и директор. Входящий телефонный звонок адресуется свободному
        //Вопросы собеседования 123
        //оператору. Если оператор не может обработать звонок, он автоматически
        //перенаправляется менеджеру. Если менеджер занят, то звонок перенаправляется
        //директору. Разработайте классы и структуры данных для этой задачи.
        //Реализуйте метод dispatchCall( ), который перенаправляет звонок первому
        //свободному сотруднику.

        //ЗАДАНИЕ 03:(Из книги "Карьера программиста" стр 122, задача 7.4)
        // Разработайте модель автостоянки, используя принципы ООП.
   }
   public static void shapeInterface(){
       System.out.println("\nBOX");
       Box box = new Box(200);
       System.out.println(box);
       box.add(new Pyramid(45,12,5));
       box.add(new Ball(12,9));
       box.add(new Cylinder(172,29,42));
       box.add(new Pyramid(38,12,5));
       box.add(new Ball(24,9));
       box.add(new Cylinder(71,9,12));
       System.out.println(box);

   }


}
