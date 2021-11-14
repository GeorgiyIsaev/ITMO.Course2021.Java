package telegramBot;

public class ToWeatherAnswer {

    private static String jsonDistrict(String nameReg){

return null;
    }


    public static String getWeatherStr(String nameReg){
        if (nameReg == "0" || nameReg == "k" || true){
            return District.fullDistrict();
        }


        String text = "Погода в " + nameReg;
        String eather = WeatherGetJson.currentWeather(59.8997451954109,30.36445362645357);
        return text;
    }
}
