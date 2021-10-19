package labs.lab03;

import java.util.Arrays;
import java.util.Scanner;

public class Lab03 {
    public static void main(String[] args) {
        // Задание 01: Проверить является ли массив отсортированным!
        trySortMassive(createMassive(3, 1, 2));
        trySortMassive(new int[] {1,2,3,4,5});
        trySortMassive(new int[] {7,2,3,4,5});
        trySortMassive(new int[] {1,2,2,4,5});

        //Задание 02: Метод для ручного заполнения массива
        System.out.println("Задание 02: Создание массива через ручной ввод");
        int[] array = createMassive();
        System.out.println("Ex 02 - (Введен массив: " + Arrays.toString(array) + ")");

        //Задание 03: Поменять местами крайние значения массива
        reversEgeValueMassive(createMassive(4, 1, 9));
        reversEgeValueMassive(new int[] {1,2,3,4,5});

        //Задание 04: Найти первое уникальное число в массиве
        findUniqueValue(createMassive(8, 1, 5));
        findUniqueValue(new int[] {7,2,3,4,3});
        //Задача 05: Число Фибоначчи
        fibonacciNumber(9);

        //Задача 06: Сортировка слиянием
        sortMerge();

        //Задача 07: Найдите первые самое встречающееся число.
        firstMeetsManyNumber();


    }

    public static int[] createMassive() {
        //Задание 02: Метод для создания массива ручным вводом
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        System.out.print("Введите значения массива: ");
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }

    public static int[] createMassive(int size, int Begin, int End) {
        //Метод для авто-генерации массива
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ((int) (Math.random() * End) + Begin);
        }
        return myArray;
    }
    public static void trySortMassive(int[] myArray) {
        //Задание 01: Проверка отсортирован ли массива
        System.out.print("Ex 01 - (Массив: " + Arrays.toString(myArray) + ")");
        boolean isSortMassive = true;
        for (int i = 0; i < myArray.length - 1; i++) {
            if (myArray[i] > myArray[i + 1]) {
                isSortMassive = false;
                break;
            }
        }
        System.out.print(" Этот массив отсортирован? ");
        if (!isSortMassive) {
            System.out.println("Please, try again");
        } else {
            System.out.println("OK!");
        }
    }

    public static void reversEgeValueMassive(int[] myArray) {
        // Задание 03: Реверс крайних значений
        System.out.println("Ex 03 - (Массив: " + Arrays.toString(myArray) + ")");

        int temp = myArray[0];
        myArray[0] = myArray[myArray.length - 1];
        myArray[myArray.length - 1] = temp;

        System.out.print("Крайние значение массива поменялись местами:  ");
        System.out.println("Новый Массив: " + Arrays.toString(myArray) + "");
    }

    public static void findUniqueValue(int[] myArray) {
        // Задача 04: Поиск уникальных значений
        System.out.println("Ex 04 - (Массив: " + Arrays.toString(myArray) + ")");

        //Проверка уникальности
        boolean ifNotUnique = false;
        int valueUnique = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if (i == j) {
                    continue;
                }
                if (myArray[i] == myArray[j]) {
                    ifNotUnique = true;
                    break;
                }
            }
            if (!ifNotUnique) {
                valueUnique = myArray[i];
                break;
            }
            ifNotUnique = false;
        }
        if (!ifNotUnique) {
            System.out.println("Первое уникальное число:  " + valueUnique);
        } else {
            System.out.println("Уникальный х значений нет");
        }
    }
    public static void fibonacciNumber(int value) {
        //Задача 05: Вычислить число фибоначчи (использовать только цикл)
        long resalt;
        long temp1 = 1, temp2= 1;
        String str = "1";
        for (int i = 0; i <=value; i++) {
            resalt = temp1 + temp2;
            str += ", " + resalt;

            temp1 = temp2;
            temp2 = resalt;
        }
        System.out.println("Ex 05 - Число Фибаначи в " + value + " последовательности равно: "+ str);
    }

    public static void sortMerge() {
        //Задача 06: Сортировка слиянием
        int[] array = createMassive(20,1,100);
        System.out.println("Ex 06 - (Массив: " + Arrays.toString(array) + ")");

        //В папке с алгоритмами!
        int[] newArray = Algorithms.SortMerge.sortArray(array);
        System.out.println("Массив после сортировки слиянием: " + Arrays.toString(newArray) + ")");
    }

    public static void firstMeetsManyNumber() {
        //Задача 07: Первое часто встречающееся число
        int[] array = createMassive(20,1,10);
        System.out.println("Ex 07 - (Массив: " + Arrays.toString(array) + ")");

        int findNumber =-1;
        int countTempFindNumber;
        int countFindNumber =0;

        for (int i = 0; i < array.length; i++) {
            countTempFindNumber = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i] ==  array[j]){
                    countTempFindNumber++;
                }
            }
            if(countFindNumber <countTempFindNumber){
                findNumber = array[i];
                countFindNumber = countTempFindNumber;
            }
        }
        System.out.println("\tПервое самое встречающееся число "+ findNumber +
                " встречает " + countFindNumber + " раз.");
    }
}