package labs.lab10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lab10 {
    public static void main(String[] args) {
        //ЗАДАНИЕ 01: Метод, который получает коллекцию и возвращает
        // коллекцию без дубликатов. (use SET)
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
        //ЗАДАНИЕ 02: Методы, добавление 1млн эл-тов в ArrayList и LinkedList.
        //Методы, который выбирает из списка элемент наугад 100000 раз.
        //Замерьте время, которое потрачено на это.


    }
}
