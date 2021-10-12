package Labs.Lab02;

import java.util.Scanner;

public class Lab02
{
    public static void main(String[] args)
    {
        //Задание 01: Вывести нечные числа от 1 до 99. Каждое число с новой строки
        counterOdd();

        //Заданние 02: Отобразить числа которые деляться на 3, на 5 и на 3 и 5.
        counter3And5();

        //Задние 03: Введите три числа. Если сумма перевого и второго числа равно третьему вывести true
        sumTwoInt();

        //Задание 04: Сравнить три числа. True если второе больше первого, а третье меньше второго
        comparisonThreeNumbers();


    }

    public static void counterOdd()
    {
        System.out.println("Ввыводим нечные числа на консоль!");
        for (int i = 1; i < 100; i++){
            if(i%2 != 0)
            {
                System.out.println(i);
            }
        }
        System.out.println();



    }

    public static void counter3And5()
    {
        System.out.println("Задание 02:");
        String divide3 = "";
        String divide5 = "";
        String divide3and5 = "";
        for (int i = 1; i < 100; i++){
            if(i%3 == 0 && i%5 == 0 )
            {
                divide3and5 += i + " ";
            }
            else if(i%3 == 0)
            {
                divide3 += i + " ";
            }
            else if(i%5 == 0 )
            {
                divide5 += i + " ";
            }
        }
        System.out.println("Делится на 3:         " + divide3);
        System.out.println("Делится на 5:         " + divide5);
        System.out.println("Делится на 3 и на 5:  " + divide3and5);
        System.out.println();
    }
    public static void sumTwoInt()
    {
        System.out.println("Задание 03:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число а: ");
        int a = scanner.nextInt();
        System.out.print("Введите число b: ");
        int b = scanner.nextInt();
        System.out.print("Введите сумму чисел а и b: ");
        int c = scanner.nextInt();
        System.out.print("Ответ: " + ((a+b) == c));
    }
    public static void comparisonThreeNumbers()
    {
        System.out.println("Задание 04 - Введите три числа:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число а: ");
        int a = scanner.nextInt();
        System.out.print("Введите число b: ");
        int b = scanner.nextInt();
        System.out.print("Введите число с:");
        int c = scanner.nextInt();

        System.out.print("Резултат срвнения c>b>a: " + (b>a && c>b));


    }




}
