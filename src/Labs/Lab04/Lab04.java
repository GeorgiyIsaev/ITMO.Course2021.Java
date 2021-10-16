package Labs.Lab04;

import java.util.Arrays;

public class Lab04 {
    public static void main(String[] args) {
        // Задача 1.	Написать метод для поиска самой длинной строки.
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
        String myText = "Шла Саша по шоссе И сосала бяку.\n" +
                "Дело было в сентябре, Было ей бяка.\n" +
                "Шла она уже полдня, Очень торопилась.\n" +
                "бяку есть было нельзя, Саша очень злилась.\n" +
                "Сушка бякою была, Чуть солоновата.\n";
        String newText = bakaCensorship(myText);
        System.out.println(newText);

        // Задача 4.	Имеются две строки. Найти количество вхождений
        // одной (являющейся подстрокой) в другую.
        String censorStr = "[вырезано цензурой]";
        System.out.println("Строка \"" +censorStr+ "\" встречается в тексте " +counterStr(newText, censorStr) + " раз!");

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
        //Задача 2: Палиндром
        boolean ifPal = true;
        for (int i = 0; i < stringArr.length()/2; i++) {
            if(stringArr.charAt(i) != stringArr.charAt(stringArr.length()-1 -i)){
                ifPal = false;
                break;
            }
        }
        return ifPal;
    }
    public static String bakaCensorship(String myText){
        //Задача 3: Цензура
        String newText = myText;
        String[] strCensor = {"бяка", "бяки", "бяке", "бяку", "бяку", "бякой","бякою", "бяке"};
        while (ifCensorship(strCensor,newText)){
            for (int i = 0; i < strCensor.length ; i++) {
                newText = newText.replace(strCensor[i], "[вырезано цензурой]");
            }
        }
        return newText;
    }

    public static boolean ifCensorship(String[] strCensor,String myText){
        //Метод для задачи 3, проверят нужна ли еще цензура!
        for (int i = 0; i < strCensor.length ; i++) {
            if(myText.contains(strCensor[i]))
                return true;
        }
        return false;
    }
    public static int counterStr(String fullText, String underString){
        //Задача 4: Сколько раз входит подстрока
        int count = 0;
        int indexCur = 0;
        while (indexCur < fullText.indexOf(underString, indexCur)){
            indexCur = fullText.indexOf(underString, indexCur) +1;
            count++;
        }
        return count;
    }
}
