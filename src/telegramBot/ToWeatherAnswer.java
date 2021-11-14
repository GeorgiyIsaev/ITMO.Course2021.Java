package telegramBot;

public class ToWeatherAnswer {

    private static String jsonDistrict(String nameReg){
        s

    }


    public static String getWeatherStr(String nameReg){
        String text = "Погода в " + nameReg;
        String eather = WeatherGetJson.currentWeather(59.8997451954109,30.36445362645357);
        return text;
    }
}
