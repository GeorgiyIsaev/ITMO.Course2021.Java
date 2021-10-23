package labs.lab09;

import java.util.Arrays;

public class Lab09 {
    public static void main(String[] args) {
        //Лабораторная 09Ж: Обработка исключений
        //Все методы должны иметь проверку параметров и генерировать исключения при
        //необходимости.

        //ЗАДАНИЕ 01. Написать метод для поиска наибольшего элемента в двумерном массиве.
        findMaxElementTest();
        //ЗАДАНИЕ 02. Написать метод, который проверяет, является ли двумерный массив квадратным.

        //ЗАДАНИЕ 03. Написать метод, который, в двумерном массиве (матрице) ищет строку, сумма
        //элементов которой является максимальной среди всех строк матрицы.

        //ЗАДАНИЕ 04. Двумерный массив MxN заполнить случайными символами алфавита

        //ЗАДАНИЕ 05. * Дан массив чисел numbers, и дан массив weight такой же длины.
        // Задача: написать метод, который бы случайно выбирал число из первого массива,
        // которое есть во втором массиве.
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





}
