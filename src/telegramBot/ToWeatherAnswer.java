package telegramBot;

public class ToWeatherAnswer {

    private static String jsonDistrict(String nameReg){

return null;
    }


    public static String getWeatherStr(String nameReg){
        if (nameReg.equals("0")){
            return District.fullDistrict();
        }


        String text = "Погода в " + nameReg;
        String weather = WeatherGetJson.currentWeather(59.8997451954109,30.36445362645357);
        text= text + "\n" + weather;
        return text;
    }
}
