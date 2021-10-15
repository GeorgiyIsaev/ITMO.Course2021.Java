package Algorithms;

import java.util.Arrays;

public class SortBubble {
    /**Пузырьковая сортировка - многократно проходит через массив для сортировки,
     *  сравнивает каждую пару соседних элементов массива и меняет их местами,
     *  если они находятся в неправильном порядке.
     *  -- Поднимает на верх массива самый крупный эл-т*/
    public static void main(String[] args) {
        int[] array = new int[]{21, 23, 19, 30, 11, 28, 23};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));

    }
    public static int[] bubbleSort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                /* если пара соседних элементов имеет неправильный порядок, он меняет их местами */
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                count++;
            }
        }
        System.out.println("Массив отсортирована за: " + count + " итераций!");
        return array;
    }
}
