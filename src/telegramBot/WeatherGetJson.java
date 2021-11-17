package telegramBot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherGetJson {
    //мой ключ доступа с сайта
    //https://home.openweathermap.org/api_keys
    private static String getKey() {
        return WeatherBot.getStarterFile().getKeyOpenWeatherMapOrg();
    }
    public static String getUrlString(double latitude, double longitude) {
        return
            "https://api.openweathermap.org/data/2.5/onecall?lat=" + latitude + "&lon=" + longitude +
            "&exclude=minutely,hourly,daily&units=metric&appid=" + getKey() + "&lang=ru";
    }
    //Широта, Долгота, и Ключ доступа к программе
    public static String currentWeather(double latitude, double longitude){
        //Координаты Питера для теста
        //59.8997451954109,30.36445362645357
        try{
            URL url = new URL(getUrlString(latitude,longitude));
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input;
            StringBuffer content = new StringBuffer();

            while ((input = in.readLine()) != null)
            {
                content.append(input);
            }

            in.close();
            connection.disconnect();

            System.out.println("Json file with current forecast for city successfully loaded from server. Response code: " + status);

            return content.toString();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "Данных нет";
    }
}
