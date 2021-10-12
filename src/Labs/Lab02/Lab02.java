package Labs.Lab02;

public class Lab02
{
    public static void main(String[] args)
    {
        //Задание 01: Вывести нечные числа от 1 до 99. Каждое число с новой строки
        counterOdd();

        //Заданние 02: Отобразить числа которые деляться на 3, на 5 и на 3 и 5.
        counter3And5();
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
}
