package lesson.lesson10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Lesson10 {
    public static void main(String[] args) {
        /**ЛЕКЦИЯ 10: ОБОБЩЕНИЯ. ЛЯМБДА */
        //Все классы наследуются от Object
        //Класс Object содержит:
        //синхронизация потоков: wait, notify, notifyAll;
        //идентификатор объекта: hashCode, equals;
        //управление объектами: finalize, clone, getClass;
        //удобно-читаемое представление: toString;

        //Обобщенные коллекции - позволяют собирать коллекции одного типа
        //Можно сделать обобщённей класс: class Gen<T>{}
        //Можно параметризовать метод: public <T> void process(List<T> list) {}

        /** ЛЯМБДА*/
        // Анонимный классы - объявление и создание одновременно (единоразово)

        //Лямбда-выражение: (parameters) -> { body };
        //BiFunction<T,U,F> -- принимает два значения, возвращает 1
        //Function<T,U> -- одно принимает, одно возвращает
        lambdaExpressions();

        //Ссылки на методы
        referencesTo();


        /** ИТЕРАТОР - Iterator & Iterable*/
        //позволяют проходить по списку (поиск, удаление)
        iteratorTest();

        /**КОМПАРАТОР */
        // используются для сравнения объектов
        comparatorTest();
        comparatorTopTest();

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
        Function<Integer, Integer> multi2 = (Integer x) -> x * 2;
        System.out.println(multi2.apply(3));
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

    public static void iteratorTest(){
        //Тест итераторов
        List<Integer> list = List.of(1, 2, 3, 4);
        ListIterator<Integer> iterator = list.listIterator();

        // последний элемент
        while (iterator.hasNext()) {
            iterator.next();
        }

        // печатает в обратном порядке
        while (iterator.hasPrevious()) {
            int previousIndex = iterator.previousIndex();
            int element = iterator.previous();
            System.out.println(element + " on " + previousIndex);
        }
    }

    private static void comparatorTest(){
        List<Message> messages = new ArrayList<>();

        messages.add(new Message("first"));
        messages.add(new Message("second"));
        messages.add(new Message("five"));
        messages.add(new Message("one"));
        messages.add(new Message("two"));
        messages.add(new Message("long number"));

        messages.sort(new MessageContentComparator()); //передадим компаратор для сортировки
        messages.forEach(System.out::println); // выедим на печать через лямбда выражение
    }
    private static void comparatorTopTest(){
        List<MassageTop> messages = new ArrayList<>();

        messages.add(new MassageTop("Anna", "Buuu",
                32, "2018-03-25"));
        messages.add(new MassageTop("Ivan", "Hi!",
                -6, "2019-01-05"));
        messages.add(new MassageTop("Anon", "Kill them all",
                1, "2020-02-17"));
        messages.add(new MassageTop("Unknown", "<Spam>",
                -18, "2021-01-14"));

        System.out.println("--> Не отсортирован");
        messages.forEach(System.out::println);
        messages.sort(new MessageDateComparator());
        System.out.println("--> Отсортирован по дате");
        messages.forEach(System.out::println);
        messages.sort(new MessageAuthorComparator());
        System.out.println("--> Отсортирован по автору");
        messages.forEach(System.out::println);


        Comparator<MassageTop> date = (m1,m2) ->
                m1.getCreated().compareTo(m2.getCreated());
        messages.sort(date); //сортировка принимает компаратор
        System.out.println("--> Отсортирован по дате2");
        messages.forEach(System.out::println);


        messages.sort(Comparator.comparing(MassageTop::getLikes)
                .reversed()
                .thenComparing(MassageTop::getFrom));
        System.out.println("--> Отсортирован по лайкам а затем по From");
        messages.forEach(System.out::println);

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
