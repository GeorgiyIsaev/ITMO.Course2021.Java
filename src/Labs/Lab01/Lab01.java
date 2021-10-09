package Labs.Lab01;
import java.util.Scanner;

public class Lab01
{
    public void InOut()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1: ");
        String str1 = scanner.next();
        System.out.println("Enter 2: ");
        String str2 = scanner.next();
        System.out.println("Enter 3: ");
        String str3 = scanner.next();
        System.out.println("Enter 4: ");
        String str4 = scanner.next();
        System.out.println("Итоговая строка: " + str1 + " " + str2 + " " +str3 + " " +str4);
    }

    public void ResaltExpression()
    {
        int resalt1 = ( 46 + 10 ) * ( 10 / 3 );
        int resalt2 = ( 29 ) * ( 4 ) * (- 15 );

        System.out.println("( 46 + 10 ) * ( 10 / 3 )" + resalt1);
        System.out.println("( 29 ) * ( 4 ) * (- 15 )" + resalt2);
    }
}

