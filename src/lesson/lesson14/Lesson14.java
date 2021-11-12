package lesson.lesson14;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


        //То же самое, но с помощью коллекции
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
        Optional<Integer> count = transactions.stream().
                reduce((sum, transaction) -> sum + transaction);
        System.out.println(count);

        Optional<Integer> count2 = transactions.stream().
                reduce((sum, transaction) -> sum + transaction);
        System.out.println(count2);

    }
}
