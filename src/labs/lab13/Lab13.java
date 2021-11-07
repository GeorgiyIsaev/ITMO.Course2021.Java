package labs.lab13;

import java.net.MalformedURLException;
import java.net.URL;

public class Lab13 {
    public static void main(String[] args) {
        /**ЗАДАЧА*/
        // Написать программу, которая с консоли считывает поисковый запрос,
        // и выводит результат поиска по Википедии.
        // Задача разбивается на 4 этапа:
        //1. Считать запрос.
        //2. Сделать запрос к серверу.
        //3. Распарсить ответ.
        //4. Вывести результат.
        startConnect();
    }

    public static void startConnect(){
        String urlAddress = "http://en.wikipedia.org/wiki/Java";
        try {
            URL url = new URL(urlAddress);

            System.out.println(url.getHost());
            System.out.println(url.getPath());
            System.out.println(url.getProtocol());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }


}
