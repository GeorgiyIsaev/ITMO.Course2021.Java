package lesson.lesson14;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Lesson14 {
    public static void main(String[] args) {
        /**ЛЕКЦИЯ 14: STREAM API */
        //Потоки работают с общими и ссылочными переменными

        //Пример подсчета количества цифр в коллекции (List или Stream)
        testListOrStream();

        //Операции потока делятся на:
        //1) Промежуточные - операция выполняемые перед терминальной
            //filter - фильтрует коллекция по условию в лямбда-выражении
            //limit
            //skip - пропускает указанное кол-во жл-тов
            //distinct - оставить только уникальные значения
            //sorted - сортирует коллекцию
            //peek - возвращает тот же поток, но позволяет вывести результат выполненных операции для отладки
            //map - возвращает поток после выполнения вложенной в него операции
        //2) Терминальные - возвращает конкретный ответ
            //count - подсчитывает количество
            //max / min - максимальное и минимальное значение
            //reduce - объединяет значения в единое значение
            //findFirst / findAny - первый или любой эл-т потока
            //anyMatch - первое число соответствующе условию
            //forEach - выполнит операцию для каждого эл-та
            //collect -
            //toArray
        testStream();
        testStreamFilter();

        //Метод Reduction() - позволяет провести несколько
        // терминальных операций в одно операции
        testReduction();

        //takeWhile и dropWhile - копируем эл-ты из потока пока не сработает условие
        //Срабатывание по условия и обрезает лист
        testTakeWhile();

        //Map - промежуточные операции для потока
        testMap();

        //Параллельные потоки будут быстрее если значений много
        //Но тратят больше памяти - разбивает метод на части выполняют разные ядра
        testParallel();
    }
    public static void testListOrStream(){
        //Подсчет количества чисел в коллекции
        List<Integer> numbers = List.of(1,3,4,5,6,6,7,8);
        long count = 0;
        for (int num : numbers) {
            if(num>5){
                count++;
            }
        }
        System.out.println("Количество чисел больше 5: " + count);

        //То же самое, но с помощью потоков
        long countStream = numbers.stream().filter(num -> num>5).count();
        System.out.println("Количество чисел больше 5: " + countStream);

        //Подсчет количества, но первые 4 цифры пропускаем
        //Рекомендуется каждую операцию потока начинать с новой строки
        long countStream2 = numbers.stream()
                .skip(4)
                .filter(num -> num>5)
                .count();
        System.out.println("Количество чисел больше 5: " + countStream2);
    }
    public static void testStream(){
        List<String> companies = List.of("Google","Amazon","Samsung","amazon","GOOGLE");
        companies.stream()                      //превращаем в поток
                .map(String::toUpperCase)       //все большими буквами
                .distinct()                     //убрать повторения
                .forEach(System.out::println);  //вывести на консоль

        //Простые типы перед превращением в поток преобразует через IntStream
        //Найдем максимальное значение
        int[] nums = {10,11,12,113,14,15,16};
        int max = IntStream.of(nums)
                .max()
                .getAsInt();
        System.out.println("Максимальный эл-т: " + max);

        //Найти среднее значение
        double avg = IntStream.of(nums)
                .average() //найти среднее значение
                .orElse(0.0); //если невозможно посчитать среднее
        System.out.println("Среднее значение: " + avg);

        //Поиск числа в диапазоне
        IntSummaryStatistics statistics = IntStream.rangeClosed(1,5555)
                .summaryStatistics();
        System.out.println(statistics.getCount() + " " +
                statistics.getMin() + " " +
                statistics.getMax() + " " +
                statistics.getAverage());

        //Перевод из инт в double
        IntStream.of(1,2,3,4)
                .asDoubleStream()
                .forEach(System.out::println);

        //Переведем обобщенный в просто и простой в ссылочный
        List<Integer> numbers = List.of(1,5,9);
        int sum1 = numbers.stream().mapToInt(i-> i).sum();
        System.out.println(sum1);
    }
    public static void testStreamFilter(){
        //Создать новую коллекцию по условию фильтра
        List<Integer> num = Arrays.asList(2,3,4,5,6,7,10,11,12,15,16);
        List<Integer> filter = num.stream()
                .filter(n-> n>=9 && n<=15)
                .collect(Collectors.toList());
        System.out.println("Коллекция после условия: " + filter);

        //Передадим условие в виде предиката
        Predicate<Integer> pr = n-> n>=9 && n<=15;
        List<Integer> filter2 = num.stream()
                .filter(pr)
                .collect(Collectors.toList());
        System.out.println("Коллекция после условия: " + filter2);

        List<String> companies = List.of("Google","","Amazon","Samsung","amazon","GOOGLE");
        long count = companies.stream()
                .filter(n -> n.length() > 0) //избегаем пустые строчки
                .filter(n -> Character.isUpperCase(n.charAt(0))) //Ищем слова с большими символами
                .count();
        System.out.println("Количество слов с условием: " + count);
    }

    public static void testReduction(){
        //Позволяет получить результат от нескольких
        //терминальных потоков одновременно
        List<Integer> transactions = List.of(20, 40, -60, 5);
        Optional<Integer> count1 = transactions.stream().
                reduce((sum, transaction) -> sum + transaction);
        System.out.println(count1);

        Optional<Integer> count2 = transactions.stream().
                reduce((sum, transaction) -> sum + transaction);
        System.out.println(count2);
    }
    public static void  testTakeWhile(){
        //takeWhile и dropWhile - копируем эл-ты из потока пока не сработает условие
        //Срабатывание по условия и обрезает лист

        List<Integer> numbers1 = Stream.of(3,5,1,2,6,0,4)
                .takeWhile(n -> n >0) //копирует все эл-ты до 0
                .collect(Collectors.toList());
        System.out.println(numbers1);

        List<Integer> numbers2 = Stream.of(3,5,1,2,6,0,4)
                .takeWhile(n -> n >0) //копирует все до эл-та меньше 0
                .dropWhile(n->n>1) //удаляет все эл-ты до меньше единицей
                .collect(Collectors.toList());
        System.out.println(numbers2);

        Set<String> conf = Set.of("Joker", "JavaZone", "Kotlin");
        conf.stream()
                .sorted() //необходимо отсортировать
                .takeWhile(w->w.startsWith("J")) //поиск только с перовой J
                .forEach(System.out::println);
    }
    public static void testMap(){
        List<Double> num2 = List.of(2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0);
        List<Double> num3 = num2.stream()
                .map(n->n/2)
                .collect(Collectors.toList());
        System.out.println(num3);

        List<Planet> planets = IntStream.of(1,2,3,4,5,6,7,8,9)
                .mapToObj(Planet::new)
                .collect(Collectors.toList());
        System.out.println(planets);
    }

    public static void testParallel(){
        //Параллельные потоки будут быстрее если значений много
        //Но тратят больше памяти - разбивает метод на части выполняют разные ядра
        Set<String> conf = Set.of("Joker", "JavaZone", "Kotlin");
        List conf2 = conf.parallelStream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("JA"))
                .collect(Collectors.toList());
        System.out.println(conf2); //[JAVAZONE]

        long sum3 = LongStream
                .rangeClosed(1,1000)
                .parallel()
                .sum();
        System.out.println(sum3);
    }
}

class Planet{
    private String name;
    private  int order;

    public Planet(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}