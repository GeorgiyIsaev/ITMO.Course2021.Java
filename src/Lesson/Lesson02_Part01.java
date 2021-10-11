package Lesson;

public class Lesson02_Part01 {
    public static void main(String[] args) {
        //ТЕМА: Циклы, Массивы и Методы
        System.out.println("Lesson02");
        // Название методов в Java пишется с маленькой буквы в отличии от C#

        //Циклы
        roundFor();
        roundWhile();

        //Операторы ветвелнеия
        branchingIf();
        branchingSwitch();

        //Встроенные методы
        builtInMethods();



        //Пользовательские методы
        int valFood = countFoodRet(12, 8);
        System.out.println("Food = " + valFood + "g");

        countFood(3, 10);

    }
    public static void roundFor()
    {
        //Цикл Фор
        int n = 9;
        for (int i = 0; i <= n; i++) {
            System.out.print(i + " ");
        }

        //Цикл с предустановлеными значениями
        int start = 1;
        int end = 1;
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println(sum);

        //Циклы с вынесением условий
        int i = 10;
        for (; i > 0; ) {
            System.out.print(i + "\t");
            i--;
        }

        //Вложенные циклы
        for (int l = 0; l <= 19; l++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(l * j + " ");
            }
        }
    }
    public static void roundWhile()
    {
       //Цикл передвигающийся по символам
        char letter ='A';
        while(letter <= 'Z')
        {
            System.out.print(letter + " ");
            letter++;
        }
        System.out.println();

        //Цикл с предусловием
        int i=0;
        do
        {
            System.out.print(i + " ");
            i++;
        }while (i<5);
        System.out.println();
    }

    // Операторы ветвления
    public static void branchingIf()
    {
        //Остановка цикла с помощью брейк
        int i = 10;
        while (true)
        {
            if (i == 0)
            {
                break;
            }
            i--;
            System.out.println(i);
        }
        //Лесенка из цифр
        for (int l = 1; l < 10; l++)
        {
            for (int j = 1; j < 10; j++)
            {
                if (l == j)
                {
                    break;
                }
            }
            System.out.println();
        }

        //Выводим только четные числа
        for (int l = 1; l < 10; l++){
            if(l%2 != 0)
            {
                continue;
            }
            System.out.println(l);
        }
    }
    // Операторы ветвления
    public static void branchingSwitch()
    {
        int val = 2;
        //Обычный свитч
        switch (val)
        {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println("default");

        }

        //Модифицуированный свитч (брейк вшит по умолчанию)
        switch (val) {
            case 1 -> System.out.println(1);
            case 2 -> System.out.println(2);
            case 3 -> System.out.println(3);
            default -> System.out.println("default");
        }
    }

    public static void builtInMethods()
    {
        System.out.println(Math.round(79.3432)); //округляет число
        System.out.println(Character.isLetter(121)); //Являет ли символом? Возвращает false
        String name = "Hak";
        System.out.println(name.toLowerCase()); // все нижним регистром


        String str1 = new String("ola");
        String str2 = str1;
        System.out.println(str2);
        str1 = new String("gege");
        System.out.println(str2);
    }
    /*Пользовательские методы*/
    public static int countFoodRet(int weight, int age){
        return weight/2+age;
    }
    public static void countFood(int weight, int age){
        System.out.println("Give cate "+(weight/2+age)+"g of food");
    }



}
