package Labs.Lab03;

import java.util.Scanner;

public class Lab03 {
    private static int n;

    public static void main(String[] args) {
        // Задание 01: Проверить является ли массив отсортированным!
       // trySortMassive(createMassive(3, 1, 2));

        //Задание 02: Метод для ручного заполнения массива
        //System.out.print("Задание 02: Создание массива через ручной ввод");
        //printMassive(createMassive());

        //Задание 03: Поменять местами крайние значения массива
       // reversEgeValueMassive();

        //Задание 04: Найти первое уникальное число в массиве
       // findUniqueValue();

        //Задача 05: Число Фибаначчи
        //fibonacciNumber(9);

        //Задача 06: Сортировка слиянием
        //sortMerge();

        //Задача 07: Найдите первые самое встречающееся число.
        firstMeetsManyNumber();


    }

    public static int[] createMassive() {
        //Метод для создания массива ручным вводом
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        System.out.print("Введите значения масиива: ");
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }

    public static int[] createMassive(int size, int Begin, int End) {
        //Метод для авто-герации массива
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ((int) (Math.random() * End) + Begin);
        }
        return myArray;
    }

    public static void printMassive(int[] myArray) {
        //Отображение массива
        System.out.print("Имеется массив:  ");
        for (int j : myArray) {

            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void trySortMassive(int[] myArray) {
        //Задание 01: Проверка отсортированности массива
        System.out.print("Задание 01 - ");
        printMassive(myArray);

        //int[] myArray = createMassive(5);
        boolean ifSortMassive = true;
        for (int i = 0; i < myArray.length - 1; i++) {
            if (myArray[i] < myArray[i + 1]) {
                ifSortMassive = false;
                break;
            }
        }
        if (!ifSortMassive) {
            System.out.println("Please, try again");
        } else {
            System.out.println("OK!");
        }
    }

    public static int[] sortMyMassive(int[] myArray) {
        // Сортировка массива
        int temp;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if (myArray[i] < myArray[j]) {
                    temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        return myArray;
    }


    public static void reversEgeValueMassive() {
        // Задание 03: Реверс крайних значений
        System.out.print("Зажание 03 - ");
        int[] myArray = createMassive(4, 1, 9);
        printMassive(myArray);

        int temp = myArray[0];
        myArray[0] = myArray[myArray.length - 1];
        myArray[myArray.length - 1] = temp;

        System.out.print("Крайние значение массива поменялись местами:  ");
        printMassive(myArray);
    }

    public static void findUniqueValue() {
        // Задача 04: Поиск уникальных значений
        System.out.print("Зажание 04 - ");
        int[] myArray = createMassive(8, 1, 5);
        printMassive(myArray);

        //Проверка ункиальности
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
            System.out.println("Уникальныйх значений нет");
        }
    }
    public static void fibonacciNumber(int value) {
        //Задача 05:  Вычислить число фибаначи (использовать только цикл)
        long resalt;
        long temp1 = 1, temp2= 1;
        String str = "1";
        for (int i = 1; i <=value; i++) {
            resalt = temp1 + temp2;
            str += ", " + resalt;

            temp1 = temp2;
            temp2 = resalt;
        }
        System.out.println("Число Фибаначи в " + value + " последовательности равно: "+ str);
    }

    public static void sortMerge() {
        //Задача 06: Сортировка слиянием
        int[] array = createMassive(20,1,100);
        printMassive(array);


    }

    public static void firstMeetsManyNumber() {
        //Задача 07: Первое часто встречающееся число
        int[] array = createMassive(20,1,10);
        printMassive(array);

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
                System.out.println("    Первое самое встречающееся число "+ findNumber +
                        " встречает " + countFindNumber + " раз.");
            }
        }
        System.out.println("Первое самое встречающееся число "+ findNumber +
                " встречает " + countFindNumber + " раз.");
    }
}