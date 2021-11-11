package labs.lab13;

import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.util.Scanner;

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
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nВведите слово для поиска: ");
            String findText = scanner.next();
            try {
                startConnectWiki(findText);

            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void startConnectWiki(String findPage ) {
        String urlAddress = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=\""+ findPage + "\"";
        try {
            String jsonFromURL = jsonToFindFromURLConnection(urlAddress);

            Gson gson = new Gson();
            Root root = gson.fromJson(textJSON,Root.class);

            System.out.println("\nИзвлекаем верный ответ");
            System.out.println(root.fomatStringText());



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String jsonToFindFromURLConnection(String urlAddress) throws IOException {
        URL url = new URL(urlAddress);
        URLConnection urlConnection = url.openConnection();

        //Копируем JSON файл
        String textJSON ="";
        try (BufferedReader in =
                     new BufferedReader(new InputStreamReader
                             (urlConnection.getInputStream()))){
            String inputLine ="";
            while ((inputLine = in.readLine()) != null)
                textJSON = inputLine;
        }
        catch(Exception ex){ex.printStackTrace();}
        return textJSON;
    }

    public static String jsonToFindFromHttpURLConnection(String urlAddress) throws IOException {
        URL url = new URL(urlAddress);

        //Соединение с HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        //Проверка статуса соединения
        int status = connection.getResponseCode();
        System.out.println("Response Code: " + status);
        StringBuffer responseContent = new StringBuffer();
        String line;
        if (status > 299) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        }
        return responseContent.toString();
    }


}
