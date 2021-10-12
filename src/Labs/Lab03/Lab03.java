package Labs.Lab03;

public class Lab03 {
    public static void main(String[] args)
    {
        // Задание 01: Проверить является ли массив осортированным!
        trySortMassive(createMassive(3,1,2));

        //Задание 02:
    }

    public static int[] createMassive(int size, int Begin, int End)
    {
        int[] myArray = new int[size];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ((int)(Math.random() * End)+Begin);
        }
        return myArray;
    }

    public static void printMassive(int[] myArray)
    {
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
}
