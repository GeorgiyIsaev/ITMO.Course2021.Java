package lesson.lesson07.ex02;

import java.util.Arrays;
import java.util.Date;

public class Lesson07 {

    public static void main(String[] args) {
        //Лекция 07: Наследование и полиморфизм
        //Наследование для класса c конструктором
        classPersonTest();

        //Наследование методов
        classManualTest();

        //Аннотация = это метаданные (например @Override)
        // @Deprecated - этот класс устарел и не должен использоваться
        Human human = new Human(); // класс зачеркнут, но пока можно использовать
        System.out.println(human.sayHello());
        //@SuppressWarnings(value = "unused") - компилятор игнорирует предпрядение о неиспользованном эл-те
        //@SuppressWarnings(value = "deprecated") - устаревший эле0мет
        //@NotNull - метод гн должен возвращать нал, а переменная не нулабельна
        //@Range(3-10) - возвращаемое значение должно быть в диапазоне

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
    private static void classManualTest(){
        Manual manual = new Manual();
        System.out.println(manual.sayHello());
        Dog dog = new Dog();
        System.out.println(dog.sayHello());
        Human human = new Human();
        System.out.println(human.sayHello());

        //статические методы не наследуются
        System.out.println(Manual.sayHelloStat());
        System.out.println(Dog.sayHelloStat());
    }
}

class Manual {
    public String sayHello(){
        return "hello in mammal";
    }
    public static String sayHelloStat(){
        return "hello in mammal";
    }
}
class  Dog extends Manual {
    public String sayHello() {
        return "waf";
    }

    public static String sayHelloStat() {
        return "waf";
    }
}
@Deprecated
class  Human extends Manual{
    @Override
    public String sayHello() {
        System.out.println("Человек");
        return super.sayHello();
        //   @Override - Анастация для
        //   удобства пользователя, необязательно
    }
}