package lesson.lesson09;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;

public class Lesson09 {
    public static void main(String[] args) {
        /**Лекция 09: */
        /** ИСКЛЮЧЕНИЯ (Обработка ошибок)*/
        //ArithmeticException - арифметические исключения (/на0)
        //NumberFormatExceptionDemo - исключение при преобразовании строки к другому тику

        //Все исключения наследуются от класса Throwable
        //от него наследуются Error (поломка вне кода) и Exception (исключения)
        //От Exception наследуется RuntimeException (непроверяемые исключение)

        // Проверяемы и не проверяемы исключения
        // Проверяемы - все Exception кроме RuntimeException
        // Исключение(проверяемые) генерирующиеся в методе указываются в сигнатуре метода
        //  public void method() throws Exception{ }
        // Для не проверяемых это не требуется
        // Не проверяемое исключение это то исключение это, то которое
        // не предусмотрел программист и его нашло само приложение
        //try{код} catch{//когда исключение} finally{после всех для закрытия}
        // throw Exception("Ошибка") // выбрасывает ошибку при запуске

        /** ДАТА и ВРЕМЯ */
        // Класс LocalDate - для хранения только даты
        localDateTest();
        // Класс LocalTime - для хранения только времени
        localTimeTest();
        // Класс LocalDateTime - хранит и время и дату
        localDateAndTimeTest();


        /** КОЛЛЕКЦИИ*/
        //Set, Map, List, Queue
        //Имеют одинаковые методы для удаления добавление и т.д.
        //различаются в логике
        //List - наиболее близок к массивам. Но может изменять размер
        //Неизменяемы списки (метод .of()) константный список
        //LinkedList - хранит ссылки на конец и начало
        // Коллекции принято хранить в абстрактной коллекции List
        //List<Integer> list = new LinkedList<Integer>();
        //set --> HashSet, TreeSet(отсортирован), LinkedHashSet
        //Map<k,v> - карта хранит ключ и значение


        /** МНОГОМЕРНЫЕ МАССИВЫ*/
        gigaArray();

    }

    public static void localDateTest(){
        LocalDate localDate = LocalDate.now();// Получить текущую дату
        LocalDate localDateOf = LocalDate.of(2017,11,25);
        LocalDate localDateParse = LocalDate.parse("2017-11-25");
        LocalDate dateOfYearDay = LocalDate.ofYearDay(2017,365); // указываем день в году

        //Получение отдельных значений
        int year = localDate.getYear(); // 2017
        int month = localDate.getMonthValue(); // 11
        int dayOfMonth = localDate.getDayOfMonth(); // 25
        int dayOfYear = localDate.getDayOfYear();  // 329

        int lenOfYear = localDate.lengthOfYear(); // 365
        int lenOfMonth = localDate.lengthOfMonth(); // 30

        //Арифметические действия
        LocalDate date = LocalDate.of(2017, 1, 1); // 2017-01-01 (1 January 2017)
        LocalDate tomorrow = date.plusDays(1);    // 2017-01-02 (2 January 2017)
        LocalDate yesterday = date.minusDays(1);  // 2016-12-31 (31 December 2016)
        LocalDate inTwoYears = date.plusYears(2); // 2019-01-01 (1 January 2019)
        LocalDate in2016 = date.withYear(2016);   // 2016-01-01 (1 January 2016)
    }
    public static void localTimeTest(){
        //Работа со временем
        LocalTime localTime = LocalTime.of(11, 45);        // 11:45
        LocalTime localTime1 = LocalTime.of(11, 45, 30);    // 11:45:30
        LocalTime localTime2 = LocalTime.parse("11:45:30"); // 11:45:30 (часы, минуты, секунды)

        //Методы преобразования
        LocalTime time1 = LocalTime.ofSecondOfDay(12345); // 03:25:45
        LocalTime nanoTime = LocalTime.ofNanoOfDay(1234567890); // 00:00:01.234567890
        LocalTime localTime3 = LocalTime.MIN; // 00:00
        LocalTime localTime4 = LocalTime.MAX; // 23:59:59.999999999
        LocalTime localTime5 = LocalTime.NOON; // 12:00
        LocalTime localTime6 = LocalTime.MIDNIGHT; // 00:00

        //Возврат переменных
        LocalTime time = LocalTime.of(11, 45, 30); // 11:45:30
        int hour = time.getHour();   // 11
        int min = time.getMinute(); // 45
        int second = time.getSecond(); // 30
        int nano =  time.getNano();   // 0, nanoseconds
        int secondDay = time.toSecondOfDay(); // 42330
    }
    public static void localDateAndTimeTest(){
        //Объединяют время и дату
        LocalDateTime dt1 = LocalDateTime.of(2017, 11, 25, 22, 30);  // 25 November 2017, 22:30
        LocalDateTime dt2 = LocalDateTime.parse("2017-11-25T22:30"); // 25 November 2017, 22:30

        LocalDate date = LocalDate.of(2017, 11, 25); // 2017-11-25
        LocalTime time = LocalTime.of(21, 30); // 21:30

        LocalDateTime dateTime = LocalDateTime.of(date, time); // 2017-11-25T21:30

        LocalDateTime dateTime1 = date.atTime(time); // 2017-11-25T21:30
        LocalDateTime dateTime2 = time.atDate(date); // 2017-11-25T21:30
    }
    public static void gigaArray(){
        //Многомерный массива
        int[][] twoArray = {
                {1,2,3,4,5},
                {3,4,5,6,7},
                {3,2,2,1,6}
        };
        int num =twoArray[0][2];
        System.out.println(num);

        int[][][] cub = new int[3][4][5];
        int current =1;
        //Заполнение вар 01
        for (int i = 0; i < cub.length; i++) {
            for (int j = 0; j < cub[i].length; j++) {
                for (int k = 0; k < cub[i][j].length ; k++) {
                    cub[i][j][k] = i + j +k;
                }
            }
        }
        //Заполнение вар 02
        for (int[][] ints : cub) {
            for (int[] vector : ints) {
                Arrays.fill(vector, current);
            }
            current++;
        }
    }

}
