package com.ITMO.Course2021.Javap;

<<<<<<< HEAD
public class Main {

    public static void main(String[] args) {
	// write your code here
=======
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        Math.min(3,5);

        System.out.println("Hello ");
        System.out.println("Hello ");
        System.out.print("Hello ");
        System.out.print("Hello ");

        // Переменные
        int number9 = 9 ;
        number9 = 18;
        System.out.println("Переменная " + number9);

        // Переменные
        boolean ready = true;
        char symbol = 'e';
        String str = "string";


        //Сканер (ввод данных)
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Your name is: " + name);

        //Сканер (ввод нескольких слов)
        System.out.println("Enter name and surname: ");
        String name2 = scanner.nextLine();
        System.out.println("Your name is: " + name2);

        //Сканер (ввод числа)  (оперции)
        System.out.println("int a: ");
        int a = scanner.nextInt();
        System.out.println("int b: ");
        int b = scanner.nextInt();
        System.out.println("Result: " + a + "+"+ b +"=" + (a+b));
        System.out.println("Result: " + a + "-"+ b +"=" + (a-b));
        System.out.println("Result: " + a + "*"+ b +"=" + (a*b));

>>>>>>> 5bb4b6e (Initial commit)
    }
}
