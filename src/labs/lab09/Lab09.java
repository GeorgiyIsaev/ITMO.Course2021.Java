package labs.lab09;

import labs.lab03.Lab03;

import java.util.Arrays;

public class Lab09 {
    public static void main(String[] args) {
        //Лабораторная 09Ж: Обработка исключений
        //Все методы должны иметь проверку параметров и генерировать исключения при
        //необходимости.

        //ЗАДАНИЕ 01. Написать метод для поиска наибольшего элемента в двумерном массиве.
        findMaxElementTest();

        //ЗАДАНИЕ 02. Написать метод, который проверяет, является ли двумерный массив квадратным.
        isTwoArraySquareTest();

        //ЗАДАНИЕ 03. Написать метод, который, в двумерном массиве (матрице) ищет строку, сумма
        //элементов которой является максимальной среди всех строк матрицы.
        findMaxSumLineTest();

        //ЗАДАНИЕ 04. Двумерный массив MxN заполнить случайными символами алфавита
        generateTwoArrayCharTest();

        //ЗАДАНИЕ 05. * Дан массив чисел numbers, и дан массив weight такой же длины.
        // Задача: написать метод, который бы случайно выбирал число из первого массива,
        // которое есть во втором массиве.
        findRandomArrayInArrayTest();
    }

    public static int[][] generateTwoArray(int line,int column, int min, int max) throws Exception {
        //Метод для генерации двумерного массива
        if(line<=1) throw new Exception("Сбой при генерации массива, параметр line не должен быть меньше 2");
        if(column<=0) throw new Exception("Сбой при генерации массива, параметр column не должен быть меньше 1");

        int[][] arrayTwo = new int[line][column];
        for (int i = 0; i <arrayTwo.length ; i++) {
            for (int j = 0; j < arrayTwo[i].length; j++) {
                arrayTwo[i][j] =((int) (Math.random() * max) + min);
            }
        }
        return arrayTwo;
    }
    public static int[][] generateTwoArray(int line,int column) throws Exception {
        //Перегрузка с предустановленными значениями
        return generateTwoArray(line, column, 0,10);
    }

    public static void findMaxElement(int[][] arrayTwo) throws Exception{
        //ЗАДАНИЕ 01. Написать метод для поиска наибольшего элемента в двумерном массиве.
        System.out.println(Arrays.deepToString(arrayTwo)); // для отображения двумерного массива метод deepToString()
        int maxValue = arrayTwo[0][0];
        for (int i = 0; i <arrayTwo.length ; i++) {
            for (int j = 0; j < arrayTwo[i].length; j++) {
                if(maxValue<arrayTwo[i][j]){
                    maxValue = arrayTwo[i][j];
                }
            }
        }
        if(maxValue<0) throw new Exception("Сбой при поиске максимального значения, в массиве отсутствую числа больше 0");
        System.out.println("Наибольшее число" + maxValue); //
    }

    public static void findMaxElementTest(){
        System.out.println("ЗАДАНИЕ 01: Поиск наибольшего элемента");
        try {
            findMaxElement(generateTwoArray(1,5));
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }

        try {
            findMaxElement(generateTwoArray(2,5,-1,-20));
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }
    }


    public static void isTwoArraySquareTest() {
        System.out.println("ЗАДАНИЕ 02: Проверка на квадратность массива");
        try {
            if(isTwoArraySquare(generateTwoArray(2,0)))
                System.out.println("Массив квадратичный!");
            else
                System.out.println("Массив НЕ квадратичный!");
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }

        try {
            if(isTwoArraySquare(generateTwoArray(4,4)))
                System.out.println("Массив квадратичный!");
            else
                System.out.println("Массив НЕ квадратичный!");
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }
        try {
            if(isTwoArraySquare(generateTwoArray(12,12)))
                System.out.println("Массив квадратичный!");
            else
                System.out.println("Массив НЕ квадратичный!");
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }

    }

    public static boolean isTwoArraySquare(int[][] arrayTwo) throws Exception {
        if(arrayTwo[0].length >=10 ||  arrayTwo.length>=10)
            throw new Exception("Сбой при проверки на квадратность, размерность массива слишком большая!");
        System.out.println("Проверяемый массив! " + Arrays.deepToString(arrayTwo));
        return arrayTwo[0].length == arrayTwo.length;
    }


    public static void findMaxSumLine(int[][] arrayTwo) throws Exception{
        //ЗАДАНИЕ 03. Поиск строки с максимальной суммой эл-тов
        System.out.println(Arrays.deepToString(arrayTwo)); // для отображения двумерного массива метод deepToString()

        int sumLintMax = -999999999;
        int indexFind = 0;
        for (int i = 0; i <arrayTwo.length ; i++) {
            int sumLine = 0;
            for (int j = 0; j < arrayTwo[i].length; j++) {
                sumLine+=arrayTwo[i][j];
            }
            if(sumLintMax<sumLine){
                sumLintMax = sumLine;
                indexFind = i;
            }
        }
        if(sumLintMax<0) throw new Exception("Сбой при поиске строки с максимальной суммой, сумма в каждой строке меньше 0");
        System.out.println("Найдено строка с наибольшей суммой " + Arrays.toString(arrayTwo[indexFind])); //
        System.out.println("Сумма в строке равна " + sumLintMax); //
    }

    public static void findMaxSumLineTest(){
        System.out.println("ЗАДАНИЕ 03: Поиск строки с максимальной суммой");
        try {
            findMaxSumLine(generateTwoArray(5,5));
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }
        try {
            findMaxSumLine(generateTwoArray(5,5,3,-10));
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }
    }
    public static char[][] generateTwoArrayChar(int line,int column) throws Exception {
        //Метод для генерации двумерного массива
        if(line<=1) throw new Exception("Сбой при генерации массива, параметр line не должен быть меньше 2");
        if(column<=0) throw new Exception("Сбой при генерации массива, параметр column не должен быть меньше 1");

        char[][] arrayTwo = new char[line][column];
        for (int i = 0; i <arrayTwo.length ; i++) {
            for (int j = 0; j < arrayTwo[i].length; j++) {
                arrayTwo[i][j] = (char) ((Math.random() * 33) + 94);//94+33
            }
        }
        return arrayTwo;
    }
    public static void generateTwoArrayCharTest(){
        System.out.println("ЗАДАНИЕ 04: Генерированный массив символов");
        try {
            char[][] arrayTwo = generateTwoArrayChar(0,6);
            System.out.println(Arrays.deepToString(arrayTwo)); // для отображения двумерного массива метод deepToString()
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }
        try {
            char[][] arrayTwo = generateTwoArrayChar(3,6);
            System.out.println(Arrays.deepToString(arrayTwo)); // для отображения двумерного массива метод deepToString()
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }
    }

    public static void findRandomArrayInArrayTest(){
        System.out.println("ЗАДАНИЕ 05: Рандомный выбор числа существующие в двух массивах ");
        try {
            int[] numbers = Lab03.createMassive(12,0,3);
            int[] weight = Lab03.createMassive(12,0,3);


            int value = findRandomArrayInArray(numbers,weight);
            System.out.println("Случайное числа " + value) ;
        }
        catch (Exception ex){
            System.out.println("ERROR! " + ex);
        }
    }

    public static int[] addValueArray(int[] array, int value){
        int[] newArray = new int[array.length+1];
        for (int i = 0; i < array.length ; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = value;
        return newArray;
    }
    public static int findRandomArrayInArray(int[] numbers,int[] weight) throws Exception{
        if(numbers.length !=weight.length)
            throw new Exception("Сбой. По условию задачи массивы должны быть одной длины");
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(weight));

        Arrays.sort(numbers);
        Arrays.sort(weight);
        int[] newArray = new int[0];


        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == weight[j]) {
                    if (newArray.length == 0) {
                        newArray = addValueArray(newArray, numbers[i]);
                    }
                    else if (numbers[i] != newArray[newArray.length-1]) {
                        newArray = addValueArray(newArray, numbers[i]);
                    }
                    break;
                }
            }
        }
        if(newArray.length==0)
            throw new Exception("Сбой. В представленных массивах нет одинаковых чисел!");

        return newArray[((int) (Math.random() * (newArray.length)) + 0)];
    }




}
