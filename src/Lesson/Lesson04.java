package Lesson;

import java.util.Arrays;

public class Lesson04 {
    /** Лекция 04: Строки (String)
     * - ссылочный, не примитивный тип, массив char */
    public static void main(String[] args) {
        // Использование Строки (String)
        //stringWorker();

        // Методы для работы со строками
        //stringMethods();

        //Преобразование строк в массивы
        //stringArray();

        //Классы StringBuffer и StringBuilder
        //otherStrings();

        //ЗАДАЧА: Отсортировать массив строк через bubble sort
        taskString();
    }

    public static void stringWorker(){
        //Перенос по строкам \n
        String str = "This is \nmultiple \nstring";
        System.out.println(str);

        //Можно обратится к пустой строке
        String str1 = "";
        System.out.println(str1);
        System.out.println(str1.length()); // Ноль символов

        //Может иметь значение null
        String nullStr = null;
        System.out.println(nullStr); //выведет null
        try {
            System.out.println(nullStr.length()); // Выбрасывает ошибку NullPointerException
        }
        catch (Exception ex){
            System.out.println("ERROR: " + ex);
        }

        // Можно обратится к символу по индексу
        // Нельзя выходить за пределы!
        String s = "ab";
        char c = s.charAt(0);
        System.out.println("Символ: " + c);

        char last = s.charAt(s.length()-1);
        System.out.println("Последний Символ: " + last);
        //Мы можем получить символ, но не изменить его!
    }

    public static void stringMethods(){
        //Проверка наличия значений
        String text = "simple text string";
        boolean empty = text.isEmpty(); // Проверка - является ли пустым?
        System.out.println("Пустой?: " + empty);
        String nullStr = null;
        //boolean empty1 = nullStr.isEmpty(); //Выбрасывает ошибку!!!
        //System.out.println("Пустой?: " + empty1);

        //Изменение регистра
        String textIn = text.toUpperCase();
        System.out.println("toUpperCase: " + textIn);

        //Проверяет что строка начинается с указанных символов!
        boolean startWith = text.startsWith("simp");
        System.out.println(startWith); //true

        //Содержит ли строка эту строку?
        boolean startWith1 = text.contains("text");
        System.out.println(startWith1); //true

        //Замена символа
        String repl = text.replace("text", "word");
        System.out.println(repl);
        String repl1 = text.replace("", " "); //добавит пробелы после каждой буквы
        System.out.println(repl1);

        //trim() - Убирает tab, каретку и пробелы С начала и конца (используется в JSON)
        String trimmed  = "\t text ! \n   \t    ";
        System.out.println(trimmed);
        System.out.println(trimmed.trim());

        //Соединение строк
        String name = "Anna";
        String surName = "Ivanova";
        String fullName1 = name + " " + surName;
        String fullName2 = name.concat(" ").concat(surName);
        System.out.println(fullName1);
        System.out.println(fullName2);

        String concatStr = "Str " + 10 + false;
        System.out.println(concatStr);

        //Приоритет операции (по порядку)
        int val = 8;
        String resultConcat =name + val + 4;
        System.out.println(resultConcat);
        String resultConcat1 = val + 4 +name;
        System.out.println(resultConcat1);

        //Сравнение
        String first = "first";
        String second = "second";
        String strFirst = "FIRST";
        String strSecond = "SECOND";
        System.out.println(first.equals(second)); //false
        System.out.println(first.equals(strFirst)); //false

        //Сравнение при игнорировании регистра
        System.out.println(second.equalsIgnoreCase(strSecond)); //true
    }
    public static void stringArray(){
        String text = "simple text string";

        //Отобразить массив символов как строку
        char[] symbols = {'A','B','C','D'};
        System.out.println(symbols); //сразу вывести как строку
        String str = String.valueOf(symbols); //Преобразовать в строку
        System.out.println(str);

        //Прообразовать строку в массив
        char[] charsFromString = str.toCharArray();
        System.out.println(charsFromString);

        // Разделить на массив строку по символу
        String[] parts  = text.split(" ");
        System.out.println(Arrays.toString(parts));

        //Отобразить каждый символ отдельно
        for (int i = 0; i < text.length() ; i++) {
            System.out.print(text.charAt(i) + " ");
        }

        //Шаблонные строки
        int year = 1998;
        System.out.printf("Me name is %s. I was born in %d - %d", "Mike", 1990, year);

        String strT = String.format("Me name is %s. I was born in %d - %d", "Mike", 1990, year);
        System.out.println(strT);
    }

    public static void otherStrings(){
        //Классы StringBuffer и StringBuilder
        StringBuilder empty = new StringBuilder("java!");
        System.out.println(empty.length());
        System.out.println(empty.charAt(4));
        //System.out.println(empty.setCharAt(0, 'j')); // нельзя отобразить при изменении
        empty.setCharAt(0, 'j'); //изменяем
        System.out.println(empty); // так можно!

        //Добавление к StringBuilder
        empty.append("100" + (8 + 4));
        System.out.println(empty);
        empty.append(" ");
        empty.append(100 + (8 + 4)); //арифметические операции
        System.out.println(empty);
        empty.append(" 9").append(" 8").append(" 9");
        System.out.println(empty);

        //Добавление через вставку
        StringBuilder stringBuilder = new StringBuilder("java!");
        stringBuilder.insert(4, " programmer");
        System.out.println(stringBuilder);

        //Замена части строки
        stringBuilder.replace(0,4,"CSharp");
        System.out.println(stringBuilder);
        stringBuilder.delete(0,7); // удаление
        System.out.println(stringBuilder);
        stringBuilder.reverse();// обратный порядок
        System.out.println(stringBuilder);

        //Вместимость capacity() динамически изменяется, не равна length()
        System.out.println("capacity " + stringBuilder.capacity());
        System.out.println("length " + stringBuilder.length());

        //Сравнение строк
        System.out.println("compareTo " + stringBuilder.compareTo(empty));
    }

    public static void taskString(){
        //Отсортировать массив строк через bubble sort
        String[] text =
                {"I", "still", "learning", "java", "language"};
        //System.out.println(Arrays.toString(text));

        //Отсортирован в алфавитном порядке
        for (int i = 0; i < text.length; i++) {
            for (int j = i + 1; j < text.length; j++) {
                if (text[j].compareTo(text[i]) < 0) {
                    String temp = text[i];
                    text[i] = text[j];
                    text[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(text));
    }
}
