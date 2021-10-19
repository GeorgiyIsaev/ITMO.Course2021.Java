package labs.lab02;

import java.util.Scanner;

public class Lab02
{
    public static void main(String[] args)
    {
        //Задание 01: Вывести нечетные числа от 1 до 99. Каждое число с новой строки
        counterOdd();

        //Задание 02: Отобразить числа, которые делаться на 3, на 5 и на 3 и 5.
        counter3And5();

        //Задание 03: Введите три числа. Если сумма первого и второго числа равно третьему вывести true
        sumTwoInt();

        //Задание 04: Сравнить три числа. True если второе больше первого, а третье меньше второго
        comparisonThreeNumbers();

        //Задание 05: Проверка значений массива
        checkMassiveEdge();
        checkMassiveEdge();
        checkMassiveEdge();
        checkMassiveEdge();
        checkMassiveEdge();
        System.out.println();

        //Задание 06: Проверка наличия в массиве 1 или 3;
        checkMassiveValue();
        checkMassiveValue();
        checkMassiveValue();
        checkMassiveValue();
        checkMassiveValue();
    }

    public static void counterOdd()
    {
        //Задание 01: Вывести нечетные числа от 1 до 99. Каждое число с новой строки
        System.out.println("Выводим нечетные числа на консоль!");
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
        //Задание 02: Отобразить числа, которые делаться на 3, на 5 и на 3 и 5.
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
        //Задание 03: Введите три числа. Если сумма первого и второго числа равно третьему вывести true
        System.out.println("Задание 03:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число а: ");
        int a = scanner.nextInt();
        System.out.print("Введите число b: ");
        int b = scanner.nextInt();
        System.out.print("Введите сумму чисел а и b: ");
        int c = scanner.nextInt();
        System.out.println("Ответ: " + ((a+b) == c));
    }
    public static void comparisonThreeNumbers()
    {
        //Задание 04: Сравнить три числа. True если второе больше первого, а третье меньше второго
        System.out.println("Задание 04 - Введите три числа:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число а: ");
        int a = scanner.nextInt();
        System.out.print("Введите число b: ");
        int b = scanner.nextInt();
        System.out.print("Введите число с: ");
        int c = scanner.nextInt();

        String str = c + ">" + b + ">" +a + ":";
        System.out.println("Результат сравнения " + str + (b>a && c>b));
    }

    public static void checkMassiveEdge()
    {
        //Задание 05: Проверка значений массива
        System.out.print("Задание 05 - Имеется массив:  ");
        int size = 5;
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ((int)(Math.random() * 2)+2);
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        System.out.println("\tПроверка соответствия равенства крайних чисел трем: " +
                ((myArray[0] == 3) && ((myArray[myArray.length-1]) == 3))
        );
    }

    public static void checkMassiveValue()
    {
        //Задание 06: Проверка наличия в массиве 1 или 3;
        System.out.print("Задание 06 - Имеется массив:  ");
        int size = 5;
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ((int)(Math.random() * 20)+1);
            System.out.print(myArray[i] + " ");
        }
        System.out.println();

        boolean ifIsNumbers = false;
        for (int j : myArray) {
            if (j == 1 || j == 3) {
                ifIsNumbers = true;
                break;
            }
        }
        System.out.println("\tПроверка наличия 1 или 3: " + ifIsNumbers);
    }
}
