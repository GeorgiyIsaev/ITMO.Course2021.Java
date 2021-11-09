package labs.lab13;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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

    public static void startConnect() {
        String urlAddress = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=\"Java\"";
        try {
            URL url = new URL(urlAddress);

            System.out.println(url.getHost());
            System.out.println(url.getPath());
            System.out.println(url.getProtocol());

            URLConnection urlConnection = url.openConnection();
            var mapFields = urlConnection.getHeaderFields();
            for(var val : mapFields.entrySet()){
                System.out.println(val.getKey() + " - " + val.getValue());
            }

            System.out.println("\nСчитываем данные:");
            InputStream inputStream = urlConnection.getInputStream();
            int c;
            while((c = inputStream.read()) != -1){
                System.out.print((char)c);
            }




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
