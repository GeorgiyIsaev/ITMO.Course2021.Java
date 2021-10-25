package lesson.lesson07.ex02;

import java.util.Arrays;
import java.util.Date;

public class Lesson07 {
    public static void main(String[] args) {
        //Лекция 07: Наследование и полиморфизм
        //Наследование для класса c конструктором

    }

    private static void classPersonTest() {
        Programmer p = new Programmer(
                "Ivan",1985,"Spb",
                new Date(),500_000L,
                new String[]{"Java", "kotlin","cs"}
        );
        System.out.println(Arrays.toString(p.getLang()));
        System.out.println(p.getStart());
        System.out.println(p.getName());
    }

}
