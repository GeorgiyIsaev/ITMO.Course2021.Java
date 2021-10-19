package labs.lab01;
import java.util.Scanner;

public class Lab01 {
    public static void main(String[] args) {
        //Задание 01: Ввод и вывод текста
        InOut();

        //Задание 02: Арифметические операции
        ResExpression();

        //Задание 03: Вывод переменных
        NumberIntOut();

        //Задание 04: Перемножение трех чисел
        Multiplication();

        //Задание 05: Ввод и вывод чисел
        InOutInt();

        //Задание 06: Четное и не четное
        EvenAndOdd();


    }

    public static void InOut() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1: ");
        String str1 = scanner.next();
        System.out.println("Enter 2: ");
        String str2 = scanner.next();
        System.out.println("Enter 3: ");
        String str3 = scanner.next();
        System.out.println("Enter 4: ");
        String str4 = scanner.next();
        System.out.println("Итоговая строка: " + str1 + " " + str2 + " " + str3 + " " + str4);
    }

    public static void ResExpression() {
        int res1 = (46 + 10) * (10 / 3);
        int res2 = (29) * (4) * (-15);

        System.out.println("( 46 + 10 ) * ( 10 / 3 ) = " + res1);
        System.out.println("( 29 ) * ( 4 ) * (- 15 ) = " + res2);
    }

    public static void NumberIntOut() {
        int number = 10500;
        int result = (number / 10) / 10;

        System.out.println("(number / 10) / 10 = " + result);
    }

    public static void Multiplication() {
        double number1 = 3.6;
        double number2 = 4.1;
        double number3 = 5.9;
        double result = number1 * number2 * number3;

        System.out.println(number1 + " * " + number2 + " * " + number3 + " = " + result);
    }

    public static void InOutInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int val1 = scanner.nextInt();
        System.out.print("Enter number 2: ");
        int val2 = scanner.nextInt();
        System.out.print("Enter number 3: ");
        int val3 = scanner.nextInt();

        System.out.println("Введены следующие числа:");
        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);
    }

    public static void EvenAndOdd() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число для обработки: ");
        int b = scanner.nextInt();

        if (b % 2 == 0 && b > 100) {
            System.out.print("Выход за пределы диапазона");
        } else if (b % 2 == 0) {
            System.out.print("Четное:");
        } else if (b % 2 != 0) {
            System.out.print("Не четное:");
        }
    }
}

