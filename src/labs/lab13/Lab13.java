package labs.lab13;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

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
            //Установим соединение
            URL url = new URL(urlAddress);
            URLConnection urlConnection = url.openConnection();

            //Прочитаем полученный JSON
            String inputLine ="";
            try (BufferedReader in =
                         new BufferedReader(new InputStreamReader
                         (urlConnection.getInputStream()))){
                while ((inputLine = in.readLine()) != null)
                    System.out.println(inputLine);
            }
            catch(Exception ex){ex.printStackTrace();}
            System.out.println("\nПолучен JSON:");
            System.out.println(inputLine);






        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
