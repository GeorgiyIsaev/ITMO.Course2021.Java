package labs.lab10;

import labs.lab03.Lab03;
import java.util.*;

public class Lab10 {
    public static void main(String[] args) {
        //ЗАДАНИЕ 01: Метод, который получает коллекцию и возвращает
        // коллекцию без дубликатов. (use SET)
        removeDuplicates();

        //ЗАДАНИЕ 02: Методы, добавление 1млн эл-тов в ArrayList и LinkedList.
        //Методы, который выбирает из списка элемент наугад 100000 раз.
        //Замерьте время, которое потрачено на это.
        executionTimerAdded();

        //ЗАДАНИЕ 03: Создать Map<User, Integer>
        //Считать имя с консоли найти количество очков
        findMarkToName();

        //ЗАДАНИЕ 04: Метод получает на вход массив элементов
        //типа К. Вернуть нужно объект Map<K, Integer>,
        // где K — Значение из массива, а Integer
        //количество вхождений в массив:
        toMapFromArrayTest();


    }

    public static void removeDuplicates(){
        //ЗАДАНИЕ 01: Метод, который получает коллекцию и возвращает
        // коллекцию без дубликатов. (use SET)
        System.out.println("ЗАДАНИЕ 01: Убрать дубликаты из коллекции!");
        List<Integer> listInt = new ArrayList<Integer>();
        for (int i = 0; i < 10 ; i++) {
            listInt.add((int) (Math.random() * 10) + 1);
        }
        for(Object value : listInt){
            System.out.print(value + " ");
        }System.out.println("");
        Set<Integer> setInt = new HashSet<Integer>(listInt);
        List<Integer> listInt2 = new ArrayList<Integer>(setInt);
        for(Object value : listInt2){
            System.out.print(value + " ");
        }System.out.println("");
    }

    public static void executionTimerAdded(){
        System.out.println("ЗАДАНИЕ 02: Таймер выполнения!");
        System.out.print("01) Добавление в ArrayList: ");
        long start = System.currentTimeMillis();
        List<Integer> listInt = new ArrayList<Integer>();
        for (int i = 0; i < 1_000_000 ; i++) {
            listInt.add((int) (Math.random() * 10) + 1);
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Время выполнения: " + elapsed + "мс.");

        System.out.print("02) Добавление в LinkedList: ");
        start = System.currentTimeMillis();
        LinkedList<Integer> listLinkedInt = new LinkedList<Integer>();
        for (int i = 0; i < 1_000_000 ; i++) {
            listLinkedInt.add((int) (Math.random() * 10) + 1);
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Время выполнения: " + elapsed + "мс.");

        System.out.print("03) Поиск в ArrayList: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000 ; i++) {
            int val = listInt.get((int) (Math.random() * 10_000-1) + 1);
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Время выполнения: " + elapsed + "мс.");


        System.out.print("04) Поиск в LinkedList: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000 ; i++) {
            int val =listLinkedInt.get((int) (Math.random() * 10_000-1) + 1);
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Время выполнения: " + elapsed + "мс.");

    }

    public static void findMarkToName() {
        System.out.println("ЗАДАНИЕ 03: Поиск оценок по имени в Мап");
        String[] names = {"Витя", "Петя", "Катя", "Маша", "Ира", "Коля", "Юля", "Даня"};
        Map<User, Integer> markToUsers = new HashMap<User, Integer>();
        for (int i = 0; i < names.length; i++) {
            markToUsers.put(new User(names[i]),
                    ((int) (Math.random() * 10) + 1));
        }
        for (Map.Entry<User, Integer> item : markToUsers.entrySet()) {
            System.out.println(item.getKey().getName() + " - " + item.getValue());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя : ");
        String findName = scanner.next();

        if (markToUsers.containsKey(new User(findName))) {
            int markFind = markToUsers.get(new User(findName));
            System.out.print(findName + " получил оценку " + markFind);
        }
        else{
            System.out.print("Ученик " + findName + " не найден! " );
        }
    }
    public static void toMapFromArrayTest(){
        System.out.println("ЗАДАНИЕ 04: Преобразовать массив в Маp");
        //Генератор массивов
        int[] array = Lab03.createMassive(15,0,10);
        Integer[] arrInteger =new Integer[array.length];
        String[] arrStr =new String[array.length];
        for (int i = 0; i < array.length; i++) {
            arrInteger[i] = array[i];
            arrStr[i] = "Текст " +  array[i];
        }

        //Тест для Integer
        System.out.println("Integer[]");
        System.out.println(Arrays.toString(array));
        Map<Integer, Integer> mapInteger = arrayToMap(arrInteger);
        System.out.println("Результат");
        printMap(mapInteger);

        //Тест для String
        System.out.println("String[]");
        System.out.println(Arrays.toString(arrStr));
        Map<String, Integer> mapString = arrayToMap(arrStr);
        System.out.println("Результат");
        printMap(mapString);

    }
    public static<T1, T2> void printMap(Map<T1, T2> map){
        for (Map.Entry<T1, T2> item : map.entrySet()) {
            System.out.print("["+ item.getKey() + ":" + item.getValue() + "], ");
        } System.out.println("");
    }

    public static<T>  Map<T, Integer> arrayToMap(T[] array){
        Map<T, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int temp = map.get(array[i]) +1;
                map.put(array[i], temp);
            }
            else {
                map.put(array[i], 1);
            }
        }
        return map;
    }
}
