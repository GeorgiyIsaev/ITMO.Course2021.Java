package Algorithms;

import java.util.Arrays;

public class SortInsertion {
    /**Сортировка вставками
     * Перебираются элементы в неотсортированной части массива.
     * Каждый элемент вставляется в отсортированную часть массива на то место, где он должен находиться.*/
    public static void main(String[] args) {
        int[] array = new int[]{21, 23, 19, 30, 11, 28, 23};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort(int[] array) {
        /* перебор элементов в несортированной части */
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            int elem = array[i]; // берем следующий элемент
            int j = i - 1;

            /* найти подходящую позицию для вставки и сдвига элементов вправо */
            while (j >= 0 && array[j] > elem) {
                array[j + 1] = array[j]; // смена
                j--;
                count++;
            }
            array[j + 1] = elem; // вставить элемент в найденную позицию в отсортированную часть
        }
        System.out.println("Массив отсортирована за: " + count + " итераций!");
        return array;
    }

}
