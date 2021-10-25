package lesson.lesson07.ex02;

import java.util.Arrays;

public class Lesson07 {
    public static void main(String[] args) {
        //Лекция 07: Наследование и полиморфизм
        //Наследование для класса c конструктором

    }

    private static void classPersonTest() {
        Programmer p = new Programmer();
        p.setName("Ivan");
        p.setYear(1985);
        p.setAddress("Spb");
        p.setSalary(500_000L);
        p.setLang(new String[]{"Java", "kotlin","cs"});
        System.out.println(Arrays.toString(p.getLang()));
        System.out.println(p.getStart());
        System.out.println(p.getName());
    }

}
