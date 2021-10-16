package Labs.Lab04;

import java.util.Arrays;

public class Lab04 {
    public static void main(String[] args) {
        // Задача 1.	Написать метод для поиска самой длинной строки.
        System.out.println("ЗАДАЧА 1");
        String str1 = "Ложка", str2 ="Нож";
        System.out.println("Есть два слова: " +str1 +", " + str2);
        System.out.println("Самое длинное из них: " +longString(str1, str2));
        String[]strArray = {"Синица","Воробей","Пингвин", "Киви"};
        System.out.println("Есть массив слов: " + Arrays.toString(strArray));
        System.out.println("Самое длинное из них: " +longString(strArray));

        // Задача 2.	Написать метод, который проверяет являться ли
        // слово палиндромом.
        System.out.println("Палиндром? (Палиндром): " + ifPalindrome("палиндром"));
        System.out.println("Палиндром? (водоходов): " + ifPalindrome("водоходов"));
        System.out.println("Палиндром? (ротатор): " + ifPalindrome("ротатор"));
        // Задача 3.	Напишите метод, заменяющий в тексте все
        // вхождения слова «бяка» на «[вырезано цензурой]».

        // Задача 4.	Имеются две строки. Найти количество вхождений
        // одной (являющейся подстрокой) в другую.

        // Задача 5.	Напишите метод, который инвертирует слова в строке.
        // Предполагается, что в строке нет знаков препинания,
        // и слова разделены пробелами.
    }
    public static String longString(String str1, String str2) {
        //Задача1: Возвращает самую длинную строку из двух
        if(str1.length() > str2.length() )
            return str1;
        else
            return str2;
    }
    public static String longString(String[] stringArr) {
        //Задача1: Возвращает самую длинную строку из массива
        String strLong = "";
        for (int i = 0; i < stringArr.length; i++) {
            if(strLong.length() < stringArr[i].length()){
                strLong = stringArr[i];
            }
        }
        return strLong;
    }

    public static boolean ifPalindrome(String stringArr) {
        boolean ifPal = true;
        for (int i = 0; i < stringArr.length()/2; i++) {
            if(stringArr.charAt(i) != stringArr.charAt(stringArr.length()-1 -i)){
                ifPal = false;
                break;
            }
        }
        return ifPal;
    }
}
