package Algorithms;

import java.util.Arrays;

public class FindBinary {
    /**Бинарный поиск - это быстрый алгоритм для поиска позиции элемента
     *  в отсортированном массиве. Для массива размера n время работы
     *  алгоритма в худшем случае составляет O(logn)
     */
    public static void main(String[] args) {
        int val;
        //Линяний поиск
        val = lineFind(new int[]{1, 4, 7, 2, 3, 5}, 1);
        System.out.println("Индекс значения: " + val);

        //Линей поиск в отсортированном массиве
        val = searchInSortedArray(new int[]{1, 2, 3, 5, 6, 7}, 3);
        System.out.println("Индекс значения: " + val);


        //Бинарный поиск в отсортированном массиве (Итеративный)
        binaryUse();

        //Бинарный поиск в отсортированном массиве (Рекурсивный)
        binaryUseRec();

    }

    public static int lineFind(int[] array, int findValue) {
        //Линейный поиск
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findValue) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static int searchInSortedArray(int[] array, int value) {
        //Линей поиск в отсортированном массиве
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                index = i;
                break;
            } else if (array[i] > value) {
                break;
            }
        }
        return index;
    }

    public static int binarySearch(int[] array, int elem, int left, int right) {
        //Бинарный поиск в отсортированном массиве (Итеративный)
        while (left <= right) {
            int mid = left + (right - left) / 2; // индекс среднего элемента

            if (elem == array[mid]) {
                return mid; // элемент найден, возвращаем его индекс
            } else if (elem < array[mid]) {
                right = mid - 1; // если нет, идем искать в левом под массиве
            } else {
                left = mid + 1;  // если нет, идем искать в правом под массиве
            }
        }
        return -1; // элемент не найден
    }

    public static void binaryUse(){
        int[] array = { 10, 13, 19, 20, 24, 26, 30, 34, 35 };
        System.out.println("Массив: " + Arrays.toString(array));
        int from = 0, to = array.length - 1;

        int indexOf10 = binarySearch(array, 10, from, to); // 0
        int indexOf19 = binarySearch(array, 19, from, to); // 2
        System.out.println("Индекс значения: " + indexOf10);
        System.out.println("Индекс значения: " + indexOf19);

        from = 0; to = 2;
        int indexOf11 = binarySearch(array, 10, from, to); // 0
        int indexOf20 = binarySearch(array, 19, from, to); // 2
        System.out.println("Индекс значения: " + indexOf11);
        System.out.println("Индекс значения: " + indexOf20);
    }


    public static int binarySearchRec(int[] array, int elem, int left, int right) {
        if (left > right) {
            return -1; // search interval is empty, the element is not found
        }

        int mid = left + (right - left) / 2; // the index of the middle element

        if (elem == array[mid]) {
            return mid; // the element is found, return its index
        } else if (elem < array[mid]) {
            return binarySearch(array, elem, left, mid - 1); // go to the left subarray
        } else {
            return binarySearch(array, elem, mid + 1, right); // go the right subarray
        }
    }

    public static void binaryUseRec(){
        int[] array = { 10, 13, 19, 20, 24, 26, 30, 34, 35 };
        System.out.println("Массив: " + Arrays.toString(array));
        int from = 0, to = array.length - 1;

        int indexOf10 = binarySearchRec(array, 10, from, to); // 0
        int indexOf19 = binarySearchRec(array, 19, from, to); // 2
        System.out.println("Индекс значения: " + indexOf10);
        System.out.println("Индекс значения: " + indexOf19);

        from = 0; to = 2;
        int indexOf11 = binarySearchRec(array, 10, from, to); // 0
        int indexOf20 = binarySearchRec(array, 19, from, to); // 2
        System.out.println("Индекс значения: " + indexOf11);
        System.out.println("Индекс значения: " + indexOf20);
    }


}

