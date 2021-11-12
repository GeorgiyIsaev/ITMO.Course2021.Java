package lesson.lesson14;

import java.util.List;

public class Lesson14 {
    public static void main(String[] args) {
        /**ЛЕКЦИЯ 14: STREAM API */
        //Потоки работают с общими и ссылочными переменными

        //Пример подсчета количества цифр в коллекции (List или Stream)
        testListOrStream();

        //Операции потока делятся на:
        //1) Промежуточные - операция выполняемые перед терминальной
        //filter - фильтрует коллекция по условию в лямбда выражении
        //limit
        //skip - пропускает указанное кол-во жл-тов
        //distinct
        //sorted - сортирует коллекцию
        //peek - возвращает тот же поток, но позволяет вывести результат выполненных операции для отладки
        //map
        //2) Терминальные - возвращает конкретный ответ
        //count - подсчитывает количество
        //max / min - максимальное и минимальное значение
        //reduce - объединяет значения в единое значение
        //findFirst / findAny - первый или любой эл-т потока
        //anyMatch - первое число соответствующе условию
        //forEach - выполнит операцию для каждого эл-та
        //collect -
        //toArray

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
    public static void test(){

    }
}
