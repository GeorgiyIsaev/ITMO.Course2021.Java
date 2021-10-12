package Labs.Lab03;

import java.util.Scanner;

public class Lab03 {
    public static void main(String[] args)
    {
        // Задание 01: Проверить является ли массив осортированным!
        //trySortMassive(createMassive(3,1,2));

        //Задание 02: Метод для ручного заполнения массива
        //System.out.print("Задание 02: Создние массива через ручной ввод");
        //printMassive(createMassive());

        //Задание 03: Поменять местами крайние значения массива
       // reversEgeValueMassive();

        //Задание 03: Найти первое уникальное число в массиве
        findUniqueValue();
    }
    public static int[] createMassive()
    {
        //Метод для создания массива ручнным вводом
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер масиива: ");
        int size = scanner.nextInt();

        System.out.print("Введите значения масиива: ");
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }
    public static int[] createMassive(int size, int Begin, int End)
    {
        //Автоматическое созданеи массива
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ((int)(Math.random() * End)+Begin);
        }
        return myArray;
    }
    public static void printMassive(int[] myArray)
    {
        //Отображение массива
        System.out.print("Имеется массив:  ");
        for (int i = 0; i < myArray.length; i++) {

            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }
    public static void trySortMassive(int[] myArray)
    {
        System.out.print("Задание 01 - ");
        printMassive(myArray);

        //int[] myArray = createMassive(5);
        boolean ifSortMassive = true;
        for (int i = 0; i < myArray.length-1; i++) {
            if(myArray[i]<myArray[i+1]){
                ifSortMassive = false;
                break;
            }
        }
        if(!ifSortMassive)
        {
            System.out.println("Please, try again");
        }
        else {
            System.out.println("OK!");
        }
    }
    public static int[] sortMyMassive(int[] myArray)
    {
        //Отсортируем
        int temp;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if(myArray[i] < myArray[j]){
                    temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        return myArray;
    }


    public static void reversEgeValueMassive()
    {
        System.out.print("Зажание 03 - ");
        int[] myArray = createMassive(4,1,9);
        printMassive(myArray);

        int temp = myArray[0];
        myArray[0] =  myArray[myArray.length -1];
        myArray[myArray.length -1] = temp;

        System.out.print("Крайние значение массива поменялись местами:  ");
        printMassive(myArray);
    }
    public static void findUniqueValue()
    {
        System.out.print("Зажание 04 - ");
        int[] myArray = createMassive(8,1,5);
        printMassive(myArray);

        //Проверка ункиальности
        boolean ifNotUnique = false;
        int valueUnique = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if(i == j)
                {
                    continue;
                }
                if(myArray[i] == myArray[j]){
                    ifNotUnique = true;
                    break;
                }
            }
            if(!ifNotUnique){
                valueUnique = myArray[i];
                break;
            }
            ifNotUnique = false;
        }
        if (!ifNotUnique)
        {
            System.out.println("Первое уникальное число:  " + valueUnique);
        }
        else
        {
            System.out.println("Уникальныйх значений нет");
        }
    }
}
