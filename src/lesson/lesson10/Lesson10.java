package lesson.lesson10;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lesson10 {
    public static void main(String[] args) {
        //Лекция 10: Обобщение
        //Все классы наследуются от Object
        //Этот класс содержит:
        //синхронизация потоков: wait, notify, notifyAll;
        //идентификатор объекта: hashCode, equals;
        //управление объектами: finalize, clone, getClass;
        //удобно-читаемое представление: toString;

        //Обобщенные коллекции - позволяют собирать коллекции одного типа
        //Можно сделать обобщённей класс
        //class Gen<T>{}
        //Можно параметризовать метод
        // public <T> void process(List<T> list) {}

        //Лямбда
        //* Анонимный классы
        // объявление и создание одновременно (единоразово) */

        //Лямбда-выражение
        // (parameters) -> { body };
        //BiFunction -- принимает два значения, возвращает 1
        //Function -- одно принимает, одно возвращает
        lambdaExpressions();

        //Ссылки на методы
        referencesTo();


        //Итератор
        //Iterator & Iterable









    }
    public static void lambdaExpressions(){
        //Лямбда-выражение
        BiFunction<Integer, Integer, Integer> multi = (x, y) -> x * y;
        int result = multi.apply(2,6);
        System.out.println(result);

        // если у него только один аргумент "()" необязательны
        Function<Integer, Integer> adder1 = x -> x + 1;
        System.out.println(adder1.apply(3));
        // без вывода типа
        Function<Integer, Integer> mult2 = (Integer x) -> x * 2;
        System.out.println(mult2.apply(3));
        // с несколькими операторами
        Function<Integer, Integer> adder5 = (x) -> {
            x += 2;
            x += 3;
            return x;
        };
        System.out.println(adder5.apply(3));

        //можно передать лямбда выражение;
        Function<String, Integer> function = (s) ->  s.length();
        printFunc(function);
        printFunc((s) ->  s.length()); // можем передать напрямую

        printFunc((s) ->  {
            int count = 0;
            for(char c: s.toCharArray()){
                if(Character.isDigit(c)){
                    count++;
                }
            }
            return count;
        }); // можем передать напрямую


        //Можно передать переименую из вне
        final String hello = "Hello "; //(Захватываются только final)
        Function<String, String> printHello = (str) -> {
            return hello + str;
        };
        System.out.println(printHello.apply("Макс"));

    }

    private static void printFunc(Function<String, Integer> function){
        //можно передать лямбда выражение
        System.out.println(function.apply("New Year 2022!"));
    }


    public static void referencesTo(){
        //ссылки на метод
        printFunc(String::length);

        BiFunction<Integer,Integer,Integer> max = Integer::max; //копируем ссылку на метод
        System.out.println(max.apply(50,70));
        BiFunction<Integer,Integer,Integer> max1 = (x,y) ->Integer.max(x,y);
        System.out.println(max1.apply(50,70));


        Function<String,Person> personFunction = Person::new;
        Person anna = personFunction.apply("Anna");
        BiFunction<String,Integer,Person> personFunction2 = Person::new;
        Person anna2 = personFunction2.apply("Anna",22);
    }

}
class Person{
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name) {
        this.name = name;
    }
}
