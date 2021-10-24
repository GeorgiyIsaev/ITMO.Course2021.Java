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



    }

    public static void removeDuplicates(){
        //ЗАДАНИЕ 01: Метод, который получает коллекцию и возвращает
        // коллекцию без дубликатов. (use SET)
        System.out.print("ЗАДАНИЕ 01: Убрать дубликаты из коллекции!");
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
        }
    }

    public static void executionTimer(){
        System.out.print("ЗАДАНИЕ 02: Таймер выполнения!");

        List<Integer> listInt = new ArrayList<Integer>();
        for (int i = 0; i < 1_000_000 ; i++) {
            listInt.add((int) (Math.random() * 10) + 1);
        }

        LinkedList<Integer> listLinkedInt = new LinkedList<Integer>();
        for (int i = 0; i < 1_000_000 ; i++) {
            listInt.add((int) (Math.random() * 10) + 1);
        }

    }
}
