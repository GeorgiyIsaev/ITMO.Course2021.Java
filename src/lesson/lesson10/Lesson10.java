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
        final String hello = "Hello ";
        Function<String, String> printHello = (str) -> {
            return hello + str;
        };
        System.out.println(printHello.apply("Макс"));

    }

    private static void printFunc(Function<String, Integer> function){
        //можно передать лямбда выражение
        System.out.println(function.apply("New Year 2022!"));
    }


}
