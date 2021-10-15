package Algorithms;

import java.util.Arrays;

public class SortSelection {
    /** Сортировка выбором - это простой алгоритм сортировки, он проходит
     *  по всему массиву, ищет наименьший элемент и помещает его в начало
     *  массива. Для подтверждения он выполняет итерацию по всем другим
     *  элементом для проверки. O(n²)*/
    public static void main(String[] args) {

        int[] array = {21, 23, 19, 30, 11, 28, 23};
        System.out.println("До   : " + Arrays.toString(array));
        System.out.println("После: " + Arrays.toString(selectionSort(array)));

    }

    public static int[] selectionSort(int[] array) {
        int count= 0;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i; // индекс найденного минимального элемента
            /* Итерации по несортированному подмассиву в поисках минимального*/
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
                count++;
            }
            /* Обмен найденного минимума и текущего элемента */
            int min = array[index];
            array[index] = array[i];
            array[i] = min;
        }
        System.out.println("Массив отсортирована за: " + count + " итераций!");
        return array;
    }

}
