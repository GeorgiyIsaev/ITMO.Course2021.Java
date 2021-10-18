package lesson;

import java.util.Arrays;

public class Lesson03 {
    public static void main(String[] args) {
        //Лекция 03: Массивы и простые алгоритмы
        //Книга - Грокаем Алгоритмы!

        //Создание и инциализация массивов
        declarationArray();

        //Специальный цикл для массива
        forArray();

        //Алгоритмы
        lectureAlgorithm();

        //Метод удаления из массива
        removeElemMassive();

        //Задача на занятии (сумма всех положительных чисел)
        taskLesson();
    }

    public static void declarationArray() {
        //Объявление массва
        int[] array;
        int arrayNo[]; //Допустимно, но не рекомендуется

        int[] array1 = {1, 2, 3, 4};
        int a = 1, b = 2, c = 3, d = 4;
        int[] numbersArr = {a, b, c, d};

        int size = 10;
        int[] sizeArr = new int[size];
        System.out.print("Не заполненый массива: ");
        System.out.println(Arrays.toString(sizeArr)); //вывести значения массива

        float[] floatArr;
        floatArr = new float[]{1.0f, 2.0f};

        //Длина массива
        int lengthArr = floatArr.length;
        System.out.println("Колличесвто эл-тов: " + lengthArr);

        //Заполнение массива
        int[] arrays = new int[3];
        arrays[0] = 1;
        arrays[1] = 2;
        arrays[2] = arrays[0] + arrays[1];
        System.out.println(Arrays.toString(arrays));

        //Преобразование масиива в строку
        byte[] byteArray = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        String arrayAssString = Arrays.toString(byteArray);
        System.out.println("Строка: " + arrayAssString);

        //Сортировка
        long[] bigArray = {20000000L, 10000000000L, 9999900L, 300000l};
        System.out.println("До Сортирвки: " + Arrays.toString(bigArray));
        Arrays.sort(bigArray);
        System.out.println("Сортировка:   " + Arrays.toString(bigArray));

        //Сравнение массивов (по значениям)
        System.out.println("Сравнениме массивов: " + Arrays.equals(numbersArr, array1));

        //Заполнение массива
        int sizeArrP = 10;
        char[] charArray = new char[size];

        Arrays.fill(charArray, 0, size / 2, 'A');
        Arrays.fill(charArray, size / 2, size, 'B');
        System.out.println("Заполнение: " + Arrays.toString(charArray));

        //Заполнение через цикл
        int[] squares = new int[10];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = i * i;
        }
        System.out.println("Заполнение rd: " + Arrays.toString(squares));

    }

    public static void forArray() {
        //Проход по массиву
        //for (type var : array)
        //{ // to do }

        char[] symbols = {'a', 'b', 'c', 'a', 'e', 'b', 'g'};
        int counter = 0;
        for (char symbol : symbols) {
            if (symbol == 'a') {
                counter++;
            }
        }
        System.out.println("Колличество символов 'a': " + counter);
    }

    public static void lectureAlgorithm() {
        // Угловой случа - случай в методе который выходи за приделы его решения
        // (Например, предусматреть условие, когда передан пустой массив)
        // "О большое" - Способ оценки алгоритмов, считает максимальное число
        // итераций до полного выполнения алгоритма


        // ПОИСК:
        // Линение поиск - прямой проход по массивы до искомого эл-та
        // Алгоритмы поиска требуют отсортированый массив:
        //  - бинарный (от среднего эл-та) - потом к следующей середние
        //      * итеративная (через циклы)
        //      * рекурсивная (вызов функции саму себя)

        // СОРТИРОВКА:
        // Сортировка выбором (помещает меньший элемент в начало массива)
        // Пузырьковыя сортировка (многократное прохождени со сравнением значений)
        // Сортировка вставками (вставляет эл-т в отсортированную часть)
        // Сортирвка слияниме (Делить на под массивы и соедняет отсортированные массиывы)
        // Быстрая сортировка (Исползует метод свап для обмена местами)
    }

    public static int[] removeElement(int[] array, int val) {
        int offset = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                offset++;
            } else {
                array[i - offset] = array[i];
            }
        }

        int[] newArray = new int[array.length - offset];
        System.arraycopy(array, 0, newArray, 0, newArray.length);
        return newArray;
    }

    public static void removeElemMassive() {
        int[] test = {0, 71, 24, 23, 4, 5, 5};
        System.out.println(Arrays.toString(removeElement(test, 2)));
    }

    public static void taskLesson() {
       /*ЗАДАЧА: написать метод, который будет считать сумму положительных элементов
        из массива размерностью 10. Массив получен рандомно из целых чисел.*/

        int[] myArray = new int[10];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ((int) (Math.random() * 19) - 10);
        }

        int result = 0;
        for (int val : myArray) {
            if (val > 0) {
                result += val;
            }

        }
        System.out.println("Имеется массив: " + Arrays.toString(myArray));
        System.out.println("Сумма всех положительный чисел = " + result);
    }
}
