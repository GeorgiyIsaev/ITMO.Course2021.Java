package labs.lab10;

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

    public static void findMarkToName(){
        System.out.println("ЗАДАНИЕ 03: Поиск оценок по имени в Мап");
        String[] names = {"Витя", "Петя", "Катя", "Маша", "Ира", "Коля", "Юля", "Даня"};
        Map<User, Integer> markToUsers = new HashMap<User, Integer>();
        for (int i = 0; i <names.length ; i++) {
            markToUsers.put(new User(names[i]),
                    ((int)  (Math.random() * 10) + 1));
        }
        for(Map.Entry<User, Integer>  item : markToUsers.entrySet()) {
            System.out.println(item.getKey().getName() + " - " + item.getValue());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя : ");
        String findName = scanner.next();
        int markFind = markToUsers.get(new User("findName"));
        System.out.print("Оценка " + findName + ": " + markFind);
    }


}
