package Algorithms;

import java.util.Arrays;

public class SortQuick {
    private static int count;

    /**Быстрая сортировка
     *  - За основу берется крайний элемент (он становится опорным)
     *  - Все значения меньше его помещаются слева, больше справа.
     *  - Теперь опорный эл-т получает верный индекс
     *  - Дальше работаем уже с отдельными частями с права и слева от него
     *  - В отдельно части массива выберем опорный эл-т и делаем то же самое (рекурсия)
     *  - Пока в массиве не останется один эл-т
     * */
    public static void main(String[] args) {

        int[] array1 = { 17, 25, 11, 16, 10, 13, 22, 14 };
        System.out.println(Arrays.toString(array1));
        count =0;
        quickSort(array1, 0, array1.length - 1); // { 10, 11, 13, 14, 16, 17, 22, 25 }
        System.out.println("Массив отсортирована за: " + count + " итераций!");
        System.out.println(Arrays.toString(array1));

        int[] array2 = { 19, 18, 17, 17, 16, 15 };
        System.out.println(Arrays.toString(array2));
        count =0;
        quickSort(array2, 0, array2.length - 1); // { 15, 16, 17, 17, 18, 19 }
        System.out.println("Массив отсортирована за: " + count + " итераций!");
        System.out.println(Arrays.toString(array2));
    }
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            count++;
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);  // сортировка в левом подмассиве
            quickSort(array, pivotIndex + 1, right); // сортировка в правом подмассиве
        }
    }
    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];  // выберите крайний правый элемент в качестве опорного элемента
        int partitionIndex = left; // первый элемент больше, чем точка поворота
        /* переместить большие значения в правую часть массива */
        for (int i = left; i < right; i++) {
            if (array[i] <= pivot) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
            count++;
        }
        swap(array, partitionIndex, right); // установить точку поворота в подходящее значение
        return partitionIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
